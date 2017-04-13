package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.ServerSystem;

public interface ServerSystemService extends Serializable {

	List<ServerSystem> getServerSystemList(ServerSystem serverSystem);
	
	ServerSystem getServerSystemByIp(String ip);
	
	void insertServerSystem(ServerSystem serverSystem);
	
	void updateServerSystem(ServerSystem serverSystem);
	
	void deleteServerSystem(String ip);
}
