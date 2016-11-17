package online.zhaopei.myproject.common.tool;

import java.util.Random;

public class MathTool {

	/**
	 * 生成指定长度的随机数字符串
	 * @param length
	 * @return
	 */
	public static String generateFixLenthString(int length) {
		Random rm = new Random();
		
		double pross = (1 + rm.nextDouble()) * Math.pow(10, length);
		
		String fixLenthString = String.valueOf(pross); 
		
		return fixLenthString.substring(1, length + 1);
	}
}
