<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<style>
    .error-message {
        color: #FFCC00;

        padding: 0.5rem;
        border-radius: 0.25rem;
    }
</style>

<c:import url="/base.jsp">
    <c:param name="title">科目情報登録</c:param>
    <c:param name="body">
        <div class="container">
            <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>
            <form action="SubjectCreateExecute.action" method="post" class="row g-3">
                <!-- 科目コード -->
                <div class="col-12">
                    <label for="cd" class="form-label">科目コード</label>
                    <input type="text" name="cd" id="cd" class="form-control" value="${cd}" required maxlength="3" placeholder="科目コードを入力してください">
                    <c:if test="${not empty errorCd}">
                        <div class="error-message">${errorCd}</div>
                    </c:if>
                </div>

                <!-- 科目名 -->
                <div class="col-12">
                    <label for="name" class="form-label">科目名</label>
                    <input type="text" name="name" id="name" class="form-control" value="${name}" required maxlength="20" placeholder="科目名を入力してください">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-secondary" style="background-color:#0d6efd;">登録</button>
                </div>

                <div>
                    <a href="SubjectList.action">戻る</a>
                </div>
            </form>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
