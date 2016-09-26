package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.CurrMapper;
import online.zhaopei.myproject.service.para.CurrService;

@Service
public class CurrServiceImpl implements CurrService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1290923350512939326L;

	@Autowired
	private CurrMapper currMapper;

	@Override
	public Para getCurrByCode(String code) {
		return this.currMapper.getCurrByCode(code);
	}

}
