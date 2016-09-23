package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.TradeMapper;
import online.zhaopei.myproject.service.para.TradeService;

@Service
public class TradeServiceImpl implements TradeService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1952909570455565108L;

	@Autowired
	private TradeMapper tradeMapper;

	@Override
	public Para getTradeByCode(String code) {
		return this.tradeMapper.getTradeByCode(code);
	}
}
