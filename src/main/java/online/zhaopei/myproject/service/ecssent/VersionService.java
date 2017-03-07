package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.Version;

public interface VersionService extends Serializable {

	List<Version> getVersionList(Version version);
	
	void insertVersion(Version version);
	
	Version getVersionByCode(String code);
	
	void updateVersion(Version version);
}
