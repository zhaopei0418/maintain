package online.zhaopei.myproject.service.gjent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;

public interface PersonalInfoService extends Serializable {

	PersonalInfo getPersonById(String id);
	
	List<PersonalInfo> getPersonalInfoList(PersonalInfo personalInfo);
	
	void clearErrorCount(String uuid);
	
	void clearErrorCount();

	List<PersonalInfo> statisticsPersonalInfo(PersonalInfo personalInfo);

	PersonalInfo getPersonalInfoByNameCertId(String name, String certId);
}
