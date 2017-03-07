package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.MD5Tool;
import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.Version;

public class VersionSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3723723860879348845L;

	public String getVersionByCodeSql(final String code) {
		return new SQL() {{
			this.SELECT("code");
			this.SELECT("name");
			this.SELECT("version_no");
			this.SELECT("base_system");
			this.SELECT("description");
			this.SELECT("send_time");
			this.SELECT("is_update_test");
			this.SELECT("update_test_time");
			this.SELECT("is_update_formal");
			this.SELECT("update_formal_time");
			this.SELECT("test_result");
			this.SELECT("test_time");
			this.SELECT("test_result_description");
			this.SELECT("is_patch");
			this.FROM("version");
			
			this.WHERE("code = '" + code + "'");
		}}.toString();
	}
	
	public String getVersionListSql(final Version version) {
		return new SQL() {{
			this.SELECT("code");
			this.SELECT("name");
			this.SELECT("version_no");
			this.SELECT("base_system");
			this.SELECT("description");
			this.SELECT("send_time");
			this.SELECT("is_update_test");
			this.SELECT("update_test_time");
			this.SELECT("is_update_formal");
			this.SELECT("update_formal_time");
			this.SELECT("test_result");
			this.SELECT("test_time");
			this.SELECT("test_result_description");
			this.SELECT("is_patch");
			this.FROM("version");
			
			OracleTool.where(this, "code", version.getCode());
			OracleTool.where(this, "name", version.getName(), true);
			OracleTool.where(this, "version_no", version.getVersionNo());
			OracleTool.where(this, "base_system", version.getBaseSystem());
			OracleTool.where(this, "description", version.getDescription(), true);
			OracleTool.where(this, "send_time", version.getBeginSendTime(), ">=");
			OracleTool.where(this, "send_time", version.getEndSendTime(), "<=");
			OracleTool.where(this, "send_time", version.getSendTimeStr(), "=");
			OracleTool.where(this, "is_update_test", version.getIsUpdateTest());
			OracleTool.where(this, "update_test_time", version.getBeginUpdateTestTime(), ">=");
			OracleTool.where(this, "update_test_time", version.getEndUpdateTestTime(), "<=");
			OracleTool.where(this, "update_test_time", version.getUpdateTestTimeStr(), "=");
			OracleTool.where(this, "is_update_formal", version.getIsUpdateFormal());
			OracleTool.where(this, "update_formal_time", version.getBeginUpdateFormalTime(), ">=");
			OracleTool.where(this, "update_formal_time", version.getEndUpdateFormalTime(), "<=");
			OracleTool.where(this, "update_formal_time", version.getUpdateFormalTimeStr(), "=");
			OracleTool.where(this, "test_result", version.getTestResult());
			OracleTool.where(this, "test_time", version.getBeginTestTime(), ">=");
			OracleTool.where(this, "test_time", version.getEndTestTime(), "<=");
			OracleTool.where(this, "test_time", version.getTestTimeStr(), "=");
			OracleTool.where(this, "is_patch", version.getIsPatch());
		}}.toString();
	}
	
	public String insertVersionSql(final Version version) {
		return new SQL() {{
			this.INSERT_INTO("version");
			
			OracleTool.values(this, "code", MD5Tool.MD5Encode(version.getName(), "UTF-8", false));
			OracleTool.values(this, "name", version.getName());
			OracleTool.values(this, "version_no", version.getVersionNo());
			OracleTool.values(this, "base_system", version.getBaseSystem());
			OracleTool.values(this, "description", version.getDescription());
			OracleTool.values(this, "send_time", version.getSendTime());
			OracleTool.values(this, "is_update_test", version.getIsUpdateTest());
			OracleTool.values(this, "update_test_time", version.getUpdateTestTime());
			OracleTool.values(this, "is_update_formal", version.getIsUpdateFormal());
			OracleTool.values(this, "update_formal_time", version.getUpdateFormalTime());
			OracleTool.values(this, "test_result", version.getTestResult());
			OracleTool.values(this, "test_time", version.getTestTime());
			OracleTool.values(this, "test_result_description", version.getTestResultDescription());
			OracleTool.values(this, "is_patch", version.getIsPatch());
		}}.toString();
	}
	
	public String updateVersionSql(final Version version) {
		return new SQL() {{
			this.UPDATE("version");
			
			OracleTool.set(this, "code", MD5Tool.MD5Encode(version.getName(), "UTF-8", false));
			OracleTool.set(this, "name", version.getName());
			OracleTool.set(this, "version_no", version.getVersionNo());
			OracleTool.set(this, "base_system", version.getBaseSystem());
			OracleTool.set(this, "description", version.getDescription());
			OracleTool.set(this, "send_time", version.getSendTime());
			OracleTool.set(this, "is_update_test", version.getIsUpdateTest());
			OracleTool.set(this, "update_test_time", version.getUpdateTestTime());
			OracleTool.set(this, "is_update_formal", version.getIsUpdateFormal());
			OracleTool.set(this, "update_formal_time", version.getUpdateFormalTime());
			OracleTool.set(this, "test_result", version.getTestResult());
			OracleTool.set(this, "test_time", version.getTestTime());
			OracleTool.set(this, "test_result_description", version.getTestResultDescription());
			OracleTool.set(this, "is_patch", version.getIsPatch());
			
			this.WHERE("code = '" + version.getCode() + "'");
		}}.toString();
	}
}
