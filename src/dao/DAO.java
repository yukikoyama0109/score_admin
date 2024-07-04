package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	// 全てのインスタンスで利用する為
	// staticフィールドとして定義(グローバル変数)
	static DataSource ds;

	// データベースへ接続する処理を getConnection という名前の
	// メソッドにまとめている
	public Connection getConnection() throws Exception{
		// データソースを確認して未接続の場合のみ接続を実行
		if(ds==null){
			// データソースを取得する為の インスタンス
			InitialContext ic = new InitialContext();
			// context.xml の/jdbc/kadai で定義した接続情報でDBに接続
			ds = (DataSource)ic
					.lookup("java:/comp/env/jdbc/kadai");
		}
		// 接続情報を戻り値として返す
		return ds.getConnection();
	}
}
