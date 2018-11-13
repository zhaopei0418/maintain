package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.DistHead;

public interface DistHeadService extends Serializable {

	DistHead getDistHeadByInvtNo(String invtNo);
	
	List<DistHead> getDistHeadList(DistHead distHead);
	
	DistHead getDistHeadBySeqNo(String seqNo);

	void calculationPackWt(String distNo);
}
