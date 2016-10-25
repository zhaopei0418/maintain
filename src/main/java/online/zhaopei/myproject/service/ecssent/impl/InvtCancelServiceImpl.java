package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtCancel;
import online.zhaopei.myproject.mapper.ecssent.InvtCancelMapper;
import online.zhaopei.myproject.service.ecssent.InvtCancelService;

@Service
public class InvtCancelServiceImpl implements InvtCancelService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4383598698099532632L;

	@Autowired
	private InvtCancelMapper invtCancelMapper;
	
	@Override
	public List<InvtCancel> getInvtCancelList(InvtCancel invtCancel) {
		return this.invtCancelMapper.getInvtCancelList(invtCancel);
	}

}
