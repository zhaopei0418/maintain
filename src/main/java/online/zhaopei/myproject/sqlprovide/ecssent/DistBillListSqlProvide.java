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
	
	public String getDistBillListListBySearchTextSql(final String seqNo, final String searchText) {
		return new SQL() {{
			this.SELECT("pdbl.seq_no");
			this.SELECT("pdbl.dist_no");
			this.SELECT("pdbl.bill_no");
			this.SELECT("pdbl.bill_type");
			this.SELECT("pdbl.entry_id");
			this.SELECT("pdbl.lms_seq_no");
			this.SELECT("pdbl.lms_no");
			this.SELECT("pdbl.pack_num");
			this.SELECT("pdbl.gross_wt");
			this.SELECT("pdbl.net_wt");
			this.SELECT("pdbl.g_name");
			this.SELECT("pdbl.trade_code");
			this.SELECT("pdbl.trade_name");
			this.SELECT("pdbl.decl_code");
			this.SELECT("pdbl.decl_name");
			this.SELECT("pdbl.owner_code");
			this.SELECT("pdbl.owner_name");
			this.SELECT("pdbl.i_e_port");
			this.SELECT("pdbl.turn_no");
			this.SELECT("pdbl.traf_mode");
			this.SELECT("pdbl.trade_mode");
			this.SELECT("pdbl.bill_id");
			this.SELECT("pdbl.customs_code");
			this.SELECT("pdbl.note");
			this.SELECT("pdbl.dec_status");
			this.SELECT("pdbl.dec_log_stat");
			this.SELECT("pdbl.arrival_flag");
			this.SELECT("pdbl.g_value");
			this.SELECT("pdbl.modify_mark");
			this.SELECT("pdbl.input_date");
			this.SELECT("cih.app_status");
			this.SELECT("cih.order_no");
			this.SELECT("cih.logistics_no");
			this.SELECT("cih.logistics_name");
			this.SELECT("cih.logistics_code");
			this.SELECT("cih.ebc_name");
			this.SELECT("cih.ebc_code");
			this.FROM("pre_dist_bill_list pdbl");
			this.LEFT_OUTER_JOIN("ceb2_invt_head cih on cih.invt_no = pdbl.bill_no");
			
			if (!StringUtils.isEmpty(seqNo)) {
				this.WHERE("pdbl.seq_no = '" + seqNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
			
			if (!StringUtils.isEmpty(searchText)) {
				String orSql = "(pdbl.bill_no like '%" + searchText + "%'";
				orSql += " OR lower(cih.order_no) like '%' || lower('" + searchText + "') || '%'";
				orSql += " OR pdbl.gross_wt like '%" + searchText + "%'";
				orSql += " OR pdbl.net_wt like '%" + searchText + "%'";
				orSql += " OR lower(cih.logistics_no) like '%' || lower('" + searchText + "') || '%'";
				orSql += " OR lower(cih.ebc_name) like '%' || lower('" + searchText + "') || '%'";
				orSql += " OR cih.logistics_name like '%' || lower('" + searchText + "') || '%'";
				orSql += " OR pdbl.trade_mode like '%" + searchText + "%'";
				orSql += " OR cih.app_status like '%" + searchText + "%')";
				this.WHERE(orSql);
			}
		}}.toString();
	}
}
