package online.zhaopei.myproject.service.para.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.common.tool.ArrayTool;
import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.UnitMapper;
import online.zhaopei.myproject.service.para.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7926089970219585153L;

	@Autowired
	private UnitMapper unitMapper;

	@Override
	public Para getUnitByCode(String unitCode) {
		return this.unitMapper.getUnitByCode(unitCode);
	}

	@Override
	public long countUnits() {
		return this.unitMapper.countUnits();
	}

	@Override
	public Map<String, String> getAllUnit() {
		return ArrayTool.mapFromListOfMap(this.unitMapper.getAllUnit(), "unit_code", "unit_name");
	}

}
