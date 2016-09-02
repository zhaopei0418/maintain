package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Customs;
import online.zhaopei.myproject.mapper.para.CustomsMapper;
import online.zhaopei.myproject.service.para.CustomsService;

@Service
public class CustomsServiceImpl implements CustomsService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8935852629921963286L;

	@Autowired
	private CustomsMapper customsMapper;
	
	@Override
	public Customs getCustomsByCode(String customsCode) {
		return this.customsMapper.getCustomsByCode(customsCode);
	}

}
