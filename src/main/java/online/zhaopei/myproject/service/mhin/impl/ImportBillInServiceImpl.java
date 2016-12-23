package online.zhaopei.myproject.service.mhin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.mysystem.ImportBill;
import online.zhaopei.myproject.mapper.mhin.ImportBillInMapper;
import online.zhaopei.myproject.service.mhin.ImportBillInService;

@Service
public class ImportBillInServiceImpl implements ImportBillInService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6573169569711765432L;

	@Autowired
	private ImportBillInMapper importBillInMapper;
	
	@Override
	public ImportBill statisticsBill(ImportBill importBill) {
		return this.importBillInMapper.statisticsBill(importBill);
	}

}
