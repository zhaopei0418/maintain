package online.zhaopei.myproject.mapper.gjent;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.sqlprovide.gjent.PersonalInfoSqlProvide;

public interface PersonalInfoMapper extends Serializable {

    @Results(id = "personalInfoResult", value = {
            @Result(property = "uuid", column = "uuid", id = true),
            @Result(property = "perName", column = "pername"),
            @Result(property = "idType", column = "idtype"),
            @Result(property = "certId", column = "certid"),
            @Result(property = "status", column = "status"),
            @Result(property = "perPhone", column = "perphone"),
            @Result(property = "sysDate", column = "sys_date"),
            @Result(property = "authWay", column = "authway"),
            @Result(property = "authCop", column = "authcop"),
            @Result(property = "checkFlag", column = "checkflag"),
            @Result(property = "checkMark", column = "checkmark"),
            @Result(property = "jyOrderNo", column = "jy_orderno"),
            @Result(property = "isCheck", column = "is_check"),
            @Result(property = "billMode", column = "bill_mode"),
            @Result(property = "errorCode", column = "error_code"),
            @Result(property = "errroResult", column = "error_result"),
            @Result(property = "errorCount", column = "error_count"),
            @Result(property = "ciq_status", column = "ciq_status"),
            @Result(property = "chkFlag", column = "chkflag"),
            @Result(property = "chkmark", column = "chkmark"),
            @Result(property = "noticeDate", column = "noticedate"),
            @Result(property = "ebpCode", column = "ebp_code"),
            @Result(property = "groupOne", column = "group_one"),
            @Result(property = "groupTwo", column = "group_two"),
            @Result(property = "sumRequestNum", column = "sum_request_num"),
            @Result(property = "sumResponseNum", column = "sum_response_num"),
            @Result(property = "personalNum", column = "personal_num"),
            @Result(property = "orderNum", column = "order_num"),
    })
    @SelectProvider(type = PersonalInfoSqlProvide.class, method = "getPersonByIdSql")
    PersonalInfo getPersonById(@Param("id") String id);

    @ResultMap("personalInfoResult")
    @SelectProvider(type = PersonalInfoSqlProvide.class, method = "getPersonalInfoListSql")
    List<PersonalInfo> getPersonalInfoList(PersonalInfo personalInfo);

    @UpdateProvider(type = PersonalInfoSqlProvide.class, method = "clearErrorCountSql")
    Integer clearErrorCount(String uuid);

    @UpdateProvider(type = PersonalInfoSqlProvide.class, method = "clearErrorCountAllSql")
    Integer clearErrorCountAll();

    @ResultMap("personalInfoResult")
    @SelectProvider(type = PersonalInfoSqlProvide.class, method = "statisticsPersonalInfoSql")
    List<PersonalInfo> statisticsPersonalInfo(PersonalInfo personalInfo);

    @ResultMap("personalInfoResult")
    @SelectProvider(type = PersonalInfoSqlProvide.class, method = "getPersonalInfoByNameCertIdSql")
    PersonalInfo getPersonalInfoByNameCertId(String name, String certId);
}
