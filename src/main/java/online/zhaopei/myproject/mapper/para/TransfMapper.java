package online.zhaopei.myproject.mapper.para;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.sqlprovide.para.TransfSqlProvide;

public interface TransfMapper extends Serializable {

	@Results(id = "trafResult", value = {
		@Result(property = "code", column = "traf_code", id = true),
		@Result(property = "name", column = "traf_spec")
	})
	@SelectProvider(type = TransfSqlProvide.class, method = "getTransfByCodeSql")
	Para getTransfByCode(String transfCode);
}
