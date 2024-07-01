package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao{

	private String baseSql;

	public Student get(String no) throws Exception{

	}

	private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
		//リストを初期化
		List<Student> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//学生インスタンスを初期化
				Student student = new Student();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
			}
		} catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}

	}

	private List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {

	}

	private List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {

	}

	private List<Student> filter(School school, boolean isAttend) throws Exception {

	}

	private boolean save(Student student) throws Exception {

	}

	private String baseSql = "select * from student where school_cd=? ";


}