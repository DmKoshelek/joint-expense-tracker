<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:page notShowMenu="${true}">
    <div class="jumbotron">
        <h1 class="display-3">Track joint expenses easily</h1>
        <p class="lead">This simple app helps to track joint expenses for a group of people.</p>
        <hr class="my-4">
        <p>So you can easily share the costs and ensure that everyone spends the same amount of cache</p>
        <p class="lead">
            <form method="post" action="${pageContext.request.contextPath}/start">
                <button class="btn btn-primary btn-lg" role="button">START ADDING JOINT EXPRESES</button>
            </form>
        </p>
    </div>
</template:page>
