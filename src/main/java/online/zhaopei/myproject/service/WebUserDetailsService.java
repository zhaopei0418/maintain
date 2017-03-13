package online.zhaopei.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.AuthUser;
import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.domain.ecssent.Permission;
import online.zhaopei.myproject.mapper.ecssent.MemberMapper;
import online.zhaopei.myproject.mapper.ecssent.PermissionMapper;
import online.zhaopei.myproject.mapper.ecssent.RoleMapper;

@Service
public class WebUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		List<Permission> permissionList = new ArrayList<Permission>();
		AuthUser user = null;
		Member m = this.memberMapper.getMemberByUserName(userName);
		if (null != m) {
			permissionList = this.permissionMapper.getPermissionListByMemberCode(m.getCode());

			for (Permission permission : permissionList) {
				if (null != permission && null != permission.getName()) {
					authList.add(new SimpleGrantedAuthority(permission.getName()));
				}
			}

			user = new AuthUser(m, authList, this.roleMapper.getRoleListByMemberCode(m.getCode()));
		} else {
			throw new UsernameNotFoundException("用户: " + userName + " 不存在!");
		}

		return user;
	}

}
