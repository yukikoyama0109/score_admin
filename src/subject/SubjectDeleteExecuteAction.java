package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");
		SubjectDAO subDao = new SubjectDAO();

		boolean subjects = false;
		Subject subject = new Subject();

//		入力されたものをsubjectにセット
		subject.setCd(request.getParameter("code"));
		subject.setName(request.getParameter("name"));



//		学校コードをセッションから取得してsubjectにセット
		subject.setSchool(teacher.getSchool());
		//テスト
		System.out.println("------SubjectDeleteExecuteAction-----");
		System.out.println("get出来てますか:code=" + request.getParameter("code"));
		System.out.println("get出来てますか:name=" + request.getParameter("name"));
		System.out.println(subject);
		System.out.println("------SubjectDeleteExecuteAction-----///");


//		deleteメソッドを実行
		subjects = subDao.delete(subject);


		if (subjects) {
//			フォワード
			request.getRequestDispatcher("subject_delete_done.jsp").forward(request, response);
		} else {
			System.out.println("出来てないよ");

		}

	}
}
