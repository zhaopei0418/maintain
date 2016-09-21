package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;
import online.zhaopei.myproject.mapper.ecssent.InvtHeadStatisticsMapper;
import online.zhaopei.myproject.service.ecssent.InvtHeadStatisticsService;

@Service
public class InvtHeadStatisticsServiceImpl implements InvtHeadStatisticsService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5713928343952572316L;

	@Autowired
	private InvtHeadStatisticsMapper invtHeadStatisticsMapper;
	
	@Override
	public List<InvtHeadStatistics> statisticsInvtHeadQuantity(InvtHeadStatistics invtHeadStatistics) {
		return this.invtHeadStatisticsMapper.statisticsInvtHeadQuantity(invtHeadStatistics);
	}

}
