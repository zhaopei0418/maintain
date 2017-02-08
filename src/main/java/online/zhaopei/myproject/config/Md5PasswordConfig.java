package online.zhaopei.myproject.config;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Md5PasswordConfig implements PasswordEncoder {

	private static final Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
	
	private static final String SALT = "ZHAOPEI";
	
	@Override
	public String encode(CharSequence rawPass) {
		return md5PasswordEncoder.encodePassword(rawPass.toString(), SALT);
	}

	@Override
	public boolean matches(CharSequence rawPass, String dbPassword) {
		return md5PasswordEncoder.isPasswordValid(dbPassword, rawPass.toString(), SALT);
	}


}
