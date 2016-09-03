package online.zhaopei.myproject.domain.gjent;

import online.zhaopei.myproject.domain.BaseDomain;

public class PersonalInfo extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8341912837423289472L;

	private String uuid;
	
	private String perName;
	
	private String certId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}
}
