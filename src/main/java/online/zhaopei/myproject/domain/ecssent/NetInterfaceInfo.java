package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;

public class NetInterfaceInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5344226061502661338L;

	public NetInterfaceInfo() {
	}
	
	public NetInterfaceInfo(String name, NetInterfaceConfig netInterfaceConfig, NetInterfaceStat netInterfaceStat) {
		this.name = name;
		this.netInterfaceConfig = netInterfaceConfig;
		this.netInterfaceStat = netInterfaceStat;
	}
	
	private String name;
	
	private NetInterfaceConfig netInterfaceConfig;
	
	private NetInterfaceStat netInterfaceStat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NetInterfaceConfig getNetInterfaceConfig() {
		return netInterfaceConfig;
	}

	public void setNetInterfaceConfig(NetInterfaceConfig netInterfaceConfig) {
		this.netInterfaceConfig = netInterfaceConfig;
	}

	public NetInterfaceStat getNetInterfaceStat() {
		return netInterfaceStat;
	}

	public void setNetInterfaceStat(NetInterfaceStat netInterfaceStat) {
		this.netInterfaceStat = netInterfaceStat;
	}
}
