package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.WrapSqlProvide;

public interface WrapMapper extends Serializable {

	@Results(id = "countryResult", value = {
		@Result(property = "code", column = "wrap_code", id = true),
		@Result(property = "name", column = "wrap_name")
	})
	@SelectProvider(type = WrapSqlProvide.class, method = "getWrapByCodeSql")
	Para getWrapByCode(String wrapCode);
}
