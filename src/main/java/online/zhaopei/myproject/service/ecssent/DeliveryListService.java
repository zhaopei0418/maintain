package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.DeliveryList;

public interface DeliveryListService extends Serializable {

	List<DeliveryList> getDeliveryListByGuid(String headGuid);
	
	List<DeliveryList> getDeliveryList(DeliveryList deliveryList);
}
