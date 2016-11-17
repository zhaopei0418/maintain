package online.zhaopei.myproject.domain.gjpayment;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class PaymentMessage extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 874668515604702819L;

	private Long id;
	
	private String xmlContent;
	
	private Date createdDate;
	
	private String beginCreateDate;
	
	private Long dateNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXmlContent() {
		return xmlContent;
	}

	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(String beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public Long getDateNum() {
		return dateNum;
	}

	public void setDateNum(Long dateNum) {
		this.dateNum = dateNum;
	}
}
