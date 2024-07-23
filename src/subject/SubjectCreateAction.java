package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class SubjectCreateAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(); //セッション

		String subjectcd = ""; //入力された科目コード
		String subjectname = ""; //入力された科目の名前


		subjectcd = request.getParameter(""); //引数を後で入力
		subjectname = request.getParameter(""); //引数を後で入力

		request.getRequestDispatcher("subject_create.jsp").forward(request, response);



	}
}
