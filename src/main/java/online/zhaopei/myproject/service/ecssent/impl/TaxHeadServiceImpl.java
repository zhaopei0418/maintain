package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.TaxHead;
import online.zhaopei.myproject.mapper.ecssent.TaxHeadMapper;
import online.zhaopei.myproject.service.ecssent.TaxHeadService;

@Service
public class TaxHeadServiceImpl implements TaxHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -442490001543883419L;

	@Autowired
	private TaxHeadMapper taxHeadMapper;
	
	@Override
	public List<TaxHead> getTaxHeadList(TaxHead taxHead) {
		return this.taxHeadMapper.getTaxHeadList(taxHead);
	}

}
