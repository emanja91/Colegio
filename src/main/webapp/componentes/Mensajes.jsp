<%-- 
    Document   : Mensajes
    Created on : 3/10/2025, 8:44:51 a. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${sessionScope.error !=null}">
    <div class="alert alert-danger mt-1" role="alert">
        ${sessionScope.error}
    </div>
        <c:remove var="error" scope="session" />
</c:if>

<c:if test="${sessionScope.success !=null}">
    <div class="alert alert-success mt-1" role="alert">
        ${sessionScope.success}
    </div>
        <c:remove var="success" scope="session" />
</c:if>
