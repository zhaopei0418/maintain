package online.zhaopei.myproject.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "maintain")
public class ApplicationProp implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3615984102709058640L;

	private String ciqDir;
	
	private String backDir;
	
	private String reissueTmpDir;

	private String reissueDir;

	private String reissueNoticeTmpDir;

	private String reissueNoticeDir;

	private String unifiedCiqDir;

	private String unifiedBackDir;

	public String getCiqDir() {
		return ciqDir;
	}

	public void setCiqDir(String ciqDir) {
		this.ciqDir = ciqDir;
	}

	public String getBackDir() {
		return backDir;
	}

	public void setBackDir(String backDir) {
		this.backDir = backDir;
	}

	public String getReissueTmpDir() {
		return reissueTmpDir;
	}

	public void setReissueTmpDir(String reissueTmpDir) {
		this.reissueTmpDir = reissueTmpDir;
	}

	public String getReissueDir() {
		return reissueDir;
	}

	public void setReissueDir(String reissueDir) {
		this.reissueDir = reissueDir;
	}

	public String getUnifiedCiqDir() {
		return unifiedCiqDir;
	}

	public void setUnifiedCiqDir(String unifiedCiqDir) {
		this.unifiedCiqDir = unifiedCiqDir;
	}

	public String getUnifiedBackDir() {
		return unifiedBackDir;
	}

	public void setUnifiedBackDir(String unifiedBackDir) {
		this.unifiedBackDir = unifiedBackDir;
	}

	public String getReissueNoticeTmpDir() {
		return reissueNoticeTmpDir;
	}

	public void setReissueNoticeTmpDir(String reissueNoticeTmpDir) {
		this.reissueNoticeTmpDir = reissueNoticeTmpDir;
	}

	public String getReissueNoticeDir() {
		return reissueNoticeDir;
	}

	public void setReissueNoticeDir(String reissueNoticeDir) {
		this.reissueNoticeDir = reissueNoticeDir;
	}
}
