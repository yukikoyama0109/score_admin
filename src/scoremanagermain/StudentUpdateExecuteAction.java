/*
	日付：2024/07/21
	作成者:グェン
	内容：学生更新
*/

package scoremanagermain;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

@WebServlet("/student_update_execute.action")
public class StudentUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Student student = null;
		StudentDAO sDao = new StudentDAO();
		boolean isAttend = false; //在学フラグ



		//リクエストパラメーターの取得
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String num = request.getParameter("class_num");
		String isAttendStr = request.getParameter("is_attend");

		//在学フラグが送信されていた場合
		if (isAttendStr != null) {
			//在学フラグを立てる
			isAttend = true;
		}

//		System.out.println("checkkkk no:  "+no);
//		System.out.println("checkkkk name:  "+name);
//		System.out.println("checkkkk num:  "+num);
//		System.out.println("checkkkk isattend:  "+isAttend);



		student = sDao.get(no);

		Boolean studentUpdate = false;
		studentUpdate = sDao.update(student, name, num, isAttend);

		//リクエストに学生リストをセット
		request.getRequestDispatcher("student_update_done.jsp").forward(request, response);




	}
}