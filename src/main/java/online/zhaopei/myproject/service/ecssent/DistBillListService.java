package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.DistBillList;

public interface DistBillListService extends Serializable {

	List<DistBillList> getDistBillListList(String seqNo);
	
	List<DistBillList> getDistBillListListBySearchText(String seqNo, String searchText);
	
	Long countDistBillList(String seqNo);
	
	List<DistBillList> excludeInvts(String distNo, String companyCode);
}
