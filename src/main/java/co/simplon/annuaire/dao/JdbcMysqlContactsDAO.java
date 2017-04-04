package co.simplon.annuaire.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JdbcMysqlContactsDAO extends AbstractJdbcContactDAO implements ContactsDAO {

	@Override
	public String getUrl() {
		return "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970?user=sql8157970&password=GTyyUfvfQ6";
	}

	@Override
	public Driver getDriver() throws SQLException {
		return new Driver();
	}

	@Override
	protected String getRequeteSqlInsert() {
		String requete = "INSERT INTO CONTACTS (LNAME, FNAME, EMAIL, AGE, CONTACT_TYPE) "
				+ "VALUES ( ? , ? , ? , ? , ? )";
		return requete;
	}

}
