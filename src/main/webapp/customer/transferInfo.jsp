<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Transfer Information</title>
    <%@ include file="/layout/head.jsp"%>
</head>

<body>
<div class="container">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-5">
                <h1>Transfer Information</h1>
            </div>
            <div class="col-sm-7">
                <a href="./" class="btn btn-outline-light">
                    <i class="fa-solid fa-bars"></i>
                    <span>List of customers</span>
                </a>
            </div>
        </div>
    </div>

    <div>
        <table class="table table-hover table-borderless">
            <thead>
            <tr>
                <th>#</th>
                <th>Sender ID</th>
                <th>Sender Name</th>
                <th>Recipient ID</th>
                <th>Recipient Name</th>
                <th>Transfer Amount (VND)</th>
                <th>Fee (&)</th>
                <th>Fee Amount (VND)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="transferInfo" items="${transferInfoList}">
                <c:set var="totalFeeAmount" value="${totalFeeAmount+transferInfo.getFeeAmount()}"></c:set>
                <tr>
                    <td class="text-center">${transferInfo.getId()}</td>
                    <td class="text-center">${transferInfo.getSenderId()}</td>
                    <td>${transferInfo.getSenderName()}</td>
                    <td class="text-center">${transferInfo.getRecipientId()}</td>
                    <td>${transferInfo.getRecipientName()}</td>
                    <td class="text-end">${transferInfo.getTransferAmount()}</td>
                    <td class="text-end">${transferInfo.getFee()}</td>
                    <td class="text-end">${transferInfo.getFeeAmount()}</td>
                </tr>
            </c:forEach>
            <tr style="font-size: 25px">
                <td colspan="7" class="text-end">
                    <span style="font-weight: bold;">Total fee amount: </span>
                </td>
                <td class="text-end">${totalFeeAmount}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/layout/script.jsp"%>
</body>

</html>
