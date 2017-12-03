package online.zhaopei.myproject.sqlprovide.gjent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class ImpInvtHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1127904464360375888L;

	public String getInvtHeadListByInvtNoSql(final String invtNo) {
		return new SQL() {{
			this.SELECT("guid");
			this.SELECT("pre_no");
			this.SELECT("invt_no");
			this.SELECT("detailscode");
			this.SELECT("applycode");
			this.SELECT("audit_state");
			this.SELECT("bw_name");
			this.SELECT("apply_date");
			this.SELECT("payecode");
			this.SELECT("payename");
			this.FROM("imp_invt_head");
			
			if (!StringUtils.isEmpty(invtNo)) {
				this.WHERE("invt_no = '" + invtNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getInvtHeadListByCopNoSql(final String copNo) {
		return new SQL() {{
			this.SELECT("guid");
			this.SELECT("pre_no");
			this.SELECT("invt_no");
			this.SELECT("detailscode");
			this.SELECT("applycode");
			this.SELECT("audit_state");
			this.SELECT("bw_name");
			this.SELECT("apply_date");
			this.SELECT("payecode");
			this.SELECT("payename");
			this.FROM("imp_invt_head");
			
			if (!StringUtils.isEmpty(copNo)) {
				this.WHERE("cop_no = '" + copNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}

	public String getInvtHeadListByOrderNoLogisticsNoSql(final String ebcCode, final String orderNo, final String logisticsCode, final String logisticsNo) {
		return new SQL(){{
			this.SELECT("guid");
			this.SELECT("pre_no");
			this.SELECT("invt_no");
			this.SELECT("detailscode");
			this.SELECT("applycode");
			this.SELECT("audit_state");
			this.SELECT("bw_name");
			this.SELECT("apply_date");
			this.SELECT("payecode");
			this.SELECT("payename");
			this.FROM("imp_invt_head");

			this.WHERE("ebc_code = '" + ebcCode + "'");
			this.WHERE("order_no = '" + orderNo + "'");
			this.WHERE("logistics_code = '" + logisticsCode + "'");
			this.WHERE("logistics_no = '" + logisticsNo + "'");
		}}.toString();
	}
	
	public String getCopNoListSql(final String applyCode) {
		return new SQL() {{
			this.SELECT("cop_no");
			this.FROM("imp_invt_head");
			
			if (!StringUtils.isEmpty(applyCode)) {
				this.WHERE("applycode like '%" + applyCode + "%'");
			}
			
		}}.toString();
	}
}
