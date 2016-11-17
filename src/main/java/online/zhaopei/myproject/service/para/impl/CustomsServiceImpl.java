package online.zhaopei.myproject.service.para.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.common.tool.ArrayTool;
import online.zhaopei.myproject.domain.para.Para;
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
	public Para getCustomsByCode(String customsCode) {
		return this.customsMapper.getCustomsByCode(customsCode);
	}

	@Override
	public Map<String, String> getCustoms() {
		return ArrayTool.mapFromListOfMap(this.customsMapper.getCustoms(), "customs_code", "abbr_cust");
	}

	@Override
	public Long countCustoms() {
		return this.customsMapper.countCustoms();
	}

}
