<%-- 
    Document   : listBooks
    Created on : Jan 19, 2023, 10:30:29 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Список книг</h1>
        <c:forEach var="book" items="${books}">
            <p>${book.name}</p>
            <p>Авторы:  
                <c:forEach var="author" items="${book.authors}">
                    <p>${author.firstname} ${author.lastname}</p> 
                </c:forEach>
            </p>
            <p>Год издания: ${book.publishedYear}</p>
            <p>Количество экземпляров: ${book.quantity}</p>
            <p>Количество в наличии: ${book.count}</p>
            <p>-------------------------------------</p>
        </c:forEach>
    </body>
</html>
