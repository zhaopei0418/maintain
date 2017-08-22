package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.InvtHead;

public interface InvtHeadService extends Serializable {

	List<InvtHead> getInvtHeadList(InvtHead invtHead);
	
	InvtHead getInvtHeadByHeadGuid(String headGuid);
	
	List<InvtHead> getDeclareTopTenSql(InvtHead invtHead);
	
	Long getInvtHeadCount(String countType);
	
	List<InvtHead> getInvtHeadMonthCount();
	
	List<InvtHead> exportInvtHeadList(InvtHead invtHead);
	
	List<String> getReleaseBackStaggeredInvtList();
	
	void updateInvtHeadStatus(String headGuid, String status);
	
	void updateInvtStatusAndInvtNo(InvtHead invtHead);
	
	void deleteInvtHeadByHeadGuid(String headGuid);
	
	List<InvtHead> getInvtHeadListByRepeatInvtNo();
}
