package online.zhaopei.myproject.mapper.ecssent;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import online.zhaopei.myproject.domain.ecssent.Version;
import online.zhaopei.myproject.sqlprovide.ecssent.VersionSqlProvide;

public interface VersionMapper {

	@Results(id = "versionResult", value = {
		@Result(property = "versionNo", column = "version_no"),
		@Result(property = "baseSystem", column = "base_system"),
		@Result(property = "sendTime", column = "send_time"),
		@Result(property = "isUpdateTest", column = "is_update_test"),
		@Result(property = "updateTestTime", column = "update_test_time"),
		@Result(property = "isUpdateFormal", column = "is_update_formal"),
		@Result(property = "updateFormalTime", column = "update_formal_time"),
		@Result(property = "testResult", column = "test_result"),
		@Result(property = "testTime", column = "test_time"),
		@Result(property = "testResultDescription", column = "test_result_description"),
		@Result(property = "isPatch", column = "is_patch"),
	})
	@SelectProvider(type = VersionSqlProvide.class, method = "getVersionListSql")
	List<Version> getVersionList(Version version);
	
	@InsertProvider(type = VersionSqlProvide.class, method = "insertVersionSql")
	int insertVersion(Version version);
	
	@UpdateProvider(type = VersionSqlProvide.class, method = "updateVersionSql")
	int updateVersion(Version version);
	
	@ResultMap("versionResult")
	@SelectProvider(type = VersionSqlProvide.class, method = "getVersionByCodeSql")
	Version getVersionByCode(String code);
}
