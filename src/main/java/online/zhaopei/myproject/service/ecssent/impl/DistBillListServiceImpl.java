package online.zhaopei.myproject.service.ecssent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.ecssent.DistBillList;
import online.zhaopei.myproject.mapper.ecssent.DistBillListMapper;
import online.zhaopei.myproject.service.ecssent.DistBillListService;

@Service
public class DistBillListServiceImpl implements DistBillListService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5857526691330220334L;

	@Autowired
	private DistBillListMapper distBillListMapper;
	
	@Override
	public List<DistBillList> getDistBillListList(String seqNo) {
		return this.distBillListMapper.getDistBillListList(seqNo);
	}

	@Override
	public List<DistBillList> getDistBillListListBySearchText(String seqNo, String searchText) {
		return this.distBillListMapper.getDistBillListListBySearchText(seqNo, searchText);
	}

	@Override
	public Long countDistBillList(String seqNo) {
		return this.distBillListMapper.countDistBillList(seqNo);
	}

	@Override
	public List<DistBillList> excludeInvts(String distNo, String companyCode) {
		return this.distBillListMapper.excludeInvts(distNo, companyCode);
	}

}
