package online.zhaopei.myproject.mapper.gjent;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.sqlprovide.gjent.PersonalInfoSqlProvide;

public interface PersonalInfoMapper extends Serializable {

	@Results(id = "personalInfoResult", value = {
		@Result(property = "uuid", column = "uuid", id = true),
		@Result(property = "perName", column = "pername"),
		@Result(property = "certId", column = "certid"),
	})
	@SelectProvider(type = PersonalInfoSqlProvide.class, method = "getPersonByIdSql")
	PersonalInfo getPersonById(@Param("id") String id);
}
