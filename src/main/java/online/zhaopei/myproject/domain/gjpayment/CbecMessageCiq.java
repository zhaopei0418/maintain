package online.zhaopei.myproject.domain.gjpayment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CBECMESSAGE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "messageHead", "messageBody" })
public class CbecMessageCiq implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5300087232732196091L;

	@XmlElement(name = "MESSAGEHEAD")
	private MessageHeadCiq messageHead;
	
	@XmlElement(name = "MESSAGEBODY")
	private MessageBodyCiq messageBody;

	public MessageHeadCiq getMessageHead() {
		return messageHead;
	}

	public void setMessageHead(MessageHeadCiq messageHead) {
		this.messageHead = messageHead;
	}

	public MessageBodyCiq getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(MessageBodyCiq messageBody) {
		this.messageBody = messageBody;
	}
	
}
