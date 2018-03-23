package online.zhaopei.myproject.mapper.ecssent;

import online.zhaopei.myproject.domain.ecssent.Store;
import online.zhaopei.myproject.sqlprovide.ecssent.StoreSqlProvide;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by zhaopei on 18/3/23.
 */
public interface StoreMapper {

    @Results(id = "storeResult", value = {
            @Result(property = "lmsNo", column = "lms_no"),
            @Result(property = "tradeCode", column = "trade_code"),
            @Result(property = "tradeName", column = "trade_name"),
            @Result(property = "itemNo", column = "item_no"),
            @Result(property = "codeTs", column = "code_ts"),
            @Result(property = "gName", column = "g_name"),
            @Result(property = "gModel", column = "g_model"),
            @Result(property = "tradeCountry", column = "trade_country"),
            @Result(property = "unit", column = "unit"),
            @Result(property = "declPrice", column = "decl_price"),
            @Result(property = "tradeCurr", column = "trade_curr"),
            @Result(property = "customsCode", column = "customs_code"),
            @Result(property = "legalIQty", column = "legal_i_qty"),
            @Result(property = "legalOQty", column = "legal_o_qty"),
            @Result(property = "legalRemainQty", column = "legal_remain_qty"),
            @Result(property = "periodStartQty", column = "period_start_qty")
    })
    @SelectProvider(type = StoreSqlProvide.class, method = "getStoreListSql")
    List<Store> getStoreList(Store store);
}
