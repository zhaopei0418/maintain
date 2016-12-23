package online.zhaopei.myproject.mapper.mhin;

import java.io.Serializable;

import org.apache.ibatis.annotations.SelectProvider;

import online.zhaopei.myproject.domain.mysystem.ImportBill;
import online.zhaopei.myproject.sqlprovide.mysystem.ImportBillSqlProvide;

public interface ImportBillInMapper extends Serializable {

	@SelectProvider(type = ImportBillSqlProvide.class, method = "statisticsBillSql")
	ImportBill statisticsBill(ImportBill importBill);
}
