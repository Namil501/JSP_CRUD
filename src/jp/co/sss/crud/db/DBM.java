package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBM {
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER_NAME = "servlet_training_user";
    private static final String PASSWORD = "systemsss";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        // どのデータベースを利用するか決定
        Class.forName(DRIVER);

        // DBに接続(どのスキーマに繋げるかを決定)
        Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        //System.out.println("DBに接続しました");

        return conn;
    }
    /**
     * DBとの接続を切断する
     *
     * @param connection
     *            DBとの接続情報
     * @throws SQLException
     *             クローズ処理に失敗した場合に送出
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                //System.out.println("DBと切断しました");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * PreparedStatementをクローズする
     *
     * @param preparedStatement
     *            ステートメント情報
     * @throws SQLException
     *             クローズ処理に失敗した場合に送出
     */
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ResultSetをクローズする
     *
     * @param resultSet
     *            SQL検索結果
     * @throws SQLException
     *             クローズ処理に失敗した場合に送出
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
