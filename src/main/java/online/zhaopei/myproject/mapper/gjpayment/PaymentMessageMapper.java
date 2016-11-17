package online.zhaopei.myproject.mapper.gjpayment;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;
import online.zhaopei.myproject.sqlprovide.gjpayment.PaymentMessageSqlProvide;

public interface PaymentMessageMapper extends Serializable {

	@Results(id = "paymentMessageResult", value = {
		@Result(property = "id", column = "id", id = true),
		@Result(property = "xmlContent", column = "xml_content"),
		@Result(property = "createdDate", column = "created_date"),
		@Result(property = "dateNum", column = "date_num"),
	})
	@SelectProvider(type = PaymentMessageSqlProvide.class, method = "getPaymentMessageListSql")
	List<PaymentMessage> getPaymentMessageList(PaymentMessage paymentMessage);
}
