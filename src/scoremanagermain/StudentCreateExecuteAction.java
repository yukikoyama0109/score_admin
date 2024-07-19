package scoremanagermain;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_create_execute.action")
public class StudentCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); //セッション
		boolean students = false;
		try{
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		String studentId = request.getParameter("no");
		String studentName = request.getParameter("name");
		int entYear = Integer.parseInt(request.getParameter("ent_year"));
		String class_num = request.getParameter("class_num");
		boolean isAttend = true;
		String school = teacher.getSchool().getCd();

		System.out.println("------------学生新規登録のテスト-------------");
		System.out.println("★★★ Insert checked: "+studentId+"--"+studentName+"--"+entYear+"--"+class_num+"--"+isAttend+"--"+school);


		StudentDAO sDao = new StudentDAO();
			students = sDao.insert(studentId, studentName, entYear, class_num, isAttend, school);
		} catch (Exception e) {
			System.out.println("▼ Error: NumberFormatException.forInputString");
			request.getRequestDispatcher("student_create_not_done.jsp").forward(request, response);
		}

		////JSPへフォワード
		if (students) {
			request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("student_create_not_done.jsp").forward(request, response);
		}



	}
}