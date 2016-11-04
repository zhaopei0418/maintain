package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.LgsHead;
import online.zhaopei.myproject.mapper.ecssent.LgsHeadMapper;
import online.zhaopei.myproject.service.ecssent.LgsHeadService;

@Service
public class LgsHeadServiceImpl implements LgsHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6062477107219372810L;

	@Autowired
	private LgsHeadMapper lgsHeadMapper;
	
	@Override
	public List<LgsHead> getLgsHeadList(LgsHead lgsHead) {
		return this.lgsHeadMapper.getLgsHeadList(lgsHead);
	}

}
