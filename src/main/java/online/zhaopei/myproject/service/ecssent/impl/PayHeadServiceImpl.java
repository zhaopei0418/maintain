package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.PayHead;
import online.zhaopei.myproject.mapper.ecssent.PayHeadMapper;
import online.zhaopei.myproject.service.ecssent.PayHeadService;

@Service
public class PayHeadServiceImpl implements PayHeadService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4027794531849148015L;

	@Autowired
	private PayHeadMapper payHeadMapper;
	
	@Override
	public List<PayHead> getPayHeadList(PayHead payHead) {
		return this.payHeadMapper.getPayHeadList(payHead);
	}

}
