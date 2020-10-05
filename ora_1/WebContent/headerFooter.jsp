<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   header {
      width: 1000px;
      height: 100px;
      margin-top: 10px;
      font-family: 'NEXON Lv1 Gothic Low OTF';
      border: solid 1px red;
   }
   #logo {
       float: left; 
   }
   #top {
      margin: 30px 20px 0 0;
      font-size: 12px;
      float: right;
      text-align: right;   
   }
   #login {
      font-size: 11px;
      text-align: right;
   }
   section {
      font-family: 'NEXON Lv1 Gothic Low OTF';
   }
   footer {
       width: 1000px;
       height: 150px;
       margin-top: 30px;
       font-family: 'NEXON Lv1 Gothic Low OTF';
       border: solid 1px green;
      }
    #footer_box {
       width: 1000px;
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
    }
   * {
      margin: 0px;
      padding: 0px;
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
   
     <section>
     <h2>공지사항</h2>
   <hr>
   <table border="1">
      <tr>
         <td>카테고리</td>
         <td>제목</td>
         <td>등록일</td>
         <td>조회수</td>
      </tr>
      <c:forEach var="n" items="${list }">
         <tr>
            <td>${n.code_name }</td>
            <td>${n.n_title }</td>
            <td>${n.n_regdate }</td>
            <td>${n.n_hit }</td>
         </tr>
      </c:forEach>
   </table>
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