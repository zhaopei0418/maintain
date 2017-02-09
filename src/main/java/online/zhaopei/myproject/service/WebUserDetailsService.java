package online.zhaopei.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.service.ecssent.MemberService;


@Service
public class WebUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//		authList.add(new SimpleGrantedAuthority("ROLE_ab"));
		User user = null;
		Member m = this.memberService.getMemberByUserName(userName);
		if (null != m) {
			user = new User(m.getMemberName(), m.getPassword(), authList);
		}
		
//		if ("admin".equals(userName)) {
//			user = new User("admin", "6f919627e922fd0681aecd91491e8a07", authList);
//		} else if ("zhaopei".equals(userName)) {
//			authList.clear();
//			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//			user = new User("zhaopei", "06efe62e732862855dad02e617125fb1", authList);
//		}
		return user;
	}

}
