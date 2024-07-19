<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="body">
	<h2 style="background-color: #f8f9fa; padding: 10px;">科目管理</h2>    	<div class="text-right">
<div class="text-right">
    <a href="#" class="btn btn-primary">新規登録</a>
</div>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col">科目コード</th>
                    <th scope="col">科目名</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>科目コードデータ</td>
                    <td>科目名データ</td>
                    <td><a href="#">変更</a></td>
                    <td><a href="#">削除</a></td>
                </tr>
            </tbody>
        </table>
	</c:param>
</c:import>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>