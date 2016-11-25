package online.zhaopei.myproject.sqlprovide.gjpayment;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;

public class PaymentMessageSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -558018063689455411L;

	public String getPaymentMessageListSql(final PaymentMessage paymentMessage) {
		return new SQL() {{
			this.SELECT("id");
			this.SELECT("xml_content");
			this.SELECT("created_date");
			this.SELECT("date_num");
			this.FROM("tb_recv_message");
			
			if (null != paymentMessage.getId()) {
				this.WHERE("id = " + paymentMessage.getId());
			}
			
			if (!StringUtils.isEmpty(paymentMessage.getXmlContent())) {
				this.WHERE("xml_content like '%" + paymentMessage.getXmlContent() + "%'");
			}
			
			if (!StringUtils.isEmpty(paymentMessage.getBeginCreateDate())) {
				this.WHERE("to_char(created_date, 'yyyymmddhh24miss') >= '" + paymentMessage.getBeginCreateDate() + "'");
			}
			
			if (null != paymentMessage.getDateNum()) {
				this.WHERE("date_num = " + paymentMessage.getDateNum());
			}
			
			if (null != paymentMessage.getBeginDateNum()) {
				this.WHERE("date_num >= " + paymentMessage.getBeginDateNum());
			}
			
			if (!StringUtils.isEmpty(paymentMessage.getOrderBy())) {
				this.ORDER_BY(paymentMessage.getOrderBy());
			}
		}}.toString();
	}
}
