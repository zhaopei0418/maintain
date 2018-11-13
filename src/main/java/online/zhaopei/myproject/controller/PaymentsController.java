package online.zhaopei.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.PayHead;
import online.zhaopei.myproject.service.ecssent.PayHeadService;
import online.zhaopei.myproject.service.gjent.ImpPayHeadService;
import online.zhaopei.myproject.service.gjpayment.PaymentMessageService;
import online.zhaopei.myproject.service.para.SyncPaymentInfoService;

import java.util.Calendar;

@Controller
@RequestMapping("/payments")
public class PaymentsController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1247933637170790663L;

	@Autowired
	private PayHeadService payHeadService;
	
	@Autowired
	private ImpPayHeadService impPayHeadService;
	
	@Autowired
	private PaymentMessageService paymentMessageService;
	
	@Autowired
	private SyncPaymentInfoService syncPaymentInfoService;
	
	@GetMapping("/syncPaymentInfo")
	@ResponseBody
	public String syncPaymentInfo() {
		
		this.syncPaymentInfoService.updateSyncTime(2L);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		PaymentMessage paymentMessage = new PaymentMessage();
//		ImpPayHead impPayHead = null;
//		paymentMessage.setBeginCreateDate(sdf.format(Calendar.getInstance().getTime()) + "000000");
//		paymentMessage.setXmlContent("<BILLMODE>0</BILLMODE>");
//		
//		List<PaymentMessage> paymentMessageList = this.paymentMessageService.getPaymentMessageList(paymentMessage);
//		
//		if (null != paymentMessageList && !paymentMessageList.isEmpty()) {
//			for (PaymentMessage pm : paymentMessageList) {
//				impPayHead = PaymentTool.buildImpPayHeadByCbecMessage(PaymentTool.buildCbecMessageByString(pm.getXmlContent(), pm.getCreatedDate()));
//				
//				if (null != impPayHead) {
//					this.impPayHeadService.insertPayHead(impPayHead);
//				}
//			}
//		}
//		
		return String.valueOf(this.syncPaymentInfoService.getSyncTime());
//		return "success";
	}
	
	@RequestMapping
	public ModelAndView index(PayHead payHead) {
		Calendar calendar = null;
		if (StringUtils.isEmpty(payHead.getBeginSysDate())) {
			calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			payHead.setBeginSysDate(CommonConstant.DATE_FORMAT.format(calendar.getTime()));
		}

		if (StringUtils.isEmpty(payHead.getEndSysDate())) {
			calendar = Calendar.getInstance();
			payHead.setEndSysDate(CommonConstant.DATE_FORMAT.format(calendar.getTime()));
		}

		PageInfo<PayHead> pageInfo = this.getPageInfo(payHead, PayHead.class, this.payHeadService, "getPayHeadList");
		ModelAndView mv = this.buildBaseModelAndView("payments/list", pageInfo);
		mv.addObject("payHead", payHead);
		mv.addObject("payHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		mv.addObject("appType", CommonConstant.getAPP_TYPE_MAP());
		mv.addObject("appStatusJson", new Gson().toJson(DeliveryHeadConstant.getAPP_STATUS_MAP()));
		return mv;
	}
}
