package online.zhaopei.myproject.domain.ecssent;

import online.zhaopei.myproject.domain.BaseDomain;

/**
 * Created by zhaopei on 18/3/23.
 */
public class Store extends BaseDomain {

    private String lmsNo;

    private String tradeCode;

    private String tradeName;

    private String agentCode;

    private String itemNo;

    private String codeTs;

    private String gName;

    private String gModel;

    private String tradeCountry;

    private String unit;

    private Double declPrice;

    private String tradeCurr;

    private String customsCode;

    private Double legalIQty;

    private Double legalOQty;

    private Double legalRemainQty;

    private Double periodStartQty;

    public String getLmsNo() {
        return lmsNo;
    }

    public void setLmsNo(String lmsNo) {
        this.lmsNo = lmsNo;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getTradeName() {
        return tradeName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCodeTs() {
        return codeTs;
    }

    public void setCodeTs(String codeTs) {
        this.codeTs = codeTs;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgModel() {
        return gModel;
    }

    public void setgModel(String gModel) {
        this.gModel = gModel;
    }

    public String getTradeCountry() {
        return tradeCountry;
    }

    public void setTradeCountry(String tradeCountry) {
        this.tradeCountry = tradeCountry;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getDeclPrice() {
        return declPrice;
    }

    public void setDeclPrice(Double declPrice) {
        this.declPrice = declPrice;
    }

    public String getTradeCurr() {
        return tradeCurr;
    }

    public void setTradeCurr(String tradeCurr) {
        this.tradeCurr = tradeCurr;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public Double getLegalIQty() {
        return legalIQty;
    }

    public void setLegalIQty(Double legalIQty) {
        this.legalIQty = legalIQty;
    }

    public Double getLegalOQty() {
        return legalOQty;
    }

    public void setLegalOQty(Double legalOQty) {
        this.legalOQty = legalOQty;
    }

    public Double getLegalRemainQty() {
        return legalRemainQty;
    }

    public void setLegalRemainQty(Double legalRemainQty) {
        this.legalRemainQty = legalRemainQty;
    }

    public Double getPeriodStartQty() {
        return periodStartQty;
    }

    public void setPeriodStartQty(Double periodStartQty) {
        this.periodStartQty = periodStartQty;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}
