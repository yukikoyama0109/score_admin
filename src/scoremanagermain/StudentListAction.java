package scoremanagermain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_list.action")
public class StudentListAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); //セッション
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		String entYearStr = ""; //入力された入学年度
		String classNum = ""; //入力されたクラス番号
		String isAttendStr = ""; //入力された在学フラグ
		int entYear = 0; //入学年度
		boolean isAttend = false; //在学フラグ
		List<Student> students = null; //学生リスト
		LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
		int year = todaysDate.getYear(); //現在の年を取得
		StudentDAO sDao = new StudentDAO(); //学生Dao
		ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化
		Map<String, String> errors = new HashMap<>(); //エラーメッセージ


		//リクエストパラメーターの取得 2 ★
		entYearStr = request.getParameter("f1"); //元はreqと書いてある
		classNum = request.getParameter("f2");
		isAttendStr = request.getParameter("f3");


		//DBからデータ取得 3 ★
		//　ログインユーザーの学校コードを元にクラス番号の一覧を取得
		System.out.println("----------------テストはじめ----------------");

		System.out.println("sesion_teacher checked :"+teacher.getSchool());
		List<String> list = cNumDao.filter(teacher.getSchool());

//		System.out.println(list);
//		System.out.println("checked!");
//		System.out.println("sDao:" + sDao);
//		System.out.println("classNum.equals: " + classNum.equals("0"));
//		System.out.println("classNum" + classNum);

//		students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
		if (entYear != 0 && !classNum.equals("0")) {
			//入学年度とクラス番号を指定
			students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
		} else if (entYear != 0 && classNum.equals("0")) {
			 //入学年度のみ指定
			 students = sDao.filter(teacher.getSchool(), entYear, isAttend);
		} else if (entYear != 0 && classNum == null || entYear == 0 ) {
			//指定なしの場合
			//全学生情報を取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		} else {
			errors.put("f1", "クラスを指定する場合は入学年度を指定してください");
			request.setAttribute("errors", errors);
			//全学生情報を取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		}

		System.out.println("students検索 checked: " + students);

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
		request.setAttribute("f1", entYear);
		//リクエストにクラスに番号をセット
		request.setAttribute("f2", classNum);

		//在学フラグが送信されていた場合
		if (isAttendStr != null) {
			//在学フラグを立てる
			isAttend = true;
			// リクエストに在学フラグをセット
			request.setAttribute("f3", isAttendStr);
		}
		//リクエストに学生リストをセット
		request.setAttribute("students", students);
		//リクエストにデータをセット
		request.setAttribute("class_num_set", list);
		request.setAttribute("ent_year_set", entYearSet);
		System.out.println("★検索した後");
		System.out.println("entYear（入学年度）: "+entYear);
		System.out.println("classNum（クラス） : " + classNum);
		System.out.println("isAttendStr（在学中）：	 :"+isAttendStr);
		System.out.println("class_num_set（クラスの一覧）: "+list);
		System.out.println("entYearSet（入学年度の一覧）: "+entYearSet);
		System.out.println("---------------------------------------------");



		//JSPへフォワード 7 ★
		request.getRequestDispatcher("student_list.jsp").forward(request, response);
	}

}

