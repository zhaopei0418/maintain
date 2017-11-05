package online.zhaopei.myproject.sqlprovide.ecssent.test;

import org.junit.Test;

import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadSqlProvide;

public class InvtHeadSqlProvideTest {

	@Test
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

}
