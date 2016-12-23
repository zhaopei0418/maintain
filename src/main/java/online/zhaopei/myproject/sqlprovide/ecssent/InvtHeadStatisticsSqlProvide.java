package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;
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
			
			if (invtHeadStatistics.isSubtotal()) {
				this.SELECT("decode(grouping(" + invtHeadStatistics.getGroupField() + "), 1, '总计', " +
						invtHeadStatistics.getGroupField() + ") as name");
				
				if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
					this.SELECT("decode(grouping(" + invtHeadStatistics.getGroupFieldTwo() + "), 1, '小计', " +
							invtHeadStatistics.getGroupFieldTwo() + ") as nameTwo");
				}
			} else {
				this.SELECT(invtHeadStatistics.getGroupField() + " as name");
				if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
					this.SELECT(invtHeadStatistics.getGroupFieldTwo() + " as nameTwo");
				}
				
				if (invtHeadStatistics.isWeekGroup()) {
					this.SELECT(invtHeadStatistics.getGroupField() + " - 7 as weekStart");
					this.SELECT(invtHeadStatistics.getGroupField() + " - 1 as weekEnd");
				}
			}
			
			this.SELECT("count(1) as quantity");
			this.SELECT("sum(cil.total_price) as goods_value");
			this.SELECT("sum(cil.qty) as goodsTotalQuantity");
			this.SELECT("sum(cth.tax_total) as taxTotal");
			this.SELECT("sum(cth.customs_tax) as customsTax");
			this.SELECT("sum(cth.value_added_tax) as valueAddedTax");
			this.SELECT("sum(cth.consumption_tax) as consumptionTax");
			this.FROM("ceb2_invt_head cih");
			
			this.INNER_JOIN("(select head_guid, sum(qty) as qty, sum(total_price) as total_price from ceb2_invt_list group by head_guid) cil on cil.head_guid = cih.head_guid");
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getDistinct())) {
				this.INNER_JOIN("(select min(head_guid) as inner_head_guid from ceb2_invt_head group by ebc_code, order_no) cih1 on cih.head_guid = cih1.inner_head_guid");
			}
			
			this.LEFT_OUTER_JOIN("(select * from ceb2_ord_head where head_guid in (select min(head_guid) as headguid from ceb2_ord_head group by ebc_code, order_no)) coh on coh.ebc_code = cih.ebc_code and coh.order_no = cih.order_no");
			this.LEFT_OUTER_JOIN("ceb2_tax_head cth on cth.invt_no = cih.invt_no");
			
			this.LEFT_OUTER_JOIN("cur_lms_head clh on clh.lms_no = cih.ems_no");
			if (!StringUtils.isEmpty(invtHeadStatistics.getBeginSysDate())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') >= '" + invtHeadStatistics.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getEndSysDate())) {
				this.WHERE("to_char(cih.sys_date, 'yyyy-mm-dd') <= '" + invtHeadStatistics.getEndSysDate() + "'");
			}
			
			OracleTool.where(this, "cih.sys_date", invtHeadStatistics.getSysDateStr(), "=");
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getAppStatus())) {
				this.WHERE("cih.app_status = '" + invtHeadStatistics.getAppStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getDistStatus())) {
				this.WHERE("cih.dist_status = '" + invtHeadStatistics.getDistStatus() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getEbcCode())) {
				this.WHERE("cih.ebc_code = '" + invtHeadStatistics.getEbcCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getEbcName())) {
				this.WHERE("cih.ebc_name like '%" + invtHeadStatistics.getEbcName() + "%'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getAgentCode())) {
				this.WHERE("cih.agent_code = '" + invtHeadStatistics.getAgentCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getAgentName())) {
				this.WHERE("cih.agent_name like '%" + invtHeadStatistics.getAgentName() + "%'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getLogisticsCode())) {
				this.WHERE("cih.logistics_code = '" + invtHeadStatistics.getLogisticsCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getLogisticsName())) {
				this.WHERE("cih.logistics_name like '%" + invtHeadStatistics.getLogisticsName() + "%'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getPayCode())) {
				this.WHERE("coh.pay_code = '" + invtHeadStatistics.getPayCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getPayName())) {
				this.WHERE("coh.pay_name like '%" + invtHeadStatistics.getPayName() + "%'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getAreaCode())) {
				this.WHERE("cih.area_code = '" + invtHeadStatistics.getAreaCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getAreaName())) {
				this.WHERE("cih.area_name like '%" + invtHeadStatistics.getAreaName() + "%'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getTradeCode())) {
				this.WHERE("clh.trade_code = '" + invtHeadStatistics.getTradeCode() + "'");
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getTradeName())) {
				this.WHERE("clh.trade_name like '%" + invtHeadStatistics.getTradeName() + "%'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getCustomsCode())) {
				this.WHERE("cih.customs_code = '" + invtHeadStatistics.getCustomsCode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getTradeMode())) {
				this.WHERE("cih.trade_mode = '" + invtHeadStatistics.getTradeMode() + "'");
			}
			
			if (!StringUtils.isEmpty(invtHeadStatistics.getDeclareStatus())) {
				if ("1".equals(invtHeadStatistics.getDeclareStatus())) {
					this.WHERE("cih.app_status in ('1', '01', '100')");
				} else {
					this.WHERE("cih.app_status not in ('1', '01', '100')");
				}
			}

			if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
				if (invtHeadStatistics.isSubtotal()) {
					this.GROUP_BY("rollup(" + invtHeadStatistics.getGroupField() + "," 
						+ invtHeadStatistics.getGroupFieldTwo() +")");
				} else {
					this.GROUP_BY(invtHeadStatistics.getGroupField() + "," 
						+ invtHeadStatistics.getGroupFieldTwo());
				}
			} else {
				if (invtHeadStatistics.isSubtotal()) {
					this.GROUP_BY("rollup(" + invtHeadStatistics.getGroupField() + ")");
				} else {
					this.GROUP_BY(invtHeadStatistics.getGroupField());
				}
			}
			orderStringBuffer.append(invtHeadStatistics.getGroupField());
			if (!StringUtils.isEmpty(invtHeadStatistics.getGroupFieldTwo())) {
				orderStringBuffer.append("," + invtHeadStatistics.getGroupFieldTwo());
			}
			orderStringBuffer.append(", count(1) desc, sum(cil.total_price) desc");
			this.ORDER_BY(orderStringBuffer.toString()); 
		}}.toString();
	}
}
