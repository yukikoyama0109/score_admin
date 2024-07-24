package grades;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("session_teacher");
		LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
        int year = todaysDate.getYear(); //現在の年を取得

        try {
            // ユーザーが所属する学校を取得
            School school = teacher.getSchool();

    		//リストを初期化
    		List<Integer> entYearSet = new ArrayList<>();
    		// 10年間から1年後まで年をリストに追加
    		for(int i = year - 10; i < year + 1; i++) {
    			entYearSet.add(i);
    		}

    		// 入学年度データの取得
    		req.setAttribute("ent_year_set", entYearSet);

            // クラスデータの取得
            ClassNumDAO classNumDAO = new ClassNumDAO();
            List<String> classList = classNumDAO.filter(school);
            req.setAttribute("classList", classList);

            // 科目データの取得
            SubjectDAO subjectDAO = new SubjectDAO();
            List<Subject> subjectList = null;
            subjectList = subjectDAO.filter(teacher.getSchool());
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
