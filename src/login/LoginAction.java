package login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

@WebServlet("/login.action")
public class LoginAction extends Action{

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
