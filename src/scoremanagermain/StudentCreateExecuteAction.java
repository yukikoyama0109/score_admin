//齊藤璃恩
//エラーメッセージ変更中


package scoremanagermain;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_create_execute.action")
public class StudentCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(); // セッション
        boolean students = false;
        try {
            Teacher teacher = (Teacher) session.getAttribute("session_teacher");

            String studentId = request.getParameter("no");
            String studentName = request.getParameter("name");
            String entYearStr = request.getParameter("ent_year");
            String class_num = request.getParameter("class_num");
            boolean isAttend = true;
            String school = teacher.getSchool().getCd();

            //変更途中
            // 入学年度が選択されているか確認
            if (entYearStr == null || entYearStr.isEmpty()) {
                request.setAttribute("errorEntYear", "入学年度を選択してください");
                request.setAttribute("no", studentId);
                request.setAttribute("name", studentName);
                request.setAttribute("class_num", class_num);
                request.getRequestDispatcher("student_create.jsp").forward(request, response);
                return;
            }

            int entYear = Integer.parseInt(entYearStr);

            System.out.println("------------学生新規登録のテスト-------------");
            System.out.println("★★★ Insert checked: " + studentId + "--" + studentName + "--" + entYear + "--" + class_num + "--" + isAttend + "--" + school);

            StudentDAO sDao = new StudentDAO();
            students = sDao.insert(studentId, studentName, entYear, class_num, isAttend, school);
		} catch (Exception e) {
			System.out.println("▼ Error: NumberFormatException.forInputString");
			request.getRequestDispatcher("student_create_not_done.jsp").forward(request, response);

		}

        //変更途中
        // JSPへフォワード
        if (students) {
            request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
        } else {
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
