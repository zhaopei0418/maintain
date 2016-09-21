package online.zhaopei.myproject.controller;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.BaseDomain;

public class BaseController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5981385211055602164L;
	
	private <T extends BaseDomain> T initPageInfo(T baseDomain, Class<T> clzz) {
		T result = baseDomain;
		if (null == baseDomain) {
			try {
				result = clzz.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (null == result.getPageNum() || 0 > result.getPageNum()) {
			result.setPageNum(1);
		}
		
		if (null == result.getPageSize() || 0 >= result.getPageSize()) {
			result.setPageSize(Integer.valueOf(CommonConstant.DEFAULT_PAGE_ZIZE.toString()));;
		}
		
		return result;
	}
	
	private List<Integer> buildPageSizeList() {
		List<Integer> pageSizeList = new ArrayList<Integer>();
		
		for (int i = 0; i <= 10; i++) {
			if (0 == i) {
				pageSizeList.add(5);
			} else {
				pageSizeList.add(i * 10);
			}
		}
		
		return pageSizeList;
	}
	
	private List<Integer> buildPageList(PageInfo pageInfo) {
		List<Integer> pageList = new ArrayList<Integer>();
		
		if (3 >= pageInfo.getPageNum()) {
			for (int i = 1; i <= pageInfo.getPages() && i <= 5; i++) {
				pageList.add(i);
			}
		} else {
			if (2 < pageInfo.getPages() - pageInfo.getPageNum()) {
				pageList.add(pageInfo.getPageNum() - 2);
				pageList.add(pageInfo.getPageNum() - 1);
				pageList.add(pageInfo.getPageNum());
				pageList.add(pageInfo.getPageNum() + 1);
				pageList.add(pageInfo.getPageNum() + 2);
			} else {
				if (5 <= pageInfo.getPages()) {
					pageList.add(pageInfo.getPages() - 4);
					pageList.add(pageInfo.getPages() - 3);
					pageList.add(pageInfo.getPages() - 2);
					pageList.add(pageInfo.getPages() - 1);
					pageList.add(pageInfo.getPages());
				} else {
					pageList.add(1);
					pageList.add(2);
					pageList.add(3);
					pageList.add(4);
				}
			}
		}
		
		return pageList;
	}
	
	protected <T extends BaseDomain> PageInfo<T> getPageInfo(T baseDomain, Class<T> clzz, Object service, String queryMethodName) {
		PageInfo<T> pageInfo = null;
		baseDomain = this.initPageInfo(baseDomain, clzz);
		PageHelper.startPage(baseDomain.getPageNum(), baseDomain.getPageSize());
		List<T> baseDomainList = null;
		Method queryMethod = null;
		try {
			 queryMethod = service.getClass().getDeclaredMethod(queryMethodName, clzz);
			 baseDomainList = (List<T>) queryMethod.invoke(service, baseDomain);
			 pageInfo = new PageInfo<T>(baseDomainList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}
	
	protected ModelAndView buildBaseModelAndView (String viewName, PageInfo pageInfo) {
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("pageList", this.buildPageList(pageInfo));
		mv.addObject("pageSizeList", this.buildPageSizeList());
		return mv;
	}
}
