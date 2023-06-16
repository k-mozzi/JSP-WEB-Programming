<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - forward</title>
</head>
<body>
	<h2>포워드 결과</h2>
	<p>
	<b><i>내장 객체의 영역</i></b><br/>
	1) page 영역: 동일한 페이지에서만 공유<br/>
	2) request 영역: 하나의 요청에 의해 호출된 페이지와 포워드된 페이지까지 공유<br/>
	3) session 영역: 클라이언트가 처음 접속한 후 웹 브라우저를 닫을 때까지 공유<br/>
	4) application 영역: 한 번 저장되면 웹 애플리케이션이 종료될 때까지 유지
	</p>
	<ul>
		<li>page 영역 : <%=pageContext.getAttribute("pAttr")%>
		</li>
		<li>request 영역 : <%=request.getAttribute("rAttr")%>
		</li>
	</ul>
</body>
</html>