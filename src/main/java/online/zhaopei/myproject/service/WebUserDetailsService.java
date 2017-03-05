package online.zhaopei.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.domain.ecssent.Permission;
import online.zhaopei.myproject.mapper.ecssent.MemberMapper;
import online.zhaopei.myproject.mapper.ecssent.PermissionMapper;

@Service
public class WebUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		List<Permission> permissionList = new ArrayList<Permission>();
		// authList.add(new SimpleGrantedAuthority("ROLE_ab"));
		User user = null;
		Member m = this.memberMapper.getMemberByUserName(userName);
		if (null != m) {
			permissionList = this.permissionMapper.getPermissionListByMemberCode(m.getCode());

			for (Permission permission : permissionList) {
				if (null != permission && null != permission.getName()) {
					authList.add(new SimpleGrantedAuthority(permission.getName()));
				}
			}

			user = new User(m.getName(), m.getPassword(), authList);
		} else {
			throw new UsernameNotFoundException("用户: " + userName + " 不存在!");
		}

		// if ("admin".equals(userName)) {
		// user = new User("admin", "6f919627e922fd0681aecd91491e8a07",
		// authList);
		// } else if ("zhaopei".equals(userName)) {
		// authList.clear();
		// authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		// user = new User("zhaopei", "06efe62e732862855dad02e617125fb1",
		// authList);
		// }
		return user;
	}

}
