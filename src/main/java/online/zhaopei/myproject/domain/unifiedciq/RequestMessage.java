package online.zhaopei.myproject.domain.unifiedciq;

import javax.xml.bind.annotation.*;

/**
 * Created by zhaopei on 18/2/1.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "messageHead", "messageBody" })
public class RequestMessage {

    @XmlElement(name = "MessageHead")
    private MessageHead messageHead;

    @XmlElement(name = "MessageBody")
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
