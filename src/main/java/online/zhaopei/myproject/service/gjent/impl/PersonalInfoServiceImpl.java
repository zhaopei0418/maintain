package online.zhaopei.myproject.service.gjent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.mapper.gjent.PersonalInfoMapper;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2479664822732948689L;

	@Autowired
	private PersonalInfoMapper personalInfoMapper;
	
	@Override
	public PersonalInfo getPersonById(String id) {
		return this.personalInfoMapper.getPersonById(id);
	}

	@Override
	public List<PersonalInfo> getPersonalInfoList(PersonalInfo personalInfo) {
		return this.personalInfoMapper.getPersonalInfoList(personalInfo);
	}

	@Override
	public void clearErrorCount(String uuid) {
		this.personalInfoMapper.clearErrorCount(uuid);
	}

	@Override
	public void clearErrorCount() {
		this.personalInfoMapper.clearErrorCountAll();
	}

	@Override
	public List<PersonalInfo> statisticsPersonalInfo(PersonalInfo personalInfo) {
		return this.personalInfoMapper.statisticsPersonalInfo(personalInfo);
	}

	@Override
	public PersonalInfo getPersonalInfoByNameCertId(String name, String certId) {
		return this.personalInfoMapper.getPersonalInfoByNameCertId(name, certId);
	}

}
