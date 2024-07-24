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
import bean.TestListSubject;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import dao.TestListSubjectDAO;
import tool.Action;

@WebServlet("/test_list_subject_execute.action")
public class TestListSubjectExecuteAction extends Action {
	@Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
    		throws Exception {
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("session_teacher");
        School school = teacher.getSchool();
        LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
        int year = todaysDate.getYear(); //現在の年を取得

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


        String entYearStr = "";
		String classNum = ""; //入力されたクラス番号
        int entYear = 0; //入学年度
        String subjectCd = "";
        String noStudent = "";

    	//リクエストパラメーターの取得
    	entYearStr = req.getParameter("f1");
    	classNum = req.getParameter("f2");
    	subjectCd = req.getParameter("f3");
    	noStudent = req.getParameter("f4");

    	System.out.println("f1-"+entYearStr + " f2-" +classNum + " f3-" + subjectCd + " f4-" + noStudent);

    	if (entYearStr == "" || classNum == "" || subjectCd == "") {
//    		//検索条件不足エラーのエラーメッセージ
            req.setAttribute("errorMe", "入学年度とクラスと科目を選択してください");
    		req.getRequestDispatcher("test_list.jsp").forward(req, res);
		}

		//ビジネスロジック
		if (entYearStr != null) {
			// 数値に変換
			entYear = Integer.parseInt(entYearStr);
		}

		List<TestListSubject> testListSubject = null;
		TestListSubjectDAO tlsDao = new TestListSubjectDAO();


        // 科目データの取得
        SubjectDAO subjectDAO = new SubjectDAO();
        List<Subject> subjectList = null;
        subjectList = subjectDAO.filter(teacher.getSchool());

        Subject subject = subjectDAO.get(subjectCd, school);

		testListSubject = tlsDao.filter(entYear, classNum, subject, school);


		System.out.println(testListSubject);

    	System.out.println("ok!");

    	req.getRequestDispatcher("test_list_student.jsp").forward(req, res);

    	TestDAO tDao = new TestDAO();





    }
}
