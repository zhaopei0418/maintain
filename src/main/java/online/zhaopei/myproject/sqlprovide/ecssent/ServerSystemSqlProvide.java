package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.ServerSystem;

public class ServerSystemSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6215325673863055772L;

	
	public String getServerSystemListSql(final ServerSystem serverSystem) {
		return new SQL() {{
			this.SELECT("ip");
			this.SELECT("port");
			this.SELECT("description");
			this.FROM("server_system");
			
			OracleTool.where(this, "ip", serverSystem.getIp());
			OracleTool.where(this, "port", serverSystem.getPort());
			OracleTool.where(this, "description", serverSystem.getDescription(), true);
		}}.toString();
	}
	
	public String insertServerSystemSql(final ServerSystem serverSystem) {
		return new SQL() {{
			this.INSERT_INTO("server_system");
			
			OracleTool.values(this, "ip", serverSystem.getIp());
			OracleTool.values(this, "port", serverSystem.getPort());
			OracleTool.values(this, "description", serverSystem.getDescription());
		}}.toString();
	}
	
	public String updateServerSystemSql(final ServerSystem serverSystem) {
		return new SQL() {{
			this.UPDATE("server_system");
			
			OracleTool.set(this, "ip", serverSystem.getIp());
			OracleTool.set(this, "port", serverSystem.getPort());
			OracleTool.set(this, "description", serverSystem.getDescription());
			
			this.WHERE("ip = '" + serverSystem.getUpdateIp() + "'");
		}}.toString();
	}
	
	public String deleteServerSystemSql(final String ip) {
		return new SQL() {{
			this.DELETE_FROM("server_system");
			
			this.WHERE("ip = '" + ip + "'");
		}}.toString();
	}
}
