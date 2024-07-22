<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">
    <c:param name="title">学生新規登録</c:param>
    <c:param name="body">
        <div class="container">
            <h2 class="text-left p-2 bg-light rounded">学生登録情報</h2>
            <form action="StudentCreateExecute.action" method="post" class="row g-3">
            	<!-- 入学年度 -->
                <div class="col-12">
                    <label for="ent_year" class="form-label">入学年度</label>
                    <select id="ent_year" name="ent_year" class="form-select">
                        <option value="">-------------</option>
                        <c:forEach var="year" items="${ent_year_set}">
                            <option value="${year}">${year}</option>
                        </c:forEach>
                    </select>
                </div>

				<!-- 学生番号 -->
                <div class="col-12">
                    <label for="studentId" class="form-label">学生番号</label>
                     <input type="text" id="studentId" name="no" class="form-control" value="${no}" required maxlength="10" placeholder="学生番号を入力してください">
                </div>

				<!-- 氏名 -->
                <div class="col-12">
                    <label for="studentName" class="form-label">氏名</label>
                    <input type="text" id="studentName" name="name" class="form-control" value="${name}" required maxlength="30" placeholder="氏名を入力してください">
                </div>

				<!-- クラス -->
                <div class="col-12">
                    <label for="class_num" class="form-label">クラス</label>
                    <select id="class_num" name="class_num" class="form-select">
                        <option value="">選択してください</option>
                        <c:forEach var="num" items="${class_num_set}">
                            <option value="${num}">${num}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-secondary">登録して終了</button>
                </div>
                <a href="StudentList.action">戻る</a>
            </form>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
