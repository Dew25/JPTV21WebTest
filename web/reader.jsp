<%-- 
    Document   : reader
    Created on : Jan 19, 2023, 9:15:47 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Информация о читателе</title>
    </head>
    <body>
        <h1>Читатель: ${reader.firstname} ${reader.lastname}</h1>
        <p>телефон: ${reader.phone}</p>
    </body>
</html>
