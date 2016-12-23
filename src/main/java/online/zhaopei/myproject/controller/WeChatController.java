package online.zhaopei.myproject.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import online.zhaopei.myproject.common.tool.JAXBTool;
import online.zhaopei.myproject.common.tool.SHA1;
import online.zhaopei.myproject.constant.WeChatMsgType;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;
import online.zhaopei.myproject.domain.mysystem.ImportBill;
import online.zhaopei.myproject.domain.wechat.WeChatMessage;
import online.zhaopei.myproject.service.ecssent.InvtHeadService;
import online.zhaopei.myproject.service.ecssent.InvtHeadStatisticsService;
import online.zhaopei.myproject.service.mhin.ImportBillInService;
import online.zhaopei.myproject.service.mhout.ImportBillOutService;

@Controller
@RequestMapping("/wechat")
public class WeChatController implements Serializable {

	private String Token = "zhaopei";

	@Autowired
	private InvtHeadService invtHeadService;
	
	@Autowired
	private InvtHeadStatisticsService invtHeadStatisticsService;
	
	@Autowired
	private ImportBillInService importBillInService;
	
	@Autowired
	private ImportBillOutService importBillOutService;
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7493297819939212348L;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void accessWeChat(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入chat");
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			System.out.println("signature==[" + signature + "]");
			System.out.println("timestamp==[" + timestamp + "]");
			System.out.println("nonce==[" + nonce + "]");
			System.out.println("echostr==[" + echostr + "]");
			access(request, response);
		} else {
			// 进入POST聊天处理
			System.out.println("enter post");
			try {
				// 接收消息并返回消息
				acceptMessage(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 验证URL真实性
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	private String access(HttpServletRequest request, HttpServletResponse response) {
		// 验证URL真实性
		System.out.println("进入验证access");
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串
		List<String> params = new ArrayList<String>();
		params.add(Token);
		params.add(timestamp);
		params.add(nonce);
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
		if (temp.equals(signature)) {
			try {
				response.getWriter().write(echostr);
				System.out.println("成功返回 echostr：" + echostr);
				return echostr;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("失败 认证");
		return null;
	}

	private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 处理接收消息
		ServletInputStream in = request.getInputStream();
		WeChatMessage inputMsg = JAXBTool.getXmlObject(WeChatMessage.class, in);

		String serverName = inputMsg.getToUserName();// 服务端
		String custerName = inputMsg.getFromUserName();// 客户端
		long createTime = inputMsg.getCreateTime();// 接收时间
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

		// 取得消息类型
		String msgType = inputMsg.getMsgType();
		String result = null;
		// 根据消息类型获取对应的消息内容
		if (WeChatMsgType.TEXT.toString().equals(msgType)) {
			// 文本消息
			System.out.println("开发者微信号：" + inputMsg.getToUserName());
			System.out.println("发送方帐号：" + inputMsg.getFromUserName());
			System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
			System.out.println("消息内容：" + inputMsg.getContent());
			System.out.println("消息Id：" + inputMsg.getMsgId());

			StringBuffer buffer = new StringBuffer("");
			buffer.append("你可以输入下面数字或者菜单名称实现快捷查询\n");
			buffer.append("[0] 菜单: 可使用的菜单列表\n");
			buffer.append("[1] 今日清单: 查询当日清单数量及货值\n");
			buffer.append("[11] 昨日清单: 查询昨日清单数量及货值\n");
			buffer.append("[4612] 电子口岸数据: 统计电子口岸清单相关数据\n");
			buffer.append("[2] 清单前10: 查询清单数量排名前10的电商企业及数量\n");
			buffer.append("[3] 清单放行前10: 查询清单放行数量排名前10的电商企业及数量\n");
			buffer.append("[4] 电商清单数据: 以电商分组来统计电商的清单数，商品数，总货值，总税款，总增值税\n");
			buffer.append("[5] 物流清单数据: 以物流分组来统计电商的清单数，商品数，总货值，总税款，总增值税\n");
			buffer.append("[6] 报关行清单数据: 以报关行分组来统计电商的清单数，商品数，总货值，总税款，总增值税\n");
			
			WeChatMessage responseMsg = new WeChatMessage();
			responseMsg.setToUserName(custerName);
			responseMsg.setFromUserName(serverName);
			responseMsg.setCreateTime(returnTime);
			responseMsg.setMsgType(msgType);
			InvtHeadStatistics invtHeadStatistics = null;
			SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfYeday = new SimpleDateFormat("yyyy年MM月dd日");
			Calendar calendar = Calendar.getInstance();
			List<InvtHeadStatistics> ihsList = null;
			InvtHeadStatistics ihs = null, ihsYesterday = null;
			ImportBill searchBill = null, resultInBill = null, resultOutBill = null;
			ImportBill resultInBillYesterday = null, resultOutBillYesterday = null;
			if ("1".equals(inputMsg.getContent()) || "今日清单".equals(inputMsg.getContent())) {
				invtHeadStatistics =  new InvtHeadStatistics("to_char(cih.sys_date, 'yyyy-mm-dd')");
				invtHeadStatistics.setSysDateStr(sdfDay.format(calendar.getTime()));
				invtHeadStatistics.setSubtotal(false);
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				if (null != ihsList && !ihsList.isEmpty()) {
					ihs = ihsList.get(0);
				}
				responseMsg.setContent("今日清单总数是：[" + (null == ihs ? 0 : ihs.getQuantity()) + "]"
						+ "总货值是：[" + (null == ihs ? 0 : ihs.getGoodsValue()) + "]");
			} else if ("11".equals(inputMsg.getContent()) || "昨日清单".equals(inputMsg.getContent())) {
				invtHeadStatistics =  new InvtHeadStatistics("to_char(cih.sys_date, 'yyyy-mm-dd')");
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				invtHeadStatistics.setSysDateStr(sdfDay.format(calendar.getTime()));
				invtHeadStatistics.setSubtotal(false);
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				if (null != ihsList && !ihsList.isEmpty()) {
					ihsYesterday = ihsList.get(0);
				}
				responseMsg.setContent("昨日清单总数是：[" + (null == ihsYesterday ? 0 : ihsYesterday.getQuantity()) + "]"
						+ "总货值是：[" + (null == ihsYesterday ? 0 : ihsYesterday.getGoodsValue()) + "]");
			} else if ("4612".equals(inputMsg.getContent()) || "电子口岸数据".equals(inputMsg.getContent())) {
				invtHeadStatistics =  new InvtHeadStatistics("cih.statistics");
				searchBill = new ImportBill();
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				invtHeadStatistics.setEndSysDate(sdfDay.format(calendar.getTime()));
				searchBill.setEndDeclareDate(sdfDay.format(calendar.getTime()));
				invtHeadStatistics.setSubtotal(false);
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				resultInBill = this.importBillInService.statisticsBill(searchBill);
				resultOutBill = this.importBillOutService.statisticsBill(searchBill);
				if (null != ihsList && !ihsList.isEmpty()) {
					ihs = ihsList.get(0);
				}
				
				invtHeadStatistics.setSysDateStr(invtHeadStatistics.getEndSysDate());
				invtHeadStatistics.setEndSysDate(null);
				searchBill.setDeclareDateStr(searchBill.getEndDeclareDate());
				searchBill.setEndDeclareDate(null);
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				resultInBillYesterday = this.importBillInService.statisticsBill(searchBill);
				resultOutBillYesterday = this.importBillOutService.statisticsBill(searchBill);
				if (null != ihsList && !ihsList.isEmpty()) {
					ihsYesterday = ihsList.get(0);
				}
				
				StringBuffer contentBuffer = new StringBuffer("各位领导上午好\n");
				contentBuffer.append("进口统一版系统:");
				contentBuffer.append(sdfYeday.format(calendar.getTime()));
				contentBuffer.append("跨境电商企业申报清单" + (null == ihsYesterday ? 0 : ihsYesterday.getQuantity()) + "票,货值");
				contentBuffer.append((null == ihsYesterday ? 0.00 : ihsYesterday.getGoodsValue() / 10000) + "万元。");
				contentBuffer.append("截至目前申报清单" + (null == ihs ? 0 : ihs.getQuantity()) + "票，货值");
				contentBuffer.append((null == ihs ? 0.00 : ihs.getGoodsValue() / 10000) + "万元");
				
				contentBuffer.append("\n进口过渡版系统:");
				contentBuffer.append(sdfYeday.format(calendar.getTime()));
				contentBuffer.append("跨境电商企业申报清单" + (null == resultInBillYesterday ? 0 : resultInBillYesterday.getCount()) + "票,货值");
				contentBuffer.append((null == resultInBillYesterday.getTotalValueRmb() ? 0.00 : resultInBillYesterday.getTotalValueRmb() / 10000) + "万元。");
				contentBuffer.append("截至目前申报清单" + (null == resultInBill ? 0 : resultInBill.getCount()) + "票，货值");
				contentBuffer.append((null == resultInBill.getTotalValueRmb() ? 0.00 : resultInBill.getTotalValueRmb() / 10000) + "万元");
				
				contentBuffer.append("\n出口系统:");
				contentBuffer.append(sdfYeday.format(calendar.getTime()));
				contentBuffer.append("跨境电商企业申报清单" + (null == resultOutBillYesterday ? 0 : resultOutBillYesterday.getCount()) + "票,货值");
				contentBuffer.append((null == resultOutBillYesterday.getTotalValueRmb() ? 0.00 : resultOutBillYesterday.getTotalValueRmb() / 10000) + "万元。");
				contentBuffer.append("截至目前申报清单" + (null == resultOutBill ? 0 : resultOutBill.getCount()) + "票，货值");
				contentBuffer.append((null == resultOutBill.getTotalValueRmb() ? 0.00 : resultOutBill.getTotalValueRmb() / 10000) + "万元");
				
				responseMsg.setContent(contentBuffer.toString());
			} else if ("2".equals(inputMsg.getContent()) || "清单前10".equals(inputMsg.getContent())) {
				PageHelper.startPage(1, 10);
				List<InvtHead> invtHeadCountList = this.invtHeadService.getDeclareTopTenSql(new InvtHead());
				StringBuffer invtHeadBuffer = new StringBuffer("");
				for (int i = 0; i < invtHeadCountList.size(); i++) {
					InvtHead ih = invtHeadCountList.get(i);
					invtHeadBuffer.append((i + 1) + ". 电商[" + ih.getEbcName() + "] 数量：[" + ih.getCount() + "]\n");
				}
				responseMsg.setContent(invtHeadBuffer.toString());
			
			} else if ("3".equals(inputMsg.getContent()) || "清单放行前10".equals(inputMsg.getContent())) {
				PageHelper.startPage(1, 10);
				InvtHead invtHead = new InvtHead();
				invtHead.setAppStatus("800");
				List<InvtHead> invtHeadCountList = this.invtHeadService.getDeclareTopTenSql(invtHead);
				StringBuffer invtHeadBuffer = new StringBuffer("");
				for (int i = 0; i < invtHeadCountList.size(); i++) {
					InvtHead ih = invtHeadCountList.get(i);
					invtHeadBuffer.append((i + 1) + ". 电商[" + ih.getEbcName() + "] 数量：[" + ih.getCount() + "]\n");
				}
				responseMsg.setContent(invtHeadBuffer.toString());
			} else if ("4".equals(inputMsg.getContent()) || "电商清单数据".equals(inputMsg.getContent())) {
				invtHeadStatistics = new InvtHeadStatistics();
				invtHeadStatistics.setGroupField("cih.ebc_name");
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				buffer = new StringBuffer("");
				for (int i = 0; i < ihsList.size(); i++) {
					ihs = ihsList.get(i);
					buffer.append((i + 1) + ". 电商[" + ihs.getName() + "] 单量：[" + ihs.getQuantity()
					+ "] 商品数量: [" + ihs.getGoodsTotalQuantity() + "] 总货值：[" + ihs.getGoodsValue()
					+ "] 总税款: [" + ihs.getTaxTotal() + "] 总增值税: [" + ihs.getValueAddedTax() + "]\n");
				}
				responseMsg.setContent(buffer.toString());
			} else if ("5".equals(inputMsg.getContent()) || "物流清单数据".equals(inputMsg.getContent())) {
				invtHeadStatistics = new InvtHeadStatistics();
				invtHeadStatistics.setGroupField("cih.logistics_name");
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				buffer = new StringBuffer("");
				for (int i = 0; i < ihsList.size(); i++) {
					ihs = ihsList.get(i);
					buffer.append((i + 1) + ". 物流[" + ihs.getName() + "] 单量：[" + ihs.getQuantity()
					+ "] 商品数量: [" + ihs.getGoodsTotalQuantity() + "] 总货值：[" + ihs.getGoodsValue()
					+ "] 总税款: [" + ihs.getTaxTotal() + "] 总增值税: [" + ihs.getValueAddedTax() + "]\n");
				}
				responseMsg.setContent(buffer.toString());
			} else if ("6".equals(inputMsg.getContent()) || "报关行清单数据".equals(inputMsg.getContent())) {
				invtHeadStatistics = new InvtHeadStatistics();
				invtHeadStatistics.setGroupField("cih.agent_name");
				ihsList = this.invtHeadStatisticsService.statisticsInvtHeadQuantity(invtHeadStatistics);
				buffer = new StringBuffer("");
				for (int i = 0; i < ihsList.size(); i++) {
					ihs = ihsList.get(i);
					buffer.append((i + 1) + ". 报关行[" + ihs.getName() + "] 单量：[" + ihs.getQuantity()
					+ "] 商品数量: [" + ihs.getGoodsTotalQuantity() + "] 总货值：[" + ihs.getGoodsValue()
					+ "] 总税款: [" + ihs.getTaxTotal() + "] 总增值税: [" + ihs.getValueAddedTax() + "]\n");
				}
				responseMsg.setContent(buffer.toString());
			} else if("0".equals(inputMsg.getContent()) || "菜单".equals(inputMsg.getContent())) {
				responseMsg.setContent(buffer.toString());
			} else {
				responseMsg.setContent("输入有误\n" + buffer.toString());
			}
			
			result = JAXBTool.buildXml(WeChatMessage.class, responseMsg);
			System.out.println("接收到与响应相差时间: " + (returnTime - createTime));
			System.out.println("result==[" + result + "]");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			response.flushBuffer();
		}
	}
}
