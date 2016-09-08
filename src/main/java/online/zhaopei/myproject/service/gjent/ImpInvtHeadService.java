package online.zhaopei.myproject.service.gjent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.gjent.ImpInvtHead;

public interface ImpInvtHeadService extends Serializable {

	List<ImpInvtHead> getInvtHeadListByInvtNo(String invtNo);
}
