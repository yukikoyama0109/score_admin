package login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

@WebServlet("/login_execute.action")
public class LoginExecuteAction extends Action{
	public void execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

		HttpSession session = request.getSession();

		String login_id = request.getParameter("id");
		String password = request.getParameter("password");

//		System.out.println("★ login_id ->" + login_id);
//		System.out.println("★ password ->" + password);

		TeacherDAO dao = new TeacherDAO();
		Teacher teacher = dao.login(login_id, password);

//		System.out.println("★ teacher ->" + teacher);

		if (teacher != null) {
			session.setAttribute("session_teacher", teacher);
		response.sendRedirect("menu.jsp");

		} else {
			request.setAttribute("id", login_id);
			request.setAttribute("errorMessage", "ログイン名またはパスワードが違います");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}





		}

}
