package grades;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TestDAO;
import tool.Action;

@WebServlet("/test_list_subject_execute.action")
public class TestListSubjectExecuteAction extends Action {
	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
    		throws Exception {
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("session_teacher");
        String entYearStr = "";
		String classNum = ""; //入力されたクラス番号
        int entYear = 0; //入学年度
        String subjectName = "";
        String noStudent = "";

    	//リクエストパラメーターの取得
    	entYearStr = req.getParameter("f1");
    	classNum = req.getParameter("f2");
    	subjectName = req.getParameter("f3");
//      noStudent = req.getParameter("f4");

    	System.out.println((entYearStr) + " -  " +classNum + " -  " + subjectName +  "!!!!");

    	//ビジネスロジック
    	if (entYearStr != null ) {
    		// 数値に変換
			entYear = Integer.parseInt(entYearStr);

		} else {
			//検索条件不足エラーのエラーメッセージ
			req.setAttribute("errorMe", "入学年度とクラスと科目を選択してください");
			req.getRequestDispatcher("test_list.jsp").forward(req, res);

		}

    	TestDAO tDao = new TestDAO();





    }
}
