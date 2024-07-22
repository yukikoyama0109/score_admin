/*
	日付：2024/07/18
	作成者:グェン
*/


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO{

	private String baseSql = "select * from student where school_cd=? ";

	//getメソッド
	public Student get(String no) throws Exception{
		//学生インスタンスを初期化
		Student student = new Student();
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;

		try {
			//プリペアードステートメントにSQL文をセット
			st = connection.prepareStatement("select * from student where no=?");
			//プリペアードステートメントに学生番号をバインド
			st.setString(1, no);
			//プリペアードステートメントを実行
			ResultSet rSet = st.executeQuery();

			//学校Daoを初期化
			SchoolDAO schoolDAO = new SchoolDAO();

			if (rSet.next()) {
				//リザルトセットが存在する場合
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getShort("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				//学校フィールドには学校コードで検索した学校インスタンスをセット
				student.setSchool(schoolDAO.get(rSet.getString("school_cd")));
			} else {
				//リザルトセットが存在しない場合
				//学生インスタンスに検索結果をセット
				student = null;
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
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return student;
	}

	// postFilterメソッド ★
	private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
		//リストを初期化
		List<Student> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//学生インスタンスを初期化
				Student student = new Student();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(school);
				//リストに追加
				list.add(student);
			}
		} catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}
		return list;
	}

	// filterメソッド ★
	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
		//リストを初期化
		List<Student> list = new ArrayList<>();
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;
		// リザルトセット
		ResultSet rSet = null;
		// Sql文の条件
		String condition = "and ent_year=? and class_num=?";
		// Sql文のソート
		String order = " order by no asc";

		//SQL文の在学フラグ条件
		String conditionIsAttend = "";
		//在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}

		try {
			//プリペアードステートメントにSQL文をセット
			st = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
			//プリペアードステートメントに学校コードをバインド
			st.setString(1, school.getCd());
			//プリペアードステートメントに入学年度をバインド
			st.setInt(2, entYear);
			//プリペアードステートメントにクラス番号をバインド
			st.setString(3, classNum);
			//プリペアードステートメントを実行
			rSet = st.executeQuery();
			//リストへの格納処理を実行
			list = postFilter(rSet, school);
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

	public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {
		//リストを初期化
		List<Student> list = new ArrayList<>();
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;
		// リザルトセット
		ResultSet rSet = null;
		// Sql文の条件
		String condition = "and ent_year=? ";
		// Sql文のソート
		String order = " order by no asc";

		//SQL文の在学フラグ条件
		String conditionIsAttend = "";
		//在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}

		try {
			//プリペアードステートメントにSQL文をセット
			st = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
			//プリペアードステートメントに学校コードをバインド
			st.setString(1, school.getCd());
			//プリペアードステートメントに入学年度をバインド
			st.setInt(2, entYear);
			//プリペアードステートメントを実行
			rSet = st.executeQuery();

			//リストへの格納処理を実行
			list = postFilter(rSet, school);
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

	public List<Student> filter(School school, boolean isAttend) throws Exception {
		//リストを初期化
		List<Student> list = new ArrayList<>();
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;
		// リザルトセット
		ResultSet rSet = null;
		// Sql文のソート
		String order = " order by no asc";

		//SQL文の在学フラグ条件
		String conditionIsAttend = "";
		//在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}

		try {
			//プリペアードステートメントにSQL文をセット
			st = connection.prepareStatement(baseSql + conditionIsAttend + order);
			//プリペアードステートメントに学校コードをバインド
			st.setString(1, school.getCd());
			//プリペアードステートメントを実行
			rSet = st.executeQuery();
			//リストへの格納処理を実行
			list = postFilter(rSet, school);
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

//	DBに学生を保存するメソッド
	public boolean save(Student student) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;
		//実行件数
		int count = 0;

		try {
			//データベースから学生を取得
			Student old = get(student.getNo());
			System.out.println("checkk old in Dao: "+old);
			if (old == null) {
				//学生が存在していなかった場合
				//プリペアードステートメントにINSERT文をセット
				st = connection.prepareStatement(
						"insert into student(no, name, ent_year, class_num, is_attend, school_cd) values(?, ?, ?, ?, ?, ?)");
				st.setString(1, student.getNo());
				st.setString(2, student.getName());
				st.setInt(3, student.getEntYear());
				st.setString(4, student.getClassNum());
				st.setBoolean(5, student.isAttend());
				st.setString(6, student.getSchool().getCd());
			} else {
				//学生が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				st = connection.prepareStatement(
						"update student set name=?, ent_year=?, class_num=?, is_attend=? where no=?");
				st.setString(1, student.getName());
				st.setInt(2, student.getEntYear());
				st.setString(3, student.getClassNum());
				st.setBoolean(4, student.isAttend());
				st.setString(5, student.getNo());
			}

			//プリペアードステートメントを実行
			count = st.executeUpdate();

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

	//学生登録
	public boolean insert(String no, String name, int ent_year, String class_num, Boolean isAttend, String school) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = null;

		//実行件数
		int count = 0;

		//プリペアードステートメントにINSERT文をセット
		try {
			st = con.prepareStatement(
				"insert into student(no, name, ent_year, class_num, is_attend, school_cd) values(?, ?, ?, ?, ?, ?)");
			st.setString(1, no);
			st.setString(2, name);
			st.setInt(3, ent_year);
			st.setString(4, class_num);
			st.setBoolean(5, isAttend);
			st.setString(6, school);


			//プリペアードステートメントを実行
			count = st.executeUpdate();

		} catch (Exception e) {
			//no（key)もう存在してるか入力値が見つからない場合はエラーが起こる
			System.out.println("▼　ユニークインデックス、またはプライマリキー違反です！");
			return false;

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

		if (count > 0) {
			//実行件数が1件以上ある場合
			System.out.println("★　学生新規登録が完成しました！");
			return true;
		} else {
			//実行件数が０件の場合
			System.out.println("★　学生新規登録が失敗しました！");
			return false;
		}

	}


//	DBに学生を保存するメソッド
	public boolean update(Student student, String name, String classNum, Boolean isAttend) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement st = null;
		//実行件数
		int count = 0;

		try {
			//データベースから学生を取得
			Student old = get(student.getNo());
			if (old == null) {
				//学生が存在していなかった場合
				//プリペアードステートメントにINSERT文をセット
				st = connection.prepareStatement(
						"insert into student(no, name, ent_year, class_num, is_attend, school_cd) values(?, ?, ?, ?, ?, ?)");
				st.setString(1, student.getNo());
				st.setString(2, student.getName());
				st.setInt(3, student.getEntYear());
				st.setString(4, student.getClassNum());
				st.setBoolean(5, student.isAttend());
				st.setString(6, student.getSchool().getCd());
			} else {
				//学生が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				st = connection.prepareStatement(
						"update student set name=?, ent_year=?, class_num=?, is_attend=? where no=?");
				st.setString(1, name);
				st.setInt(2, student.getEntYear());
				st.setString(3, classNum);
				st.setBoolean(4, isAttend);
				st.setString(5, student.getNo());
			}

			//プリペアードステートメントを実行
			count = st.executeUpdate();

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
