package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
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
	
	@SelectProvider(type = CountrySqlProvide.class, method = "getCountriesSql")
	List<Map<String, String>> getCountries();
	
	@ResultType(Long.class)
	@SelectProvider(type = CountrySqlProvide.class, method = "countCountriesSql")
	Long countCountries();
}
