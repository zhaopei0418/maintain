package online.zhaopei.myproject.domain.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EListRejectMessage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlType(propOrder = {"appNo", "eListNo", "operator", "reason"})
public class EListRejectMessage implements Serializable {

	/**
	 * 1918847528302179399L
	 */
	private static final long serialVersionUID = 1918847528302179399L;

	private String appNo;
	
	private String eListNo;
	
	private String operator;
	
	private String reason;

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	public String geteListNo() {
		return eListNo;
	}

	public void seteListNo(String eListNo) {
		this.eListNo = eListNo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
