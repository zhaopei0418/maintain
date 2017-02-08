package online.zhaopei.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class WebUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//		authList.add(new SimpleGrantedAuthority("ROLE_ab"));
		User user = null;
		if ("admin".equals(userName)) {
			user = new User("admin", "6f919627e922fd0681aecd91491e8a07", authList);
		} else if ("zhaopei".equals(userName)) {
			authList.clear();
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			user = new User("zhaopei", "06efe62e732862855dad02e617125fb1", authList);
		}
		return user;
	}

}
