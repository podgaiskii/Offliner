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
    <title>Управление пользователями</title>
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
                <li class="menu"><a href="<c:url value="/logout"/>"> <i class="fa fa-user fa-lg" aria-hidden="true"> Выйти</i></a></li>
            </ul>
        </div>
    </div>
    <div class="container">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="admin_menu"><a href="<c:url value="/products"/>">Управление продуктами</a></li>
                <li class="admin_menu"><a href="<c:url value="/account/all"/>">Управление пользователями</a></li>
            </ul>
        </div>

    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%--content--%>
<div class="container">
    <c:if test="${!empty accounts}">
        <table class="tg">
            <tr>
                <th width="40">№</th>
                <th width="120">Логин</th>
                <th width="120">Email</th>
                <th width="120">Пароль</th>
                <th width="100">Роль</th>
                <th width="120">Имя</th>
                <th width="120">Фамилия</th>
                <th width="120">Отчество</th>
                <th width="140">Телефон</th>
                <th width="120">Адресс</th>
                <th width="110">Дата рождения</th>
                <th width="60"></th>
                <th width="60"></th>
            </tr>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.login}</td>
                    <td>${account.email}</td>
                    <td>${account.password}</td>
                    <td>${account.role}</td>
                    <td>${account.name}</td>
                    <td>${account.surname}</td>
                    <td>${account.middleName}</td>
                    <td>${account.phone}</td>
                    <td>${account.address}</td>
                    <td>${account.birthDate}</td>

                    <td><a href="<c:url value='/account/edit/${account.id}'/>">Изменить</a></td>
                    <td><a href="<c:url value='/account/delete/${account.id}'/>">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<div class="container" align="center">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <h3>Добавление пользователя</h3>
            <c:url var="addAction" value="/account/all"/>
            <form:form action="${addAction}" commandName="account">
                <table >
                    <c:if test="${!empty account.login}">
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="id" readonly="true" size="8" disabled="true"/>
                                <form:hidden path="id"/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="login">
                                <spring:message text="Логин:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="login"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">
                                <spring:message text="Пароль:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email">
                                <spring:message text="Email:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="role">
                                <spring:message text="Роль:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="role"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="name">
                                <spring:message text="Имя:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="surname">
                                <spring:message text="Фамилия:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="surname"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="middleName">
                                <spring:message text="Отчество:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="middleName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="phone">
                                <spring:message text="Номер телефона:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="phone"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address">
                                <spring:message text="Адрес:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="address"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="birthDate">
                                <spring:message text="Дата рождения:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="birthDate"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:if test="${!empty account.login}">
                                <input class="admin_btn" type="submit" value="<spring:message text="Изменить"/>"/>
                            </c:if>
                            <c:if test="${empty account.login}">
                                <input class="admin_btn" type="submit" value="<spring:message text="Добавить"/>"/>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>
<br>
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