<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<title>Pet Shop</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li><a href="index.do">home</a></li>
            <li><a href="about.do">about us</a></li>
            <li><a href="pets.do">pets</a></li>
            <li><a href="specials.do">specials pets </a></li>
            
         
           
             <c:if test="${ empty sessionScope.clientid }">
            	<li><a href="myaccount.do">my accout</a></li>
	            <li><a href="register.do">register</a></li>
            </c:if>
 	
          
            
          
            
           
            
            <li><a href="contact.do">contact</a></li>
            
            	 <c:if test="${ !empty sessionScope.clientid }">
            	 	              <li><a href="cart.do?userid=${sessionScope.clientid }">prices</a></li>    
            	 
            	  <li> <a href="logout.do">logout</a>
            	   </c:if>
           
            </ul>
        </div>     
            
            
       </div> 
       
       