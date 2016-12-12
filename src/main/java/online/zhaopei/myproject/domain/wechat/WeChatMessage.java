package online.zhaopei.myproject.domain.wechat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import online.zhaopei.myproject.common.adapter.CDataAdapter;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeChatMessage {

	@XmlElement(name = "ToUserName")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String toUserName;
	
	@XmlElement(name = "FromUserName")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String fromUserName;
	
	@XmlElement(name = "CreateTime")
	private Long createTime;
	
	@XmlElement(name = "MsgType")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String msgType;
	
	@XmlElement(name = "Event")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String event;
	
	@XmlElement(name = "EventKey")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String eventKey;
	
	@XmlElement(name = "Content")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String content;
	
	@XmlElement(name = "MsgId")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}
