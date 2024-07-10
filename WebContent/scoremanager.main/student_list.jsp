<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

	<c:param name="title">学生管理一覧</c:param>

	<c:param name="body">

		<form action="itirann" method="post">
		<h2>学生管理一覧</h2>
			<label>入学年度</label>
			<select name="f1"></select>

			<label>クラス</label>
			<select name="f2"></select>

			<p>在学中ON/OFF<input type="checkbox"name="f3"></p>

			<label>在学中</label>

			<a href="#">新規登録</a>

			<input type="button" value="絞り込み">

			<div>検索結果件数</div>
			<table>
				<thead>
                	<tr>
                        <th>入学年度</th>
                        <th>学生番号</th>
                        <th>氏名</th>
                        <th>クラス</th>
                        <th>在学中</th>
                    </tr>
                </thead>
				<tr>

					<td>学生情報(入学年度)</td>
					<td>学生情報(学生番号)</td>
					<td>学生情報(氏名)</td>
					<td>学生情報(クラス)</td>
					<td>学生情報(在学中)</td>
				</tr>
			</table>

			<a href="#">新規登録</a>

			<div>学生情報無しメッセージ</div>

		</form>

	</c:param>
</c:import>