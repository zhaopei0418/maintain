package online.zhaopei.myproject.service.para;

import java.io.Serializable;

public interface SyncPaymentInfoService extends Serializable {

	Long getSyncTime();
	
	Integer updateSyncTime(Long lastSyncTime);
}
