//齊藤璃恩
//エラーメッセージ変更中


package scoremanagermain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_create_execute.action")
public class StudentCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(); // セッション
        boolean students = false;
        Teacher teacher = (Teacher) session.getAttribute("session_teacher");
        LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
		int year = todaysDate.getYear(); //現在の年を取得
		//リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		// 10年間から1年後まで年をリストに追加
		for(int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化
		List<String> list = cNumDao.filter(teacher.getSchool());
        try {


            String studentId = request.getParameter("no");
            String studentName = request.getParameter("name");
            String entYearStr = request.getParameter("ent_year");
            String class_num = request.getParameter("class_num");
            boolean isAttend = true;
            String school = teacher.getSchool().getCd();



            //変更途中
            // 入学年度が選択されているか確認
            if (entYearStr == null || entYearStr.isEmpty()) {
            	request.setAttribute("ent_year_set", entYearSet);
            	request.setAttribute("errorEntYear", "入学年度を選択してください");
                request.setAttribute("no", studentId);
                request.setAttribute("name", studentName);
                request.setAttribute("class_num_set", list);
                request.getRequestDispatcher("student_create.jsp").forward(request, response);
                return;
            }

            int entYear = Integer.parseInt(entYearStr);


            StudentDAO sDao = new StudentDAO();
            students = sDao.insert(studentId, studentName, entYear, class_num, isAttend, school);
		} catch (Exception e) {
			throw e;
		}

        //変更途中
        // JSPへフォワード
        if (students) {
            request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
        } else {
        	request.setAttribute("ent_year_set", entYearSet);
        	request.setAttribute("class_num_set", list);

            request.setAttribute("errorStudentId", "学生番号が重複しています");
            request.setAttribute("no", request.getParameter("no"));
            request.setAttribute("ent_year", request.getParameter("ent_year"));
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("class_num", request.getParameter("class_num"));
            request.getRequestDispatcher("student_create.jsp").forward(request, response);


            return; // 重複エラー時に戻るため
//            request.getRequestDispatcher("student_create_not_done.jsp").forward(request, response);


        }
    }
}
