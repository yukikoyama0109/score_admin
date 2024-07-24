<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>科目情報変更</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <c:import url="/base.jsp">
        <c:param name="title">科目情報変更</c:param>
        <c:param name="body">
            <div class="container mt-5">
               <div class="row border mx-1 mb-3 py-2 align-items-center rounded" id="filter" style="background-color: #f0f0f0;">
                 <h4>科目情報変更</h4>
               </div>
                <form action="SubjectUpdateExecute.action" method="post">
                    <div class="mb-3">
                        <label for="code" class="form-label">科目コード</label>
                    </div>
                    	<input type="text" value="${code}" name="cd" readonly>
                    <div class="mb-3">
                        <label for="name" class="form-label">科目名</label>
                        <input type="text" class="form-control" id="name" name="name" value="${name}" maxlength="20" required>
                    </div>
                    <button type="submit" class="btn btn-primary">変更</button>
                    <p class="mt-3"><a href="SubjectList.action">戻る</a></p>
                </form>
            </div>
        </c:param>
    </c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
