package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;

public class SchoolDAO extends DAO{

	public School get(String no) throws Exception{

		School school = new School();
		Connection con = getConnection();

		//プリペアードステートメント

		PreparedStatement st=null;

		try {
			st = con.prepareStatement("select cd from school");

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				school.setCd(rs.getString("cd"));

//				school.setName(rs.getString("name"));

			} else {

				//リザルトセットが存在しない場合
				//学生インスタンスに検索結果をセット
				school = null;
			}

		} catch (Exception e) {

			throw e;

		} finally {
			//プリペアードステートメントを閉じる
			if (st != null) {

				try {
					st.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}

			//コネクションを閉じる

			if (con != null) {
				try {
					con.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return school;

	}

}
