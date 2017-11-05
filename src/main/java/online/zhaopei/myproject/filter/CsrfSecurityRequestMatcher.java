package online.zhaopei.myproject.filter;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CsrfSecurityRequestMatcher implements RequestMatcher {
	
	private static Logger logger = Logger.getLogger(CsrfSecurityRequestMatcher.class);
	
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	public boolean matches(HttpServletRequest request) {
		if (execludeUrls != null && execludeUrls.size() > 0) {
			String servletPath = request.getRequestURI();
			for (String url : execludeUrls) {
				logger.info("path=" + servletPath + "是否包含(" + url + "):" + servletPath.contains(url));
				if (servletPath.contains(url)) {
					return false;
				}
			}
		}
		return !allowedMethods.matcher(request.getMethod()).matches();
	}

	/**
	 * 需要排除的url列表
	 */
	private List<String> execludeUrls;

	public List<String> getExecludeUrls() {
		return execludeUrls;
	}

	public void setExecludeUrls(List<String> execludeUrls) {
		this.execludeUrls = execludeUrls;
	}
}
