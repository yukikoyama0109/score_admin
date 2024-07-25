package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO extends DAO {

    private String baseSql = "SELECT student.ent_year, student.class_num, student_no, student.name FROM test ";

    // getメソッド
    public Test get(Student student, Subject subject, School school, int no) throws Exception {
        Test test = null;
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(baseSql + "AND student_no=? AND subject_cd=? AND no=?");
        st.setString(1, school.getCd());
        st.setString(2, student.getNo());
        st.setString(3, subject.getCd());
        st.setInt(4, no);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            test = new Test();
            test.setStudent(student);
            test.setSubject(subject);
            test.setSchool(school);
            test.setNo(rs.getInt("no"));
            test.setPoint(rs.getInt("point"));
        }

        rs.close();
        st.close();
        con.close();

        return test;
    }

    // postFilterメソッド
    private List<Test> postFilter(ResultSet rs, School school) throws Exception {
        List<Test> list = new ArrayList<>();
        while (rs.next()) {
            Test test = new Test();
//            test.setNo(rs.getInt("no"));
            test.setClassNum(rs.getString("class_num"));
//            test.setSubject(rs.getString("subject_cd"));
//            test.setPoint(rs.getInt("point"));

            Student student = new Student();
            student.setNo(rs.getString("student_no"));
            student.setEntYear(rs.getInt("ent_year"));
            student.setName(rs.getString("name"));

            System.out.println("dao" + (rs.getString("student_no")));
//            student.setName(rs.getString("name"));
            // 他のStudentフィールドを設定する必要がある場合は追加

            Subject subject = new Subject();
//            subject.setCd(rs.getString("subject_cd"));
//            subject.setName(rs.getString("name"));
            // 他のSubjectフィールドを設定する必要がある場合は追加

            test.setStudent(student);
            System.out.println(student);
            test.setSubject(subject);
            System.out.println(subject);
            test.setSchool(school);
            System.out.println(school);

            list.add(test);
        }
        return list;
    }

    // filterメソッド
    public List<Test> filter(School school, int entYear, String classNum, Subject subject, int num ) throws Exception {
        List<Test> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String condition = " ent_year=? AND test.class_num=?";
        String order = " ORDER BY no ASC";
        String condition2 = " AND test.no=? AND subject_cd=? ";


//        String conditionIsAttend = "";
//        if (isAttend) {
//            conditionIsAttend = "AND is_attend=true";
//        }

        try {
            statement = connection.prepareStatement(baseSql+"JOIN student ON test.student_no = student.no having" + condition + condition2 );
//            statement.setString(1, school.getCd());
            statement.setInt(1, entYear);
            statement.setString(2, classNum);
            statement.setInt(3, num);
            statement.setString(4, subject.getCd());

            rs = statement.executeQuery();
            list = postFilter(rs, school);
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
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

    // saveメソッド
    public boolean save(List<Test> list) throws Exception {
        boolean result = true;
        Connection con = getConnection();
        try {
            con.setAutoCommit(false);
            for (Test test : list) {
                result &= save(test, con);
            }
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.close();
        }
        return result;
    }

    private boolean save(Test test, Connection connection) throws Exception {
        String sql = "INSERT INTO test (student_no, subject_cd, no, point, school_cd) VALUES (?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE point=?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, test.getStudent().getNo());
        st.setString(2, test.getSubject().getCd());
        st.setInt(3, test.getNo());
        st.setInt(4, test.getPoint());
        st.setString(5, test.getSchool().getCd());
        st.setInt(6, test.getPoint());
        int affectedRows = st.executeUpdate();
        st.close();
        return affectedRows > 0;
    }

    // deleteメソッド
    public boolean delete(List<Test> list) throws Exception {
        boolean result = true;
        Connection con = getConnection();
        try {
            con.setAutoCommit(false);
            for (Test test : list) {
                result &= delete(test, con);
            }
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.close();
        }
        return result;
    }

    private boolean delete(Test test, Connection connection) throws Exception {
        String sql = "DELETE FROM test WHERE student_no=? AND subject_cd=? AND no=? AND school_cd=?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, test.getStudent().getNo());
        st.setString(2, test.getSubject().getCd());
        st.setInt(3, test.getNo());
        st.setString(4, test.getSchool().getCd());
        int affectedRows = st.executeUpdate();
        st.close();
        return affectedRows > 0;
    }
}
