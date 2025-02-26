package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public Util() {
    }
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres"; //
        String password = "qwaza1337";
        return DriverManager.getConnection(url, user, password);


    }

}
