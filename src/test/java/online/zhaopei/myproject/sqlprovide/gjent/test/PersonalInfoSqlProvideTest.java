package online.zhaopei.myproject.sqlprovide.gjent.test;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.sqlprovide.gjent.PersonalInfoSqlProvide;
import org.junit.Test;

/**
 * Created by zhaopei on 17/11/6.
 */
public class PersonalInfoSqlProvideTest {

    //@Test
    public void statisticsPersonalInfoSqlTest() throws Exception {
        System.out.println("Test");
        PersonalInfoSqlProvide pisp = new PersonalInfoSqlProvide();
        PersonalInfo pi = new PersonalInfo();
        pi.setGroupOne("to_char(pil1.sys_date, 'yyyy-mm-dd')");
        pi.setGroupTwo("to_char(pil1.sys_date, 'yyyy-mm-dd hh24')");
        pi.setBeginSysDate("2017-11-01");
        pi.setEndSysDate("2017-11-02");
        pi.setSysDateStr("2017-11-03");
        System.out.println(pisp.statisticsPersonalInfoSql(pi));
    }
}
