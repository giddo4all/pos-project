package edu.ust.seis.pos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.ust.seis.pos.Commons.*;

public class SecuritySubsystem {

	private static List<String> userSession = new ArrayList<String>();
	public static String userID;

	public enum UserRole {

		SUPERADMIN, ADMIN, MANAGER, CASHIER;

	}

	public SecuritySubsystem() throws URISyntaxException, IOException,
			RecordNotFoundException, DuplicatePrimaryKeyException {

		DataStore ds = new DataStore();
		ds.createSheet(Commons.AUTH_SHEETNAME);
		int rowIndex = -7;
		try {
			rowIndex = ds.getDataStoreRowIndex(Commons.AUTH_SHEETNAME,
					Commons.AUTH_USERNAME, Commons.ADMIN_USERNAME_VALUE);
		} catch (Exception e) {

		}
		if (rowIndex < 0) {

			// Map<String, String> mp = new HashMap<String, String>();
			// // .createPlaceHolderMapFromHeader(Commons.AUTH_SHEETNAME);
			// mp.put(Commons.AuthHeader.IDNumber.toString(),
			// Commons.ADMIN_USER_ID_VALUE);
			// mp.put(Commons.AuthHeader.username.toString(),
			// Commons.ADMIN_USERNAME_VALUE);
			// mp.put(Commons.AuthHeader.password.toString(),
			// Commons.ADMIN_PASSWORD_VALUE);
			// mp.put(Commons.AuthHeader.role.toString(),
			// AuthRoles.superAdmin.toString());
			// // ds.dataStoreWrite(mp, Commons.AUTH_SHEETNAME);

			registerUser(ADMIN_USERNAME_VALUE, ADMIN_PASSWORD_VALUE,
					UserRole.SUPERADMIN);
		}
	}

	public String registerUser(String userName, String password, UserRole role)
			throws IOException, URISyntaxException, RecordNotFoundException,
			DuplicatePrimaryKeyException {

		DataStore ds = new DataStore();
		ds.createSheet(Commons.AUTH_SHEETNAME);

		int rowIndex = ds.getDataStoreRowIndex(Commons.AUTH_SHEETNAME,
				Commons.AuthHeader.username.toString(), userName);
		String userID = generateUserID();

		if (role == UserRole.SUPERADMIN) {
			userID = ADMIN_USER_ID_VALUE;
		}

		if (rowIndex < 0) {
			Map<String, String> mp = new HashMap<String, String>();
			mp.put(Commons.AuthHeader.IDNumber.toString(), userID);
			mp.put(Commons.AuthHeader.username.toString(), userName);
			mp.put(Commons.AuthHeader.password.toString(), password);
			mp.put(Commons.AuthHeader.role.toString(), role.toString());
			ds.dataStoreWrite(mp, Commons.AUTH_SHEETNAME);
		} else {

			throw new DuplicatePrimaryKeyException(
					"The provided username name already exist; Provide a different one");
		}

		return userID;
	}

	public boolean login(String userName, String password)
			throws URISyntaxException, IOException, RecordNotFoundException {

		boolean isLoginSuccess = false;
		DataStore dt = new DataStore();
		String[] colRead = { AUTH_ID_NUMBER, AUTH_PASSWORD, AUTH_ROLE };
		ArrayList<String> pswd = new ArrayList<String>();
		try {
			pswd = dt.dataStoreRead(AUTH_SHEETNAME, AUTH_USERNAME, colRead,
					userName);
			userSession = pswd;

		} catch (Exception e) {
			throw new RecordNotFoundException(
					"The provided Username and Password combination does not exist");
		}

		if (pswd.get(1).equals(password)) {
			isLoginSuccess = true;
		} else {
			throw new RecordNotFoundException(
					"The provided Username and Password combination does not exist");
		}

		return isLoginSuccess;
	}

	private String generateUserID() {
		return "DGS" + Commons.epochTimesStamp();
	}

	public String getUserName() {
		String name = null;
		try {
			name = userSession.get(1);
		} catch (Exception e) {
			throw new NullPointerException(
					"User Session is null due to unsuccessful login");
		}
		return name;
	}

	public String getUserID() {

		String id = null;
		try {
			id = userSession.get(0);
		} catch (Exception e) {
			throw new NullPointerException(
					"User Session is null due to unsuccessful login");
		}
		return id;
	}
}
