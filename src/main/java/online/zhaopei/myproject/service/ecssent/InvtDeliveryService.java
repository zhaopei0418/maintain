package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.InvtDeliveryComparison;

public interface InvtDeliveryService extends Serializable {

	List<InvtDeliveryComparison> comparisonDeliveryByLogisticsNo(String logisticsCode, String logisticsNo, String headGuid);
}
