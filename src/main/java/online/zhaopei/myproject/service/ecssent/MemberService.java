package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.Member;

public interface MemberService extends Serializable {

	void insertMember(Member member);
	
	long countMember(Member member);
	
	void deleteMember(Member member);
	
	void updateMember(Member member);
	
	List<Member> getMemberList(Member member);
	
	Member getMemberByUserName(String userName);
}
