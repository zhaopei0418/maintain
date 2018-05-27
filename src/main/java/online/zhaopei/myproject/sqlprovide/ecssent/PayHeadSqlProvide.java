package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import online.zhaopei.myproject.common.tool.OracleTool;
import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.PayHead;

public class PayHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1118566175488097348L;

	public String getPayHeadListSql(final PayHead payHead) {
		return new SQL() {{
			this.SELECT("guid");
			this.SELECT("pay_transaction_id");
			this.SELECT("ebp_code");
			this.SELECT("ebp_name");
			this.SELECT("pay_code");
			this.SELECT("pay_name");
			this.SELECT("ord_no");
			this.SELECT("payer_name");
			this.SELECT("payer_id_number");
			this.SELECT("amount_paid");
			this.SELECT("app_status");
			this.SELECT("app_type");
			this.SELECT("pay_time");
			this.SELECT("sys_date");
			this.FROM("ceb2_pay_head");
			
			if (!StringUtils.isEmpty(payHead.getGuid())) {
				this.WHERE("guid = '" + payHead.getGuid() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getPayTransactionId())) {
				this.WHERE("pay_transaction_id like '" + payHead.getPayTransactionId() + "%'");
			}
			
			if (!StringUtils.isEmpty(payHead.getEbpCode())) {
				this.WHERE("ebp_code = '" + payHead.getEbpCode() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getEbpName())) {
				this.WHERE("ebp_name like '" + payHead.getEbpName() + "%'");
			}
			
			if (!StringUtils.isEmpty(payHead.getPayCode())) {
				this.WHERE("pay_code = '" + payHead.getPayCode() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getPayName())) {
				this.WHERE("pay_name like '" + payHead.getPayName() + "%'");
			}
			
			if (!StringUtils.isEmpty(payHead.getOrdNo())) {
				this.WHERE("ord_no = '" + payHead.getOrdNo() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getPayerName())) {
				this.WHERE("payer_name like '" + payHead.getPayName() + "%'");
			}
			
			if (!StringUtils.isEmpty(payHead.getPayerIdNumber())) {
				this.WHERE("payer_id_number like '" + payHead.getPayerIdNumber() + "%'");
			}
			
			if (!StringUtils.isEmpty(payHead.getAppStatus())) {
				this.WHERE("app_status = '" + payHead.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getAppType())) {
				this.WHERE("app_type = '" + payHead.getAppType() + "'");
			}
			
			if (!StringUtils.isEmpty(payHead.getBeginSysDate())) {
				this.WHERE("sys_date >= to_date('" + payHead.getBeginSysDate() + "', 'yyyy-MM-dd')");
			}
			
			if (!StringUtils.isEmpty(payHead.getEndSysDate())) {
				this.WHERE("sys_date <= to_date('" + payHead.getEndSysDate() + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
			}
			
			if (!StringUtils.isEmpty(payHead.getBeginPayTime())) {
				this.WHERE("pay_time >= to_date('" + payHead.getBeginPayTime() + "', 'yyyy-MM-dd')");
			}
			
			if (!StringUtils.isEmpty(payHead.getEndPayTime())) {
				this.WHERE("pay_time <= to_date('" + payHead.getEndPayTime() + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
			}
		}}.toString();
	}
}
