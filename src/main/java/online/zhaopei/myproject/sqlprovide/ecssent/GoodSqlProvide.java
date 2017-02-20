package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.domain.ecssent.Good;

public class GoodSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2734765559004701414L;

	public String getGoodListSql(final Good good) {
		return new SQL() {{
			this.SELECT("*");
			
			StringBuffer goodsSql = new StringBuffer("");
			goodsSql.append("select cgh.seq_no");
			goodsSql.append(",cgh.cbe_code");
			goodsSql.append(",cgh.cbe_name");
			goodsSql.append(",cgh.apply_code");
			goodsSql.append(",cgh.apply_name");
			goodsSql.append(",cgl.list_no");
			goodsSql.append(",cgl.goods_no");
			goodsSql.append(",cgl.shelf_goods_name");
			goodsSql.append(",cgl.describe");
			goodsSql.append(",cgl.code_ts");
			goodsSql.append(",cgl.goods_name");
			goodsSql.append(",cgl.goods_model");
			goodsSql.append(",cgl.unit");
			goodsSql.append(",cgl.currency");
			goodsSql.append(",cgl.unit1");
			goodsSql.append(",cgl.unit2");
			goodsSql.append(",cgl.price");
			goodsSql.append(",cgl.price_rmb");
			goodsSql.append(",cgl.tax_code");
			goodsSql.append(",cgl.ecp_code");
			goodsSql.append(",cgl.ecp_name");
			goodsSql.append(",cgl.country");
			goodsSql.append(",cgl.image");
			goodsSql.append(",cgl.bar_code");
			goodsSql.append(",cgl.limitation_goods_code");
			goodsSql.append(",cgl.position_seq");
			goodsSql.append(",cgl.is_tax");
			goodsSql.append(",cgl.is_permit");
			goodsSql.append(",cgl.brands");
			goodsSql.append(",cgl.supervise_id");
			goodsSql.append(",cgl.item_no");
			goodsSql.append(",cgl.apply_user");
			goodsSql.append(",cgl.status");
			goodsSql.append(",cgl.approve_man");
			goodsSql.append(",cgl.approve_time");
			goodsSql.append(",cgl.approve_opinion");
			goodsSql.append(",cgl.dec_time");
			goodsSql.append(",cgl.update_time");
			goodsSql.append(",cgl.indb_time");
			goodsSql.append(",cgl.shelf_goods_name_foreign");
			goodsSql.append(",cgl.batch_numbers");
			goodsSql.append(",cgl.modify_mark");
			goodsSql.append(",cgl.is_simple");
			goodsSql.append(" from cur_goods_head cgh inner join cur_goods_list cgl on cgh.seq_no = cgl.seq_no");
			goodsSql.append(" where 1 = 1");
			
			if (!StringUtils.isEmpty(good.getCbeCode())) {
				goodsSql.append(" and cgh.cbe_code = '" + good.getCbeCode() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getCbeName())) {
				goodsSql.append(" and cgh.cbe_name like '%" + good.getCbeName() + "%'");
			}
			
			if (!StringUtils.isEmpty(good.getApplyCode())) {
				goodsSql.append(" and cgh.apply_code = '" + good.getApplyCode() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getApplyName())) {
				goodsSql.append(" and cgh.apply_name like '%" + good.getApplyName() + "%'");
			}
			
			if (!StringUtils.isEmpty(good.getGoodsNo())) {
				goodsSql.append(" and cgl.goods_no = '" + good.getGoodsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getShelfGoodsName())) {
				goodsSql.append(" and cgl.shelf_goods_name like '%" + good.getShelfGoodsName() + "%'");
			}
			
			goodsSql.append(" union all");
			goodsSql.append(" select pgh.seq_no");
			goodsSql.append(",pgh.cbe_code");
			goodsSql.append(",pgh.cbe_name");
			goodsSql.append(",pgh.apply_code");
			goodsSql.append(",pgh.apply_name");
			goodsSql.append(",pgl.list_no");
			goodsSql.append(",pgl.goods_no");
			goodsSql.append(",pgl.shelf_goods_name");
			goodsSql.append(",pgl.describe");
			goodsSql.append(",pgl.code_ts");
			goodsSql.append(",pgl.goods_name");
			goodsSql.append(",pgl.goods_model");
			goodsSql.append(",pgl.unit");
			goodsSql.append(",pgl.currency");
			goodsSql.append(",pgl.unit1");
			goodsSql.append(",pgl.unit2");
			goodsSql.append(",pgl.price");
			goodsSql.append(",pgl.price_rmb");
			goodsSql.append(",pgl.tax_code");
			goodsSql.append(",pgl.ecp_code");
			goodsSql.append(",pgl.ecp_name");
			goodsSql.append(",pgl.country");
			goodsSql.append(",pgl.image");
			goodsSql.append(",pgl.bar_code");
			goodsSql.append(",pgl.limitation_goods_code");
			goodsSql.append(",pgl.position_seq");
			goodsSql.append(",pgl.is_tax");
			goodsSql.append(",pgl.is_permit");
			goodsSql.append(",pgl.brands");
			goodsSql.append(",pgl.supervise_id");
			goodsSql.append(",pgl.item_no");
			goodsSql.append(",pgl.apply_user");
			goodsSql.append(",pgl.status");
			goodsSql.append(",pgl.approve_man");
			goodsSql.append(",pgl.approve_time");
			goodsSql.append(",pgl.approve_opinion");
			goodsSql.append(",pgl.dec_time");
			goodsSql.append(",pgl.update_time");
			goodsSql.append(",pgl.indb_time");
			goodsSql.append(",pgl.shelf_goods_name_foreign");
			goodsSql.append(",pgl.batch_numbers");
			goodsSql.append(",pgl.modify_mark");
			goodsSql.append(",pgl.is_simple");
			goodsSql.append(" from pre_goods_head pgh inner join pre_goods_list pgl on pgh.seq_no = pgl.seq_no");
			goodsSql.append(" where 1 = 1");
			
			if (!StringUtils.isEmpty(good.getCbeCode())) {
				goodsSql.append(" and pgh.cbe_code = '" + good.getCbeCode() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getCbeName())) {
				goodsSql.append(" and pgh.cbe_name like '%" + good.getCbeName() + "%'");
			}
			
			if (!StringUtils.isEmpty(good.getApplyCode())) {
				goodsSql.append(" and pgh.apply_code = '" + good.getApplyCode() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getApplyName())) {
				goodsSql.append(" and pgh.apply_name like '%" + good.getApplyName() + "%'");
			}
			
			if (!StringUtils.isEmpty(good.getGoodsNo())) {
				goodsSql.append(" and pgl.goods_no = '" + good.getGoodsNo() + "'");
			}
			
			if (!StringUtils.isEmpty(good.getShelfGoodsName())) {
				goodsSql.append(" and pgl.shelf_goods_name like '%" + good.getShelfGoodsName() + "%'");
			}
			
			this.FROM("(" + goodsSql.toString() + ")");
		}}.toString();
	}
}
