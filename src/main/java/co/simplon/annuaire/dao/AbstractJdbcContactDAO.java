package co.simplon.annuaire.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.annuaire.domaine.Contact;

public abstract class AbstractJdbcContactDAO implements ContactsDAO {

	static String requeteSqlSelect = "SELECT EMAIL FROM CONTACTS WHERE CONTACT_TYPE = ? ";
	static String requeteSqlInsert = "INSERT INTO CONTACTS (ID, LNAME, FNAME, EMAIL, AGE, CONTACT_TYPE) "
			+ "VALUES (S_CONTACTS.NEXTVAL, ? , ? , ? , ? , ? )";

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
		PreparedStatement requete = connexion.prepareStatement(requeteSqlSelect);
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

	protected String getRequeteSqlInsert() {
		return requeteSqlInsert;
	}
	
	@Override
	public void createContact(Contact contact) throws Exception {
		Connection connexion = DriverManager.getConnection(getUrl());
		PreparedStatement requete = connexion.prepareStatement(getRequeteSqlInsert());
		requete.setString(1, contact.getNom());
		requete.setString(2, contact.getPrenom());
		requete.setString(3, contact.getEmail());
		requete.setInt(4, contact.getAge());
		requete.setString(5, contact.getType());
		requete.executeUpdate();
		requete.close();
		connexion.close();
	}

}