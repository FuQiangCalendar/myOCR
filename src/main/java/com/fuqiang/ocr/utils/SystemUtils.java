package com.fuqiang.ocr.utils;

public class SystemUtils {
	
	/**
	 * 
	 * @Title:	isWindows
	 * @Description:	判断是不是windows系统
	 * @param:	@return
	 * @return:	boolean
	 * @author:	FuQiang
	 * @date:	2020年9月3日 下午2:02:51
	 * @throws
	 */
	public static boolean isWindows () {
		String system = System.getProperty("os.name"); 
		if(system.toLowerCase().startsWith("win")){
			return true;
		}
		
		return false;
	}
	 
	public static void main(String[] args) {
		System.out.println(isWindows());
	}
}
