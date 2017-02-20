package online.zhaopei.myproject.mapper.ecssent;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.Good;
import online.zhaopei.myproject.sqlprovide.ecssent.GoodSqlProvide;

public interface GoodMapper {

	@Results(id = "goodResult", value = {
		@Result(property = "seqNo", column = "seq_no"),
		@Result(property = "cbeCode", column = "cbe_code"),
		@Result(property = "cbeName", column = "cbe_name"),
		@Result(property = "applyCode", column = "apply_code"),
		@Result(property = "applyName", column = "apply_name"),
		@Result(property = "listNo", column = "list_no"),
		@Result(property = "goodsNo", column = "goods_no"),
		@Result(property = "shelfGoodsName", column = "shelf_goods_name"),
		@Result(property = "describe", column = "describe"),
		@Result(property = "codeTs", column = "code_ts"),
		@Result(property = "goodsName", column = "goods_name"),
		@Result(property = "goodsModel", column = "goods_model"),
		@Result(property = "unit", column = "unit"),
		@Result(property = "currency", column = "currency"),
		@Result(property = "unit1", column = "unit1"),
		@Result(property = "unit2", column = "unit2"),
		@Result(property = "price", column = "price"),
		@Result(property = "priceRmb", column = "price_rmb"),
		@Result(property = "taxCode", column = "tax_code"),
		@Result(property = "ecpCode", column = "ecp_code"),
		@Result(property = "ecpName", column = "ecp_name"),
		@Result(property = "country", column = "country"),
		@Result(property = "image", column = "image"),
		@Result(property = "barCode", column = "bar_code"),
		@Result(property = "limitationGoodsCode", column = "limitation_goods_code"),
		@Result(property = "positionSeq", column = "position_seq"),
		@Result(property = "isTax", column = "is_tax"),
		@Result(property = "isPermit", column = "is_permit"),
		@Result(property = "brands", column = "brands"),
		@Result(property = "superviseId", column = "supervise_id"),
		@Result(property = "itemNo", column = "item_no"),
		@Result(property = "applyUser", column = "apply_user"),
		@Result(property = "status", column = "status"),
		@Result(property = "approveMan", column = "approve_man"),
		@Result(property = "approveTime", column = "approve_time"),
		@Result(property = "approveOpinion", column = "approve_opinion"),
		@Result(property = "decTime", column = "dec_time"),
		@Result(property = "updateTime", column = "update_time"),
		@Result(property = "indbTime", column = "indb_time"),
		@Result(property = "shelfGoodsNameForeign", column = "shelf_goods_name_foreign"),
		@Result(property = "approveType", column = "approve_type"),
		@Result(property = "batchNumbers", column = "batch_numbers"),
		@Result(property = "modifyMark", column = "modify_mark"),
		@Result(property = "isSimple", column = "is_simple"),
	})
	@SelectProvider(type = GoodSqlProvide.class, method = "getGoodListSql")
	List<Good> getGoodList(Good good);
}
