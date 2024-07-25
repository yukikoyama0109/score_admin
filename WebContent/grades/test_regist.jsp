<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">
    <c:param name="title">成績管理一覧</c:param>
    <c:param name="body">
        <form action="TestRegist.action" method="post" class="mt-4">
          <div class="row border mb-3 py-2 align-items-center rounded" id="filter" style="background-color: #f0f0f0;">
		  	<h2>成績管理</h2>
		  </div>
            <div class="row">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-2">
                        <label class="form-label" for="student-f1-select">入学年度</label>
                        <select class="form-select" id="student-f1-select" name="f1">
                            <option value="0">--------</option>
                            <c:forEach var="year" items="${ent_year_set}">
                                <option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-2">
                        <label class="form-label" for="student-f2-select">クラス</label>
                        <select class="form-select" id="student-f2-select" name="f2">
                            <option value="0">--------</option>
                            <c:forEach var="num" items="${class_num_set}">
                                <option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-3">
                        <label class="form-label" for="student-f3-select">科目</label>
                        <select class="form-select" id="student-f3-select" name="f3">
                            <option value="0">--------</option>
                            <c:forEach var="subject" items="${subjectList}">
                                <option value="${subject.cd}" <c:if test="${subject.cd==f3}">selected</c:if>>${subject.cd}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-2">
                        <label class="form-label" for="student-f4-select">回数</label>
                        <select class="form-select" id="student-f4-select" name="f4">
                            <option value="0">--------</option>
                            <c:forEach var="num" items="${numList}">
                                <option value="${num}" <c:if test="${num==f4}">selected</c:if>>${num}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-2">
                        <button type="submit" class="btn btn-primary mt-4">検索</button>
                    </div>
                </div>
            </div>
        </form>

        <div>

            <form action="TestRegistExecute.action" method="post">

                <div>

                    <label for="name">科目：${subject.name}</label>

                    <!--  <input type="text" id="name" name="name" class="form-control" />-->

                </div>

                <table class="table table-striped">

                    <thead>

                        <tr>
                            <th>入学年度</th>
                            <th>クラス</th>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th>点数</th>
                        </tr>

                    </thead>

                     <c:forEach var="testregist" items="${testregist}">

                    <tbody>

                        <tr>

                            <td>${f1}</td>
                            <td>${f2}</td>
                            <td>${testregist.student.no}</td>
                            <td>${testregist.student.name}</td>
                            <td><input type="text" name="point_${student.no}" value="${testregist.point}" class="form-control" /></td>

                        </tr>

                    </tbody>

                    </c:forEach>

                </table>

 				<div>
                    <input type="button" value="登録して終了" class="btn btn-success" style="background-color:#6c757d;">
                </div>

            </form>

        </div>

    </c:param>

    </c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

