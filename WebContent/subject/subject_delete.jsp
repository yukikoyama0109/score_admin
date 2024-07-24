
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
						<h2 class="mb-3 p-2 text rounded">科目情報削除</h2>
							<div class="message mb-2">
							 	<form action="SubjectDeleteExecute.action" method="post">
								<label>「${name}(${code})」を削除してもよろしいでしょうか</label>

                        			<div class="button mb-4">
										<!-- SubjectDeleteExecuteActionで受け取れるように設定 -->
										<input type="hidden" name="code" value="${code}">
										<input type="hidden" name="name" value="${name}">
		                                <input type="submit" value="削除" class="btn btn-danger" style="border-radius: 0;">

									</div>
								</form>
                       	 	</div>
                        <br>
                        <div>
                            <a href="SubjectList.action" class="me-5">戻る</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:param>
</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
