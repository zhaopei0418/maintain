package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.CheckMailGoodHead;
import online.zhaopei.myproject.mapper.ecssent.CheckMailGoodHeadMapper;
import online.zhaopei.myproject.service.ecssent.CheckMailGoodHeadService;

@Service
public class CheckMailGoodHeadServiceImpl implements CheckMailGoodHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6314214991459164605L;

	@Autowired
	private CheckMailGoodHeadMapper checkMailGoodHeadMapper;
	
	@Override
	public List<CheckMailGoodHead> getCheckMailGoodHeadList(CheckMailGoodHead checkMailGoodHead) {
		return this.checkMailGoodHeadMapper.getCheckMailGoodHeadList(checkMailGoodHead);
	}

}
