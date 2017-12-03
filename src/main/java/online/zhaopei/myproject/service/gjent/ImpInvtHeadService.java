package online.zhaopei.myproject.service.gjent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.gjent.ImpInvtHead;

public interface ImpInvtHeadService extends Serializable {

	List<ImpInvtHead> getInvtHeadListByInvtNo(String invtNo);
	
	List<ImpInvtHead> getInvtHeadListByCopNo(String copNo);
	
	List<String> getCopNoList(String applyCode);

	List<ImpInvtHead> getInvtHeadListByOrderNoLogisticsNo(String ebcCode, String orderNo, String logisticsCode, String logisticsNo);
}
