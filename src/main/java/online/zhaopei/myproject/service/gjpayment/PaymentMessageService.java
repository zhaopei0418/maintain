package online.zhaopei.myproject.service.gjpayment;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;

public interface PaymentMessageService extends Serializable {

	List<PaymentMessage> getPaymentMessageList(PaymentMessage paymentMessage);
}
