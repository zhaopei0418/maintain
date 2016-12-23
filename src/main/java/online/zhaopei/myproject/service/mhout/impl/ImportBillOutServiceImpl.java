package online.zhaopei.myproject.service.mhout.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.mysystem.ImportBill;
import online.zhaopei.myproject.mapper.mhout.ImportBillOutMapper;
import online.zhaopei.myproject.service.mhout.ImportBillOutService;

@Service
public class ImportBillOutServiceImpl implements ImportBillOutService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4361491307361535022L;

	@Autowired
	private ImportBillOutMapper importBillOutMapper;
	
	@Override
	public ImportBill statisticsBill(ImportBill importBill) {
		return this.importBillOutMapper.statisticsBill(importBill);
	}

	
}
