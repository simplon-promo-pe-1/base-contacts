package co.simplon.annuaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MainMysql {

    static String databaseUrl = "jdbc:mysql://HOSTNAME:3306/DBID";
    static String requeteSql = "SELECT FNAME FROM CONTACTS ORDER BY FNAME";

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());

        Connection connexion = DriverManager.getConnection(databaseUrl, "user", "password");
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSql);
        while (resultat.next()) {
            String prenom = resultat.getString("FNAME");
            System.out.println(prenom);
        }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
