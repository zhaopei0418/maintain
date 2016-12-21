package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;


public class OrderListSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1112311194082242440L;

	public String countOrderListSql(final String headGuid) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("ceb2_ord_list");
			
			if (!StringUtils.isEmpty(headGuid)) {
				OracleTool.where(this, "head_guid", headGuid);
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getOrderListByHeadGuidSql(final String headGuid) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("g_num");
			this.SELECT("item_no");
			this.SELECT("item_name");
			this.SELECT("item_describe");
			this.SELECT("bar_code");
			this.SELECT("unit");
			this.SELECT("qty");
			this.SELECT("price");
			this.SELECT("total_price");
			this.SELECT("currency");
			this.SELECT("country");
			this.SELECT("note");
			this.SELECT("sys_date");
			this.FROM("ceb2_ord_list");
			
			if (!StringUtils.isEmpty(headGuid)) {
				OracleTool.where(this, "head_guid", headGuid);
			} else {
				this.WHERE("1 = 2");
			}
		}}.toString();
	}
	
	public String getOrderListBySearchTextSql(final String headGuid, final String searchText) {
		return new SQL() {{
			this.SELECT("head_guid");
			this.SELECT("g_num");
			this.SELECT("item_no");
			this.SELECT("item_name");
			this.SELECT("item_describe");
			this.SELECT("bar_code");
			this.SELECT("unit");
			this.SELECT("qty");
			this.SELECT("price");
			this.SELECT("total_price");
			this.SELECT("currency");
			this.SELECT("country");
			this.SELECT("note");
			this.SELECT("sys_date");
			
			this.FROM("ceb2_ord_list");
			
			if (!StringUtils.isEmpty(headGuid)) {
				OracleTool.where(this, "head_guid", headGuid);
			} else {
				this.WHERE("1 = 2");
			}
			
			if (!StringUtils.isEmpty(searchText)) {
				String orSql = "(unit like '%" + searchText + "%'";
				orSql += " OR g_name like '%" + searchText + "%'";
				orSql += " OR g_code like '%" + searchText + "%'";
				orSql += " OR item_no like '%" + searchText + "%'";
				orSql += " OR qty like '%" + searchText + "%'";
				orSql += " OR price = '" + searchText + "'";
				orSql += " OR total_price = '" + searchText + "'";
				orSql += " OR country like '%" + searchText + "%'";
				orSql += " OR currency like '%" + searchText + "%')";
				this.WHERE(orSql);
			}
			
		}}.toString();
	}
}
