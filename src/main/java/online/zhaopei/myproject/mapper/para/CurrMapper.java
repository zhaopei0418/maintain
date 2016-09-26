package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.CurrSqlProvide;

public interface CurrMapper extends Serializable {

	@Results(id = "countryResult", value = {
		@Result(property = "code", column = "curr_code", id = true),
		@Result(property = "name", column = "curr_name")
	})
	@SelectProvider(type = CurrSqlProvide.class, method = "getCurrByCodeSql")
	Para getCurrByCode(String code);
}
