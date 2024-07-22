package grades;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;

@WebServlet("/test_list.action")
public class TestListAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("session_teacher");

        try {
            // ユーザーが所属する学校を取得
            School school = teacher.getSchool();

            // クラスデータの取得
            ClassNumDAO classNumDAO = new ClassNumDAO();
            List<String> classList = classNumDAO.filter(school);
            req.setAttribute("classList", classList);

            // 科目データの取得
            SubjectDAO subjectDAO = new SubjectDAO();
            List<Subject> subjectList = subjectDAO.filter(school);
            req.setAttribute("subjectList", subjectList);

            // test_list.jsp へのフォワード
            req.getRequestDispatcher("test_list.jsp").forward(req, res);
        } catch (Exception e) {
            throw new IOException("Data retrieval failed", e);
        }









    }

    private void setTestListSubject(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // ここで科目リストの設定などの処理を行う



    }

    private void setTestListStudent(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // ここで学生リストの設定などの処理を行う
    }
}
