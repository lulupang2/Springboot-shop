package springshop.config;

public interface PasswdEncoder {
	String encode(CharSequence rawPassword);
	
	boolean matches(CharSequence rawPassword, String encodedPasswd);
	
	default boolean upgradeEncoding(String encodedPasswd) {
		return false;
		
	}

}
