<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<style>
    .custom-btn {
        padding: 0.25rem 0.5rem; /* ボタンのパディングを調整 */
        font-size: 0.875rem; /* ボタンのフォントサイズを調整 */
    }
</style>
<c:import url="/base.jsp">

<c:param name="title">ログイン</c:param>
<c:param name="body">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">ログイン</h3>
                </div>
                <div class="card-body">
                    <form action="LoginExecute.action" method="post">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingId" name="id" value="${id}" placeholder="ログインID" required>
                            <label for="floatingId">ログインID</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="floatingPassword" name="password" value="${password}" placeholder="パスワード" required>
                            <label for="floatingPassword">パスワード</label>
                        </div>
                        <div class="form-check d-flex justify-content-center mb-3">
                            <input type="checkbox" class="form-check-input" name="chk_d_ps" id="chkShowPassword">
                            <label class="form-check-label" for="chkShowPassword">パスワード表示</label>
                        </div>
                        <div class="mt-2 text-danger">
							<br>${errorMessage}
						</div>
                        <div class="row justify-content-center">
                            <div class="col-md-6 text-center"> <!-- ボタンを中心に揃え -->
                                <button class="btn btn-primary w-100 py-2 mt-3" type="submit">ログイン</button> <!-- ボタンの幅を100%に設定 -->
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</c:param>

</c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

<script>
    // チェックボックスの状態に応じてパスワード表示を切り替える
    document.getElementById('chkShowPassword').addEventListener('change', function() {
        var passwordField = document.getElementById('floatingPassword');
        if (this.checked) {
            passwordField.type = 'text'; // テキスト表示に切り替える
        } else {
            passwordField.type = 'password'; // パスワード表示に戻す
        }
    });
</script>
