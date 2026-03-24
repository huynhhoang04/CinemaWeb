<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 03/03/2026
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Tái sử dụng Header của sếp --%>
<jsp:include page="/views/layouts/header.jsp" />

<style>
    body { background-color: #121212; color: #fff; font-family: sans-serif; }

    .profile-container {
        max-width: 1000px; margin: 50px auto; padding: 0 20px;
        display: flex; gap: 30px; align-items: flex-start;
    }

    /* Cột trái: Card thông tin user */
    .profile-card {
        flex: 1; background: #1e1e1e; border-radius: 12px;
        padding: 30px; text-align: center;
        border: 1px solid #333; box-shadow: 0 10px 30px rgba(0,0,0,0.5);
    }

    .profile-avatar {
        width: 120px; height: 120px; border-radius: 50%;
        background-color: #333; margin: 0 auto 20px;
        display: flex; align-items: center; justify-content: center;
        font-size: 3rem; border: 3px solid #e50914;
    }

    .profile-name { font-size: 1.8rem; font-weight: bold; margin-bottom: 5px; }
    .profile-role { color: #e50914; font-size: 0.9rem; font-weight: bold; margin-bottom: 25px; text-transform: uppercase;}

    .info-group { text-align: left; margin-bottom: 15px; border-bottom: 1px solid #333; padding-bottom: 10px; }
    .info-label { color: #888; font-size: 0.85rem; margin-bottom: 5px; display: block; }
    .info-value { font-size: 1.1rem; color: #ddd; }

    /* Cột phải: Lịch sử đặt vé */
    .history-card {
        flex: 2; background: #1e1e1e; border-radius: 12px;
        padding: 30px; border: 1px solid #333; min-height: 400px;
    }

    .history-title {
        font-size: 1.5rem; margin-top: 0; margin-bottom: 25px;
        padding-bottom: 15px; border-bottom: 2px solid #e50914;
    }

    .empty-history {
        text-align: center; color: #666; margin-top: 50px;
    }
    .empty-history span { display: block; font-size: 4rem; margin-bottom: 15px; opacity: 0.3;}
</style>

<div class="profile-container">

    <div class="profile-card">
        <div class="profile-avatar">👤</div>
        <div class="profile-name">${sessionScope.currentUser.full_name}</div>

        <div class="info-group">
            <span class="info-label">Tên đăng nhập</span>
            <span class="info-value">@${sessionScope.currentUser.username}</span>
        </div>
        <div class="info-group">
            <span class="info-label">Địa chỉ Email</span>
            <span class="info-value">${sessionScope.currentUser.email}</span>
        </div>

        <c:if test="${not empty error}">
            <div style="background: #e50914; color: white; padding: 15px; text-align: center; margin-bottom: 20px;">${error}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div style="background: #28a745; color: white; padding: 15px; text-align: center; margin-bottom: 20px;">${message}</div>
        </c:if>

        <button onclick="document.getElementById('passwordModal').style.display='flex'" class="btn-change-pass">
            Đổi mật khẩu
        </button>

        <div id="passwordModal" style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0,0,0,0.8); z-index: 1000; align-items: center; justify-content: center;">
            <div style="background: #1e1e1e; padding: 40px; border-radius: 8px; width: 400px; border: 1px solid #333; position: relative;">

                <span onclick="document.getElementById('passwordModal').style.display='none'" style="position: absolute; top: 15px; right: 20px; font-size: 1.5rem; cursor: pointer; color: #888;">&times;</span>

                <h3 style="margin-top: 0; color: #fff; border-bottom: 2px solid #e50914; padding-bottom: 10px; margin-bottom: 20px;">Đổi mật khẩu</h3>

                <form action="${pageContext.request.contextPath}/profile" method="post">
                    <input type="hidden" name="action" value="change_password">

                    <div style="margin-bottom: 15px;">
                        <label style="color: #aaa; font-size: 0.9rem; display: block; margin-bottom: 5px;">Mật khẩu hiện tại</label>
                        <input type="password" name="oldPassword" required style="width: 100%; padding: 10px; box-sizing: border-box; background: #333; border: 1px solid #444; color: white; border-radius: 4px;">
                    </div>

                    <div style="margin-bottom: 15px;">
                        <label style="color: #aaa; font-size: 0.9rem; display: block; margin-bottom: 5px;">Mật khẩu mới</label>
                        <input type="password" name="newPassword" required style="width: 100%; padding: 10px; box-sizing: border-box; background: #333; border: 1px solid #444; color: white; border-radius: 4px;">
                    </div>

                    <div style="margin-bottom: 25px;">
                        <label style="color: #aaa; font-size: 0.9rem; display: block; margin-bottom: 5px;">Xác nhận mật khẩu mới</label>
                        <input type="password" name="confirmPassword" required style="width: 100%; padding: 10px; box-sizing: border-box; background: #333; border: 1px solid #444; color: white; border-radius: 4px;">
                    </div>

                    <button type="submit" style="width: 100%; padding: 12px; background: #e50914; color: white; border: none; border-radius: 4px; font-weight: bold; cursor: pointer;">Xác Nhận Đổi</button>
                </form>
            </div>
        </div>
    </div>

    <div class="history-card">
        <h2 class="history-title">🎬 Lịch sử đặt vé</h2>

        <c:if test="${empty historyList}">
            <div class="empty-history">
                <span>🎟️</span>
                <p>Bạn chưa có giao dịch nào.</p>
                <a href="${pageContext.request.contextPath}/movie" style="color: #e50914; text-decoration: none; font-weight: bold;">
                    Khám phá phim đang chiếu ngay!
                </a>
            </div>
        </c:if>

        <c:if test="${not empty historyList}">
            <div class="history-list" style="display: flex; flex-direction: column; gap: 20px;">
                <c:forEach var="bk" items="${historyList}">
                    <div style="background: #2a2a2a; border-radius: 8px; padding: 20px; border-left: 5px solid
                    <c:choose>
                    <c:when test="${bk.paymentStatus == 'COMPLETED'}">#28a745</c:when>
                    <c:when test="${bk.paymentStatus == 'PENDING'}">#ffc107</c:when>
                    <c:otherwise>#dc3545</c:otherwise>
                    </c:choose>;">

                        <div style="display: flex; justify-content: space-between; border-bottom: 1px solid #444; padding-bottom: 10px; margin-bottom: 15px;">
                            <h3 style="margin: 0; font-size: 1.3rem;">${bk.movieTitle}</h3>
                            <span style="font-size: 0.9rem; color: #aaa;">Mã HĐ: #${bk.bookingId}</span>
                        </div>

                        <div style="display: flex; justify-content: space-between; flex-wrap: wrap;">
                            <div style="flex: 2; line-height: 1.8; color: #ccc;">
                                <div>📅 Thời gian chiếu: <strong>${bk.showTime}</strong></div>
                                <div>🏠 Phòng chiếu: <strong>${bk.roomName}</strong></div>
                                <div>💺 Ghế đã chọn: <strong style="color: #e50914;">${bk.seats}</strong></div>
                            </div>

                            <div style="flex: 1; text-align: right; border-left: 1px solid #444; padding-left: 20px;">
                                <div style="font-size: 1.2rem; font-weight: bold; color: #fff; margin-bottom: 10px;">
                                    <fmt:formatNumber value="${bk.totalPayment}" pattern="#,###"/> VNĐ
                                </div>

                                <c:choose>
                                    <c:when test="${bk.paymentStatus == 'PENDING'}">
                                        <div style="color: #ffc107; font-weight: bold; margin-bottom: 10px;">Chờ thanh toán</div>
                                        <form action="${pageContext.request.contextPath}/profile" method="POST" style="display: inline;">
                                            <input type="hidden" name="action" value="pay_now">
                                            <input type="hidden" name="booking_id" value="${bk.bookingId}">
                                            <button type="submit" style="background: #28a745; color: white; border: none; padding: 6px 15px; border-radius: 4px; font-size: 0.9rem; cursor: pointer; margin-bottom: 5px;">
                                                Thanh toán ngay
                                            </button>
                                        </form>
                                        <form action="${pageContext.request.contextPath}/profile" method="POST" style="display: inline;">
                                            <input type="hidden" name="action" value="cancel_booking">
                                            <input type="hidden" name="booking_id" value="${bk.bookingId}">
                                            <button type="submit" onclick="return confirm('Hủy vé sẽ làm mất ghế bạn đã chọn. Bạn có chắc chắn không?');"
                                                    style="background: transparent; color: #dc3545; border: 1px solid #dc3545; padding: 5px 15px; border-radius: 4px; cursor: pointer;">
                                                Hủy
                                            </button>
                                        </form>
                                    </c:when>
                                    <c:when test="${bk.paymentStatus == 'COMPLETED'}">
                                        <span style="background: #28a745; color: white; padding: 5px 10px; border-radius: 4px; font-size: 0.9rem;">Thành công</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span style="background: #555; color: #aaa; padding: 5px 10px; border-radius: 4px; font-size: 0.9rem;">Đã hủy</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>

</div>

<jsp:include page="/views/layouts/footer.jsp" />
