<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>${ param.title }</title>
<style>
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #f8f9fa;
    padding: 10px;
  }
  header h1 {
    margin: 0;
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
        width: 100%;
        height: 600px;
        display: flex;
        flex-direction: row;
    }
    #sidebar {
        box-sizing: border-box;
        width: 15%;
        padding-left: 1rem;

    }
    #content {
        box-sizing: border-box;
        width: 85%;
        padding-top: 1rem;
        padding-left: 2rem;
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
</style>
</head>

<body>

<header>
  <h1>得点管理システム</h1>
	<p>ユーザー名表示予定</p>
  <a href="somepage.jsp" class="header-link">ログアウト</a>
</header>

<div class="menu-container">

    <ul>
    	<li><a href="#">メニュー</a>
        <li><a href="#">学生管理</a></li>
        <li>
            <label>成績管理</label>
            <ul>
                <li><a href="#">成績登録</a></li>
                <li><a href="#">成績参照</a></li>
            </ul>
        </li>
        <li><a href="#">科目管理</a></li>
    </ul>
</div>
${ param.body }
<footer>
  <p>@ 2023 TIC</p>
  <p>大原学園</p>
</footer>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</html>
