package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); //セッション
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");
		boolean subjects = false;

		Subject subject = new Subject();

//		入力されたものをsubjectにセット
		subject.setCd(request.getParameter("cd"));
		subject.setName(request.getParameter("name"));

//		学校コードをセッションから取得してsubjectにセット
		subject.setSchool(teacher.getSchool());
//		インスタンス生成
		SubjectDAO subDao = new SubjectDAO();
//		saveメソッドを実行
		subjects = subDao.save(subject);


//		jspへフォワード
		if (subjects) {
			request.getRequestDispatcher("subject_create_done.jsp").forward(request, response);
		} else{

		}

	}
}
