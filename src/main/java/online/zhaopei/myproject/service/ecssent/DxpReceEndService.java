package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;

public interface DxpReceEndService extends Serializable {

	List<DxpReceEnd> getDxpReceEndList(DxpReceEnd dxpReceEnd);
}
