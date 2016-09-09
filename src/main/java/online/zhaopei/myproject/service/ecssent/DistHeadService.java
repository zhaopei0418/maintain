package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;

import online.zhaopei.myproject.domain.ecssent.DistHead;

public interface DistHeadService extends Serializable {

	DistHead getDistHeadByInvtNo(String invtNo);
}
