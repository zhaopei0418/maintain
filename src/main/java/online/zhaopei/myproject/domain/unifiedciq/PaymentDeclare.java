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
public class PaymentDeclare {

    @XmlElement(name = "PAY_ID")
    private String payId;

    @XmlElement(name = "ORDER_NO")
    private String orderNo;

    @XmlElement(name = "PAY_TRANSACTION_NO")
    private String payTransactionNo;

    @XmlElement(name = "PAY_ENTERPRISE_NAME")
    private String payEnterpriseName;

    @XmlElement(name = "PAY_ENTERPRISE_CODE")
    private String payEnterpriseCode;

    @XmlElement(name = "PAYER_DOCUMENT_TYPE")
    private String payerDocumentType;

    @XmlElement(name = "PAYER_DOCUMENT_NUMBER")
    private String payerDocumentNumber;

    @XmlElement(name = "CREATE_TIME")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date createTime;

    @XmlElement(name = "ORDER_ID")
    private String orderId;

    @XmlElement(name = "PAYER_NAME")
    private String payerName;

    @XmlElement(name = "TELEPHONE")
    private String telephone;

    @XmlElement(name = "AMOUNT_PAID")
    private Double amountPaid;

    @XmlElement(name = "CURRENCY")
    private String currency;

    @XmlElement(name = "PAY_TIME")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date payTime;

    @XmlElement(name = "REMARK")
    private String remark;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayTransactionNo() {
        return payTransactionNo;
    }

    public void setPayTransactionNo(String payTransactionNo) {
        this.payTransactionNo = payTransactionNo;
    }

    public String getPayEnterpriseName() {
        return payEnterpriseName;
    }

    public void setPayEnterpriseName(String payEnterpriseName) {
        this.payEnterpriseName = payEnterpriseName;
    }

    public String getPayEnterpriseCode() {
        return payEnterpriseCode;
    }

    public void setPayEnterpriseCode(String payEnterpriseCode) {
        this.payEnterpriseCode = payEnterpriseCode;
    }

    public String getPayerDocumentType() {
        return payerDocumentType;
    }

    public void setPayerDocumentType(String payerDocumentType) {
        this.payerDocumentType = payerDocumentType;
    }

    public String getPayerDocumentNumber() {
        return payerDocumentNumber;
    }

    public void setPayerDocumentNumber(String payerDocumentNumber) {
        this.payerDocumentNumber = payerDocumentNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
