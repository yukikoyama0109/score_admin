<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">ログイン</c:param>
<c:param name="body">

<form action="login-execute.action" method="post">
	<p>ログインID<input type="text" name="id" value="${id}"></p>
	<p>パスワード<input type="password" name="password" value="${password}"></p>
	<p>パスワード表示/非表示<input type="checkbox" name="chk_d_ps" ></p>
	<label>パスワード表示</label>
	<input type="submit" type="button" name="login" value="ログイン">


</form>

</c:param>

</c:import>