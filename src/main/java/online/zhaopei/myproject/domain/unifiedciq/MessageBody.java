package online.zhaopei.myproject.domain.unifiedciq;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhaopei on 18/2/1.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageBody {

    @XmlElement(name = "C_PAYMENT_DECLARE")
    private PaymentDeclare paymentDeclare;

    public PaymentDeclare getPaymentDeclare() {
        return paymentDeclare;
    }

    public void setPaymentDeclare(PaymentDeclare paymentDeclare) {
        this.paymentDeclare = paymentDeclare;
    }
}
