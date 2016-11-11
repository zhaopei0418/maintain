package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.DistHead;

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
	
	public String getDistHeadListSql(final DistHead distHead) {
		return new SQL() {{
			this.SELECT("pdh.seq_no");
			this.SELECT("pdh.dist_no");
			this.SELECT("pdh.dist_type");
			this.SELECT("pdh.dist_stat");
			this.SELECT("pdh.customs_code");
			this.SELECT("pdh.i_e_flag");
			this.SELECT("pdh.i_e_type");
			this.SELECT("pdh.total_pack_num");
			this.SELECT("pdh.total_gross_wt");
			this.SELECT("pdh.decl_code");
			this.SELECT("pdh.decl_name");
			this.SELECT("pdh.input_date");
			this.SELECT("pdh.district_code");
			this.SELECT("pdh.discharge_code");
			this.SELECT("pdh.return_reason");
			this.SELECT("pdvl.ve_no");
			this.FROM("pre_dist_head pdh");
			this.LEFT_OUTER_JOIN("pre_dist_ve_list pdvl on pdh.seq_no = pdvl.seq_no");
			
			if (!StringUtils.isEmpty(distHead.getSeqNo())) {
				this.WHERE("pdh.seq_no = '" + distHead.getSeqNo() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getDistNo())) {
				this.WHERE("pdh.dist_no like '%" + distHead.getDistNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(distHead.getDistStat())) {
				this.WHERE("pdh.dist_stat = '" + distHead.getDistStat() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getVeNo())) {
				this.WHERE("pdvl.ve_no like '%" + distHead.getVeNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(distHead.getCustomsCode())) {
				this.WHERE("pdh.customs_code = '" + distHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getIeFlag())) {
				this.WHERE("pdh.i_e_flag = '" + distHead.getIeFlag() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getIeType())) {
				this.WHERE("pdh.i_e_type = '" + distHead.getIeType() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getDeclCode())) {
				this.WHERE("pdh.decl_code = '" + distHead.getDeclCode() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getDeclName())) {
				this.WHERE("pdh.decl_name like '%" + distHead.getDeclName() + "%'");
			}
			
			if (!StringUtils.isEmpty(distHead.getIePort())) {
				this.WHERE("pdh.i_e_port = '" + distHead.getIePort() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getBeginInputDate())) {
				this.WHERE("to_char(pdh.input_date, 'yyyy-mm-dd') <= '" + distHead.getBeginInputDate() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getEndInputDate())) {
				this.WHERE("to_char(pdh.input_date, 'yyyy-mm-dd') >= '" + distHead.getEndInputDate() + "'");
			}
			
			if (!StringUtils.isEmpty(distHead.getInputDateStr())) {
				this.WHERE("to_char(pdh.input_date, 'yyyy-mm-dd') = '" + distHead.getInputDateStr() + "'");
			}
			
		}}.toString();
	}
	
	public String getDistHeadBySeqNoSql(final String seqNo) {
		return new SQL() {{
			this.SELECT("pdh.seq_no");
			this.SELECT("pdh.dist_no");
			this.SELECT("pdh.cop_dist_no");
			this.SELECT("pdh.dist_type");
			this.SELECT("pdh.dist_stat");
			this.SELECT("pdh.customs_code");
			this.SELECT("pdh.i_e_flag");
			this.SELECT("pdh.i_e_type");
			this.SELECT("pdh.total_pack_num");
			this.SELECT("pdh.total_gross_wt");
			this.SELECT("pdh.decl_code");
			this.SELECT("pdh.decl_name");
			this.SELECT("pdh.input_person");
			this.SELECT("pdh.input_date");
			this.SELECT("pdh.district_code");
			this.SELECT("pdh.discharge_code");
			this.SELECT("pdh.return_reason");
			this.SELECT("pdh.cfs_code");
			this.SELECT("pdh.i_e_port");
			this.SELECT("pdh.note");
			this.SELECT("pdvl.ve_no");
			this.FROM("pre_dist_head pdh");
			this.LEFT_OUTER_JOIN("pre_dist_ve_list pdvl on pdh.seq_no = pdvl.seq_no");
			if (!StringUtils.isEmpty(seqNo)) {
				this.WHERE("pdh.seq_no = '" + seqNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
}
