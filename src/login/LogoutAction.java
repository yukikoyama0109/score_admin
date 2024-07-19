package login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

@WebServlet("/logout.action")
public class LogoutAction extends Action{

	@Override
    public void execute(HttpServletRequest req, HttpServletResponse resp)
        throws Exception {
		HttpSession session = req.getSession();

		if (session.getAttribute("session_teacher") != null) {
			session.removeAttribute("session_teacher");
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("logout-error");
		}
    }
}
