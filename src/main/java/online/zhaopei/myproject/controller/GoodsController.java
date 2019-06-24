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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.GoodConstant;
import online.zhaopei.myproject.domain.AuthUser;
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
		AuthUser currUser = BaseController.getCurrUser();
		
		if (!StringUtils.isEmpty(currUser.getMember().getCompanyCode())) {
			if (null == good) {
				good = new Good();
			}
			good.setApplyCode(currUser.getMember().getCompanyCode());
		}
		
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
			writer.println("电商企业,报关企业,商品货号,上架品名,申报品名,规格型号,备案商品编号,行邮税号,价格(元),单位,HS编码,原产国,状态,入库日期");
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

	@RequestMapping("exportExcel")
	public ResponseEntity<byte[]> exportExcel(Good good) throws IOException {
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String prefix = "goods";
		String fileName = prefix + sdfFileName.format(Calendar.getInstance().getTime()) + ".xls";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		File file = new File("export/" + fileName);
		OutputStream output = null;
		AuthUser currUser = BaseController.getCurrUser();
		if (!StringUtils.isEmpty(currUser.getMember().getCompanyCode())) {
			if (null == good) {
				good = new Good();
			}
			good.setApplyCode(currUser.getMember().getCompanyCode());
		}
		List<Good> goodList = this.goodService.getGoodList(good);
		Workbook wb = new HSSFWorkbook();
		int sheetCount = 0;
		Sheet sheet = null;
		Row row = null;
		Good generateGood = null;
		int minLength = 0;

		try {
			output = new FileOutputStream(file);

			if(null != goodList && !goodList.isEmpty()) {
				sheetCount = goodList.size() % CommonConstant.XLS_MAX_LINE == 0 ? goodList.size() / CommonConstant.XLS_MAX_LINE :
						(goodList.size() / CommonConstant.XLS_MAX_LINE + 1);
				for(int i = 0; i < sheetCount; i++) {
					sheet = wb.createSheet(prefix + i);
					minLength = goodList.size() >= (i + 1) * CommonConstant.XLS_MAX_LINE ? CommonConstant.XLS_MAX_LINE :
							goodList.size() - i * CommonConstant.XLS_MAX_LINE;
					row = sheet.createRow(0);
					row.createCell(0).setCellValue("电商企业");
					row.createCell(1).setCellValue("报关企业");
					row.createCell(2).setCellValue("商品货号");
					row.createCell(3).setCellValue("上架品名");
					row.createCell(4).setCellValue("申报品名");
					row.createCell(5).setCellValue("规格型号");
					row.createCell(6).setCellValue("备案商品编号");
					row.createCell(7).setCellValue("商品描述");
					row.createCell(8).setCellValue("价格（元）");
					row.createCell(9).setCellValue("单位");
					row.createCell(10).setCellValue("HS编码");
					row.createCell(11).setCellValue("原产国");
					row.createCell(12).setCellValue("状态");
					row.createCell(13).setCellValue("入库日期");
					for(int j = 0; j < minLength; j++) {
						generateGood = goodList.get(i * CommonConstant.XLS_MAX_LINE + j);
						row = sheet.createRow(j + 1);
						row.createCell(0).setCellValue(generateGood.getCbeName());
						row.createCell(1).setCellValue(generateGood.getApplyName());
						row.createCell(2).setCellValue(generateGood.getGoodsNo());
						row.createCell(3).setCellValue(generateGood.getShelfGoodsName());
						row.createCell(4).setCellValue(generateGood.getGoodsName());
						row.createCell(5).setCellValue(generateGood.getGoodsModel());
						row.createCell(6).setCellValue(generateGood.getItemNo());
						row.createCell(7).setCellValue(generateGood.getDescribe());
						row.createCell(8).setCellValue(generateGood.getPriceRmb());
						row.createCell(9).setCellValue(ParaTool.getUnitDesc(generateGood.getUnit(), this.unitService));
						row.createCell(10).setCellValue(generateGood.getCodeTs());
						row.createCell(11).setCellValue(ParaTool.getCountryDesc(generateGood.getCountry(), this.countryService));
						row.createCell(12).setCellValue(GoodConstant.getSTATUS().get(generateGood.getStatus()));
						row.createCell(13).setCellValue((null == generateGood.getDecTime() ? "" :
								CommonConstant.DATE_TIME_FORMAT.format(generateGood.getDecTime())));
					}
				}
			}

			wb.write(output);
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			output.close();
		}
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
