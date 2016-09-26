package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.WrapMapper;
import online.zhaopei.myproject.service.para.WrapService;

@Service
public class WrapServiceImpl implements WrapService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3746460155742723819L;

	@Autowired
	private WrapMapper wrapMapper;

	@Override
	public Para getWrapByCode(String wrapCode) {
		return this.wrapMapper.getWrapByCode(wrapCode);
	}
}
