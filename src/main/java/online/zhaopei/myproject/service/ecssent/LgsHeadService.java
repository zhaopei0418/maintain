package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.LgsHead;

public interface LgsHeadService extends Serializable {

	List<LgsHead> getLgsHeadList(LgsHead lgsHead);
}
