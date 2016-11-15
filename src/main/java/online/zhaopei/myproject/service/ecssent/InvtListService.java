package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.InvtList;

public interface InvtListService extends Serializable {

	List<InvtList> getInvtListListByHeadGuid(String headGuid);
	
	Long countInvtList(String headGuid);
	
	List<InvtList> getInvtListListBySearchText(String headGuid, String searchText);
}
