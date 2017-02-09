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
import online.zhaopei.myproject.domain.ecssent.TaxHead;
import online.zhaopei.myproject.service.ecssent.TaxHeadService;
import online.zhaopei.myproject.service.para.CustomsService;

@Controller
@RequestMapping("/taxes")
public class TaxesController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1134904697664104711L;

	@Autowired
	private TaxHeadService taxHeadService;
	
	@Autowired
	private CustomsService customsService;
	
	@RequestMapping("export")
	public ResponseEntity<byte[]> export(TaxHead taxHead) throws IOException {
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = "tax_" + sdfFileName.format(Calendar.getInstance().getTime()) + ".csv";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		File file = new File("export/" + fileName);
		PrintWriter writer = null;
		OutputStream output = null;
		List<TaxHead> taxHeadList = this.taxHeadService.getTaxHeadList(taxHead);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			output = new FileOutputStream(file);
			output.write(CommonConstant.BOM);
			output.close();
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")));
			writer.println("税单号,清单号,缴款书编号,证件号码,担保企业代码,电商企业代码,物流企业代码,报关企业代码,税款总额,关税,增值税,消费税,所属关区,入库日期");
			for(TaxHead th : taxHeadList) {
				writer.print(th.getTaxNo());
				writer.print("," + th.getInvtNo());
				writer.print("," + th.getEntDutyNo());
				writer.print("," + th.getIdNumber());
				writer.print("," + th.getAssureCode());
				writer.print("," + th.getEbcCode());
				writer.print("," + th.getLogisticsCode());
				writer.print("," + th.getAgentCode());
				writer.print("," + th.getTaxTotal());
				writer.print("," + th.getCustomsTax());
				writer.print("," + th.getValueAddedTax());
				writer.print("," + th.getConsumptionTax());
				writer.print("," + ParaTool.getCustomsDesc(th.getCustomsCode(), this.customsService));
				writer.print("," + sdf.format(th.getSysDate()));
				writer.println();
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			output.close();
			writer.close();
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(this.getClass().getResource(""));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping
	public ModelAndView index(TaxHead taxHead) {
		PageInfo<TaxHead> pageInfo = this.getPageInfo(taxHead, TaxHead.class, this.taxHeadService, "getTaxHeadList");
		ModelAndView mv = this.buildBaseModelAndView("taxes/list", pageInfo);
		mv.addObject("taxHead", taxHead);
		mv.addObject("taxHeadList", pageInfo.getList());
		mv.addObject("customsCodeMap", CommonConstant.getZBXC_CUSTOMS_MAP());
		return mv;
	}
}
