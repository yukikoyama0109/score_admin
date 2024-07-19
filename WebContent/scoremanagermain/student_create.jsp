<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">
    <c:param name="title">学生新規登録</c:param>
    <c:param name="body">
        <div class="container">
            <h2>学生登録情報</h2>



            <form action="StudentCreateExecute.action" method="post">

                <label for="ent_year">入学年度:</label>
                <select id="ent_year" name="ent_year">
                    <option value="">-------------</option>
                    <c:forEach var="year" items="${ent_year_set}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>



                <label for="studentId">学生番号:</label>
                <input type="text" id="studentId" name="no" value="${studentId}" required>



                <label for="studentName">氏名:</label>
                <input type="text" id="studentName" name="name" value="${studentName}" required>



                <label for="class_num">クラス:</label>
                <select id="class_num" name="class_num">
                    <option value="">選択してください</option>
                    <c:forEach var="num" items="${class_num_set}">
                        <option value="${num}">${num}</option>
                    </c:forEach>
                </select>


                <button type="submit" name="end" class="submit-button">登録して終了</button>

				<a href="#">戻る</a>
            </form>



        </div>
    </c:param>
</c:import>


<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {

        margin: auto;
    }
    h2 {
        text-align: left; /* タイトルの左寄せ */
        margin-bottom: 1rem;
        background-color: #f2f2f2; /* タイトルの背景色を灰色に設定 */
        padding: 0.5rem; /* タイトルの余白を追加 */
        border-radius: 4px; /* タイトルの角丸を設定 */
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
    }
    label {
        margin-top: 1rem;
    }
    input[type="text"], input[type="number"], select {
        width: 100%;
        padding: 0.5rem;
        font-size: 1rem;
    }
    .submit-button {
        width: auto; /* 幅を自動調整 */
        align-self: flex-start;
        padding: 1rem;
        background-color: #4CAF50;
        color: white;
        border: none;
        font-size: 1rem;
        cursor: pointer;
        background-color: #808080;
        border-radius: 4px;
    }
</style>
