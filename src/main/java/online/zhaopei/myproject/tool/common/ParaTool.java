package online.zhaopei.myproject.tool.common;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.service.para.CustomsService;
import online.zhaopei.myproject.service.para.TradeService;

public class ParaTool implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6915465654456254940L;

	public String getTradeModeDesc(String tradeMode, TradeService tradeService) {
		String result = "";
		Para para = null;
		if (null == CommonConstant.getTRADE_MODE_MAP().get(tradeMode)) {
			para = tradeService.getTradeByCode(tradeMode);
			if (null != para) {
				result = para.getName();
			}
		}
		return result;
	}

	public String getCustomsDesc(String customsCode, CustomsService customsService) {
		String result = "";
		Para para = null;
		if (null == CommonConstant.getCUSTOMS_MAP().get(customsCode)) {
			para = customsService.getCustomsByCode(customsCode);
			if (null != para) {
				result = para.getName();
			}
		}
		return result;
	}
}
