<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title}</title>
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

header {
  background-color: #f8f9fa;
  padding: 15px;
  display: flex;
  justify-content: space-between;

}

header h1 {
margin-top: 15px;
margin-left:25px;
font-weight: 600;
}

.header-link {
  color: blue;
  text-decoration: underline;
  font-size: 16px;
  cursor: pointer;
}

footer {
  background-color: #d3d3d3;
  padding: 10px;
  text-align: center;
}

#container {
  display: flex;
  margin-top: 20px; /* ページの上部からのマージンを追加 */
  margin-bottom: 20px; /* ページの下部からのマージンを追加 */
}

#sidebar {
  width: 200px;
  padding-left: 1rem;
  background-color: #ffffff;
}

#content {
  flex: 1; /* コンテンツ部分を伸縮させて残りのスペースを埋める */
  padding: 1rem;
}

nav ul {
  list-style-type: none;
  padding: 0;
}

nav ul li {
  margin-bottom: 0.5rem;
}

nav ul li a {
  text-decoration: none;
  color: #333;
}

nav ul li a:hover {
  text-decoration: underline;
}

.userNameLogin {
	float: center;
	margin-right: 15px;

}
.divLogin{
	display: flex;
	margin-top: 23px;
	margin-right: 50px;
}
#sidebar {
  width: 200px;
  padding-left: 1rem;
  background-color: #ffffff;
  border-right: 1px solid gray; /* 縦線の色を灰色に変更 */
}
nav ul li a {
  text-decoration: none;
  color: blue; /* リンクの色を青色に変更 */
}
</style>
</head>

<body>

<header>
	<h1>得点管理システム</h1>

	<c:if test="${not empty session_teacher.id}">
		<div class="divLogin">
		  <p class="userNameLogin">${ session_teacher.name }様</p>
		  <a href="../login/Logout.action" class="header-link">ログアウト</a>
		</div>
	</c:if>

</header>

<div id="container">
	<c:if test="${not empty session_teacher.id}">
		<div id="sidebar">
		    <nav>
		      <ul>
		        <li><a href="../menu/menu.action">メニュー</a></li>
		        <li><a href="../scoremanagermain/StudentList.action">学生管理</a></li>
		        <li>
		          <label>成績管理</label>
		          <ul>
		            <li><a href="../grades/TestRegist.action">ㅤ成績登録</a></li>
		            <li><a href="../grades/TestList.action">ㅤ成績参照</a></li>
		          </ul>
		        </li>
		        <li><a href="../subject/SubjectList.action">科目管理</a></li>
		      </ul>
		    </nav>
		</div>
	</c:if>

  	<div id="content">
    	${param.body}
  	</div>
</div>

<footer>
  <p>@ 2023 TIC</p>
  <p>大原学園</p>
</footer>

</body>
</html>
