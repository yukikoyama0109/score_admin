<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

<style>
    .bg-danger-light {
        background-color: #f8d7da; /* 赤色の明るいバリエーション */
    }

    .bg-success-light {
        background-color: #d1e7dd; /* 緑色の明るいバリエーション */
    }

    .bg-purple-light {
        background-color: #d6c8fa; /* 紫色の明るいバリエーション */
    }

    .box {
        height: 200px; /* 高さを調整 */
    }
        .box {
        height: 200px; /* ボックスの高さを調整 */
        font-size: 30px; /* ボックス内のテキストのフォントサイズを大きくする */
    }

    .box a {
        font-size: 30px; /* リンクのテキストのフォントサイズを大きくする */
    }
     h2 {
        background-color: #f0f0f0; /* 薄い灰色 */
        padding: 10px;
        border-radius: 5px;
    }

</style>

<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="body">
        <div class="container mt-4">
            <h2 class="mb-3 p-2  text rounded">メニュー</h2>
            <div class="row">
                <div class="col-md-4 mb-4">
                   <div class="box bg-danger-light text-center text-white p-5 rounded d-flex flex-column justify-content-center align-items-center"> <!-- 赤色 -->
                        <a href="scoremanager.main/StudentList.action" >学生管理</a>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="box bg-success-light text-center text p-5 rounded"> <!-- 緑色 -->
                        <div>成績管理</div>
                        <a href="#" >成績登録</a><br>
                        <a href="#" >成績参照</a>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="box bg-purple-light text-center text-white p-5 rounded d-flex flex-column justify-content-center align-items-center"> <!-- 紫色 -->
                        <a href="#" >科目管理</a>
                    </div>
                </div>
            </div>
        </div>
    </c:param>
</c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
