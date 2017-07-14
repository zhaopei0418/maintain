package online.zhaopei.myproject.sqlprovide.gjent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.gjent.PersonalInfo;

public class PersonalInfoSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8269148158645035995L;

	public String getPersonByIdSql() {
		return new SQL() {{
			this.SELECT("uuid, pername, certid");
			this.FROM("personal_info");
			this.WHERE("certid = #{id}");
		}}.toString();
	}
	
	public String getPersonalInfoListSql(final PersonalInfo personalInfo) {
		return new SQL() {{
			this.SELECT("uuid");
			this.SELECT("pername");
			this.SELECT("certid");
			this.SELECT("status");
			this.SELECT("checkmark");
			this.SELECT("checkflag");
			this.SELECT("perphone");
			this.SELECT("error_count");
			this.SELECT("sys_date");
			this.FROM("personal_info");
			
			if (!StringUtils.isEmpty(personalInfo.getSearchText())) {
				this.WHERE("pername like '%" + personalInfo.getSearchText() + "%'");
				this.OR().WHERE("certid like '%" + personalInfo.getSearchText() + "%'");
				this.OR().WHERE("perphone like '%" + personalInfo.getSearchText() + "%'");
				this.OR().WHERE("checkflag like '%" + personalInfo.getSearchText() + "%'");
				this.OR().WHERE("checkmark like '%" + personalInfo.getSearchText() + "%'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getUuid())) {
				this.WHERE("uuid = '" + personalInfo.getUuid() + "'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getPerName())) {
				this.WHERE("pername like '%" + personalInfo.getPerName() + "%'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getCertId())) {
				this.WHERE("certid like '%" + personalInfo.getCertId() + "%'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getStatus())) {
				this.WHERE("status = '" + personalInfo.getStatus() + "'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getPerPhone())) {
				this.WHERE("perphone = '" + personalInfo.getPerPhone() + "'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getBeginSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') >= '" + personalInfo.getBeginSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getEndSysDate())) {
				this.WHERE("to_char(sys_date, 'yyyy-mm-dd') <= '" + personalInfo.getEndSysDate() + "'");
			}
			
			if (!StringUtils.isEmpty(personalInfo.getCheckFlag())) {
				this.WHERE("checkflag = '" + personalInfo.getCheckFlag() + "'");
			}
			OracleTool.where(this, "error_count", personalInfo.getErrorCount());
			
		}}.toString();
	}
	
	public String clearErrorCountSql(final String uuid) {
		return new SQL(){{
			this.UPDATE("personal_info");
			this.SET("error_count = 0");
			this.WHERE("uuid = '" + uuid + "'");
		}}.toString();
	}
}
