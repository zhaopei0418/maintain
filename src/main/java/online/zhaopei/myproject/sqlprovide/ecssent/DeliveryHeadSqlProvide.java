package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.DeliveryHead;

public class DeliveryHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1427693713608303177L;

	private List<String> selectField() {
		return new ArrayList<String>(){{
			this.add("cdh.head_guid");
			this.add("cdh.app_type");
			this.add("cdh.app_time");
			this.add("cdh.app_status");
			this.add("cdh.app_uid");
			this.add("cdh.app_uname");
			this.add("cdh.app_sender_id");
			this.add("cdh.decl_time");
			this.add("cdh.customs_code");
			this.add("cdh.cop_no");
			this.add("cdh.pre_no");
			this.add("cdh.rkd_no");
			this.add("cdh.operator_code");
			this.add("cdh.operator_name");
			this.add("cdh.ie_flag");
			this.add("cdh.traf_mode");
			this.add("cdh.traf_no");
			this.add("cdh.voyage_no");
			this.add("cdh.bill_no");
			this.add("cdh.logistics_code");
			this.add("cdh.logistics_name");
			this.add("cdh.unload_location");
			this.add("cdh.note");
			this.add("cdh.del_flag");
			this.add("cdh.msg_guid");
			this.add("cdh.sys_days");
			this.add("cdh.sys_date");
		}};
	}

	public String getDeliveryHeadListSql(final DeliveryHead deliveryHead) {
		final DeliveryHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.FROM("ceb2_delivery_head cdh");
			
			if (!StringUtils.isEmpty(deliveryHead.getLogisticsNo())) {
				this.LEFT_OUTER_JOIN("ceb2_delivery_list cdl on cdh.head_guid = cdl.head_guid");
				this.WHERE("cdl.logistics_no = '" + deliveryHead.getLogisticsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getHeadGuid())) {
				this.WHERE("cdh.head_guid = '" + deliveryHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppType())) {
				this.WHERE("cdh.app_type = '" + deliveryHead.getAppType() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppStatus())) {
				this.WHERE("cdh.app_status = '" + deliveryHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppUid())) {
				this.WHERE("cdh.app_uid = '" + deliveryHead.getAppUid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppUname())) {
				this.WHERE("cdh.app_uname = '" + deliveryHead.getAppUname() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppSenderId())) {
				this.WHERE("cdh.app_sender_id = '" + deliveryHead.getAppSenderId() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getCustomsCode())) {
				this.WHERE("cdh.customs_code = '" + deliveryHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getCopNo())) {
				this.WHERE("cdh.cop_no = '" + deliveryHead.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getPreNo())) {
				this.WHERE("cdh.pre_no = '" + deliveryHead.getPreNo());
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getRkdNo())) {
				this.WHERE("cdh.rkd_no = '" + deliveryHead.getRkdNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getOperatorCode())) {
				this.WHERE("cdh.operator_code = '" + deliveryHead.getOperatorCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getOperatorName())) {
				this.WHERE("cdh.operator_name like '%" + deliveryHead.getOperatorName() + "%'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getIeFlag())) {
				this.WHERE("cdh.ie_flag = '" + deliveryHead.getIeFlag() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getTrafMode())) {
				this.WHERE("cdh.traf_mode = '" + deliveryHead.getTrafMode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getTrafNo())) {
				this.WHERE("cdh.traf_no = '" + deliveryHead.getTrafNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getVoyageNo())) {
				this.WHERE("cdh.voyage_no = '" + deliveryHead.getVoyageNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getBillNo())) {
				this.WHERE("cdh.bill_no = '" + deliveryHead.getBillNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getLogisticsCode())) {
				this.WHERE("cdh.logistics_code = '" + deliveryHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getLogisticsName())) {
				this.WHERE("cdh.logistics_name like '%" + deliveryHead.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getUnloadLocation())) {
				this.WHERE("cdh.unload_location = '" + deliveryHead.getUnloadLocation() + "'");
			}
			
			if (StringUtils.isNumber(String.valueOf(deliveryHead.getDelFlag()))) {
				this.WHERE("cdh.del_flag = " + deliveryHead.getDelFlag());
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getMsgGuid())) {
				this.WHERE("cdh.msg_guid = '" + deliveryHead.getMsgGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getBeginSysDate())) {
				this.WHERE("to_char(cdh.sys_date, 'yyyy-mm-dd') >= '" + deliveryHead.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getEndSysDate())) {
				this.WHERE("to_char(cdh.sys_date, 'yyyy-mm-dd') <= '" + deliveryHead.getEndSysDate() + "'");
			}
		}}.toString();
	}
}
