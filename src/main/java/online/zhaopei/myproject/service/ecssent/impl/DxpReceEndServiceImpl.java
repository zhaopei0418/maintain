package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DxpReceEnd;
import online.zhaopei.myproject.mapper.ecssent.DxpReceEndMapper;
import online.zhaopei.myproject.service.ecssent.DxpReceEndService;

@Service
public class DxpReceEndServiceImpl implements DxpReceEndService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4330767848600036523L;
	
	@Autowired
	private DxpReceEndMapper expReceEndMapper;

	@Override
	public List<DxpReceEnd> getDxpReceEndList(DxpReceEnd dxpReceEnd) {
		return this.expReceEndMapper.getDxpReceEndList(dxpReceEnd);
	}

}
