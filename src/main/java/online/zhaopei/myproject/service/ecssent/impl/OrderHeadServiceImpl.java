package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.OrderHead;
import online.zhaopei.myproject.mapper.ecssent.OrderHeadMapper;
import online.zhaopei.myproject.service.ecssent.OrderHeadService;

@Service
public class OrderHeadServiceImpl implements OrderHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -529882645451224292L;

	@Autowired
	private OrderHeadMapper orderHeadMapper;
	
	@Override
	public List<OrderHead> getOrderHeadList(OrderHead orderHead) {
		return this.orderHeadMapper.getOrderHeadList(orderHead);
	}

	@Override
	public OrderHead getOrderHeadByHeadGuid(String headGuid) {
		return this.orderHeadMapper.getOrderHeadByHeadGuid(headGuid);
	}

}
