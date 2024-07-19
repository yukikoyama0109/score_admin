package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO{

//	getメソッド
	public Subject get(String cd, School school)throws Exception{
		//科目インスタンスを初期化
		Subject subject = new Subject();
		Connection connection = getConnection();

		PreparedStatement statement = null;

		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from SUBJECT where cd=?  and  school_cd=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1, cd);
			statement.setString(2, school.getCd());
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			//学校Daoを初期化
			SchoolDAO schoolDAO = new SchoolDAO();


			if (rSet.next()) {
				//リザルトセットが存在する場合
				//学生インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
				//学校フィールドには学校コードで検索した学校インスタンスをセット
				subject.setSchool(schoolDAO.get(rSet.getString("school_cd")));

			} else {
				//リザルトセットが存在しない場合
				//学生インスタンスに検索結果をセット
				subject = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			//プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return subject;
	}
	//filterメソッド
	public List<Subject> filter(School school)throws Exception{

		//リストを初期化
		List<Subject> list = new ArrayList<>();

		//科目インスタンスを初期化
				Subject subject = new Subject();
		//コネクションを確立
		Connection connection = getConnection();

		//プリペアードステートメント
		PreparedStatement statement = null;



		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from subject where school_cd=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1, school.getCd());
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			//学校Daoを初期化
			SchoolDAO schoolDAO = new SchoolDAO();


			if (rSet.next()) {
				//リザルトセットが存在する場合
				//学生インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
				//学校フィールドには学校コードで検索した学校インスタンスをセット
				subject.setSchool(schoolDAO.get(rSet.getString("school_cd")));

			} else {
				//リザルトセットが存在しない場合
				//学生インスタンスに検索結果をセット
				subject = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			//プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return list;

	}

	public boolean save(Subject subject)throws Exception{

		//コネクションを確立
				Connection connection = getConnection();
				//プリペアードステートメント
				PreparedStatement statement = null;


				//実行件数
				int count = 0;
				try {
					//データベースから科目を取得
					Subject old = get(subject.getCd(), subject.getSchool());
					if (old == null) {
						//科目が存在していなかった場合
						//プリペアードステートメントにINSERT文をセット
						statement = connection.prepareStatement(
								"insert into subject(cd, name, school_cd) values(?, ?, ?)");
						statement.setString(1, subject.getCd());
						statement.setString(2, subject.getName());
						statement.setString(3, subject.getSchool().getCd());

					} else {
						//科目が存在した場合
						//プリペアードステートメントにUPDATE文をセット
						statement = connection.prepareStatement(
								"update subject set cd=?, name=?, school_cd=? where cd=?");
						statement.setString(1, subject.getName());
						statement.setString(2, subject.getSchool().getCd());
						statement.setString(3, subject.getCd());

					}

					//プリペアードステートメントを実行
					count = statement.executeUpdate();

				} catch (Exception e) {
					throw e;
				} finally {
					//プリペアードステートメントを閉じる
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException sqle) {
							throw sqle;
						}
					}
					//コネクションを閉じる
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException sqle) {
							throw sqle;
						}
					}
				}

				if (count > 0) {
					//実行件数が1件以上ある場合
					return true;
				} else {
					//実行件数が０件の場合
					return false;
				}

	}

	public boolean delete(Subject subject)throws Exception{
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//実行件数
		int count = 0;

		try {
			//データベースから科目を取得
			Subject old = get(subject.getCd(), subject.getSchool());

				//プリペアードステートメントにDELETE文をセット
				statement = connection.prepareStatement(
						"delete from subject where cd=?");
				statement.setString(1, subject.getCd());

			//プリペアードステートメントを実行
			count = statement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			//プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		} else {
			//実行件数が０件の場合
			return false;
		}

	}


}
