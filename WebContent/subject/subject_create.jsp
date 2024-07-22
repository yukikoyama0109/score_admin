<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">
    <c:param name="title">科目情報登録</c:param>
    <c:param name="body">
        <div class="container">
            <h2 class="text-left p-2 bg-light rounded">科目情報登録</h2>
            <form action="SubjectCreateExecute.action" method="post" class="row g-3">
            	<!-- 科目コード -->
                <div class="col-12">
                    <label for="cd" class="form-label">科目コード</label>
                    <input type="text" name="cd" class="form-control" value="${cd}" required maxlength="3" placeholder="科目コードを入力してください">
                </div>

				<!-- 科目名 -->
                <div class="col-12">
                    <label class="form-label">科目名</label>
                    <input type="text" name="name" value="${name}" required maxlength="20" placeholder="科目名を入力してください">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-secondary">登録</button>
                </div>
                <a href="SubjectList.action">戻る</a>
            </form>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
