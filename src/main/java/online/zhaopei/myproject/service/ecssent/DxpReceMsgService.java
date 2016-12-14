package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;

import online.zhaopei.myproject.domain.ecssent.DxpReceMsg;

public interface DxpReceMsgService extends Serializable {

	DxpReceMsg getDxpReceMsgByMsgGuid(String msgGuid);
}
