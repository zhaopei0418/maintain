package online.zhaopei.myproject.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageInfo;
import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.AuthUser;
import online.zhaopei.myproject.domain.ecssent.Store;
import online.zhaopei.myproject.service.ecssent.StoreService;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.CurrService;
import online.zhaopei.myproject.service.para.UnitService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhaopei on 18/3/23.
 */
@Controller
@RequestMapping("/stores")
public class StoresController extends BaseController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private CurrService currService;

    @RequestMapping
    public ModelAndView index(Store store) {

        AuthUser currUser = BaseController.getCurrUser();

        if (!StringUtils.isEmpty(currUser.getMember().getCompanyCode())) {
            if (null == store) {
                store = new Store();
            }
            store.setAgentCode(currUser.getMember().getCompanyCode());
        }

        PageInfo<Store> pageInfo = this.getPageInfo(store, Store.class, this.storeService, "getStoreList");
        ModelAndView mv = this.buildBaseModelAndView("stores/list", pageInfo);
        mv.addObject("store", store);
        mv.addObject("storeList", pageInfo.getList());
        mv.addObject("country", ParaTool.getAllCountries(countryService));
        mv.addObject("unit", ParaTool.getAllUnits(unitService));
        return mv;
    }

    @RequestMapping("export")
    public ResponseEntity<byte[]> export(Store store) throws IOException {
        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = "store_" + sdfFileName.format(Calendar.getInstance().getTime()) + ".csv";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        File file = new File("export/" + fileName);
        PrintWriter writer = null;
        OutputStream output = null;
        AuthUser currUser = BaseController.getCurrUser();
        if (!StringUtils.isEmpty(currUser.getMember().getCompanyCode())) {
            if (null == store) {
                store = new Store();
            }
            store.setAgentCode(currUser.getMember().getCompanyCode());
        }
        List<Store> storeList = this.storeService.getStoreList(store);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            output = new FileOutputStream(file);
            output.write(CommonConstant.BOM);
            output.close();

            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")));
            writer.println("账册号,经营单位,料号,HS编码,商品名称,规格,成交单价,成交币制,单位,出库,入库,库存");
            for(Store s : storeList) {
                writer.print(s.getLmsNo());
                writer.print("," + s.getTradeName());
                writer.print("," + s.getItemNo());
                writer.print("," + s.getCodeTs());
                writer.print("," + s.getgName());
                writer.print("," + s.getgModel());
                writer.print("," + s.getgModel());
                writer.print("," + s.getDeclPrice());
                writer.print("," + ParaTool.getCurrDesc(s.getTradeCurr(), this.currService));
                writer.print("," + ParaTool.getUnitDesc(s.getUnit(), this.unitService));
                writer.print("," + s.getLegalOQty());
                writer.print("," + s.getLegalIQty());
                writer.print("," + s.getLegalRemainQty());
                writer.println();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            output.close();
            writer.close();
        }
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping("exportexcel")
    public ResponseEntity<byte[]> exportexcel(Store store) throws IOException {
        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String prefix = "store_";
        String fileName = prefix + sdfFileName.format(Calendar.getInstance().getTime()) + ".xls";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        File file = new File("export/" + fileName);
        OutputStream output = null;
        AuthUser currUser = BaseController.getCurrUser();
        if (!StringUtils.isEmpty(currUser.getMember().getCompanyCode())) {
            if (null == store) {
                store = new Store();
            }
            store.setAgentCode(currUser.getMember().getCompanyCode());
        }
        List<Store> storeList = this.storeService.getStoreList(store);
        Workbook wb = new HSSFWorkbook();
        int sheetCount = 0;
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        Store generateStroe = null;
        int minLength = 0;

        try {
            output = new FileOutputStream(file);

            if(null != storeList && !storeList.isEmpty()) {
                sheetCount = storeList.size() % CommonConstant.XLS_MAX_LINE == 0 ? storeList.size() / CommonConstant.XLS_MAX_LINE :
                        (storeList.size() / CommonConstant.XLS_MAX_LINE + 1);
                for(int i = 0; i < sheetCount; i++) {
                    sheet = wb.createSheet(prefix + i);
                    minLength = storeList.size() >= (i + 1) * CommonConstant.XLS_MAX_LINE ? CommonConstant.XLS_MAX_LINE :
                            storeList.size() - i * CommonConstant.XLS_MAX_LINE;
                    row = sheet.createRow(0);
                    row.createCell(0).setCellValue("账册号");
                    row.createCell(1).setCellValue("经营单位");
                    row.createCell(2).setCellValue("料号");
                    row.createCell(3).setCellValue("HS编码");
                    row.createCell(4).setCellValue("商品名称");
                    row.createCell(5).setCellValue("规格");
                    row.createCell(6).setCellValue("成交单价");
                    row.createCell(7).setCellValue("成交币制");
                    row.createCell(8).setCellValue("单位");
                    row.createCell(9).setCellValue("出库");
                    row.createCell(10).setCellValue("入库");
                    row.createCell(11).setCellValue("库存");
                    for(int j = 0; j < minLength; j++) {
                        generateStroe = storeList.get(i * CommonConstant.XLS_MAX_LINE + j);
                        row = sheet.createRow(j + 1);
                        row.createCell(0).setCellValue(generateStroe.getLmsNo());
                        row.createCell(1).setCellValue(generateStroe.getTradeName());
                        row.createCell(2).setCellValue(generateStroe.getItemNo());
                        row.createCell(3).setCellValue(generateStroe.getCodeTs());
                        row.createCell(4).setCellValue(generateStroe.getgName());
                        row.createCell(5).setCellValue(generateStroe.getgModel());
                        row.createCell(6).setCellValue(generateStroe.getDeclPrice());
                        row.createCell(7).setCellValue(ParaTool.getCurrDesc(generateStroe.getTradeCurr(), this.currService)
                                + "[" + generateStroe.getTradeCurr() + "]");
                        row.createCell(8).setCellValue(ParaTool.getUnitDesc(generateStroe.getUnit(), this.unitService)
                                + "[" + generateStroe.getUnit() + "]");
                        row.createCell(9).setCellValue(generateStroe.getLegalOQty());
                        row.createCell(10).setCellValue(generateStroe.getLegalIQty());
                        row.createCell(11).setCellValue(generateStroe.getLegalRemainQty());
                    }
                }
            }

            wb.write(output);
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
