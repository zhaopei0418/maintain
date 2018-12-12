package online.zhaopei.myproject.common.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

import com.alibaba.druid.util.StringUtils;

public class OracleTool {

	public static String toString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "to_date('" + sdf.format(date) + "', 'YYYY-MM-DD hh24:mi:ss')";
	}
	
	public static String toString(String str) {
		return toString(str, false);
	}
	
	public static String toString(String str, boolean isVague) {
		return isVague ? "'%" + str + "%'" : "'" + str + "'";
	}
	
	public static String toString(Double num) {
		return String.valueOf(num);
	}
	
	public static String toString(Integer num) {
		return String.valueOf(num);
	}
	
	public static String toString(Long num) {
		return String.valueOf(num);
	}
	
	public static void where(SQL sql, String column, String value) {
		where(sql, column, value, "=", false);
	}
	
	public static void where(SQL sql, String column, String value, boolean isVague) {
		where(sql, column, value, "=", isVague);
	}
	
	public static void where(SQL sql, String column, String value, String operator, boolean isVague) {
		if (!StringUtils.isEmpty(value)) {
			sql.WHERE(column + (isVague ? " like " : " " + operator + " ") + toString(value, isVague));
		}
	}
	
	public static void where(SQL sql, String column, Double value) {
		if (null != value) {
			sql.WHERE(column + " = " + value);
		}
	}
	
	public static void where(SQL sql, String column, Integer value) {
		if (null != value) {
			sql.WHERE(column + " = " + value);
		}
	}
	
	public static void where(SQL sql, String column, Long value) {
		if (null != value) {
			sql.WHERE(column + " = " + value);
		}
	}
	
	public static void where(SQL sql, String column, String value, String operator) {
		if (!StringUtils.isEmpty(value)) {
			if (">=".equals(operator) || ">".equals(operator)) {
				sql.WHERE(column + " " + operator + " to_date('" + value + "', 'yyyy-MM-dd')");
			} else if ("=".equals(operator)) {
				sql.WHERE(column + " >= to_date('" + value + "', 'yyyy-MM-dd')");
				sql.WHERE(column + " <= to_date('" + value + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
			} else {
				sql.WHERE(column + " " + operator + " to_date('" + value + " 23:59:59', 'yyyy-MM-dd hh24:mi:ss')");
			}
		}
	}
	
	public static void values(SQL sql, String column, String value) {
		if (!StringUtils.isEmpty(value)) {
			sql.VALUES(column, toString(value));
		}
	}
	
	public static void values(SQL sql, String column, Integer value) {
		if (null != value) {
			sql.VALUES(column, toString(value));
		}
	}
	
	public static void values(SQL sql, String column, Long value) {
		if (null != value) {
			sql.VALUES(column, toString(value));
		}
	}
	
	public static void values(SQL sql, String column, Double value) {
		if (null != value) {
			sql.VALUES(column, toString(value));
		}
	}
	
	public static void values(SQL sql, String column, Date date) {
		if (null != date) {
			sql.VALUES(column, toString(date));
		}
	}
	
	public static void orderBy(SQL sql, String orderBy) {
		if (!StringUtils.isEmpty(orderBy)) {
			sql.ORDER_BY(orderBy);
		}
	}
	
	public static void set(SQL sql, String column, String value) {
		sql.SET(column + " = " + (null == value ? "null" : toString(value)));
	}
	
	public static void set(SQL sql, String column, Double value) {
		sql.SET(column + " = " + (null == value ? "null" : value));
	}
	
	public static void set(SQL sql, String column, Integer value) {
		sql.SET(column + " = " + (null == value ? "null" : value));
	}
	
	public static void set(SQL sql, String column, Long value) {
		sql.SET(column + " = " + (null == value ? "null" : value));
	}
	
	public static void set(SQL sql, String column, Date value) {
		sql.SET(column + " = " + (null == value ? "null" : toString(value)));
	}
}
