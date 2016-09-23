package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.TradeSqlProvide;

public interface TradeMapper extends Serializable {

	@Results(id = "tradeResult", value = {
		@Result(property = "code", column = "trade_mode", id = true),
		@Result(property = "name", column = "abbr_trade")
	})
	@SelectProvider(type = TradeSqlProvide.class, method = "getTradeByCodeSql")
	Para getTradeByCode(String code);
}
