package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.ServerSystem;
import online.zhaopei.myproject.mapper.ecssent.ServerSystemMapper;
import online.zhaopei.myproject.service.ecssent.ServerSystemService;

@Service
public class ServerSystemServiceImpl implements ServerSystemService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8257877433838834957L;

	@Autowired
	private ServerSystemMapper serverSystemMapper;
	
	@Override
	public List<ServerSystem> getServerSystemList(ServerSystem serverSystem) {
		return this.serverSystemMapper.getServerSystemList(serverSystem);
	}

	@Override
	public void insertServerSystem(ServerSystem serverSystem) {
		this.serverSystemMapper.insertServerSystem(serverSystem);
	}

	@Override
	public void updateServerSystem(ServerSystem serverSystem) {
		this.serverSystemMapper.updateServerSystem(serverSystem);
	}

	@Override
	public void deleteServerSystem(String ip) {
		this.serverSystemMapper.deleteServerSystem(ip);
	}

	@Override
	public ServerSystem getServerSystemByIp(String ip) {
		return this.serverSystemMapper.getServerSystemByIp(ip);
	}

}
