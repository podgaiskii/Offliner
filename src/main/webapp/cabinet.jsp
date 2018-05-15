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
    <title>Ноутбуки</title>
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
<div class="container">
    <div class="row">
        <div class="col-md-2" align="center">
            <br>
            <br>
            <br>
            <label> <span style="font-size: 25px; ">${account.login}</span> </label>
            <img src="images/user.png" width="160" height="160">
        </div>
        <div class="col-md-2" align="right">
            <br>
            <br>
            <br>
            <br>
            <br>
            <p>Имя:</p>
            <P>Фамилия:</P>
            <P>Отчество:</P>
            <P>Email:</P>
            <P>Номер телефона:</P>
            <P>Дата рождения:</P>
            <P>Адрес:</P>
        </div>
        <div class="col-md-2" align="left">
            <br>
            <br>
            <br>
            <br>
            <br>
            <p>${account.name}</p>
            <P>${account.surname}</P>
            <P>${account.patronymic}</P>
            <P>${account.email}</P>
            <P>${account.phone}</P>
            <P>${account.birthDate}</P>
            <P>${account.address}</P>
        </div>
        <div class="col-md-6">
            <table width="100%">
                <caption class="corz_caption"><img src="imagies/corza.png" width="100" height="100">Корзина товаров
                </caption>
                <tr class="tr_corz">
                    <td class="td_corz"><span class="table_cap">Наимeнование товара</span></td>
                    <td class="td_corz"><span class="table_cap">Цена</span></td>
                    <td class="td_corz"></td>
                </tr>
                <c:forEach items="${listProductsInBasket}" var="suborder">
                    <tr class="tr_corz">
                        <c:forEach items="${listProducts}" var="product">
                            <c:if test="${suborder.id_product==product.id}">
                                <td class="td_corz">${product.type} ${product.model}</td>
                                <td class="td_corz">${product.cost}</td>
                            </c:if>
                        </c:forEach>
                        <td class="td_corz">
                            <a href="<c:url value='cabinet/remove/${suborder.id}'/>" class="btn table_btn"> Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td class="td_corz">Сумма заказа:</td>
                    <td class="td_corz">${all_cost}</td>
                </tr>
            </table>
            <c:url var="addAction" value="/cabinet/addBasket"/>
            <form:form action="${addAction}">
                <input class="btn order_btn" type="submit" value="<spring:message text="Оформить заказ"/>"/>
            </form:form>
        </div>
    </div>
</div>
<br>
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
                        <li><a href="<c:url value="/vacancies"/>" class="myinfo" style="color: white">Вакансии</a></li>
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