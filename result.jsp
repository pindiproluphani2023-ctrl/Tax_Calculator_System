<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html> 
<html> 
<head> 
    <title>Tax Result</title> 
    <link rel="stylesheet" href="style.css"> 
</head> 
<body> 
 
<div class="bg"> 
    <div class="card"> 
        <h1>Your<span>Tax</span></h1> 
 
        <% 
            String error = (String) request.getAttribute("error"); 
            Double income = (Double) request.getAttribute("income"); 
            Double tax = (Double) request.getAttribute("tax"); 
        %> 
 
        <div class="result"> 
            <% if (error != null) { %> 
                <p class="error"><%= error %></p> 
            <% } else { %> 
                <p><b>Income:</b> ₹ <%= income %></p> 
                <p class="success"><b>Tax Payable:</b> ₹ <%= tax %></p> 
            <% } %> 
        </div> 
 
        <a href="index.html"> 
            <button style="margin-top:25px;">Calculate Again    </button> 
        </a> 
    </div> 
</div> 
 
</body> 
</html>