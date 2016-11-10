package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.CustomsSqlProvide;

public interface CustomsMapper extends Serializable {

	@Results(id = "customsResult", value = {
		@Result(property = "code", column = "customs_code", id = true),
		@Result(property = "name", column = "abbr_cust")
	})
	@SelectProvider(type = CustomsSqlProvide.class, method = "getCustomsByCodeSql")
	Para getCustomsByCode(@Param("customsCode") String customsCode);
	
	@SelectProvider(type = CustomsSqlProvide.class, method = "getCustomsSql")
	List<Map<String, String>> getCustoms();
	
	@ResultType(Long.class)
	@SelectProvider(type = CustomsSqlProvide.class, method = "countCustomsSql")
	Long countCustoms();
}
