package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtList;
import online.zhaopei.myproject.mapper.ecssent.InvtListMapper;
import online.zhaopei.myproject.service.ecssent.InvtListService;

@Service
public class InvtListServiceImpl implements InvtListService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5987336872360862846L;

	@Autowired
	private InvtListMapper invtListMapper;

	@Override
	public List<InvtList> getInvtListListByHeadGuid(String headGuid) {
		return this.invtListMapper.getInvtListListByHeadGuid(headGuid);
	}

}
