package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Teacher;

public class TeacherDAO extends DAO{
	public Teacher login(String id, String password) throws Exception {
		Teacher teacher = null;

		Connection con = getConnection();

		School school = new School();

		PreparedStatement st;
		st = con.prepareStatement("select * from teacher where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

//		System.out.println("★ SQL ->" + st);

		SchoolDAO schoolDAO = new SchoolDAO();

		if (rs.next()) {
			teacher = new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setPassword(rs.getString("password"));
//			teacher.setName(rs.getString("name"));
//			school.setCd(rs.getString("cd"));
			teacher.setSchool(schoolDAO.get(rs.getString("school_cd")));
		}


		st.close();
		con.close();

		return teacher;
	}
//	public Teacher get(String id)throws Exception {
//
//		Teacher teacher = null;
//
//		Connection con = getConnection();
//
//		School school = new School();
//
//		PreparedStatement st;
//		st = con.prepareStatement("select cd from school");
//
//		st.close();
//		con.close();
//
//		return teacher;
//	}

}




