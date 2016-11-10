package online.zhaopei.myproject.service.para;

import java.io.Serializable;
import java.util.Map;

import online.zhaopei.myproject.domain.para.Para;

public interface CustomsService extends Serializable {

	Para getCustomsByCode(String customsCode);
	
	Map<String, String> getCustoms();
	
	Long countCustoms();
}
