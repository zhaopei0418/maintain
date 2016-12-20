package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.OrderList;

public interface OrderListService extends Serializable {

	List<OrderList> getOrderListByHeadGuid(String headGuid);
	
	Long countOrderList(String headGuid);
	
	List<OrderList> getOrderListBySearchText(String headGuid, String searchText);
}
