package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");
		SubjectDAO subDao = new SubjectDAO();

//		boolean型の変数の生成
		boolean subjects = false;
		Subject subject = new Subject();


//		入力されたものをsubjectにセット
		subject.setCd(request.getParameter("cd"));
		subject.setName(request.getParameter("name"));

//		学校コードをセッションから取得してsubjectにセット
		subject.setSchool(teacher.getSchool());

//		saveメソッドを実行する
		subjects = subDao.save(subject);

//		saveメソッドを実行できているとsubjectsがtrueになるのでフォワードされる
		if (subjects) {
//			フォワード
			request.getRequestDispatcher("subject_update_done.jsp").forward(request, response);
		} else {

		}


	}
}
