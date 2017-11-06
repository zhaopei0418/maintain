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
	
	public String clearErrorCountAllSql() {
		return new SQL(){{
			this.UPDATE("personal_info");
			this.SET("error_count = 0");
			this.WHERE("is_check = 'N'");
			this.WHERE("error_count = 3");
		}}.toString();
	}

	public String statisticsPersonalInfoSql(final PersonalInfo personalInfo) {
		return new SQL() {{
			StringBuffer sBuffer = new StringBuffer("");
			this.SELECT("(case when pil11.group_one is null then ioh1.group_one else pil11.group_one end) group_one");
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				this.SELECT("(case when pil11.group_two is null then ioh1.group_two else pil11.group_two end) group_two");
			}
			this.SELECT("pil11.sum_request_num");
			this.SELECT("pil11.sum_response_num");
			this.SELECT("pil11.num personal_num");
			this.SELECT("ioh1.num order_num");
			sBuffer.append("(select decode(grouping(" + personalInfo.getGroupOne() + "), 1, '总计', " + personalInfo.getGroupOne() + ") group_one,");
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				sBuffer.append("decode(grouping(" + personalInfo.getGroupTwo() + "), 1, '小计', " + personalInfo.getGroupTwo() + ") group_two,");
			}
			sBuffer.append("sum(pil1.request_num) sum_request_num, sum(pil1.response_num) sum_response_num, count(1) num from ");
			sBuffer.append("(select (length(pil.request_msg) - length(replace(pil.request_msg, 'ROW FSD'))) / length('ROW FSD') request_num,");
			sBuffer.append("(length(pil.response_msg) - length(replace(pil.response_msg, 'ROW no'))) / length('ROW no') response_num, pil.sys_date from personal_info_log pil) pil1 where 1 = 1");
			if (!StringUtils.isEmpty(personalInfo.getBeginSysDate())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') >= '" + personalInfo.getBeginSysDate() + "'");
			}
			if (!StringUtils.isEmpty(personalInfo.getEndSysDate())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') <= '" + personalInfo.getEndSysDate() + "'");
			}
			if (!StringUtils.isEmpty(personalInfo.getSysDateStr())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') = '" + personalInfo.getSysDateStr() + "'");
			}
			sBuffer.append(" group by rollup(" + personalInfo.getGroupOne());
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
			    sBuffer.append("," + personalInfo.getGroupTwo());
			}
			sBuffer.append(")) pil11 full outer join ");
			sBuffer.append("(select decode(grouping(" + personalInfo.getGroupOne() + "), 1, '总计', " + personalInfo.getGroupOne() + ") group_one,");
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				sBuffer.append("decode(grouping(" + personalInfo.getGroupTwo() + "), 1, '小计', " + personalInfo.getGroupTwo() + ") group_two,");
			}
			sBuffer.append(" count(1) num from imp_ord_head pil1 where 1 = 1");
			if (!StringUtils.isEmpty(personalInfo.getBeginSysDate())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') >= '" + personalInfo.getBeginSysDate() + "'");
			}
			if (!StringUtils.isEmpty(personalInfo.getEndSysDate())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') <= '" + personalInfo.getEndSysDate() + "'");
			}
			if (!StringUtils.isEmpty(personalInfo.getSysDateStr())) {
				sBuffer.append(" and to_char(pil1.sys_date, 'yyyy-mm-dd') = '" + personalInfo.getSysDateStr() + "'");
			}
			sBuffer.append(" group by rollup(" + personalInfo.getGroupOne());
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				sBuffer.append("," + personalInfo.getGroupTwo());
			}
			sBuffer.append(")) ioh1 on ");
			sBuffer.append(" pil11.group_one = ioh1.group_one ");
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				sBuffer.append("and pil11.group_two = ioh1.group_two");
			}
			this.FROM(sBuffer.toString());
			if (!StringUtils.isEmpty(personalInfo.getGroupTwo())) {
				this.ORDER_BY("(case when pil11.group_one is null then ioh1.group_one else pil11.group_one end), (case when pil11.group_two is null then ioh1.group_two else pil11.group_two end)");
            } else {
				this.ORDER_BY("(case when pil11.group_one is null then ioh1.group_one else pil11.group_one end)");
			}
		}}.toString();
	}
}
