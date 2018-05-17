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
    <title>Управление товарами</title>
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
    <c:if test="${!empty products}">
        <table class="tg">
            <tr>
                <th width="40">№</th>
                <th width="120">Тип</th>
                <th width="50">Производитель</th>
                <th width="50">Модель</th>
                <th width="120">Цена</th>
                <th width="120">Год выпуска</th>
                <th width="120">Цвета</th>
                <th width="120">Размер экрана</th>
                <th width="120">Разрешение</th>
                <th width="120">Оперативная память</th>
                <th width="120">Память</th>
                <th width="120">Аккумулятор</th>
                <th width="120">Изображение</th>
                <th width="60"></th>
                <th width="60"></th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.type}</td>
                    <td>${product.manufacturer}</td>
                    <td>${product.model}</td>
                    <td>${product.price} BYN</td>
                    <td>${product.year}</td>
                    <td>${product.colors}</td>
                    <td>${product.diagonal}"</td>
                    <td>${product.resolution}</td>
                    <td>${product.ram} Гб</td>
                    <td>${product.memorySize} Гб</td>
                    <td>${product.batteryCapacity}
                        <c:choose>
                            <c:when test="${product.type == 'laptop'}">Вт/ч</c:when>
                            <c:otherwise>мАч</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${product.imageUrl}</td>
                    <td><a href="<c:url value='product/edit/${product.id}'/>">Изменить</a></td>
                    <td><a href="<c:url value='product/delete/${product.id}'/>">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div class="container" align="center">
    <div class="row">
        <div class="col-md-10" >
            <h3>Добавление товара</h3>
            <c:url var="addAction" value="/products/add"/>
            <form:form action="${addAction}" commandName="product">
                <table>
                    <c:if test="${!empty product.type}">
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
                        <td >
                            <form:label path="type">
                                <spring:message text="Тип:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="type"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="manufacturer">
                                <spring:message text="Производитель:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="manufacturer"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="model">
                                <spring:message text="Модель:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="model"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="price">
                                <spring:message text="Цена:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="price"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="year">
                                <spring:message text="Год выпуска:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="year"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="colors">
                                <spring:message text="Цвета:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="colors"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="diagonal">
                                <spring:message text="Размер экрана:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="diagonal"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="resolution">
                                <spring:message text="Разрешение:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="resolution"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="ram">
                                <spring:message text="Оперативная память:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="ram"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="memorySize">
                                <spring:message text="Объем памяти:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="memorySize"/>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <form:label path="batteryCapacity">
                                <spring:message text="Объём батареи:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="batteryCapacity"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="imageUrl">
                                <spring:message text="Адрес картинки:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="imageUrl"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:if test="${!empty product.type}">
                                <input class="admin_btn" type="submit" value="<spring:message text="Изменить"/>"/>
                            </c:if>
                            <c:if test="${empty product.type}">
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