package co.simplon.annuaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

    static String databaseUrl = "jdbc:oracle:thin:localhost:1521:XE";
    static String requeteSql = "SELECT FNAME FROM CONTACTS ORDER BY FNAME";

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl, "SIMPLON", "SIMPLON");
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
