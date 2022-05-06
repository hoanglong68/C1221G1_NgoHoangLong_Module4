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
<form action="edit">
<h1>thông tin tờ khai</h1>
<p>Năm sinh: ${yTe.ten}</p>
<p>Họ tên: ${yTe.namSinh}</p>
<p>Quốc tịch: ${yTe.quocTich}</p>
<p>Hộ Chiếu: ${yTe.cmnd}</p>
<p>Thông tin đi lại: ${yTe.phuongTien}</p>
<p>Số hiệu phương tiện: ${yTe.soHieuPhuongTien}</p>
<p>Số ghế: ${yTe.soGhe}</p>
<p>Ngày khởi hành: ${yTe.ngayKhoiHanh}</p>
<p>Ngày kết thúc: ${yTe.ngayKetThuc}</p>
<p>tỉnh/ thành phố đã đến: ${yTe.diaDiem}</p>
    <input type="submit" value="chỉnh sửa thông tin">
</form>
</body>
</html>
