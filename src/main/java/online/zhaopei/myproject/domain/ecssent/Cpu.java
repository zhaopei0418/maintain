package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.CpuInfo;

public class Cpu implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8060551474971269359L;
	
	public Cpu() {
		
	}
	
	public Cpu(CpuInfo cpuInfo, CpuPerc cpuPerc) {
		this.cpuInfo = cpuInfo;
		this.cpuPerc = cpuPerc;
	}
	
	private CpuInfo cpuInfo;
	
	private CpuPerc cpuPerc;

	public CpuInfo getCpuInfo() {
		return cpuInfo;
	}

	public void setCpuInfo(CpuInfo cpuInfo) {
		this.cpuInfo = cpuInfo;
	}

	public CpuPerc getCpuPerc() {
		return cpuPerc;
	}

	public void setCpuPerc(CpuPerc cpuPerc) {
		this.cpuPerc = cpuPerc;
	}
}
