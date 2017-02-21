package online.zhaopei.myproject.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.GoodConstant;
import online.zhaopei.myproject.domain.ecssent.Good;
import online.zhaopei.myproject.service.ecssent.GoodService;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.UnitService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2966447781818617131L;

	@Autowired
	private GoodService goodService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private UnitService unitService;
	
	@RequestMapping
	public ModelAndView index(Good good) {
		PageInfo<Good> pageInfo = this.getPageInfo(good, Good.class, this.goodService, "getGoodList");
		ModelAndView mv = this.buildBaseModelAndView("goods/list", pageInfo);
		mv.addObject("good", good);
		mv.addObject("goodList", pageInfo.getList());
		mv.addObject("status", GoodConstant.getSTATUS());
		mv.addObject("country", ParaTool.getAllCountries(countryService));
		mv.addObject("unit", ParaTool.getAllUnits(unitService));
		return mv;
	}
	
	@RequestMapping("export")
	public ResponseEntity<byte[]> export(Good good) throws IOException {
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = "goods_" + sdfFileName.format(Calendar.getInstance().getTime()) + ".csv";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		File file = new File("export/" + fileName);
		PrintWriter writer = null;
		OutputStream output = null;
		List<Good> goodList = this.goodService.getGoodList(good);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			output = new FileOutputStream(file);
			output.write(CommonConstant.BOM);
			output.close();
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")));
			writer.println("仓储企业,报关企业,商品货号,上架品名,申报品名,规格型号,备案商品编号,行邮税号,价格(元),单位,HS编码,原产国,状态,入库日期");
			for(Good g : goodList) {
				writer.print(g.getCbeName());
				writer.print("," + g.getApplyName());
				writer.print("," + g.getGoodsNo());
				writer.print(",\"" + g.getShelfGoodsName() + "\"");
				writer.print(",\"" + g.getGoodsName() + "\"");
				writer.print(",\"" + g.getGoodsModel() + "\"");
				writer.print("," + g.getItemNo());
				writer.print("," + g.getTaxCode());
				writer.print("," + g.getPriceRmb());
				writer.print("," + ParaTool.getUnitDesc(g.getUnit(), unitService));
				writer.print("," + g.getCodeTs());
				writer.print("," + ParaTool.getCountryDesc(g.getCountry(), countryService));
				writer.print("," + GoodConstant.getSTATUS().get(g.getStatus()));
				writer.print("," + (null == g.getDecTime() ? "" : sdf.format(g.getDecTime())));
				writer.println();
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			output.close();
			writer.close();
		}
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
