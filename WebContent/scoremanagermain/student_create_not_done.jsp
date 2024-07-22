<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<style>
    h2 {
        background-color: #f0f0f0; /* 薄い灰色 */
        padding: 10px;
        border-radius: 5px;
        margin-top: 0rem;
        border-radius: 0; /* 角を四角に */
    }

        .alert {
        border-radius: 0; /* 角を四角に */
    }

        .large-margin {
        margin-top: 6rem; /* 3remのカスタムマージン */
    }
</style>
<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="body">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card-body">
						<h2 class="mb-3 p-2 text rounded">学生情報登録</h2>
							<div class="alert alert-danger alert-dismissible my-2 py-1 " role="alert">
							    <h4 class="fs-7 m-0 text-center">登録が完了していません</h4>

							<div class="alert alert-warning alert-dismissible my-2 py-1">
							    <label>
									<p>以下の項目に改めて確認してください</p>
									<p>・入学年度またはクラスは入力するのを忘れているか？</p>
									<p>・学生番号が重複しているか？</p>
								</label>
							</div>
							</div>
                        <div>
                            <a href="StudentCreate.action" class="me-5">戻る</a>
                            <a href="StudentList.action">学生一覧</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
