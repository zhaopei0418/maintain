package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class DistBillListSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1267512445462375593L;

	public String countDistBillListSql(final String seqNo) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("pre_dist_bill_list");
			
			if (!StringUtils.isEmpty(seqNo)) {
				this.WHERE("seq_no = '" + seqNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getDistBillListListSql(final String seqNo) {
		return new SQL() {{
			this.SELECT("seq_no");
			this.SELECT("dist_no");
			this.SELECT("bill_no");
			this.SELECT("bill_type");
			this.SELECT("entry_id");
			this.SELECT("lms_seq_no");
			this.SELECT("lms_no");
			this.SELECT("pack_num");
			this.SELECT("gross_wt");
			this.SELECT("net_wt");
			this.SELECT("g_name");
			this.SELECT("trade_code");
			this.SELECT("trade_name");
			this.SELECT("decl_code");
			this.SELECT("decl_name");
			this.SELECT("owner_code");
			this.SELECT("owner_name");
			this.SELECT("i_e_port");
			this.SELECT("turn_no");
			this.SELECT("traf_mode");
			this.SELECT("trade_mode");
			this.SELECT("bill_id");
			this.SELECT("customs_code");
			this.SELECT("note");
			this.SELECT("dec_status");
			this.SELECT("dec_log_stat");
			this.SELECT("arrival_flag");
			this.SELECT("g_value");
			this.SELECT("modify_mark");
			this.SELECT("input_date");
			this.FROM("pre_dist_bill_list");
			
			if (!StringUtils.isEmpty(seqNo)) {
				this.WHERE("seq_no = '" + seqNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getDistBillListListBySearchTextSql(final String seqNo,final String searchText) {
		return new SQL() {{
			this.SELECT("seq_no");
			this.SELECT("dist_no");
			this.SELECT("bill_no");
			this.SELECT("bill_type");
			this.SELECT("entry_id");
			this.SELECT("lms_seq_no");
			this.SELECT("lms_no");
			this.SELECT("pack_num");
			this.SELECT("gross_wt");
			this.SELECT("net_wt");
			this.SELECT("g_name");
			this.SELECT("trade_code");
			this.SELECT("trade_name");
			this.SELECT("decl_code");
			this.SELECT("decl_name");
			this.SELECT("owner_code");
			this.SELECT("owner_name");
			this.SELECT("i_e_port");
			this.SELECT("turn_no");
			this.SELECT("traf_mode");
			this.SELECT("trade_mode");
			this.SELECT("bill_id");
			this.SELECT("customs_code");
			this.SELECT("note");
			this.SELECT("dec_status");
			this.SELECT("dec_log_stat");
			this.SELECT("arrival_flag");
			this.SELECT("g_value");
			this.SELECT("modify_mark");
			this.SELECT("input_date");
			this.FROM("pre_dist_bill_list");
			
			if (!StringUtils.isEmpty(seqNo)) {
				this.WHERE("seq_no = '" + seqNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
			
			if (!StringUtils.isEmpty(searchText)) {
				this.WHERE("bill_no like '%" + searchText + "%'");
			}
		}}.toString();
	}
}
