package online.zhaopei.myproject;

import java.util.Calendar;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.domain.gjpayment.BodyMaster;
import online.zhaopei.myproject.domain.gjpayment.CbecMessage;
import online.zhaopei.myproject.domain.gjpayment.MessageBody;

public class MaintainTest {

//	public static void main(String[] args) throws Exception {
//
//		JAXBContext context = JAXBContext.newInstance(MessageBody.class);
//		Marshaller m = context.createMarshaller();
//		
//		MessageBody messageBody = new MessageBody();
//		BodyMaster bm = new BodyMaster();
//		bm.setPayTime(Calendar.getInstance().getTime());
//		messageBody.setBodyMaster(bm);
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
////		m.marshal(messageBody, System.out);
//		
//		context = JAXBContext.newInstance(CbecMessage.class);
//		
//		Unmarshaller um = context.createUnmarshaller();
//		
////		CbecMessage cm = (CbecMessage) um.unmarshal(new FileInputStream(new File("/Users/zhaopei/work/test/payment1.xml")));
////		System.out.println(new Gson().toJson(cm));
//		String sql = new SQL() {{
//			this.INSERT_INTO("imp_pay_head");
//			this.VALUES("uuid", "'123'");
//			this.VALUES("guid", "'456'");
//		}}.toString();
//		System.out.println("123=" + sql);
//		
//		System.out.println("CFTHENANCUSTOM".length());
//		System.out.println("20160907133002014".length());
//		System.out.println("51021".length());
//		System.out.println("2088502727113172".length());
//		System.out.println("2015121311082174915343097".length());
//		System.out.println("33f8bc60-a3e0-4030-a6bf-dc9329e33db9".length());
//		
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
////			System.out.println(MathTool.generateFixLenthString(5));
//		}
//		
//	}

}
