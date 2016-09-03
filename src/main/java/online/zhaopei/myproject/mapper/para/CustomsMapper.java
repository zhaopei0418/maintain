package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Customs;
import online.zhaopei.myproject.sqlprovide.para.CustomsSqlProvide;

public interface CustomsMapper extends Serializable {

	@Results(id = "customsResult", value = {
		@Result(property = "customsCode", column = "customs_code", id = true),
		@Result(property = "customsName", column = "customs_name"),
		@Result(property = "abbrCust", column = "abbr_cust")
	})
	@SelectProvider(type = CustomsSqlProvide.class, method = "getCustomsByCodeSql")
	Customs getCustomsByCode(@Param("customsCode") String customsCode);
}
