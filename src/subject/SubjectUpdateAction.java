package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		Subject subject = null;
		SubjectDAO subDao = new SubjectDAO();

//		変更する科目コードを入れるための変数code
		String code = "";

//		jspから変更したい科目の科目コードを取得
		code = request.getParameter("code");

//		getメソッドを実行し変更したい科目の科目コードと科目名を取得
		subject =subDao.get(code, teacher.getSchool());

//		jspで科目コードと科目名を表示できるようにセット
		request.setAttribute("code", code);
		request.setAttribute("name", subject.getName());
//		JSPへフォワード
		request.getRequestDispatcher("subject_update.jsp").forward(request, response);

	}
}

