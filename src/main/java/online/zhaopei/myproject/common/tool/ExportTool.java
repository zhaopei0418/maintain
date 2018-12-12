package online.zhaopei.myproject.common.tool;

import io.swagger.models.auth.In;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.BaseDomain;
import online.zhaopei.myproject.domain.ecssent.InvtHead;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.CurrService;
import online.zhaopei.myproject.service.para.UnitService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhaopei on 17/11/24.
 */
public class ExportTool {

    static {
        System.loadLibrary("export");
    }

    public static String buildExportSql(final InvtHead invtHead) {
        return new SQL() {{
            this.SELECT("cih.invt_no 海关清单号");
            this.SELECT("cih.app_status 海关状态");
            this.SELECT("cpr.rtn_info 海关回执");
            this.SELECT("cpr.rtn_time 海关回执时间");
            this.SELECT("cpr.sys_date 海关回执入库时间");
//            this.SELECT("iih.detailscode 国检清单编号");
//            this.SELECT("iih.audit_state 国检状态");
//            this.SELECT("iih.bw_name 国检回执");
            this.SELECT("cih.ebc_name 电商企业");
            this.SELECT("cih.order_no 订单编号");
            this.SELECT("cih.logistics_name 物流企业");
            this.SELECT("cih.logistics_no 物流单号");
//            this.SELECT("iih.payename 支付企业");
//            this.SELECT("iih.applycode 支付单编号");
            this.SELECT("cih.bill_no 主单号");
            this.SELECT("cih.sys_date 申报日期");
//            this.SELECT("iih.goodsvalue 总货值");
            this.SELECT("cih.consignee_address 收货人地址");
            this.SELECT("cih.gross_weight 总毛重");
            this.SELECT("cih.net_weight 总净重");
            this.SELECT("pdbl.dist_no 核放单号");
            this.SELECT("pdh.dist_stat 核放单状态");
            this.SELECT("cih.dist_time 过卡口时间");

            this.FROM("ceb2_invt_head cih");

            //this.LEFT_OUTER_JOIN("imp_invt_head@ggfw_zhengzhou iih on iih.order_no = cih.order_no and iih.ebc_code = cih.ebc_code and iih.logistics_code = cih.logistics_code and iih.logistics_no = cih.logistics_no");
            this.LEFT_OUTER_JOIN("ceb2_pub_rtn cpr on cpr.biz_guid = cih.head_guid and cpr.rtn_status = cih.app_status left outer join (select tt.biz_guid, tt.rtn_status,max(tt.sys_date) as max_sys_date from ceb2_pub_rtn tt group by tt.biz_guid, tt.rtn_status) tt0 on tt0.biz_guid = cpr.biz_guid and tt0.rtn_status = cpr.rtn_status and tt0.max_sys_date = cpr.sys_date");
            this.LEFT_OUTER_JOIN("pre_dist_bill_list pdbl on pdbl.bill_no = cih.invt_no left outer join pre_dist_head pdh on pdh.seq_no = pdbl.seq_no");

            OracleTool.where(this, "cih.head_guid", invtHead.getHeadGuid());
            OracleTool.where(this, "cih.app_status", invtHead.getAppStatus());
            OracleTool.where(this, "cih.sys_date", invtHead.getBeginAppTime(), ">=");
            OracleTool.where(this, "cih.sys_date", invtHead.getEndAppTime(), "<=");
            OracleTool.where(this, "cih.sys_date", invtHead.getSysDateStr(), "=");
            OracleTool.where(this, "cih.app_sender_id", invtHead.getAppSenderId());
            OracleTool.where(this, "cih.order_no", invtHead.getOrderNo(), true);
            OracleTool.where(this, "cih.ebc_code", invtHead.getEbcCode());
            OracleTool.where(this, "cih.ebc_name", invtHead.getEbcName(), true);
            OracleTool.where(this, "cih.logistics_no", invtHead.getLogisticsNo(), true);
            OracleTool.where(this, "cih.logistics_code", invtHead.getLogisticsCode());
            OracleTool.where(this, "cih.logistics_name", invtHead.getLogisticsName(), true);
            OracleTool.where(this, "cih.cop_no", invtHead.getCopNo());
            OracleTool.where(this, "cih.invt_no", invtHead.getInvtNo(), true);
            OracleTool.where(this, "cih.agent_code", invtHead.getAgentCode());
            OracleTool.where(this, "cih.agent_name", invtHead.getAgentName(), true);
            OracleTool.where(this, "cih.area_code", invtHead.getAreaCode());
            OracleTool.where(this, "cih.area_name", invtHead.getAreaName(), true);
            OracleTool.where(this, "cih.dist_status", invtHead.getDistStatus());
            OracleTool.where(this, "cih.customs_code", invtHead.getCustomsCode());
            OracleTool.where(this, "cih.trade_mode", invtHead.getTradeMode());
            OracleTool.where(this, "cih.bill_no", invtHead.getBillNo());
            OracleTool.where(this, "cih.voyage_no", invtHead.getVoyageNo());
            OracleTool.where(this, "cih.buyer_telephone", invtHead.getBuyerTelephone());
            OracleTool.where(this, "pdbl.dist_no", invtHead.getDistNo());

            if (!StringUtils.isEmpty(invtHead.getDeclareStatus())) {
                if ("1".equals(invtHead.getDeclareStatus())) {
                    this.WHERE("cih.app_status in ('1', '01', '100')");
                } else {
                    this.WHERE("cih.app_status not in ('1', '01', '100')");
                }
            }

            if (null != invtHead.getCopNoList() && !invtHead.getCopNoList().isEmpty()) {
                StringBuffer stringBufferIn = new StringBuffer("(");
                for(String copNo : invtHead.getCopNoList()) {
                    stringBufferIn.append("'" + copNo + "',");
                }
                stringBufferIn.deleteCharAt(stringBufferIn.length() - 1);
                stringBufferIn.append(")");
                this.WHERE("cih.cop_no in " + stringBufferIn.toString());
            }
        }}.toString();
    }

