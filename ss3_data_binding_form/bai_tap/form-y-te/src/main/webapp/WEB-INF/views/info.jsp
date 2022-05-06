<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>thông tin</title>
</head>
<body>
<form action="edit" method="post">
    <input type="hidden" name="medical" value="${medical}">
    <h1>thông tin tờ khai</h1>
    <p>Năm sinh: ${medical.ten}</p>
    <p>Họ tên: ${medical.namSinh}</p>
    <p>Quốc tịch: ${medical.quocTich}</p>
    <p>Hộ Chiếu: ${medical.cmnd}</p>
    <p>Thông tin đi lại: ${medical.phuongTien}</p>
    <p>Số hiệu phương tiện: ${medical.soHieuPhuongTien}</p>
    <p>Số ghế: ${medical.soGhe}</p>
    <p>Ngày khởi hành: ${medical.ngayKhoiHanh}</p>
    <p>Ngày kết thúc: ${medical.ngayKetThuc}</p>
    <p>tỉnh/ thành phố đã đến: ${medical.diaDiem}</p>
    <input type="submit" value="chỉnh sửa thông tin">
</form>
</body>
</html>
