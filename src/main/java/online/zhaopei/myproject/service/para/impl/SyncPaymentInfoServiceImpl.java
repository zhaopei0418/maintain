package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.mapper.para.SyncPaymentInfoMapper;
import online.zhaopei.myproject.service.para.SyncPaymentInfoService;

@Service
public class SyncPaymentInfoServiceImpl implements SyncPaymentInfoService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7881987729251624471L;

	@Autowired
	private SyncPaymentInfoMapper syncPaymentInfoMapper;
	
	@Override
	public Long getSyncTime() {
		return this.syncPaymentInfoMapper.getSyncTime();
	}

	@Override
	public Integer updateSyncTime(Long lastSyncTime) {
		return this.syncPaymentInfoMapper.updateSyncTime(lastSyncTime);
	}

}
