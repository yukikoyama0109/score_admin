package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class ClassNumDAO extends DAO {

    public List<String> filter(School school) throws Exception {

        List<String> list = new ArrayList<>();

        // データベースに接続
        Connection connection = getConnection();


        PreparedStatement st = connection.prepareStatement(
            "SELECT class_num FROM class_num WHERE school_cd = ?"
        );

        // クエリにパラメータをセット
        st.setString(1, school.getCd());
//        System.out.println(school.getCd());
//        System.out.println(st);

        // SQL文を実行した結果をリザルトセットに格納
        ResultSet rs = st.executeQuery();
//        System.out.println(st.executeQuery());
//
//        System.out.println(rs);
        // 値をセット
        while (rs.next()) {
            // リストにクラス番号を追加
            list.add(rs.getString("class_num"));
        }

        // データベースとの接続を解除（必ず書く）
        rs.close();
        st.close();
        connection.close();

        // クラス番号のリストを返却
        return list;
    }
}
