<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

* {
	margin: 0px;
	padding: 0px;
}

header {
	width: 1140px;
	height: 120px;
	margin: 0 auto;
	font-family: 'NEXON Lv1 Gothic Low OTF';
	border: solid 1px red;
}

#logo {
	float: left; 
	margin: 20px 0 0 20px;
}

#top {
	margin: 30px 20px 0 0;
	font-size: 16px;
	float: right;
	text-align: right;   
}

#login {
	font-size: 14px;
	text-align: right;
}
   
h2 {
	border: solid 1px orange;
	padding: 20px;
	width: 120px;
	margin: 40px auto;
	color: #88bea6;
	text-align: center;
	font-family: 'NEXON Lv1 Gothic Low OTF';
}

#contents {
	width: 1100px;
	height: 700px;
	margin: 20px auto;
	font-family: 'NEXON Lv1 Gothic Low OTF';
	border: solid 1px yellow;
}

table, th, td {
	border: solid 1px #fff2e4;
	border-collapse: collapse;
}

th {
	padding: 6px;
	text-align: center;
	background-color: #fff2e4;
}

td {
	padding: 6px;
	text-align: center;
}

footer {
	width: 100%;
	height: 150px;
	margin-top: 30px;
	font-family: 'NEXON Lv1 Gothic Low OTF';
	border: solid 1px green;
}

#footer_box {
	width: 1140px;
	height: 150px;
	margin: 0 auto;
	text-align: center;
}

#footer_icon{
	margin: 0 auto;
}

#address {
	margin: 10px 0 0 0;
	font-size: 11px;
	list-style-type: none;
}



</style>

</head>
<body>
   <header>
      <div id="logo">
         <img src='img/logo.png' height="100">
      </div>
      <div id="login">
         summer님의 마이페이지
         <img src="img/myIcon.png" height="40">
         &nbsp;&nbsp;
      </div>
      <div id="top">
         오늘의 라이딩&nbsp;&nbsp;&nbsp;&nbsp;자전거길&nbsp;&nbsp;&nbsp;&nbsp;후기게시판&nbsp;&nbsp;&nbsp;&nbsp;번개게시판&nbsp;&nbsp;&nbsp;&nbsp;정보게시판
      </div>
   </header>
   
		<h2>공지사항</h2>
		<hr>
		<section id="contents">
			<table border="1" width="100%">
		      <tr>
		         <th>${n.code_name }</th>
		         <th>${n.n_title }</th>
		         <th>${n.n_regdate }</th>
		         <th>${n.n_hit }</th>
		      </tr>
		    </table> 

			<br>
			<p>${n.n_content }</p><br>
		</section>
     
   <footer>
      <div id='footer_box'>
            <div id="footer_icon" >
               <img src='img/instagram.png' height="50px">
               <img src='img/facebook.png' height="50px">
               <img src='img/twitter.png' height="50px">
               <ul id="address">
                  <li>04108 | 서울시 마포구 백범로 23 구프라자 3층</li>
                  <li>TEL: 02-707-1480 | Email: ora@bit.com</li>
                  <li>COPYRIGHT (C)2020 오늘의 라이딩 ALL RIGHTS RESERVED</li>
               </ul>
            </div>
            
         </div>
   </footer>
</body>
</html>