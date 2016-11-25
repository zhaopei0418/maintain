package online.zhaopei.myproject.service.gjent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.gjent.ImpPayHead;
import online.zhaopei.myproject.mapper.gjent.ImpPayHeadMapper;
import online.zhaopei.myproject.service.gjent.ImpPayHeadService;

@Service
public class ImpPayHeadServiceImpl implements ImpPayHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1234679383332263330L;

	@Autowired
	private ImpPayHeadMapper impPayHeadMapper;
	
	@Override
	public void insertPayHead(ImpPayHead impPayHead) {
		this.impPayHeadMapper.insertPayHead(impPayHead);
	}

	@Override
	public List<ImpPayHead> getImpPayHeadList(ImpPayHead impPayHead) {
		return this.impPayHeadMapper.getImpPayHeadList(impPayHead);
	}

	@Override
	public Long countImpPayHead(ImpPayHead impPayHead) {
		return this.impPayHeadMapper.countImpPayHead(impPayHead);
	}

	@Override
	public void updateImpPayHead(ImpPayHead impPayHead) {
		this.impPayHeadMapper.updateImpPayHead(impPayHead);
	}

}
