package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DeliveryList;
import online.zhaopei.myproject.mapper.ecssent.DeliveryListMapper;
import online.zhaopei.myproject.service.ecssent.DeliveryListService;

@Service
public class DeliveryListServiceImpl implements DeliveryListService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4281019896736815185L;

	@Autowired
	private DeliveryListMapper deliveryListMapper;
	
	@Override
	public List<DeliveryList> getDeliveryListByGuid(String headGuid) {
		return this.deliveryListMapper.getDeliveryListByGuid(headGuid);
	}

	@Override
	public List<DeliveryList> getDeliveryList(DeliveryList deliveryList) {
		return this.deliveryListMapper.getDeliveryList(deliveryList);
	}

}
