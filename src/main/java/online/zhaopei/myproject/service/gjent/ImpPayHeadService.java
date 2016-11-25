package online.zhaopei.myproject.service.gjent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.gjent.ImpPayHead;

public interface ImpPayHeadService extends Serializable {

	void insertPayHead(ImpPayHead impPayHead);
	
	List<ImpPayHead> getImpPayHeadList(ImpPayHead impPayHead);
	
	Long countImpPayHead(ImpPayHead impPayHead);
	
	void updateImpPayHead(ImpPayHead impPayHead);
}
