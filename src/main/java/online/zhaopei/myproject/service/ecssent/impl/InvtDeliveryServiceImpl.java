package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.InvtDeliveryComparison;
import online.zhaopei.myproject.mapper.ecssent.InvtDeliveryMapper;
import online.zhaopei.myproject.service.ecssent.InvtDeliveryService;

@Service
public class InvtDeliveryServiceImpl implements InvtDeliveryService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1094380211625565670L;

	@Autowired
	private InvtDeliveryMapper invtDeliveryMapper;
	
	@Override
	public List<InvtDeliveryComparison> comparisonDeliveryByLogisticsNo(String logisticsCode, String logisticsNo,
			String headGuid) {
		return this.invtDeliveryMapper.comparisonDeliveryByLogisticsNo(logisticsCode, logisticsNo, headGuid);
	}

}
