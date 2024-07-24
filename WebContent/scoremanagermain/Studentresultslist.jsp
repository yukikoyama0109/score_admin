<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

	<c:param name="title">学生管理一覧</c:param>
	<c:param name="body">
		<form action="itirann" method="post">
			<div>氏名：</div>
			<table>
				<thead>
                	<tr>
                        <th>科目名</th>
                        <th>科目コード</th>
                        <th>回数</th>
                        <th>点数</th>
                    </tr>
                    <tr>
						<td>学生情報(科目名)</td>
						<td>学生情報(科目コード)</td>
						<td>学生情報(回数)</td>
						<td>学生情報(点数)</td>
					</tr>
                </thead>
			</table>
		</form>
	</c:param>
</c:import>