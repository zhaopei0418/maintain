package online.zhaopei.myproject.service.mhout;

import java.io.Serializable;

import online.zhaopei.myproject.domain.mysystem.ImportBill;

public interface ImportBillOutService extends Serializable {

	ImportBill statisticsBill(ImportBill importBill);
}
