package online.zhaopei.myproject.sqlprovide.ecssent.test;

import online.zhaopei.myproject.sqlprovide.ecssent.DistBillListSqlProvide;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaopei on 17/11/3.
 */
public class DistBillListSqlProvideTest {
    //@Test
    public void excludeInvtsSql() throws Exception {
        DistBillListSqlProvide dblsp = new DistBillListSqlProvide();
        System.out.println(dblsp.excludeInvtsSql("distNo123", "companyCode123"));

    }

}