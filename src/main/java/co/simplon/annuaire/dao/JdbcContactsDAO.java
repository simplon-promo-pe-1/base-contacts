package co.simplon.annuaire.dao;

import java.sql.Driver;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class JdbcContactsDAO extends AbstractJdbcContactDAO implements ContactsDAO {
	    
	@Override
	public String getUrl() {
		return "jdbc:oracle:thin:SIMPLON/SIMPLON@localhost:1521:XE";
	}

	@Override
	public Driver getDriver() throws SQLException {
		return new OracleDriver();
	}
    
}
