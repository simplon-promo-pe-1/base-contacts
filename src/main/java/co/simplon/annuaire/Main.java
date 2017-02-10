package co.simplon.annuaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

	static String databaseUrl = "jdbc:oracle:thin:localhost:1521:XE";
    static String requeteSqlPrefix = "SELECT EMAIL FROM CONTACTS WHERE CONTACT_TYPE='";
    static String requeteSqlSuffixe = "' ";
    
    public static void main(String[] args) throws Exception {
    		String type = "";
    		if (args.length > 0) {
    			type = args[0];
    		};
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl, "SIMPLON", "SIMPLON");
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSqlPrefix + type + requeteSqlSuffixe);
        while (resultat.next()) {
            String email = resultat.getString(1);
            System.out.println(email);
        }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
