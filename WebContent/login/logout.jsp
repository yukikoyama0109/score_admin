<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<style>
    h2 {
        background-color: #f0f0f0; /* 薄い灰色 */
        padding: 10px;
        border-radius: 5px;
    }
</style>
<c:import url="/base.jsp">
    <c:param name="title">成績登録完了</c:param>
    <c:param name="body">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card-body">
						<h2 class="mb-3 p-2 text rounded">ログアウト</h2>
							<div class="alert alert-success alert-dismissible my-2 py-1 text-center" role="alert" style="background-color: #d4edda; border-color: #c3e6cb; color: #155724;">
							    <p class="fs-7 m-0">ログアウトしました</p>
							</div>

                        <br>
                        <a href="Login.action">ログイン</a>
                    </div>
                </div>
            </div>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
