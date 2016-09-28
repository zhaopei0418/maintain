package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.DeliveryHead;

public interface DeliveryHeadService extends Serializable {

	List<DeliveryHead> getDeliveryHeadList(DeliveryHead deliveryHead);
}
