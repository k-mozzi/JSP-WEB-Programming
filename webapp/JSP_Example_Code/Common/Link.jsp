<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr>
		<td align="center">
		<% if(session.getAttribute("UserId") == null){ %>
			<a href="../ch6/LoginForm.jsp">로그인</a>
		<% } else { %>
			<a href="../ch6/Logout.jsp">로그아웃</a>
		<% } %>
			&nbsp;&nbsp;&nbsp;	<!-- 메뉴 사이의 공백 확보용 특수 문자 -->
			<a href="../ch8/List.jsp">게시판(페이징X)</a>
			&nbsp;&nbsp;&nbsp;
			<a href="../ch9/List.jsp">게시판(페이징O)</a>
		</td>
	</tr>
</table>