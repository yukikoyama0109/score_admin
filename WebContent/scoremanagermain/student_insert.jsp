<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="body">
        <div class="container">
            <h2>学生登録情報</h2>
            <form action="register" method="post">
                <label for="ent_year">入学年度:</label>
                <select id="ent_year" name="ent_year" class="input-field">
                    <option value="">-------------</option>
                    <c:forEach var="year" items="${entYearList}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>

                <label for="studentId">学生番号:</label>
                <input type="text" id="studentId" name="no" class="input-field" required>

                <label for="studentName">氏名:</label>
                <input type="text" id="studentName" name="name" class="input-field" required>

                <label for="classId">クラス:</label>
                <select id="classId" name="class_num" class="input-field">
                    <option value="">選択してください</option>
                    <c:forEach var="classNum" items="${classNumList}">
                        <option value="${classNum}">${classNum}</option>
                    </c:forEach>
                </select>

                <button type="submit" class="submit-button">登録して終了</button>
            </form>
            <p><a href="#">戻る</a></p>
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
        text-align: left;
        margin-bottom: 1rem;
        background-color: #f2f2f2;
        padding: 0.5rem;
        border-radius: 4px;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
    }
    label {
        margin-top: 1rem;
    }
    .input-field {
        width: 100%;
        padding: 0.5rem;
        font-size: 1rem;
    }
    .submit-button {
        width: auto;
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