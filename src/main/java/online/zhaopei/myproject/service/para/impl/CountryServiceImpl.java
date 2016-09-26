package online.zhaopei.myproject.service.para.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.para.Para;
import online.zhaopei.myproject.mapper.para.CountryMapper;
import online.zhaopei.myproject.service.para.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2730613734084382554L;

	@Autowired
	private CountryMapper countryMapper;

	@Override
	public Para getCountryByCode(String code) {
		return this.countryMapper.getCountryByCode(code);
	}

}
