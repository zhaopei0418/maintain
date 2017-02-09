package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.sqlprovide.ecssent.MemberSqlProvide;

public interface MemberMapper extends Serializable {

	@InsertProvider(type = MemberSqlProvide.class, method = "insertMemberSql")
	int insertMember(Member member);
	
	@SelectProvider(type = MemberSqlProvide.class, method = "countMemberSql")
	long countMember(Member member);
	
	@DeleteProvider(type = MemberSqlProvide.class, method = "deleteMemberSql")
	int deleteMember(Member member);
	
	@UpdateProvider(type = MemberSqlProvide.class, method = "updateMemberSql")
	int updateMember(Member member);
	
	@Results(id = "memberResult", value = {
		@Result(property = "memberName", column = "member_name", id = true),
		@Result(property = "password", column = "password"),
	})
	@SelectProvider(type = MemberSqlProvide.class, method = "getMemberListSql")
	List<Member> getMemberList(Member member);
	
	@ResultMap("memberResult")
	@SelectProvider(type = MemberSqlProvide.class, method = "getMemberByUserNameSql")
	Member getMemberByUserName(String userName);
}
