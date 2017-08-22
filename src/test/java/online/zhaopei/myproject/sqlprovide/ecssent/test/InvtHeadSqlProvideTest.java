package online.zhaopei.myproject.sqlprovide.ecssent.test;

import org.junit.Test;

import online.zhaopei.myproject.sqlprovide.ecssent.InvtHeadSqlProvide;

public class InvtHeadSqlProvideTest {

	@Test
	public void test() {
		InvtHeadSqlProvide ihsp = new InvtHeadSqlProvide();
		System.out.println(ihsp.getInvtHeadListByRepeatInvtNoSql());
		System.out.println(ihsp.deleteInvtHeadByHeadGuidSql("123"));
	}

}
