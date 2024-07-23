<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">
    <c:param name="title">学生管理一覧</c:param>
    <c:param name="body">
        <div class="container mt-5">
            <form action="itirann" method="post">
                <div class="mb-3 row">
                    <label for="name" class="col-md-2 col-form-label">氏名：${student.name}</label>
                    <!--  <input type="text" id="name" name="name" class="form-control" />-->
                </div>
                <br> <!-- 改行を追加 -->
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>科目名</th>
                            <th>科目コード</th>
                            <th>回数</th>
                            <th>点数</th>
                        </tr>
                    </thead>
                     <c:forEach var="student" items="${students}">
                    <tbody>
                        <tr>
                            <td>${subject.name}</td>
                            <td>${subject.cd}</td>
                            <td>${test.point}</td>
                            <td>${test.point}</td>
                        </tr>
                    </tbody>
                    </c:forEach>
                </table>
            </form>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
