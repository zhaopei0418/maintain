package online.zhaopei.myproject.sqlprovide.mysystem;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.mysystem.ImportBill;

public class ImportBillSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4579225256219877374L;

	public String statisticsBillSql(final ImportBill importBill) {
		return new SQL() {{
			this.SELECT("count(1) as count");
			this.SELECT("sum(totalvaluermb) as totalValueRmb");
			this.FROM("tb_bondend_import_bill");
			
			this.WHERE("last_status <> 0");
			this.WHERE("last_status <> 3");
			OracleTool.where(this, "declaredate", importBill.getBeginDeclareDate(), ">=");
			OracleTool.where(this, "declaredate", importBill.getEndDeclareDate(), "<=");
			OracleTool.where(this, "declaredate", importBill.getDeclareDateStr(), "=");
		}}.toString();
	}
}