    /**
     *
     * @param fileNamePrefix 生成文件前缀
     * @param domainList 域对象列表
     * @param headers 表头
     * @param properties 属性列表每个元素[方法名, "-1", "自定义列表以逗号分隔，每项再以冒号分隔如：800:放行,899:结关"]
     *                   自定义列表转成Map以属性值为键取值, 第二个取值: -1:不转换; -2:取自定义列表; 0, 1, 2:单位，国家，币制
     * @param services 服务列表0：单位，1：国家，2：币制
     * @return 生成的excel文件
     */
    public static File generateExportExcel(String fileNamePrefix, List<? extends BaseDomain> domainList, String[] headers, String[][] properties, Object[] services) {
        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String fileName = fileNamePrefix + sdfFileName.format(Calendar.getInstance().getTime()) + ".xls";
        File file = new File("export/" + fileName);
        OutputStream output = null;
        BaseDomain domainObject = null;
        Workbook wb = new HSSFWorkbook();
        int sheetCount = 0;
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        int minLength = 0;
        Class<? extends BaseDomain> clazz = null;
        Method getMethod = null;
        Object result = null;
        Integer intResult = null;
        Double doubleResult = null;
        String strResult = null;
        Class returnType = null;
        int propType = -1;
        CurrService currService = null;
        UnitService unitService = null;
        CountryService countryService = null;
        Map<String, String> propMap = null;
        String[] tmpStrs = null, tmpStrs1 = null;

        try {
            output = new FileOutputStream(file);

            if(null != domainList && !domainList.isEmpty()) {
                sheetCount = domainList.size() % CommonConstant.XLS_MAX_LINE == 0 ? domainList.size() / CommonConstant.XLS_MAX_LINE :
                        (domainList.size() / CommonConstant.XLS_MAX_LINE + 1);
                for(int i = 0; i < sheetCount; i++) {
                    sheet = wb.createSheet(fileNamePrefix + i);
                    minLength = domainList.size() >= (i + 1) * CommonConstant.XLS_MAX_LINE ? CommonConstant.XLS_MAX_LINE :
                            domainList.size() - i * CommonConstant.XLS_MAX_LINE;
                    row = sheet.createRow(0);
                    for(int k = 0; k < headers.length; k++) {
                        row.createCell(k).setCellValue(headers[k]);
                    }
                    for(int j = 0; j < minLength; j++) {
                        domainObject = domainList.get(i * CommonConstant.XLS_MAX_LINE + j);
                        clazz = domainObject.getClass();
                        row = sheet.createRow(j + 1);
                        for(int k = 0; k < headers.length; k++) {
                            getMethod = clazz.getMethod(properties[k][0]);
                            propType = Integer.valueOf(properties[k][1]);
                            returnType = getMethod.getReturnType();
                            result = getMethod.invoke(domainObject);
                            cell = row.createCell(k);
                            if(Double.class == returnType) {
                                doubleResult = (Double) result;
                            } else if(Integer.class == returnType) {
                                intResult = (Integer) result;
                            } else if(Date.class == returnType) {
                                strResult = dateFormat.format((Date) result);
                            } else {
                                strResult = (String) result;
                            }
                            if(-2 == propType) {
                                propMap = new HashMap<String, String>();
                                tmpStrs = properties[k][2].split(",");
                                for(String s : tmpStrs) {
                                    tmpStrs1 = s.split(":");
                                    propMap.put(tmpStrs1[0], tmpStrs1[1]);
                                }
                                strResult = propMap.get(String.valueOf(null == strResult ? intResult: strResult));
                            } else if(0 == propType) {
                                unitService = (UnitService) services[0];
                                strResult = ParaTool.getUnitDesc(strResult, unitService);
                            } else if(1 == propType) {
                                countryService = (CountryService) services[1];
                                strResult = ParaTool.getCountryDesc(strResult, countryService);
                            } else if(2 == propType) {
                                currService = (CurrService) services[2];
                                strResult = ParaTool.getCurrDesc(strResult, currService);
                            }

                            if(null != intResult) {
                                cell.setCellValue(intResult);
                            } else if(null != doubleResult) {
                                cell.setCellValue(doubleResult);
                            } else {
                                cell.setCellValue(strResult);
                            }
                        }
                    }
                }
            }

            wb.write(output);
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public static native void hello(String name);

    public static native void generateExportFile(int type, String sqlPathName, String exportPathName);
}
