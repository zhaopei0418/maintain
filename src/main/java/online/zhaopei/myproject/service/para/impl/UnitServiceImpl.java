package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.service.para.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7926089970219585153L;

	@Autowired
	private UnitService unitService;

	@Override
	public Para getUnitByCode(String unitCode) {
		return this.unitService.getUnitByCode(unitCode);
	}

}
