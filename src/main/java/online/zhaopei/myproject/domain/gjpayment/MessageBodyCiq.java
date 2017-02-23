package online.zhaopei.myproject.domain.gjpayment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MESSAGEBODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageBodyCiq implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1999722319026906835L;

	@XmlElement(name = "BODYMASTER")
	private BodyMasterCiq bodyMaster;

	public BodyMasterCiq getBodyMaster() {
		return bodyMaster;
	}

	public void setBodyMaster(BodyMasterCiq bodyMaster) {
		this.bodyMaster = bodyMaster;
	}
	
}
