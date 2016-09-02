package online.zhaopei.myproject.service.gjent;

import java.io.Serializable;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;

public interface PersonalInfoService extends Serializable {

	PersonalInfo getPersonById(String id);
}
