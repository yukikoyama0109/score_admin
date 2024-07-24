package subject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;


public class SubjectListAction extends Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); //セッション
		Teacher teacher = (Teacher)session.getAttribute("session_teacher");

		List<Subject> SubjectsCdList = null;

		ClassNumDAO cNumDao = new ClassNumDAO(); //クラス番号Daoを初期化
		SubjectDAO subDao = new SubjectDAO(); //初期化


		System.out.println("----------科目管理のテストはじめ---------------");

		//　ログインユーザーの学校コードを元にクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());
		System.out.println("class_num_set（クラスの一覧）: "+list);

		System.out.println(subDao.filter(teacher.getSchool()));
		//科目コードリストを初期化
		SubjectsCdList = subDao.filter(teacher.getSchool());

//		リクエストに科目一覧をセット
		request.setAttribute("subjects", SubjectsCdList);


		//リクエストにデータをセット
		request.setAttribute("class_num_set", list);



		//リクエストに学生リストをセット
//				request.setAttribute("subject_cd", subject_cd);

		//JSPへフォワード
				request.getRequestDispatcher("subject_list.jsp").forward(request, response);




	}


}
