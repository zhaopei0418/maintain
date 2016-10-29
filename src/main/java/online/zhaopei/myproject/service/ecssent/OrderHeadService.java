package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.OrderHead;

public interface OrderHeadService extends Serializable {

	List<OrderHead> getOrderHeadList(OrderHead orderHead);
}
