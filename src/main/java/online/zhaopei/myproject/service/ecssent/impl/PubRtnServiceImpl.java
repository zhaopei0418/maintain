package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.PubRtn;
import online.zhaopei.myproject.mapper.ecssent.PubRtnMapper;
import online.zhaopei.myproject.service.ecssent.PubRtnService;

@Service
public class PubRtnServiceImpl implements PubRtnService {

	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1881933697208445449L;

	@Autowired
	private PubRtnMapper pubRtnMapper;
	
	@Override
	public List<PubRtn> getPubRtnListByBizGuid(String bizGuid) {
		return this.pubRtnMapper.getPubRtnListByBizGuid(bizGuid);
	}

	@Override
	public Long countPubRtnByBizGuid(String bizGuid) {
		return this.pubRtnMapper.countPubRtnByBizGuid(bizGuid);
	}

}
