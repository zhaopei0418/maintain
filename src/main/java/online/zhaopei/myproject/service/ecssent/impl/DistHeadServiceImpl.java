package online.zhaopei.myproject.service.ecssent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DistHead;
import online.zhaopei.myproject.mapper.ecssent.DistHeadMapper;
import online.zhaopei.myproject.service.ecssent.DistHeadService;

@Service
public class DistHeadServiceImpl implements DistHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1374617484615543545L;

	@Autowired
	private DistHeadMapper distHeadMapper;
	
	@Override
	public DistHead getDistHeadByInvtNo(String invtNo) {
		return this.distHeadMapper.getDistHeadByInvtNo(invtNo);
	}

}
