package co.simplon.annuaire.domaine;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;

import com.ninja_squad.dbsetup.operation.Operation;

public class CommonOperations {
	public static final Operation DELETE_ALL = deleteAllFrom("HOBBIES",
			"CONTACTS");
}
