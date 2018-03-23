package online.zhaopei.myproject.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageInfo;
import online.zhaopei.myproject.common.tool.ParaTool;
import online.zhaopei.myproject.constant.CommonConstant;
import online.zhaopei.myproject.domain.AuthUser;
import online.zhaopei.myproject.domain.ecssent.Store;
import online.zhaopei.myproject.service.ecssent.StoreService;
import online.zhaopei.myproject.service.para.CountryService;
import online.zhaopei.myproject.service.para.UnitService;
import org.apache.commons.io.FileUtils;
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
            writer.println("账册号,经营单位,料号,HS编码,商品名称,规格,成交单价,单位,出库,入库,库存");
            for(Store s : storeList) {
                writer.print(s.getLmsNo());
                writer.print("," + s.getTradeName());
                writer.print("," + s.getItemNo());
                writer.print("," + s.getCodeTs());
                writer.print("," + s.getgName());
                writer.print("," + s.getgModel());
                writer.print("," + s.getgModel());
                writer.print("," + s.getDeclPrice());
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
}
