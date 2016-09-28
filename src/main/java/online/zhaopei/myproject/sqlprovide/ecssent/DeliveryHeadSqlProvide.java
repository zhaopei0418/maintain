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
			this.add("head_guid");
			this.add("app_type");
			this.add("app_time");
			this.add("app_status");
			this.add("app_uid");
			this.add("app_uname");
			this.add("app_sender_id");
			this.add("decl_time");
			this.add("customs_code");
			this.add("cop_no");
			this.add("pre_no");
			this.add("rkd_no");
			this.add("operator_code");
			this.add("operator_name");
			this.add("ie_flag");
			this.add("traf_mode");
			this.add("traf_no");
			this.add("voyage_no");
			this.add("bill_no");
			this.add("logistics_code");
			this.add("logistics_name");
			this.add("unload_location");
			this.add("note");
			this.add("del_flag");
			this.add("msg_guid");
			this.add("sys_days");
			this.add("sys_date");
		}};
	}

	public String getDeliveryHeadListSql(final DeliveryHead deliveryHead) {
		final DeliveryHeadSqlProvide self = this;
		return new SQL() {{
			for(String field : self.selectField()) {
				this.SELECT(field);
			}
			this.FROM("ceb2_delivery_head");
			if (!StringUtils.isEmpty(deliveryHead.getHeadGuid())) {
				this.WHERE("head_guid = '" + deliveryHead.getHeadGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppType())) {
				this.WHERE("app_type = '" + deliveryHead.getAppType() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppStatus())) {
				this.WHERE("app_status = '" + deliveryHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppUid())) {
				this.WHERE("app_uid = '" + deliveryHead.getAppUid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppUname())) {
				this.WHERE("app_uname = '" + deliveryHead.getAppUname() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getAppSenderId())) {
				this.WHERE("app_sender_id = '" + deliveryHead.getAppSenderId() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getCustomsCode())) {
				this.WHERE("customs_code = '" + deliveryHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getCopNo())) {
				this.WHERE("cop_no = '" + deliveryHead.getCopNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getPreNo())) {
				this.WHERE("pre_no = '" + deliveryHead.getPreNo());
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getRkdNo())) {
				this.WHERE("rkd_no = '" + deliveryHead.getRkdNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getOperatorCode())) {
				this.WHERE("operator_code = '" + deliveryHead.getOperatorCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getOperatorName())) {
				this.WHERE("operator_name like '%" + deliveryHead.getOperatorName() + "%'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getIeFlag())) {
				this.WHERE("ie_flag = '" + deliveryHead.getIeFlag() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getTrafMode())) {
				this.WHERE("traf_mode = '" + deliveryHead.getTrafMode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getTrafNo())) {
				this.WHERE("traf_no = '" + deliveryHead.getTrafNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getVoyageNo())) {
				this.WHERE("voyage_no = '" + deliveryHead.getVoyageNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getBillNo())) {
				this.WHERE("bill_no = '" + deliveryHead.getBillNo() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getLogisticsCode())) {
				this.WHERE("logistics_code = '" + deliveryHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getLogisticsName())) {
				this.WHERE("logistics_name like '%" + deliveryHead.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getUnloadLocation())) {
				this.WHERE("unload_location = '" + deliveryHead.getUnloadLocation() + "'");
			}
			
			if (StringUtils.isNumber(String.valueOf(deliveryHead.getDelFlag()))) {
				this.WHERE("del_flag = " + deliveryHead.getDelFlag());
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getMsgGuid())) {
				this.WHERE("msg_guid = '" + deliveryHead.getMsgGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getBeginSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + deliveryHead.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(deliveryHead.getEndSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + deliveryHead.getEndSysDate() + "'");
			}
		}}.toString();
	}
}
