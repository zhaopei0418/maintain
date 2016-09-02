package online.zhaopei.myproject.service.para;

import java.io.Serializable;

import online.zhaopei.myproject.domain.para.Customs;

public interface CustomsService extends Serializable {

	Customs getCustomsByCode(String customsCode);
}
