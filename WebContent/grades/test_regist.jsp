<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">
    <c:param name="title">成績管理一覧</c:param>
    <c:param name="body">
        <form action="TestRegist.action" method="post" class="mt-4">
          <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter" style="background-color: #f0f0f0;">
		  	<h2 class="mb-4">成績管理</h2>
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
                        <label class="form-label" for="student-f4-select">回目</label>
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

        <!-- koyama -->
        <c:choose>
                <c:when test="${tests.size() > 0}">
                    <div><h4>検索結果：${tests.size()}件</h4></div>
                    <form action="TestRegistExecute.action"method="post">
                    <table class="table table-hover">
                        <tr>
                            <th>入学年度</th>
                            <th>クラス</th>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th><input type="text" name="point_${student_no} }">点数</th>

                        </tr>
                        <c:forEach var="test" items="${tests}">
                            <tr>
                                <td>${test.entYear}</td>
                                <td>${test.classNum}</td>
                                <td>${test.student_no}</td>
                                <td>${test.name}</td>
                                <td ${test.point}></td>

                                <!-- <td><a href="StudentUpdate.action?no=${student.no}">変更</a></td> -->
                            </tr>
                        </c:forEach>
						<div class="col-2">
                       		<button type="submit" class="btn btn-primary mt-4">登録して終了</button>
						</div>
                    </table>
                    </form>
                </c:when>
                <c:otherwise>
                    <div>成績情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
         </form>
         <!-- koyama/// -->
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
