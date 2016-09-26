package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.CountrySqlProvide;

public interface CountryMapper extends Serializable {

	@Results(id = "countryResult", value = {
		@Result(property = "code", column = "country_code", id = true),
		@Result(property = "name", column = "coun_c_name")
	})
	@SelectProvider(type = CountrySqlProvide.class, method = "getCountryByCodeSql")
	Para getCountryByCode(String code);
}
