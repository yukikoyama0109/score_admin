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

//		Subject subject = new Subject();

        String cd = request.getParameter("cd");
        String name = request.getParameter("name");



		if (cd == null || cd.length() != 3) {
            request.setAttribute("errorCd", "科目コードは3文字で入力してください");
            request.setAttribute("cd", cd);
            request.setAttribute("name", name);
            request.getRequestDispatcher("subject_create.jsp").forward(request, response);
            return;

		}

        // SubjectDAOのインスタンス生成
        SubjectDAO subjectDao = new SubjectDAO();

        // 科目が既に存在するかチェック
        if (subjectDao.get(cd, teacher.getSchool()) != null) {
            request.setAttribute("errorCd", "科目コードが重複しています");
            request.setAttribute("cd", cd);
            request.setAttribute("name", name);
            request.getRequestDispatcher("subject_create.jsp").forward(request, response);
            return;
        }

        // 新しい科目を作成して保存
        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(teacher.getSchool());

        subjects = subjectDao.save(subject);


//		jspへフォワード
		if (subjects) {
			request.getRequestDispatcher("subject_create_done.jsp").forward(request, response);
		} else{

		}

	}
}
