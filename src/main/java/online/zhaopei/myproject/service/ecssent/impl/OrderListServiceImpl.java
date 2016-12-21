package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.OrderList;
import online.zhaopei.myproject.mapper.ecssent.OrderListMapper;
import online.zhaopei.myproject.service.ecssent.OrderListService;

@Service
public class OrderListServiceImpl implements OrderListService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4432878268859514716L;

	@Autowired
	private OrderListMapper orderListMapper;
	
	@Override
	public List<OrderList> getOrderListByHeadGuid(String headGuid) {
		return this.orderListMapper.getOrderListByHeadGuid(headGuid);
	}

	@Override
	public Long countOrderList(String headGuid) {
		return this.orderListMapper.countOrderList(headGuid);
	}

	@Override
	public List<OrderList> getOrderListBySearchText(String headGuid, String searchText) {
		return this.orderListMapper.getOrderListBySearchText(headGuid, searchText);
	}

}
