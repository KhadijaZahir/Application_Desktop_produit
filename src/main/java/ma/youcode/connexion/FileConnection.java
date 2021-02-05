package ma.youcode.connexion;

import java.sql.*;

public class FileConnection {

    public static Connection getConnexion() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/produit", "root", "");
        System.out.println("connection done");
        return conn;
    }

}

