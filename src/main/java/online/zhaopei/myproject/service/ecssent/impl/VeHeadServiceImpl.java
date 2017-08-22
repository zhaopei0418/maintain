package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.VeHead;
import online.zhaopei.myproject.mapper.ecssent.VeHeadMapper;
import online.zhaopei.myproject.service.ecssent.VeHeadService;

@Service
public class VeHeadServiceImpl implements VeHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6656639526696762796L;

	@Autowired
	private VeHeadMapper veHeadMapper;
	
	@Override
	public List<VeHead> getVeHeadList(VeHead veHead) {
		return this.veHeadMapper.getVeHeadList(veHead);
	}

	@Override
	public VeHead getVeHeadByVeNo(String veNo) {
		return this.veHeadMapper.getVeHeadByVeNo(veNo);
	}

	@Override
	public void syncVeENo() {
		this.veHeadMapper.syncVeENo();
	}

}
