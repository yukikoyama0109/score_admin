<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生情報変更</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <c:import url="/base.jsp">
        <c:param name="title">学生情報変更</c:param>
        <c:param name="body">
            <div class="container mt-5">
               <div class="row border mx-1 mb-3 py-2 align-items-center rounded" id="filter" style="background-color: #f0f0f0;">
                 <h2>学生情報変更</h2>
               </div>
                <form action="StudentUpdateExecute.action" method="post">
                    <div class="mb-3">
                        <label for="code" class="form-label">入学年度</label>
                    	<input type="text" class="form-control" value="${entYear}" readonly>
                    </div>

                    <div class="mb-3">
                        <label for="code" class="form-label">学生番号</label>
                    	<input type="text" class="form-control" name="no" value="${no}" readonly>
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">氏名</label>
                        <input type="text" class="form-control" id="name" name="name" value="${name}" maxlength="30" required>
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">クラス</label>
                        <select name="class_num" value="${num}" id="class_num" class="form-select">
		                    <c:forEach var="class_num" items="${class_num_set}">
		                        <option value="${class_num}">${class_num}</option>
		                    </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3 d-flex align-items-center">
                        <label for="is_attend" class="form-label mb-0">在学中</label>
                        <input type="checkbox" class="form-check ms-2" id="is_attend" name="is_attend" value="t" <c:if test="${!empty is_attend}">checked!</c:if>>
                    </div>

                    <button type="submit" class="btn btn-primary">変更</button>
                    <p class="mt-3"><a href="StudentList.action">戻る</a></p>
                </form>
            </div>
        </c:param>
    </c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
