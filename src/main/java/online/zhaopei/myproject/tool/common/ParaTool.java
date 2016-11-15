package online.zhaopei.myproject.tool.common;

import java.io.Serializable;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.CurrService;
import online.zhaopei.myproject.service.para.CustomsService;
import online.zhaopei.myproject.service.para.TradeService;
import online.zhaopei.myproject.service.para.TransfService;
import online.zhaopei.myproject.service.para.UnitService;
import online.zhaopei.myproject.service.para.WrapService;

public class ParaTool implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6915465654456254940L;

	public static Map<String, String> getAllCustoms(CustomsService customsService) {
		Map<String, String> customsMap = null;
		Long count = customsService.countCustoms();
		
		if (count != CommonConstant.getCUSTOMS_MAP().size()) {
			customsMap = customsService.getCustoms();
			CommonConstant.getCURRENCY_MAP().clear();
			CommonConstant.getCUSTOMS_MAP().putAll(customsMap);
		}
		return CommonConstant.getCUSTOMS_MAP();
	}
	
	public static Map<String, String> getAllCountries(CountryService countryService) {
		Map<String, String> countriesMap = null;
		Long count = countryService.countCountries();
		
		if (count != CommonConstant.getCOUNTRY_MAP().size()) {
			countriesMap = countryService.getCountries();
			CommonConstant.getCOUNTRY_MAP().clear();
			CommonConstant.getCOUNTRY_MAP().putAll(countriesMap);
		}
		return CommonConstant.getCOUNTRY_MAP();
	}
	
	public static String getCountryDesc(String countryCode, CountryService countryService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getCOUNTRY_MAP().get(countryCode))) {
			para = countryService.getCountryByCode(countryCode);
			if (null != para) {
				CommonConstant.getCOUNTRY_MAP().put(countryCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getCOUNTRY_MAP().get(countryCode);
		}
		return result;
	}

	public static String getCurrDesc(String currCode, CurrService currService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getCURRENCY_MAP().get(currCode))) {
			para = currService.getCurrByCode(currCode);
			if (null != para) {
				CommonConstant.getCURRENCY_MAP().put(currCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getCURRENCY_MAP().get(currCode);
		}
		return result;
	}

	public static String getTradeModeDesc(String tradeMode, TradeService tradeService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getTRADE_MODE_MAP().get(tradeMode))) {
			para = tradeService.getTradeByCode(tradeMode);
			if (null != para) {
				CommonConstant.getTRADE_MODE_MAP().put(tradeMode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getTRADE_MODE_MAP().get(tradeMode);
		}
		return result;
	}

	public static String getCustomsDesc(String customsCode, CustomsService customsService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getCUSTOMS_MAP().get(customsCode))) {
			para = customsService.getCustomsByCode(customsCode);
			if (null != para) {
				CommonConstant.getCUSTOMS_MAP().put(customsCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getCUSTOMS_MAP().get(customsCode);
		}
		return result;
	}

	public static String getWrapDesc(String wrapCode, WrapService wrapService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getWRAP_TYPE_MAP().get(wrapCode))) {
			para = wrapService.getWrapByCode(wrapCode);
			if (null != para) {
				CommonConstant.getWRAP_TYPE_MAP().put(wrapCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getWRAP_TYPE_MAP().get(wrapCode);
		}
		return result;
	}

	public static String getUnitDesc(String unitCode, UnitService unitService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getUNIT_MAP().get(unitCode))) {
			para = unitService.getUnitByCode(unitCode);
			if (null != para) {
				CommonConstant.getUNIT_MAP().put(unitCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getUNIT_MAP().get(unitCode);
		}
		return result;
	}

	public static String getTransfDesc(String transfCode, TransfService transfService) {
		String result = "";
		Para para = null;
		if (StringUtils.isEmpty(CommonConstant.getTRAF_MODE_MAP().get(transfCode))) {
			para = transfService.getTransfByCode(transfCode);
			if (null != para) {
				CommonConstant.getTRAF_MODE_MAP().put(transfCode, para.getName());
				result = para.getName();
			}
		} else {
			result = CommonConstant.getTRAF_MODE_MAP().get(transfCode);
		}
		return result;
	}
}
