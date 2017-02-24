package online.zhaopei.myproject.sqlprovide.gjent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.gjent.ImpPayHead;

public class ImpPayHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1648244417863783185L;

	public String countImpPayHeadSql(final ImpPayHead impPayHead) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("imp_pay_head");
			
			OracleTool.where(this, "guid", impPayHead.getGuid());
			OracleTool.where(this, "pay_code", impPayHead.getPayCode());
			OracleTool.where(this, "pay_transaction_id", impPayHead.getPayTransactionId());
			OracleTool.where(this, "uuid", impPayHead.getUuid());
			
		}}.toString();
	}
	
	public String getImpPayHeadListSql(final ImpPayHead impPayHead) {
		return new SQL() {{
			this.SELECT("guid");
			this.SELECT("app_time");
			this.SELECT("app_status");
			this.SELECT("pay_code");
			this.SELECT("pay_name");
			this.SELECT("pay_transaction_id");
			this.SELECT("pay_time");
			this.SELECT("uuid");
			this.FROM("imp_pay_head");
			
			OracleTool.where(this, "guid", impPayHead.getGuid());
			OracleTool.where(this, "pay_code", impPayHead.getPayCode());
			OracleTool.where(this, "pay_name", impPayHead.getPayName(), true);
			OracleTool.where(this, "pay_transaction_id", impPayHead.getPayTransactionId(), true);
			OracleTool.where(this, "uuid", impPayHead.getUuid());
			OracleTool.orderBy(this, impPayHead.getOrderBy());
			
		}}.toString();
	}
	
	public String updateImpPayHeadSql(final ImpPayHead impPayHead) {
		return new SQL() {{
			this.UPDATE("imp_pay_head");
			
			OracleTool.set(this, "uuid", impPayHead.getUuid());
			OracleTool.set(this, "app_time", impPayHead.getAppTime());
			OracleTool.set(this, "seqno", impPayHead.getSeqNo());
			OracleTool.set(this, "managercustomscode", impPayHead.getManagerCustomsCode());
			OracleTool.set(this, "pay_time", impPayHead.getPayTime());
			OracleTool.set(this, "order_no", impPayHead.getOrderNo());
			OracleTool.set(this, "pay_name", impPayHead.getPayName());
			OracleTool.set(this, "ebp_code", impPayHead.getEbpCode());
			OracleTool.set(this, "ebp_name", impPayHead.getEbpName());
			OracleTool.set(this, "paymenttype", impPayHead.getPaymentType());
			OracleTool.set(this, "currency", impPayHead.getCurrency());
			OracleTool.set(this, "amount_paid", impPayHead.getAmountPaid());
			OracleTool.set(this, "payer_id_number", impPayHead.getPayerIdNumber());
			OracleTool.set(this, "customerflag", impPayHead.getCustomerFlag());
			OracleTool.set(this, "ietype", impPayHead.getIeType());
			OracleTool.set(this, "note", impPayHead.getNote());
			OracleTool.set(this, "payer_name", impPayHead.getPayerName());
			OracleTool.set(this, "payecode", impPayHead.getPayECode());
			OracleTool.set(this, "cbecodeinsp", impPayHead.getCbeCodeInsp());
			OracleTool.set(this, "cbecode", impPayHead.getCbeCode());
			OracleTool.set(this, "cbename", impPayHead.getCbeName());
			OracleTool.set(this, "billmode", impPayHead.getBillMode());
			
			OracleTool.where(this, "pay_code", impPayHead.getPayCode());
			OracleTool.where(this, "pay_transaction_id", impPayHead.getPayTransactionId());
		}}.toString();
	}
	
	public String insertPayHeadSql(final ImpPayHead impPayHead) {
		return new SQL() {{
			this.INSERT_INTO("imp_pay_head");
			
			OracleTool.values(this, "guid", impPayHead.getGuid());
			OracleTool.values(this, "uuid", impPayHead.getUuid());
			OracleTool.values(this, "app_time", impPayHead.getAppTime());
			OracleTool.values(this, "seqno", impPayHead.getSeqNo());
			OracleTool.values(this, "managercustomscode", impPayHead.getManagerCustomsCode());
			OracleTool.values(this, "pay_time", impPayHead.getPayTime());
			OracleTool.values(this, "order_no", impPayHead.getOrderNo());
			OracleTool.values(this, "pay_code", impPayHead.getPayCode());
			OracleTool.values(this, "pay_name", impPayHead.getPayName());
			OracleTool.values(this, "pay_transaction_id", impPayHead.getPayTransactionId());
			OracleTool.values(this, "ebp_code", impPayHead.getEbpCode());
			OracleTool.values(this, "ebp_name", impPayHead.getEbpName());
			OracleTool.values(this, "paymenttype", impPayHead.getPaymentType());
			OracleTool.values(this, "currency", impPayHead.getCurrency());
			OracleTool.values(this, "amount_paid", impPayHead.getAmountPaid());
			OracleTool.values(this, "payer_id_type", "1");
			OracleTool.values(this, "payer_id_number", impPayHead.getPayerIdNumber());
			OracleTool.values(this, "customerflag", impPayHead.getCustomerFlag());
			OracleTool.values(this, "ietype", impPayHead.getIeType());
			OracleTool.values(this, "note", impPayHead.getNote());
			OracleTool.values(this, "payer_name", impPayHead.getPayerName());
			OracleTool.values(this, "payecode", impPayHead.getPayECode());
			OracleTool.values(this, "cbecodeinsp", impPayHead.getCbeCodeInsp());
			OracleTool.values(this, "cbecode", impPayHead.getCbeCode());
			OracleTool.values(this, "cbename", impPayHead.getCbeName());
			OracleTool.values(this, "billmode", impPayHead.getBillMode());
			OracleTool.values(this, "auditstate", "success");
			this.VALUES("sys_date", "sysdate");
		}}.toString();
	}
}
