package scoremanagermain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import tool.Action;

@WebServlet("/student_create.action")
public class StudentCreateAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(); //セッション

		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		String entYearStr = ""; //入力された入学年度
		String classNum = ""; //入力されたクラス番号
		int entYear = 0; //入学年度
//		boolean isAttend = false; //在学フラグ
		List<Student> students = null; //学生リスト
		LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
		int year = todaysDate.getYear(); //現在の年を取得
		ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化


		//リクエストパラメーターの取得 2 ★
		entYearStr = request.getParameter("ent_year"); //元はreqと書いてある
		classNum = request.getParameter("class_num");

		//DBからデータ取得 3 ★
		//　ログインユーザーの学校コードを元にクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());

		//ビジネスロジック 4 ★
		if (entYearStr != null) {
			// 数値に変換
			entYear = Integer.parseInt(entYearStr);
		}
		//リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年間から1年後まで年をリストに追加
		for(int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		// レスポンス値をセット 6 ★
		//リクエストに入学年度をセット
		request.setAttribute("entYear", entYear);

		//リクエストにクラスに番号をセット
		request.setAttribute("classNum", classNum);

		//リクエストに学生リストをセット
		request.setAttribute("students", students);
		//リクエストにデータをセット
		request.setAttribute("class_num_set", list);
		request.setAttribute("ent_year_set", entYearSet);


//		JSPへフォワード 7 ★
//		response.sendRedirect("../menu.jsp");
		request.getRequestDispatcher("student_create.jsp").forward(request, response);


	}
}