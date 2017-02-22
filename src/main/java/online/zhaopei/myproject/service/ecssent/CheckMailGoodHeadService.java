package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.CheckMailGoodHead;

public interface CheckMailGoodHeadService extends Serializable {

	List<CheckMailGoodHead> getCheckMailGoodHeadList(CheckMailGoodHead checkMailGoodHead);
}
