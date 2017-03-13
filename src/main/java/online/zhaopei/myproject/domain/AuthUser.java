package online.zhaopei.myproject.domain;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.domain.ecssent.Role;

public class AuthUser extends User {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1070751654803830924L;

	public AuthUser(String username, String password, Collection authorities) {
		super(username, password, true, true, true, true, authorities);
	}
	
	public AuthUser(Member member,Collection<? extends GrantedAuthority> authorities, Set<Role> roles) {
		super(member.getName(), member.getPassword(), true, true, true, true, authorities);
		this.member = member;
		this.roles = roles;
	}
	
	public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private Member member;
	
	private Set<Role> roles;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
