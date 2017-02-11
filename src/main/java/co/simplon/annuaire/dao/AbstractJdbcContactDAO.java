package co.simplon.annuaire.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJdbcContactDAO implements ContactsDAO {

	static String requeteSql = "SELECT EMAIL FROM CONTACTS WHERE CONTACT_TYPE = ? ";

	public abstract String getUrl();

	public abstract Driver getDriver() throws SQLException;

	public AbstractJdbcContactDAO() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.simplon.annuaire.dao.ContactsDAO#findEmailsByContactType(java.lang
	 * .String)
	 */
	@Override
	public List<String> findEmailsByContactType(String type) throws Exception {
		List<String> emails = new ArrayList<String>();
		DriverManager.registerDriver(getDriver());

		Connection connexion = DriverManager.getConnection(getUrl());
		PreparedStatement requete = connexion.prepareStatement(requeteSql);
		requete.setString(1, type);
		ResultSet resultat = requete.executeQuery();
		while (resultat.next()) {
			String email = resultat.getString(1);
			emails.add(email);
		}
		resultat.close();
		requete.close();
		connexion.close();
		return emails;
	}

}