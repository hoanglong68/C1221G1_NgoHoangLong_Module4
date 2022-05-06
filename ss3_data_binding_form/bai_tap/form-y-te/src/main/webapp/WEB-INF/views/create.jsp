<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Y Te</title>
</head>
<body>
<h1>tờ khai y tế</h1>
<h2 style="color: red">khai sai là vi phạm đi tù</h2>
<form:form action="create" modelAttribute="yTe" method="post">
    <div>
        họ tên(ghi chữ IN HOA)<form:input type="text" path="ten"/>
    </div>
    <div>
        năm sinh<form:input type="number" path="namSinh"/>
    </div>
    <div>
        <form:select path="gioiTinh">
            <option value="">-chọn-</option>
            <option value="Nam">Nam</option>
            <option value="Nu">Nữ</option>
        </form:select>
    </div>
    <div>
        <form:select path="quocTich">
            <option value="Việt Nam">Việt Nam</option>
            <option value="Lào">Lào</option>
            <option value="Trung Quốc">Trung Quốc</option>
        </form:select>
    </div>
    <div>
        Số CMND <form:input type="number" path="cmnd"/>
    </div>
    <div>
        <form:checkbox path="phuongTien" value="tàu bay"/>tàu bay
        <form:checkbox path="phuongTien" value="tàu thuyền"/>tàu thuyền
        <form:checkbox path="phuongTien" value="ô tô"/>ô tô
        <form:checkbox path="phuongTien" value="khác"/>khác
    </div>
    <div>
        Số hiệu phương tiện <form:input type="text" path="soHieuPhuongTien"/>
    </div>
    <div>
        Số ghế <form:input type="text" path="soGhe"/>
    </div>
    <div>
        ngày khởi hành: <form:input type="date" path="ngayKhoiHanh"/>
    </div>
    <div>
        ngày kết thúc: <form:input type="date" path="ngayKetThuc"/>
    </div>
    <div>
        trong vòng 40 ngày qua, đã đi dến thành phố lào ?
        <form:textarea path="diaDiem"/>
    </div>
    <div>
        <input type="submit" value="gửi lời khai">
    </div>
</form:form>
</body>
</html>
