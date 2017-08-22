package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.VeHead;

public class VeHeadSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7262583581090759105L;

	public String getVeHeadListSql(final VeHead veHead) {
		return new SQL() {{
			this.SELECT("ve_id");
			this.SELECT("ve_no");
			this.SELECT("ve_owner");
			this.SELECT("ve_run_num");
			this.SELECT("link_tel");
			this.SELECT("ve_cop_id");
			this.SELECT("ve_cop_name");
			this.SELECT("ic_card_id");
			this.SELECT("ve_e_no");
			this.SELECT("customs_code");
			this.SELECT("ve_wt");
			this.SELECT("input_date");
			this.FROM("pre_ve_head");
			
			if (!StringUtils.isEmpty(veHead.getSearchText())) {
				this.WHERE("ve_no like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_owner like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_run_num like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("link_tel like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_cop_id like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_cop_name like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ic_card_id like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_e_no like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("customs_code like '%" + veHead.getSearchText() + "%'");
				this.OR().WHERE("ve_wt like '%" + veHead.getSearchText() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeId())) {
				this.WHERE("ve_id = '" + veHead.getVeId() + "'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeNo())) {
				this.WHERE("ve_no like '%" + veHead.getVeNo() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeOwner())) {
				this.WHERE("ve_owner like '%" + veHead.getVeOwner() + "'%");
			}
			
			if (!StringUtils.isEmpty(veHead.getLinkTel())) {
				this.WHERE("link_tel like '%" + veHead.getLinkTel() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeCopId())) {
				this.WHERE("ve_cop_id = '" + veHead.getVeCopId() + "'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeCopName())) {
				this.WHERE("ve_cop_name like '%" + veHead.getVeCopName() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getIcCardId())) {
				this.WHERE("ic_card_id like '%" + veHead.getIcCardId() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeRunNum())) {
				this.WHERE("ve_run_num like '%" + veHead.getVeRunNum() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getVeEno())) {
				this.WHERE("ve_e_no like '%" + veHead.getVeEno() + "%'");
			}
			
			if (!StringUtils.isEmpty(veHead.getCustomsCode())) {
				this.WHERE("customs_code = '" + veHead.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(veHead.getBeginInputDate())) {
				this.WHERE("to_char(input_date, 'yyyy-mm-dd') >= '" + veHead.getBeginInputDate() + "'");
			}
			
			if (!StringUtils.isEmpty(veHead.getEndInputDate())) {
				this.WHERE("to_char(input_date, 'yyyy-mm-dd') <= '" + veHead.getEndInputDate() + "'");
			}
		}}.toString();
	}
	
	public String getVeHeadByVeNoSql(final String veNo) {
		return new SQL() {{
			this.SELECT("ve_id");
			this.SELECT("ve_no");
			this.SELECT("ve_owner");
			this.SELECT("ve_run_num");
			this.SELECT("link_tel");
			this.SELECT("ve_cop_id");
			this.SELECT("ve_cop_name");
			this.SELECT("ic_card_id");
			this.SELECT("ve_e_no");
			this.SELECT("customs_code");
			this.SELECT("ve_wt");
			this.SELECT("input_date");
			this.FROM("pre_ve_head");
			
			if (!StringUtils.isEmpty(veNo)) {
				this.WHERE("ve_no = '" + veNo + "'");
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
 	}
	
	public String syncVeENoSql() {
		return new SQL() {{
			this.UPDATE("pre_ve_head pvh");
			this.SET("pvh.ve_e_no = (select cvh.ve_e_no from cur_ve_head cvh where pvh.ve_no = cvh.ve_no)");
			this.WHERE("exists (select * from cur_ve_head cvh where cvh.ve_no = pvh.ve_no and pvh.ve_e_no is null and cvh.ve_e_no is not null)");
		}}.toString();
	}
}
