package online.zhaopei.myproject.mapper.ecssent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadStatisticsSqlProvide;

public interface InvtHeadStatisticsMapper extends Serializable {

	@Results({
		@Result(property = "name", column = "name"),
		@Result(property = "quantity", column = "quantity"),
		@Result(property = "goodsValue", column = "goods_value")
	})
	@SelectProvider(type = InvtHeadStatisticsSqlProvide.class, method = "statisticsInvtHeadQuantitySql")
	List<InvtHeadStatistics> statisticsInvtHeadQuantity(InvtHeadStatistics invtHeadStatistics);
}
