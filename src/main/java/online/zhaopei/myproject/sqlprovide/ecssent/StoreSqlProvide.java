package online.zhaopei.myproject.sqlprovide.ecssent;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.Store;
import oracle.jdbc.oracore.OracleTypeOPAQUE;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by zhaopei on 18/3/23.
 */
public class StoreSqlProvide {

    public String getStoreListSql(final Store store) {
        return new SQL() {{
            this.SELECT("plh.lms_no");
            this.SELECT("plh.trade_code");
            this.SELECT("plh.trade_name");
            this.SELECT("st.item_no");
            this.SELECT("st.code_ts");
            this.SELECT("st.g_name");
            this.SELECT("st.g_model");
            this.SELECT("st.trade_country");
            this.SELECT("st.unit");
            this.SELECT("st.decl_price");
            this.SELECT("st.trade_curr");
            this.SELECT("st.customs_code");
            this.SELECT("st.legal_i_qty");
            this.SELECT("st.legal_o_qty");
            this.SELECT("st.legal_remain_qty");
            this.SELECT("st.period_start_qty");
            this.FROM("pre_lms_head plh");
            this.INNER_JOIN("store_total st on st.lms_no = plh.lms_no");
            this.LEFT_OUTER_JOIN("pre_goods_head pgh on pgh.cbe_code = plh.trade_code");

            OracleTool.where(this, "plh.lms_no", store.getLmsNo());
            OracleTool.where(this, "plh.trade_code", store.getTradeCode());
            OracleTool.where(this, "plh.trade_name", store.getTradeName(), true);
            OracleTool.where(this, "st.item_no", store.getItemNo());
            OracleTool.where(this, "st.code_ts", store.getCodeTs());
            OracleTool.where(this, "st.g_name", store.getgName(), true);
            OracleTool.where(this, "pgh.apply_code", store.getAgentCode());

        }}.toString();
    }
}
