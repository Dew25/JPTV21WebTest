<%-- 
    Document   : book
    Created on : Jan 18, 2023, 2:50:23 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Инфорамация о книге</title>
    </head>
    <body>
        <h1>Книга: ${book.name}</h1>
        <p>Авторы: <c:forEach var="author" items="${book.authors}">
                        ${author.firstname} ${author.lastname}
                    </c:forEach>
        </p>
        <p>Год издания: ${book.publishedYear}</p>
        <p>Количество всего: ${book.quantity}</p>
        <p>Количество в наличии: ${book.count}</p>
        
    </body>
</html>
