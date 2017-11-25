package online.zhaopei.myproject.common.tool;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by zhaopei on 17/11/24.
 */
public class ExportTool {

    static {
        System.loadLibrary("export");
    }

    public static String buildExportSql(final InvtHead invtHead) {
        return new SQL() {{
            this.SELECT("cih.invt_no 海关清单号");
            this.SELECT("cih.app_status 海关状态");
            this.SELECT("cpr.rtn_info 海关回执");
            this.SELECT("cpr.rtn_time 海关回执时间");
            this.SELECT("cpr.sys_date 海关回执入库时间");
            this.SELECT("iih.detailscode 国检清单编号");
            this.SELECT("iih.audit_state 国检状态");
            this.SELECT("iih.bw_name 国检回执");
            this.SELECT("cih.ebc_name 电商企业");
            this.SELECT("cih.order_no 订单编号");
            this.SELECT("cih.logistics_name 物流企业");
            this.SELECT("cih.logistics_no 物流单号");
            this.SELECT("iih.payename 支付企业");
            this.SELECT("iih.applycode 支付单编号");
            this.SELECT("cih.bill_no 主单号");
            this.SELECT("cih.sys_date 申报日期");
            this.SELECT("iih.goodsvalue 总货值");
            this.SELECT("cih.consignee_address 收货人地址");
            this.SELECT("cih.gross_weight 总毛重");
            this.SELECT("cih.net_weight 总净重");
            this.SELECT("pdbl.dist_no 核放单号");
            this.SELECT("pdh.dist_stat 核放单状态");
            this.SELECT("cih.dist_time 过卡口时间");

            this.FROM("ceb2_invt_head cih");

            this.LEFT_OUTER_JOIN("imp_invt_head@ggfw_zhengzhou iih on iih.order_no = cih.order_no and iih.ebc_code = cih.ebc_code and iih.logistics_code = cih.logistics_code and iih.logistics_no = cih.logistics_no");
            this.LEFT_OUTER_JOIN("ceb2_pub_rtn cpr on cpr.biz_guid = cih.head_guid and cpr.rtn_status = cih.app_status left outer join (select tt.biz_guid, tt.rtn_status,max(tt.sys_date) as max_sys_date from ceb2_pub_rtn tt group by tt.biz_guid, tt.rtn_status) tt0 on tt0.biz_guid = cpr.biz_guid and tt0.rtn_status = cpr.rtn_status and tt0.max_sys_date = cpr.sys_date");
            this.LEFT_OUTER_JOIN("pre_dist_bill_list pdbl on pdbl.bill_no = cih.invt_no left outer join pre_dist_head pdh on pdh.seq_no = pdbl.seq_no");

            OracleTool.where(this, "cih.head_guid", invtHead.getHeadGuid());
            OracleTool.where(this, "cih.app_status", invtHead.getAppStatus());
            OracleTool.where(this, "cih.sys_date", invtHead.getBeginAppTime(), ">=");
            OracleTool.where(this, "cih.sys_date", invtHead.getEndAppTime(), "<=");
            OracleTool.where(this, "cih.sys_date", invtHead.getSysDateStr(), "=");
            OracleTool.where(this, "cih.app_sender_id", invtHead.getAppSenderId());
            OracleTool.where(this, "cih.order_no", invtHead.getOrderNo(), true);
            OracleTool.where(this, "cih.ebc_code", invtHead.getEbcCode());
            OracleTool.where(this, "cih.ebc_name", invtHead.getEbcName(), true);
            OracleTool.where(this, "cih.logistics_no", invtHead.getLogisticsNo(), true);
            OracleTool.where(this, "cih.logistics_code", invtHead.getLogisticsCode());
            OracleTool.where(this, "cih.logistics_name", invtHead.getLogisticsName(), true);
            OracleTool.where(this, "cih.cop_no", invtHead.getCopNo());
            OracleTool.where(this, "cih.invt_no", invtHead.getInvtNo(), true);
            OracleTool.where(this, "cih.agent_code", invtHead.getAgentCode());
            OracleTool.where(this, "cih.agent_name", invtHead.getAgentName(), true);
            OracleTool.where(this, "cih.area_code", invtHead.getAreaCode());
            OracleTool.where(this, "cih.area_name", invtHead.getAreaName(), true);
            OracleTool.where(this, "cih.dist_status", invtHead.getDistStatus());
            OracleTool.where(this, "cih.customs_code", invtHead.getCustomsCode());
            OracleTool.where(this, "cih.trade_mode", invtHead.getTradeMode());
            OracleTool.where(this, "cih.bill_no", invtHead.getBillNo());
            OracleTool.where(this, "cih.voyage_no", invtHead.getVoyageNo());
            OracleTool.where(this, "cih.buyer_telephone", invtHead.getBuyerTelephone());
            OracleTool.where(this, "pdbl.dist_no", invtHead.getDistNo());

            if (!StringUtils.isEmpty(invtHead.getDeclareStatus())) {
                if ("1".equals(invtHead.getDeclareStatus())) {
                    this.WHERE("cih.app_status in ('1', '01', '100')");
                } else {
                    this.WHERE("cih.app_status not in ('1', '01', '100')");
                }
            }

            if (null != invtHead.getCopNoList() && !invtHead.getCopNoList().isEmpty()) {
                StringBuffer stringBufferIn = new StringBuffer("(");
                for(String copNo : invtHead.getCopNoList()) {
                    stringBufferIn.append("'" + copNo + "',");
                }
                stringBufferIn.deleteCharAt(stringBufferIn.length() - 1);
                stringBufferIn.append(")");
                this.WHERE("cih.cop_no in " + stringBufferIn.toString());
            }
        }}.toString();
    }

    public static native void hello(String name);

    public static native void generateExportFile(int type, String sqlPathName, String exportPathName);
}
