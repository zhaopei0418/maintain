package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.Member;
import online.zhaopei.myproject.mapper.ecssent.MemberMapper;
import online.zhaopei.myproject.service.ecssent.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2552449622388263655L;

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(Member member) {
		this.memberMapper.insertMember(member);
	}

	@Override
	public long countMember(Member member) {
		return this.memberMapper.countMember(member);
	}

	@Override
	public void deleteMember(Member member) {
		this.memberMapper.deleteMember(member);
	}

	@Override
	public void updateMember(Member member) {
		this.memberMapper.updateMember(member);
	}

	@Override
	public List<Member> getMemberList(Member member) {
		return this.memberMapper.getMemberList(member);
	}

	@Override
	public Member getMemberByUserName(String userName) {
		return this.memberMapper.getMemberByUserName(userName);
	}

}
