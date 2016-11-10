package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.VeHead;

public interface VeHeadService extends Serializable {

	List<VeHead> getVeHeadList(VeHead veHead);
	
	VeHead getVeHeadByVeNo(String veNo);
}
