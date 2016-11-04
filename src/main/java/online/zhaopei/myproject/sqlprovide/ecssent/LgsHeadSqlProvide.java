package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.LgsHead;

public class LgsHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7334695241230074645L;

	public String getLgsHeadListSql(final LgsHead lgsHead) {
		return new SQL() {{
			this.SELECT("guid");
			this.SELECT("logistics_no");
			this.SELECT("bill_no");
			this.SELECT("logistics_code");
			this.SELECT("logistics_name");
			this.SELECT("consignee");
			this.SELECT("sys_date");
			this.SELECT("app_type");
			this.SELECT("app_status");
			this.FROM("ceb2_lgs_head");
			
			if (!StringUtils.isEmpty(lgsHead.getSearchText())) {
				this.WHERE("logistics_code like '%" + lgsHead.getSearchText() + "%'");
				this.OR().WHERE("bill_no like '%" + lgsHead.getSearchText() + "%'");
				this.OR().WHERE("logistics_code like '%" + lgsHead.getSearchText() + "%'");
				this.OR().WHERE("logistics_name like '%" + lgsHead.getSearchText() + "%'");
				this.OR().WHERE("consignee like '%" + lgsHead.getSearchText() + "%'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getGuid())) {
				this.WHERE("guid = '" + lgsHead.getGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getLogisticsNo())) {
				this.WHERE("logistics_no = '" + lgsHead.getLogisticsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getBillNo())) {
				this.WHERE("bill_no = '" + lgsHead.getBillNo() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getLogisticsCode())) {
				this.WHERE("logistics_code = '" + lgsHead.getLogisticsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getLogisticsName())) {
				this.WHERE("logistics_name like '%" + lgsHead.getLogisticsName() + "%'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getConsignee())) {
				this.WHERE("consignee = '" + lgsHead.getConsignee() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getAppType())) {
				this.WHERE("app_type = '" + lgsHead.getAppType() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getAppStatus())) {
				this.WHERE("app_status = '" + lgsHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getBeginSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + lgsHead.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(lgsHead.getEndSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + lgsHead.getEndSysDate() + "'");
			}
		}}.toString();
	}
}
