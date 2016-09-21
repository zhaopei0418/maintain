package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;

public class InvtHeadStatisticsSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1244807440525270693L;

	public String statisticsInvtHeadQuantitySql(final InvtHeadStatistics invtHeadStatistics) {
		return new SQL() {{
			StringBuffer orderStringBuffer = new StringBuffer();
			if (StringUtils.isEmpty(invtHeadStatistics.getGroupField())) {
				invtHeadStatistics.setGroupField("cih.ebc_name");
			}
			
			this.SELECT("decode(grouping(" + invtHeadStatistics.getGroupField() + "), 1, '总计', " +
					invtHeadStatistics.getGroupField() + ") as name");
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
				this.SELECT("decode(grouping(" + invtHeadStatistics.getGroupFieldTwo() + "), 1, '小计', " +
						invtHeadStatistics.getGroupFieldTwo() + ") as nameTwo");
			}
			this.SELECT("count(1) as quantity");
			this.SELECT("sum(coh.goods_value) as goods_value");
			this.FROM("ceb2_invt_head cih");
			this.LEFT_OUTER_JOIN("ceb2_ord_head coh on cih.order_no = coh.order_no and cih.ebc_code = coh.ebc_code");
			this.LEFT_OUTER_JOIN("cur_lms_head clh on clh.lms_no = cih.ems_no");
			if (!StringUtils.isEmpty(invtHeadStatistics.getBeginSysDate())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') >= '" + invtHeadStatistics.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getEndSysDate())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') <= '" + invtHeadStatistics.getEndSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getAppStatus())) {
				this.WHERE("cih.app_status = '" + invtHeadStatistics.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getDistStatus())) {
				this.WHERE("cih.dist_status = '" + invtHeadStatistics.getDistStatus() + "'");
			}
			if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
				this.GROUP_BY("rollup(" + invtHeadStatistics.getGroupField() + "," 
					+ invtHeadStatistics.getGroupFieldTwo() +")");
			} else {
				this.GROUP_BY("rollup(" + invtHeadStatistics.getGroupField() + ")");
			}
			orderStringBuffer.append(invtHeadStatistics.getGroupField());
			if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
				orderStringBuffer.append("," + invtHeadStatistics.getGroupFieldTwo());
			}
			orderStringBuffer.append(", count(1) desc, sum(coh.goods_value) desc");
			this.ORDER_BY(orderStringBuffer.toString()); 
		}}.toString();
	}
}
