package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class DistHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4962289950024210261L;

	public String getDistHeadByInvtNoSql(final String invtNo) {
		return new SQL() {{
			this.SELECT("pdh.seq_no");
			this.SELECT("pdh.dist_no");
			this.SELECT("pdh.customs_code");
			this.SELECT("pdh.decl_code");
			this.SELECT("pdh.decl_name");
			this.SELECT("pdh.dist_stat");
			this.SELECT("pdh.input_date");
			this.SELECT("pdh.decl_date");
			this.SELECT("pdh.return_reason");
			this.SELECT("pdh.note");
			this.FROM("pre_dist_head pdh");
			this.INNER_JOIN("pre_dist_bill_list pdbl on pdh.seq_no = pdbl.seq_no");
			
			if(!StringUtils.isEmpty(invtNo)) {
				this.WHERE("pdbl.bill_no = '" + invtNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}
