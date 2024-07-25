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
import dao.StudentDAO;
import dao.SubjectDAO;
import tool.Action;

@WebServlet("/test_regist.action")
public class TestRegistAction extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(); //セッション
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		String entYearStr = ""; //入力された入学年度
		String classNum = ""; //入力されたクラス番号
		String subject = "";//入力された科目
		String num = "1";//入力された回目

		try {


			ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化
			StudentDAO sDao = new StudentDAO(); //学生Dao
			SubjectDAO subDao = new SubjectDAO();//科目Dao


			entYearStr = request.getParameter("f1"); //元はreqと書いてある
			classNum = request.getParameter("f2");
			subject = request.getParameter("f3");
			num = request.getParameter("f4");

			System.out.println("test");

			System.out.println(teacher.getSchool());
			System.out.println("checked!");


			// 入学年度データの取得
			LocalDate todaysDate = LocalDate.now(); //LocalDateインスタンスを取得
			int year = todaysDate.getYear(); //現在の年を取得

			List<Integer> entYearSet = new ArrayList<>();
			// 10年間から1年後まで年をリストに追加
			for(int i = year - 10; i < year + 1; i++) {
				entYearSet.add(i);
			}
			//jspで表示できるようにセット
			request.setAttribute("ent_year_set", entYearSet);

			// クラスデータの取得
			// セッションからユーザーが所属する学校を取得
	        School school = teacher.getSchool();
	        // ユーザーが所属する学校からクラスリストを取得
	        List<String> classList = cNumDao.filter(school);
	        //jspで表示できるようにセット
	        request.setAttribute("class_num_set", classList);

	        // 科目データの取得
	        List<Subject> subjectList = null;
	        // ユーザーが所属する学校コードから科目リストを取得
	        subjectList = subDao.filter(school);
	        //jspで表示できるようにセット
	        request.setAttribute("subjectList", subjectList);

	        //回数の取得
	        List<Integer> numList = new ArrayList<>() ;

	//        回目の取得
	//        test
	        numList.add(1);
	        numList.add(2);
	        //jspで表示できるようにセット
	        request.setAttribute("numList", numList);

	        System.out.println("------TestRegistAction------");
	        System.out.println("入学年度" + entYearSet);
	        System.out.println("クラスデータ" + classList);
	        System.out.println("科目データ" + subjectList);
	        System.out.println("回目データ" + numList);
	        System.out.println("------TestRegistAction------///");

	        request.getRequestDispatcher("test_regist.jsp").forward(request, response);

		} catch (Exception e) {
            throw new IOException("Data retrieval failed", e);
        }

	}
//	成績を絞り込みするメソッド
	private void setRequestData(HttpServletRequest req, HttpServletResponse res) throws Exception {

	}
}

