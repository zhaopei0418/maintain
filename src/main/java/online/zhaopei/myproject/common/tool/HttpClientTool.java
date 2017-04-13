package online.zhaopei.myproject.common.tool;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Swap;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;

import online.zhaopei.myproject.domain.ecssent.Cpu;
import online.zhaopei.myproject.domain.ecssent.FileSystemInfo;
import online.zhaopei.myproject.domain.ecssent.NetInterfaceInfo;

public final class HttpClientTool {

	public static Mem getMemJson(String url) {
		return getJson(url + "memInfo", Mem.class);
	}
	
	public static Swap getSwapJson(String url) {
		return getJson(url + "swapInfo", Swap.class);
	}
	
	public static CpuPerc getCpuPercJson(String url) {
		return getJson(url + "cpuPerc", CpuPerc.class);
	}
	
	public static List<Cpu> getCpuListJson(String url) {
		return getJson(url + "cpuList", List.class);
	}
	
	public static OperatingSystem getOperatingSystemJson(String url) {
		return getJson(url + "osInfo", OperatingSystem.class);
	}
	
	public static List<FileSystemInfo> getFileSystemInfoListJson(String url) {
		Gson gson = new Gson();
		String result = get(url + "fileSystemList");
		if (!StringUtils.isEmpty(result)) {
			return Arrays.asList(gson.fromJson(result, FileSystemInfo[].class));
		} else {
			return null;
		}
	}
	
	public static List<NetInterfaceInfo> getNetInterfaceInfoListJson(String url) {
		Gson gson = new Gson();
		String result = get(url + "netInterfaceInfo");
		if (!StringUtils.isEmpty(result)) {
			return Arrays.asList(gson.fromJson(result, NetInterfaceInfo[].class));
		} else {
			return null;
		}
	}
	
	public static List<NetInterfaceInfo> getNetworkInterfaceInfoListJson(String url) {
		Gson gson = new Gson();
		String result = get(url + "networkInterfaceInfo");
		if (!StringUtils.isEmpty(result)) {
			return Arrays.asList(gson.fromJson(result, NetInterfaceInfo[].class));
		} else {
			return null;
		}
	}
	
	public static <T> T getJson(String url, Class<T> clazz) {
		Gson gson = new Gson();
		String result = get(url);
		if (!StringUtils.isEmpty(result)) {
			return gson.fromJson(result, clazz);
		} else {
			return null;
		}
	}
	
	public static String get(String url) {
		HttpClient client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		String result = null;
		InputStream inputStream = null;
		try {
			HttpResponse response  = client.execute(httpget);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				inputStream = entity.getContent();
				StringBuffer out = new StringBuffer();
				byte[] b = new byte[4096];
				for (int n; -1 != (n = inputStream.read(b));) {
					out.append(new String(b, 0, n));
				}
				result = out.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
