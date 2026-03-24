-- ==============================================================================
-- 1. CÁC BẢNG ĐỘC LẬP (Không phụ thuộc khóa ngoại, tạo trước)
-- ==============================================================================

CREATE TABLE users
(
    user_id   SERIAL PRIMARY KEY,
    username  VARCHAR(50)                 NOT NULL UNIQUE,
    password  VARCHAR(100)                NOT NULL,
    full_name VARCHAR(100),
    email     VARCHAR(100)                NOT NULL UNIQUE,
    role      VARCHAR(100) DEFAULT 'USER' NOT NULL CHECK (role IN ('ADMIN', 'USER'))
);

CREATE TABLE theatre
(
    theatre_id     SERIAL PRIMARY KEY,
    theatre_name   VARCHAR(100) NOT NULL,
    location       VARCHAR(100) NOT NULL,
    preview_url    VARCHAR(255) NOT NULL,
    info           TEXT,
    theatre_status VARCHAR(100) NOT NULL CHECK (theatre_status IN ('MAINTENANCE', 'OPEN', 'CLOSE')),
    city           VARCHAR(50),
    coordinates    VARCHAR(100) NOT NULL
);

CREATE TABLE series
(
    series_id   SERIAL PRIMARY KEY,
    series_name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE genres
(
    genre_id   SERIAL PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE directors
(
    director_id   SERIAL PRIMARY KEY,
    director_name VARCHAR(255) NOT NULL,
    avatar_url    VARCHAR(255),
    bio           TEXT
);

CREATE TABLE actors
(
    actor_id   SERIAL PRIMARY KEY,
    actor_name VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(255),
    bio        TEXT
);

CREATE TABLE articles
(
    article_id SERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    summary    TEXT         NOT NULL,
    content    TEXT         NOT NULL,
    image_url  VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active  BOOLEAN   DEFAULT true
);


-- ==============================================================================
-- 2. CÁC BẢNG CẤP 1 (Phụ thuộc vào các bảng trên)
-- ==============================================================================

CREATE TABLE room
(
    room_id     SERIAL PRIMARY KEY,
    room_name   VARCHAR(100)                     NOT NULL,
    room_type   VARCHAR(100)                     NOT NULL CHECK (room_type IN ('NORMAL', 'VIP', 'PRO MAX')),
    capacity    INT                              NOT NULL,
    theatre_id  INT REFERENCES theatre (theatre_id),
    room_status VARCHAR(100) DEFAULT 'AVAILABLE' NOT NULL CHECK (room_status IN ('MAINTENANCE', 'AVAILABLE', 'UNAVAILABLE'))
);

CREATE TABLE movies
(
    movie_id     SERIAL PRIMARY KEY,
    title        VARCHAR(255)                       NOT NULL,
    description  TEXT,
    poster_url   VARCHAR(255)                       NOT NULL,
    trailer_url  VARCHAR(255)                       NOT NULL,
    duration     INT                                NOT NULL,
    release_date DATE,
    movie_status VARCHAR(100) DEFAULT 'UNAVAILABLE' NOT NULL CHECK (movie_status IN ('AVAILABLE', 'UPCOMING', 'UNAVAILABLE')),
    series_id    INT REFERENCES series (series_id)
);

CREATE TABLE bookings
(
    booking_id     SERIAL PRIMARY KEY,
    user_id        INT REFERENCES users (user_id),
    booking_date   TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    total_payment  NUMERIC(10, 2) DEFAULT 0,
    payment_status VARCHAR(50) NOT NULL CHECK (payment_status IN ('PENDING', 'CANCEL', 'COMPLETED')),
    payment_method VARCHAR(50) NOT NULL CHECK (payment_method IN ('E_WALLET', 'TRANSFER', 'CARD'))
);


-- ==============================================================================
-- 3. CÁC BẢNG CẤP 2 (Bảng trung gian N-N và Lịch chiếu)
-- ==============================================================================

CREATE TABLE movie_genre
(
    movie_id INT REFERENCES movies (movie_id) ON DELETE CASCADE,
    genre_id INT REFERENCES genres (genre_id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, genre_id)
);

CREATE TABLE movie_director
(
    movie_id    INT REFERENCES movies (movie_id) ON DELETE CASCADE,
    director_id INT REFERENCES directors (director_id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, director_id)
);

CREATE TABLE movie_actor
(
    movie_id       INT REFERENCES movies (movie_id) ON DELETE CASCADE,
    actor_id       INT REFERENCES actors (actor_id) ON DELETE CASCADE,
    character_name VARCHAR(255),
    PRIMARY KEY (movie_id, actor_id)
);

CREATE TABLE showtime
(
    showtime_id SERIAL PRIMARY KEY,
    movie_id    INT REFERENCES movies (movie_id),
    room_id     INT REFERENCES room (room_id),
    start_at    TIMESTAMP      NOT NULL,
    price       NUMERIC(10, 2) NOT NULL CHECK (price > 0)
);


-- ==============================================================================
-- 4. BẢNG CẤP 3 (Vé - Phụ thuộc vào Booking và Showtime)
-- ==============================================================================

CREATE TABLE tickets
(
    ticket_id   SERIAL PRIMARY KEY,
    booking_id  INT REFERENCES bookings (booking_id),
    showtime_id INT REFERENCES showtime (showtime_id),
    seat_number VARCHAR(10) NOT NULL,
    UNIQUE (showtime_id, seat_number)
);