package online.zhaopei.myproject.service.para;

import java.io.Serializable;
import java.util.Map;

import online.zhaopei.myproject.domain.para.Para;

public interface UnitService extends Serializable {

	Para getUnitByCode(String unitCode);
	
	long countUnits();
	
	Map<String, String> getAllUnit();
}
