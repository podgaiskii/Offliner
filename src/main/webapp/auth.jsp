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
    <title>Вход в систему</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resource/images/icon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/script.js"></script>
    <script src="${pageContext.request.contextPath}/resource/https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <style type="text/css">
        body, html{
            background-color: #2d2c2b;
            padding: 0;
            margin: 0;
            color: #a7dffe;
        }
    </style>
</head>
<body>
    <div class="container" align="center">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center"><span style="font-size: 20px">Авторизация</span></h3>
                    </div>
                    <div class="panel-body">
                        <c:url var="inputAction" value="/auth"/>
                        <form:form action="${inputAction}" modelAttribute="account">
                            <fieldset>
                                <div class="form-group">
                                    <form:input class="form-control" path="login" placeholder="Логин" name="login" type="text" autofocus=""/>
                                </div>
                                <div class="form-group">
                                    <form:input class="form-control" path="password" placeholder="Пароль" name="password" type="password" />
                                </div>

                                <div class="row">
                                    <div class="col-md-1"></div>
                                    <div class="col-md-4">
                                        <button type="submit" class="btn avtreg_btn" value="<spring:message text="Input"/>">
                                            <i class="fa fa-sign-in"> Вход </i>
                                        </button>
                                    </div>
                                    <div class="col-md-2"></div>
                                    <div class="col-md-4">
                                        <a href="<c:url value="/register"/>"><i class="fa fa-user-plus"> Регистрация </i></a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12" style="margin-top: 30px">
                                        <a href="<c:url value="/index"/>" style="font-size: 13pt"><i class="fa fa-home"> На главную страницу сайта </i></a>
                                    </div>
                                </div>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
