package online.zhaopei.myproject.service.gjent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.gjent.ImpInvtHead;
import online.zhaopei.myproject.mapper.gjent.ImpInvtHeadMapper;
import online.zhaopei.myproject.service.gjent.ImpInvtHeadService;

@Service
public class ImpInvtHeadServiceImpl implements ImpInvtHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5869040359694808448L;

	@Autowired
	private ImpInvtHeadMapper impInvtHeadMapper;

	@Override
	public List<ImpInvtHead> getInvtHeadListByInvtNo(String invtNo) {
		return this.impInvtHeadMapper.getInvtHeadListByInvtNo(invtNo);
	}

	@Override
	public List<ImpInvtHead> getInvtHeadListByCopNo(String copNo) {
		return this.impInvtHeadMapper.getInvtHeadListByCopNo(copNo);
	}

}
