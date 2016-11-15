package online.zhaopei.myproject.service.para;

import java.io.Serializable;
import java.util.Map;

import online.zhaopei.myproject.domain.para.Para;

public interface CountryService extends Serializable {

	Para getCountryByCode(String code);
	
	Map<String, String> getCountries();
	
	Long countCountries();
}
