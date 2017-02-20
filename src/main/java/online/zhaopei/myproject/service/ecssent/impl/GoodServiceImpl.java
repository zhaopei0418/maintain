package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.Good;
import online.zhaopei.myproject.mapper.ecssent.GoodMapper;
import online.zhaopei.myproject.service.ecssent.GoodService;

@Service
public class GoodServiceImpl implements GoodService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6641146330316031680L;

	@Autowired
	private GoodMapper goodMapper;
	
	@Override
	public List<Good> getGoodList(Good good) {
		return this.goodMapper.getGoodList(good);
	}

}
