package online.zhaopei.myproject.sqlprovide.ecssent.test;

import org.junit.Test;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadSqlProvide;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InvtHeadSqlProvideTest {

	//@Test
	public void test() {
		InvtHeadSqlProvide ihsp = new InvtHeadSqlProvide();
		System.out.println(ihsp.getInvtHeadListByRepeatInvtNoSql());
		System.out.println(ihsp.deleteInvtHeadByHeadGuidSql("123"));
		InvtHead invtHead = new InvtHead();
		invtHead.setCusStatus("010");
		System.out.println(ihsp.getInvtHeadListSql(invtHead));
		System.out.println(ihsp.syncInvtNoStatusSql("26", "800"));
		System.out.println(ihsp.syncInvtNoStatusSql("24", "500"));
	}

	//@Test
	public void testGetInvtHeadListSql() {
		InvtHeadSqlProvide ihsp = new InvtHeadSqlProvide();
		InvtHead ih = new InvtHead();
		ih.setSearchCompanyCode("4102");
		ih.setExactOrderNo("123123");
		System.out.println(ihsp.getInvtHeadListSql(ih));
	}

	//@Test
	public void testGetNonSyncInvtListSql() {
		InvtHeadSqlProvide ihsp = new InvtHeadSqlProvide();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Calendar calendar = Calendar.getInstance();
		System.out.println("current = " + sdf3.format(calendar.getTime()));
		calendar.add(Calendar.MINUTE, -30);
		String endDate = sdf1.format(calendar.getTime());
		System.out.println("endDate = " + endDate);
		calendar.add(Calendar.DATE, -15);
		String startDate = sdf2.format(calendar.getTime());
		System.out.println("startDate = " + startDate);
		System.out.println("testGetNonSyncInvtListSql ====================" + ihsp.getNonSyncInvtListSql(startDate, endDate));
	}

}
