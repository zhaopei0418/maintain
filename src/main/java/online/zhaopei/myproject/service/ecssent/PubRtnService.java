package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.PubRtn;

public interface PubRtnService extends Serializable {

	List<PubRtn> getPubRtnListByBizGuid(String bizGuid);
	
	Long countPubRtnByBizGuid(String bizGuid);
}
