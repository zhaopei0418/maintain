package online.zhaopei.myproject.service.ecssent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DxpReceMsg;
import online.zhaopei.myproject.mapper.ecssent.DxpReceMsgMapper;
import online.zhaopei.myproject.service.ecssent.DxpReceMsgService;

@Service
public class DxpReceMsgServiceImpl implements DxpReceMsgService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4982361225977910223L;

	@Autowired
	private DxpReceMsgMapper dxpReceMsgMapper;
	
	@Override
	public DxpReceMsg getDxpReceMsgByMsgGuid(String msgGuid) {
		return this.dxpReceMsgMapper.getDxpReceMsgByMsgGuid(msgGuid);
	}

}
