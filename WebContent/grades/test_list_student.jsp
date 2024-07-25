<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<style>
    .subject-info, .student-info, .guide-message {
        margin-bottom: 10px; /* 余白を調整 */
    }

    hr {
        margin-top: 40px;
        margin-bottom: 20px; /* 余白を調整 */
        border-width: 1px;
        border-color: #ccc;
    }

    h2 {
        background-color: #f0f0f0; /* 薄い灰色 */
        padding: 10px;
        border-radius: 5px;
    }

    .guide-message {
        color: blue;  /* 文字色を青に */
        background-color: white;  /* 背景色を白に */
        padding: 10px;
        border-radius: 5px;
    }

    .form-control-wide {
        width: 70%; /* 幅を70%に設定 */
    }

    .form-control-narrow {
        width: 110px; /* 幅を150pxに設定 */
    }

    .narrow-table {
        width: auto;
        margin-left: 0;
    }
</style>
<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="body">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="">
                    <div class="card-body">
                        <h2 class="mb-3 p-2 text rounded">成績参照</h2>
                        <div class="card">
                            <div class="card-body">
                                <div class="subject-info">
                                    <div class="row g-3 align-items-center">
                                        <div class="col-md-2 align-self-center">
                                            <strong>科目情報:</strong>
                                        </div>
                                        <form action="TestListSubjectExecute.action" method="post" class="row g-3">
                                        <div class="col-md-2">
                                            <label for="f1" class="form-label">入学年度:</label>
                                            <select name="f1" id="f1" class="form-select form-control-narrow">
                                                <option value="">-----------</option>
                                                <c:forEach var="year" items="${ent_year_set}">
                                                    <option value="${year}">${year}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
	                                        <div class="col-md-2">
	                                            <label for="f2" class="form-label">クラス:</label>
	                                            <select name="f2" id="f2" class="form-select form-control-narrow">
	                                                <option value="">----------</option>
	                                                <c:forEach var="num" items="${classList}">
	                                                    <option value="${num}">${num}</option>
	                                                </c:forEach>
	                                            </select>
	                                        </div>
                                        <div class="col-md-4">
                                            <label for="f3" class="form-label">科目:</label>
                                            <select name="f3" id="f3" class="form-select form-control-wide">
                                                <option value="">----------</option>
                                                <c:forEach var="subject" items="${subjectList}">
                                                    <option value="${subject.cd}">${subject.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-2 text-end">
                                            <button type="submit" class="btn btn-secondary">検索</button>
                                        </div>

                                       	<div class="errorMe text-warning justify-content-center">
											${errorMessage1}
										</div>
                                		</form>
                                    </div>
                                </div>

                                <hr>

                                <div class="student-info">
                                    <div class="row g-3 align-items-center">
                                        <div class="col-md-2 align-self-center">
                                            <strong>学生情報:</strong>
                                        </div>
                                        <form action="TestListStudentExecute.action" method="post" class="formX row g-3">
	                                        <div class="col-md-6">
	                                            <label for="f4" class="form-label">学生番号:</label>
	                                            <input type="text" name="f4" id="f4" class="form-control" required maxlength="10" placeholder="学生番号を入力してください" value="${f4}">
	                                        </div>
	                                        <div class="col-md-4 text-end">
	                                            <button type="submit" class="btn btn-secondary">検索</button>
	                                        </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>

						<div class="errorMe justify-content-center">
						<c:if test="${flag2 == 0 }">
							<p class="custom-header">氏名：${studentKeyName}（${studentKeyNo}）</p>
						</c:if>
							${errorMessage2}
						</div>

						<c:if test="${flag == 0 }">
	                        <div class="guide-message">
	                            科目情報を選択または学生番号を入力してクリックしてください
	                        </div>
                        </c:if>

                        <input type="hidden" name="sj" value="科目情報識別コード">
                        <input type="hidden" name="st" value="学生情報識別コード">
                    </div>
                </div>
            </div>
        </div>
<c:if test="${testListSub.size() > 0}">
        <form style="margin-left: 1em" action="itirann" method="post">
            <p class="custom-header">科目：${subjectKeyName}</p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>入学年度</th>
                            <th>クラス</th>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th>1回</th>
                            <th>2回</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tls" items="${testListSub}">
                            <tr>
                                <td>${tls.entYear}</td>
                                <td>${tls.classNum}</td>
                                <td>${tls.studentNo}</td>
                                <td>${tls.studentName}</td>
                                <c:forEach var="point" items="${tls.points}">
	                                <td>${point.key}</td>
	                                <td>${point.value > 0 ? point.value : '-'}</td>
                              	</c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
</c:if>


		<form style="margin-left: 1em" action="itirann" method="post">

            <c:if test="${testListStu.size() > 0}">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>科目名</th>
                            <th>科目コード</th>
                            <th>回数</th>
                            <th>点数</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tls" items="${testListStu}">
                            <tr>
                                <td>${tls.subjectName}</td>
                                <td>${tls.subjectCd}</td>
                                <td>${tls.num}</td>
                                <td>${tls.point}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            </c:if>
        </form>


    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

