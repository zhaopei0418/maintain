package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.Version;
import online.zhaopei.myproject.mapper.ecssent.VersionMapper;
import online.zhaopei.myproject.service.ecssent.VersionService;

@Service
public class VersionServiceImpl implements VersionService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7482116690283604295L;

	@Autowired
	private VersionMapper versionMapper;
	
	@Override
	public List<Version> getVersionList(Version version) {
		return this.versionMapper.getVersionList(version);
	}

	@Override
	public void insertVersion(Version version) {
		this.versionMapper.insertVersion(version);
	}

	@Override
	public Version getVersionByCode(String code) {
		return this.versionMapper.getVersionByCode(code);
	}

	@Override
	public void updateVersion(Version version) {
		this.versionMapper.updateVersion(version);
	}

}
