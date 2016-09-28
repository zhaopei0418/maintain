package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DeliveryHead;
import online.zhaopei.myproject.mapper.ecssent.DeliveryHeadMapper;
import online.zhaopei.myproject.service.ecssent.DeliveryHeadService;

@Service
public class DeliveryHeadServiceImpl implements DeliveryHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6463514635280371175L;
	
	@Autowired
	private DeliveryHeadMapper deliveryHeadMapper;

	@Override
	public List<DeliveryHead> getDeliveryHeadList(DeliveryHead deliveryHead) {
		return this.deliveryHeadMapper.getDeliveryHeadList(deliveryHead);
	}

}
