package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		Subject subject = null;
		SubjectDAO subDao = new SubjectDAO();
//		消去したい科目の科目コードを入れるための変数code
		String code = "";
//		jspから科目コードを取得
		code = request.getParameter("code");
//		jspからとったcodeとセッションからとった学校コード(school_cd)を引数にしてgetメソッドを実行
		subject =subDao.get(code, teacher.getSchool());

//		テスト
		System.out.println("-----SubjectDeleteAction----");
		System.out.println("SubjectDeleteAction" +code);
		System.out.println("SubjectDeleteAction" +teacher.getSchool());
		System.out.println("SubjectDeleteAction" +subject);
		System.out.println("-----SubjectDeleteAction----///");

//		jspで表示できるようにセット
		request.setAttribute("code", code);
		request.setAttribute("name", subject.getName());


//		削除ページをフォワード
		request.getRequestDispatcher("subject_delete.jsp").forward(request, response);

	}
}
