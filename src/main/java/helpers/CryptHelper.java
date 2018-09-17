package helpers;

import org.mindrot.jbcrypt.BCrypt;

public class CryptHelper {
	
	public static String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(11));
	}
	
	public static boolean verify(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
	
}
