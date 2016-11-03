package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.PayHead;

public interface PayHeadService extends Serializable {

	List<PayHead> getPayHeadList(PayHead payHead);
}
