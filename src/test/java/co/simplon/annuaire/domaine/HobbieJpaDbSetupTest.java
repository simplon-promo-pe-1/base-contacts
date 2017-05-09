package co.simplon.annuaire.domaine;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

public class HobbieJpaDbSetupTest {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(HobbieJpaDbSetupTest.class);

	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setup() {
		// on force l'init de la base
		emf = Persistence
				.createEntityManagerFactory("BaseContactsTest");
	}

	@Before
	public void prepare() throws Exception {
		Calendar dateHobby = Calendar.getInstance();
		dateHobby.set(Calendar.DAY_OF_MONTH, 3);
		dateHobby.set(Calendar.MONTH, Calendar.MAY);
		dateHobby.set(Calendar.YEAR, 2017);

		Operation operation = sequenceOf(
				CommonOperations.DELETE_ALL,
				insertInto("CONTACTS")
						.columns("ID", "FNAME", "LNAME", "EMAIL",
								"CONTACT_TYPE",
								"AGE")
						.values(1L, "Dave", "Smith", "dsmith@icloud.com",
								"friend",
								46).build(),
				insertInto("HOBBIES")
						.columns("ID", "HOBBY", "SINCE", "CONTACT_ID")
						.values(1L, "Horseback Riding", dateHobby.getTime(), 1L)
						.build());

		DbSetup dbSetup = new DbSetup(new DriverManagerDestination(
				"jdbc:hsqldb:file:testDB", "sa", ""), operation);
		dbSetup.launch();
	}

	@Test
	public void le_mapping_du_premier_hobbie_doit_etre_coherent() {
		// GIVEN
		Long idRecherche = 1L;

		// WHEN
		EntityManager em = emf.createEntityManager();
		Hobbie hobbie = em.find(Hobbie.class, idRecherche);

		// THEN
		LOGGER.info(hobbie.getNom());
		assertThat(hobbie.getId(), equalTo(idRecherche));
		assertThat(hobbie.getNom(), equalTo("Horseback Riding"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(hobbie.getDepuis());
		assertThat(cal.get(Calendar.DAY_OF_MONTH), equalTo(3));
		assertThat(cal.get(Calendar.MONTH), equalTo(Calendar.MAY));
		assertThat(cal.get(Calendar.YEAR), equalTo(2017));
		assertThat(hobbie.getContactId(), equalTo(1L));
	}
}
