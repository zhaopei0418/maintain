package online.zhaopei.myproject.service.mhin;

import java.io.Serializable;

import online.zhaopei.myproject.domain.mysystem.ImportBill;

public interface ImportBillInService extends Serializable {

	ImportBill statisticsBill(ImportBill importBill);
}
