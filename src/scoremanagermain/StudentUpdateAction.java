/*
	日付：2024/07/21
	作成者:グェン
	内容：学生更新
*/

package scoremanagermain;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_update.action")
public class StudentUpdateAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		String noStr = ""; //学生番号

		//リクエストパラメーターの取得
		noStr = request.getParameter("no");

		System.out.println("ーーーーーーーー学生情報変更のテストーーーーーー");
		System.out.println("変更のボタンをクリックしたら、得た学生番号（Primary Key)：" + noStr);

		Student student = null; //学生リスト
		StudentDAO sDao = new StudentDAO();
		student = sDao.get(noStr);

		ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化

		List<String> list = cNumDao.filter(teacher.getSchool());

		request.setAttribute("entYear", student.getEntYear());
		request.setAttribute("no", student.getNo());
		request.setAttribute("name", student.getName());
		request.setAttribute("num", student.getClassNum());
		request.setAttribute("class_num_set", list);
		request.setAttribute("student", student);

		//リクエストに学生リストをセット
		request.getRequestDispatcher("student_update.jsp").forward(request, response);


	}
}