package menu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

@WebServlet("/menu.action")
public class menuAction extends Action{

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}
