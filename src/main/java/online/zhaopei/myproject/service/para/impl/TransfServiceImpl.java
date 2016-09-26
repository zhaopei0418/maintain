package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.TransfMapper;
import online.zhaopei.myproject.service.para.TransfService;

@Service
public class TransfServiceImpl implements TransfService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2520566687668908112L;

	@Autowired
	private TransfMapper transfMapper;

	@Override
	public Para getTransfByCode(String transfCode) {
		return this.transfMapper.getTransfByCode(transfCode);
	}
}
