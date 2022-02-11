package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String SERVER_ADDRESS_PORT = "localhost:3306";
    private static final String DATABASE_NAME = "apt_db";
    private static final String USER_ID = "root";
    private static final String USER_PASSWRD = "";

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://" + SERVER_ADDRESS_PORT
            + "/" + DATABASE_NAME + "?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        return DriverManager.getConnection(url, USER_ID, USER_PASSWRD);
    }
}

