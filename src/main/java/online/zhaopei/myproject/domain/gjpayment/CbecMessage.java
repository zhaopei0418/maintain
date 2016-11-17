package online.zhaopei.myproject.domain.gjpayment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CBECMESSAGE")
@XmlAccessorType(XmlAccessType.FIELD)
public class CbecMessage implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5300087232732196091L;

	@XmlElement(name = "MESSAGEHEAD")
	private MessageHead messageHead;
	
	@XmlElement(name = "MESSAGEBODY")
	private MessageBody messageBody;

	public MessageHead getMessageHead() {
		return messageHead;
	}

	public void setMessageHead(MessageHead messageHead) {
		this.messageHead = messageHead;
	}

	public MessageBody getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(MessageBody messageBody) {
		this.messageBody = messageBody;
	}
	
}
