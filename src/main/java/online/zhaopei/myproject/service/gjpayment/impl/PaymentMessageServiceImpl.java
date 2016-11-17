package online.zhaopei.myproject.service.gjpayment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.gjpayment.PaymentMessage;
import online.zhaopei.myproject.mapper.gjpayment.PaymentMessageMapper;
import online.zhaopei.myproject.service.gjpayment.PaymentMessageService;

@Service
public class PaymentMessageServiceImpl implements PaymentMessageService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -59750532162554595L;

	@Autowired
	private PaymentMessageMapper paymentMessageMapper;
	
	@Override
	public List<PaymentMessage> getPaymentMessageList(PaymentMessage paymentMessage) {
		return this.paymentMessageMapper.getPaymentMessageList(paymentMessage);
	}

}
