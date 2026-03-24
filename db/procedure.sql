create or replace procedure register_user(
    p_username varchar,
    p_password varchar,
    p_full_name varchar,
    p_email varchar
)
    language plpgsql
as $$
begin
    insert into users (username, password, full_name, email)
    values (p_username, p_password, p_full_name, p_email);
end;
$$;

create or replace procedure update_password(in p_password varchar, in p_user_id int)
    language plpgsql
as
$$
begin
    update users as u
    set password = p_password where u.user_id = p_user_id;
end;
$$;

create or replace procedure create_booking_with_tickets(p_user_id INT,
                                                        p_showtime_id INT,
                                                        p_total_payment DECIMAL,
                                                        p_payment_method VARCHAR,
                                                        p_seats TEXT[])
    language plpgsql
as
$$
declare
    v_booking_id INT;
    v_seat       TEXT;
begin
    INSERT INTO bookings (user_id, total_payment, payment_status, payment_method)
    VALUES (p_user_id, p_total_payment, 'PENDING', p_payment_method)
    RETURNING booking_id INTO v_booking_id;

    FOREACH v_seat IN ARRAY p_seats
        LOOP
            INSERT INTO tickets (booking_id, showtime_id, seat_number)
            VALUES (v_booking_id, p_showtime_id, v_seat);
        END LOOP;

EXCEPTION
    WHEN unique_violation THEN
        RAISE EXCEPTION 'Thao tác thất bại: Ghế đã có người đặt trong lúc bạn đang thao tác. Vui lòng chọn ghế khác!';

    WHEN OTHERS THEN
        RAISE EXCEPTION 'Hệ thống đang bận, lỗi giao dịch: %', SQLERRM;
end;
$$;

create or replace procedure update_booking_status(in p_booking_id int, in p_user_id int, in p_status varchar)
    language plpgsql
as $$
begin
    update bookings set payment_status = p_status where booking_id = p_booking_id and user_id = p_user_id;

exception
    when others then
        raise exception 'Lỗi hệ thống : %', SQLERRM;
end;
$$;