package online.zhaopei.myproject.domain.gjpayment;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import online.zhaopei.myproject.common.adapter.DateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyMaster implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4001147269292461151L;

	@XmlElement(name = "SEQNO")
	private String seqNo;
	
	@XmlElement(name = "GUID")
	private String guid;
	
	@XmlElement(name = "MANAGERCUSTOMSCODE")
	private String managerCustomsCode;
	
	@XmlElement(name = "PAYTIME")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date payTime;
	
	@XmlElement(name = "ORDERID")
	private String orderId;
	
	@XmlElement(name = "PAYENTERPRISECODE")
	private String payEnterpriseCode;
	
	@XmlElement(name = "PAYENTERPRISENAME")
	private String payEnterpriseName;
	
	@XmlElement(name = "PAYNUMBER")
	private String payNumber;
	
	@XmlElement(name = "ECPCODE")
	private String ecpCode;
	
	@XmlElement(name = "ECPNAME")
	private String ecpName;
	
	@XmlElement(name = "PAYMENTTYPE")
	private String paymentType;
	
	@XmlElement(name = "MONETARYTYPE")
	private String monetaryType;
	
	@XmlElement(name = "FEE")
	private Double fee;
	
	@XmlElement(name = "CUSTOMERFLAG")
	private String customerFlag;
	
	@XmlElement(name = "IDTYPE")
	private String idType;
	
	@XmlElement(name = "CUSTOMERID")
	private String customerId;
	
	@XmlElement(name = "IETYPE")
	private String ieType;
	
	@XmlElement(name = "REMARK")
	private String remark;
	
	@XmlElement(name = "PAYUSER")
	private String payUser;
	
	@XmlElement(name = "PAYECODE")
	private String payECode;
	
	@XmlElement(name = "CBECODEINSP")
	private String cbeCodeInsp;
	
	@XmlElement(name = "COININSP")
	private String coinInsp;
	
	@XmlElement(name = "CBECODE")
	private String cbeCode;
	
	@XmlElement(name = "cbeName")
	private String cbeName;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getManagerCustomsCode() {
		return managerCustomsCode;
	}

	public void setManagerCustomsCode(String managerCustomsCode) {
		this.managerCustomsCode = managerCustomsCode;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPayEnterpriseCode() {
		return payEnterpriseCode;
	}

	public void setPayEnterpriseCode(String payEnterpriseCode) {
		this.payEnterpriseCode = payEnterpriseCode;
	}

	public String getPayEnterpriseName() {
		return payEnterpriseName;
	}

	public void setPayEnterpriseName(String payEnterpriseName) {
		this.payEnterpriseName = payEnterpriseName;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public String getEcpCode() {
		return ecpCode;
	}

	public void setEcpCode(String ecpCode) {
		this.ecpCode = ecpCode;
	}

	public String getEcpName() {
		return ecpName;
	}

	public void setEcpName(String ecpName) {
		this.ecpName = ecpName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getMonetaryType() {
		return monetaryType;
	}

	public void setMonetaryType(String monetaryType) {
		this.monetaryType = monetaryType;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getIeType() {
		return ieType;
	}

	public void setIeType(String ieType) {
		this.ieType = ieType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public String getPayECode() {
		return payECode;
	}

	public void setPayECode(String payECode) {
		this.payECode = payECode;
	}

	public String getCbeCodeInsp() {
		return cbeCodeInsp;
	}

	public void setCbeCodeInsp(String cbeCodeInsp) {
		this.cbeCodeInsp = cbeCodeInsp;
	}

	public String getCoinInsp() {
		return coinInsp;
	}

	public void setCoinInsp(String coinInsp) {
		this.coinInsp = coinInsp;
	}

	public String getCbeCode() {
		return cbeCode;
	}

	public void setCbeCode(String cbeCode) {
		this.cbeCode = cbeCode;
	}

	public String getCbeName() {
		return cbeName;
	}

	public void setCbeName(String cbeName) {
		this.cbeName = cbeName;
	}
}
