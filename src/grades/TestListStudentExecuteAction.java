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
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestListStudentDAO;
import tool.Action;

@WebServlet("/test_list_student_execute.action")
public class TestListStudentExecuteAction extends Action {
	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
    		throws Exception {
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("session_teacher");
        School school = teacher.getSchool();
        LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
        int year = todaysDate.getYear(); //現在の年を取得
        int flag = 0; //flag = false
        try {
            // ユーザーが所属する学校を取得

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

        } catch (Exception e) {
            throw new IOException("Data retrieval failed", e);
        }
//-------------------------------------------------------------------------------
        try {
        	String noStudent = "";

        	//リクエストパラメーターの取得
        	noStudent = req.getParameter("f4");


        	Student student = null; //学生リスト
        	StudentDAO sDao = new StudentDAO(); //学生Dao
        	student = sDao.get(noStudent);

        	List<TestListStudent> testListStudent = null;
        	TestListStudentDAO tlstuDao = new TestListStudentDAO();


        	testListStudent = tlstuDao.filter(student);

        	if (testListStudent.size() >0) {
        		req.setAttribute("flag2",flag);
    			req.setAttribute("studentKeyName", student.getName());
    			req.setAttribute("studentKeyNo", student.getNo());
    			req.setAttribute("testListStu", testListStudent);

    		} else {
    			req.setAttribute("flag2",flag);
    			req.setAttribute("studentKeyName", student.getName());
    			req.setAttribute("studentKeyNo", noStudent);
    			req.setAttribute("errorMessage2", "学生情報が存在しませんでした");
    			req.setAttribute("testListStu", testListStudent);
    		}
    		req.getRequestDispatcher("test_list_student.jsp").forward(req, res);

        } catch (Exception e) {
        	req.setAttribute("flag2",flag+1);
        	req.setAttribute("errorMessage2", "学生情報が存在しませんでした");
        	req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
		}












    }
}
