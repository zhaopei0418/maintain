package online.zhaopei.myproject.service.para;

import java.io.Serializable;

import online.zhaopei.myproject.domain.para.Para;

public interface WrapService extends Serializable {

	Para getWrapByCode(String wrapCode);
}
