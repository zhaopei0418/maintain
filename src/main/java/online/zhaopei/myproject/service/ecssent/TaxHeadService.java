package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.TaxHead;

public interface TaxHeadService extends Serializable {

	List<TaxHead> getTaxHeadList(TaxHead taxHead);
}
