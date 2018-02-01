package online.zhaopei.myproject.domain.unifiedciq;

import online.zhaopei.myproject.common.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by zhaopei on 18/2/1.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageHead {

    @XmlElement(name = "MESSAGE_ID")
    private String messageId;

    @XmlElement(name = "MESSAGE_TYPE")
    private String messageType;

    @XmlElement(name = "MESSAGE_SOURCE")
    private String messageSource;

    @XmlElement(name = "MESSAGE_DEST")
    private String messageDest;

    @XmlElement(name = "MESSAGE_SIGN_DATA")
    private String messageSignData;

    @XmlElement(name = "MESSAGE_CATEGORY")
    private String messageCategory;

    @XmlElement(name = "MESSAGE_VERSION")
    private String messageVersion;

    @XmlElement(name = "MESSAGE_TIME")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date messageTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(String messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessageDest() {
        return messageDest;
    }

    public void setMessageDest(String messageDest) {
        this.messageDest = messageDest;
    }

    public String getMessageSignData() {
        return messageSignData;
    }

    public void setMessageSignData(String messageSignData) {
        this.messageSignData = messageSignData;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }
}
