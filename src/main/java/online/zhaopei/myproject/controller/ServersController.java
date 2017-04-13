package online.zhaopei.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.common.tool.HttpClientTool;
import online.zhaopei.myproject.domain.ecssent.ServerInfo;
import online.zhaopei.myproject.domain.ecssent.ServerSystem;
import online.zhaopei.myproject.service.ecssent.ServerSystemService;

@Controller
@RequestMapping("/servers")
public class ServersController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6595599384169249092L;

	@Autowired
	private ServerSystemService serverSystemService;

	@RequestMapping
	public ModelAndView index(ServerSystem serverSystem) {
		PageInfo<ServerSystem> pageInfo = this.getPageInfo(serverSystem, ServerSystem.class, this.serverSystemService,
				"getServerSystemList");
		ModelAndView mv = this.buildBaseModelAndView("servers/list", pageInfo);
		mv.addObject("serverSystem", serverSystem);
		mv.addObject("serverSystemList", pageInfo.getList());
		return mv;
	}

	@RequestMapping("info/{ip}/{port}")
	public ModelAndView info(@PathVariable String ip, @PathVariable String port) {
		ModelAndView mv = new ModelAndView("servers/info");
		List<ServerSystem> serverSystemList = this.serverSystemService.getServerSystemList(new ServerSystem());
		ServerSystem ss = this.serverSystemService.getServerSystemByIp(ip);
		String httpPre = "http://";
		String url = null;
		ServerInfo serverInfo = null;
		try {
			url = httpPre + ip + ":" + port + "/";
			serverInfo = new ServerInfo();
			serverInfo.setServerSystem(ss);
			serverInfo.setMem(HttpClientTool.getMemJson(url));
			serverInfo.setSwap(HttpClientTool.getSwapJson(url));
			serverInfo.setCpuPerc(HttpClientTool.getCpuPercJson(url));
			serverInfo.setCpuList(HttpClientTool.getCpuListJson(url));
			serverInfo.setOperatingSystem(HttpClientTool.getOperatingSystemJson(url));
			serverInfo.setFileSystemInfoList(HttpClientTool.getFileSystemInfoListJson(url));
			serverInfo.setNetInterfaceInfoList(HttpClientTool.getNetInterfaceInfoListJson(url));
			if (null == serverInfo.getMem()) {
				serverInfo = null;
				throw new RuntimeException("调用" + url + "失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("serverInfo", serverInfo);
		mv.addObject("serverSystemList", serverSystemList);
		return mv;
	}

	@RequestMapping("info")
	public ModelAndView info() {
		ModelAndView mv = new ModelAndView("servers/index");
		List<ServerSystem> serverSystemList = this.serverSystemService.getServerSystemList(new ServerSystem());
		List<ServerInfo> serverInfoList = new ArrayList<ServerInfo>();
		String httpPre = "http://";
		String url = null;
		ServerInfo serverInfo = null;
		if (null != serverSystemList && !serverSystemList.isEmpty()) {
			for (ServerSystem ss : serverSystemList) {
				try {
					url = httpPre + ss.getIp() + ":" + ss.getPort() + "/";
					serverInfo = new ServerInfo();
					serverInfo.setServerSystem(ss);
					serverInfo.setMem(HttpClientTool.getMemJson(url));
					serverInfo.setSwap(HttpClientTool.getSwapJson(url));
					serverInfo.setCpuPerc(HttpClientTool.getCpuPercJson(url));
					serverInfo.setCpuList(HttpClientTool.getCpuListJson(url));
					serverInfo.setOperatingSystem(HttpClientTool.getOperatingSystemJson(url));
					serverInfo.setFileSystemInfoList(HttpClientTool.getFileSystemInfoListJson(url));
					serverInfo.setNetInterfaceInfoList(HttpClientTool.getNetInterfaceInfoListJson(url));
					if (null == serverInfo.getMem()) {
						throw new RuntimeException("调用" + url + "失败!");
					} else {
						serverInfoList.add(serverInfo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		mv.addObject("serverInfoList", serverInfoList);
		mv.addObject("serverSystemList", serverSystemList);
		return mv;
	}
}
