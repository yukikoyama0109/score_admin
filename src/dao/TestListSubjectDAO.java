package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO {

    private String baseSql = "select * from test where student_no=? ";

    // postFilterメソッド
    private List<TestListSubject> postFilter(ResultSet rSet) throws Exception {
        // リストを初期化
        List<TestListSubject> list = new ArrayList<>();
        try {
            while (rSet.next()) {
                // 学生インスタンスを初期化
                TestListSubject testlistsubject = new TestListSubject();
                // 学生インスタンスに検索結果をセット
                testlistsubject.setEntYear(rSet.getInt("entYear"));
                testlistsubject.setStudentNo(rSet.getString("studentNo"));
                testlistsubject.setStudentName(rSet.getString("studentName"));
                testlistsubject.setClassNum(rSet.getString("classNum"));
                // pointsフィールドに値を設定
                Map<Integer, Integer> points = new HashMap<>();
                points.put(rSet.getInt("subject_id"), rSet.getInt("points"));
                testlistsubject.setPoints(points);


                // リストに追加
                list.add(testlistsubject);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return list;
    }

    // filterメソッド
    public List<TestListSubject> filter(int entYear, String classNum, Subject subject, School school) throws Exception {
        List<TestListSubject> list = new ArrayList<>();
        // コネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメント
        PreparedStatement st = null;
        // リザルトセット
        ResultSet rSet = null;

        try {
            // プリペアードステートメントにSQL文をセット
            st = connection.prepareStatement(baseSql);
            // プリペアードステートメントに学生番号をバインド
            st.setString(1, subject.getCd()); // 学生番号に該当する項目をセット
            // プリペアードステートメントを実行
            rSet = st.executeQuery();
            // リストへの格納処理を実行
            list = postFilter(rSet);
        } catch (Exception e) {
            throw e;
        } finally {
            // プリペアードステートメントを閉じる
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
            // コネクションを閉じる
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
}