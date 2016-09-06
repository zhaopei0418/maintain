package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.mapper.ecssent.InvtHeadMapper;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;

@Service
public class InvtHeadServiceImpl implements InvtHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -704597295328871550L;

	@Autowired
	private InvtHeadMapper invtHeadMapper;
	
	@Override
	public List<InvtHead> getInvtHeadList(InvtHead invtHead) {
		return this.invtHeadMapper.getInvtHeadList(invtHead);
	}

}
