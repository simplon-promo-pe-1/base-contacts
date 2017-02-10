package co.simplon.annuaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

public class Main {

	static String databaseUrl = "jdbc:oracle:thin:localhost:1521:XE";
    static String requeteSql = "SELECT EMAIL FROM CONTACTS WHERE CONTACT_TYPE = ? ";
    
    public static void main(String[] args) throws Exception {
    		String type = "";
    		if (args.length > 0) {
    			type = args[0];
    		};
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl, "SIMPLON", "SIMPLON");
        PreparedStatement requete = connexion.prepareStatement(requeteSql);
        requete.setString(1, type);
        ResultSet resultat = requete.executeQuery();
        while (resultat.next()) {
            String email = resultat.getString(1);
            System.out.println(email);
        }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
