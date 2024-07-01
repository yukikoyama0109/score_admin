package scoremanager.main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); //セッション
		Teacher teacher = (Teacher)session.getAttribute("user");

		String entYearStr = ""; //入力された入学年度
		String classNum = ""; //入力されたクラス番号
		String isAttendStr = ""; //入力された在学フラグ
		int entYear = 0; //入学年度
		boolean isAttend = false; //在学フラグ
		List<Student> students = null; //学生リスト
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear(); //現在の年を取得
		StudentDao sDao = new StudentDao(); //学生Dao
		ClassNumDao cNumDao = new StudentDao(); //クラス番号Daoを初期化
		Map<String, String> errors = new HashMap<>(); //エラーメッセージ

	}

}

