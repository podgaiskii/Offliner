<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Offliner</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resource/images/icon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/font-awesome.css" >
    <script src="${pageContext.request.contextPath}/resource/js/script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <style type="text/css">
        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
        .tg .tg-4eph {
            background-color: #f9f9f9;
        }
        /*--footer--*/
        footer {
            background: #171615;
        }
        .menu {
            cursor: pointer;
        }
    </style>

</head>
<body>
<%--header--%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li class="menu"><a href="<c:url value="/index"/>"> <i class="fa fa-plug fa-lg" aria-hidden="true"></i> Главная</a></li>
                <li class="menu"><a href="<c:url value="/products/phone"/>"> <i class="fa fa-mobile fa-lg" aria-hidden="true"></i> Телефоны</a></li>
                <li class="menu"><a href="<c:url value="/products/tablet"/>"> <i class="fa fa-tablet fa-lg" aria-hidden="true"></i> Планшеты</a></li>
                <li class="menu"><a href="<c:url value="/products/laptop"/>"> <i class="fa fa-laptop fa-lg" aria-hidden="true"></i> Ноутбуки</a></li>
                <li class="menu"><a href="<c:url value="/return"/>"> <i class="fa fa-redo fa-lg" aria-hidden="true"></i> Возврат товара</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" style="padding-top: 3px">
                <li class="menu"><a href="<c:url value="/auth"/>"> <i class="fa fa-user fa-lg" aria-hidden="true"> Кабинет</i></a></li>
            </ul>
        </div>
    </div>
</div>
<br>
<br>
<br>
<br>
<%--content--%>
<div class="container" style="">
    <div class="row">
        <div class="col-md-8">
            <div class="container">
                <c:url var="addAction" value="/return/add"/>
                <form:form action="${addAction}" modelAttribute="return" method="post">
                    <label class="return_lab">Выберите модель:</label>
                    <form:select class="form-control return_lab " path="productID">
                        <c:forEach items="${products}" var="product">
                            <form:option value="${product.id}">
                                ${product.manufacturer} ${product.model}
                            </form:option>
                        </c:forEach>
                    </form:select>
                    <p>Сообщите о причине возврата: </p>
                    <form:textarea path="reason" class="form-control " style="width: 600px; height:200px "/>
                    <input class="btn return_btn" type="submit" value="<spring:message text="Оформить возврат"/>"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-2">

    </div>
</div>
<br>
<br>
<%--footer--%>
<footer>
    <div class="container">
        <hr>
        <div class="row">
            <div style="padding-left: 20px; padding-right: 20px;">
                <div style="alignment: center">
                    <ul class="list-unstyled list-inline pull-left" style="font-size: 12pt;">
                        <li><a href="<c:url value="/about"/>" class="myinfo" style="color: white">О нас</a></li>
                        |
                        <li><a href="<c:url value="/reviews"/>" class="myinfo" style="color: white">Отзывы</a></li>
                    </ul>
                </div>
                <br>
                <br>
                <p style="color: #525150">Полное наименование: ООО "Offliner"<br>
                    Юр. адрес: Республика Беларусь, 202280, Минская область, г. Минск, пр. Дзержинского, д.95,
                    помещение 1402, офис а, <br>
                    УНП: 1488022801337, Выдано Минским Городским исполнительным комитетом 10 мая 2018г. В торговом реестре с 15 декабря
                    2018г.<br>
                    Режим работы магазина: пн-пт: 8:00 - 22:00, сб-вс: 10:00 - 22:00.</p>
                <br>
            </div>
        </div>
    </div>
</footer>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
</body>

</html>