package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SyncPaymentInfoMapper extends Serializable {

	@ResultType(Long.class)
	@Select("select last_sync_time from last_sync_payment_time where sync_id = 1")
	Long getSyncTime();
	
	@Update("update last_sync_payment_time set last_sync_time = #{lastSyncTime} where sync_id = 1")
	Integer updateSyncTime(Long lastSyncTime);
}
