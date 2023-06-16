<%@ page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h4>Include 페이지</h4>
<%
int pInteger2 = (Integer) (pageContext.getAttribute("pageInteger"));
/* String pString2 = pageContext.getAttribute("pageString").toString(); */
Person pPerson2 = (Person) (pageContext.getAttribute("pagePerson"));
%>
<ul>
	<li>Integer Object: <%=pInteger2%></li>
	<li>String Object: <%=pageContext.getAttribute("pageString")%></li>
	<li>Person Object: <%=pPerson2.getName()%>, <%=pPerson2.getAge()%></li>
</ul>