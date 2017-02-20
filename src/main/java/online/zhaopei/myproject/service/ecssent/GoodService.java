package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.Good;

public interface GoodService extends Serializable {

	List<Good> getGoodList(Good good);
}
