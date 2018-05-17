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
    <title>Отзывы</title>
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
<div class="container" >

    <c:if test="${!empty reviews}">
        <c:forEach items="${reviews}" var="review">
            <div class="review_block">
                <div class="row">
                    <div class="col-md-11" >
                        <label style="font-size: 11px">
                            <c:forEach items="${accounts}" var="account">
                                <c:if test="${review.userID==account.id}">
                                    <td>${account.login}</td>
                                </c:if>
                            </c:forEach>
                        </label>
                        <br>
                        <label style="font-size: 20px;">${review.title}</label>
                        <br>
                        <c:if test="${review.mark==1}">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                        </c:if>
                        <c:if test="${review.mark==2}">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                        </c:if>
                        <c:if test="${review.mark==3}">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                        </c:if>
                        <c:if test="${review.mark==4}">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                        </c:if>
                        <c:if test="${review.mark==5}">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                            <img src="${pageContext.request.contextPath}/resource/images/star.png" width="40" height="40">
                        </c:if>

                    </div>
                    <div class="col-md-1">
                    </div>
                    <div class="col-md-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <p>${review.contents}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>

</div>

<div class="container" >
    <hr>
    <label style="font-size: 30px"> Добавьте свой отзыв</label>
    <hr>
    <c:url var="addAction" value="/reviews"/>
    <form:form action="${addAction}" commandName="review">
        <div class="row">
            <div class="col-md-3">
                <p>Придумайте заголовок:</p>
                <form:input path="title"  class="form-control "  style="width: 285px;"/>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-1">
                <label> Оценка от 1 до 5:</label>
            </div>
            <form:input path="mark" class="form-control " style="width: 50px"/>
        </div>
        <br>
        <div class="row">
            <div class="col-md-6">
                <p>Текст вашего сообщения:</p>
                <form:textarea path="contents" class="form-control " style="width: 500px; height:200px "/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6" align="right">
                <input class="btn" type="submit" value="<spring:message text="Отправить"/>"/>
            </div>
        </div>

    </form:form>
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