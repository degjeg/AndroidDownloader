/*
 * 文件名：StringUtil.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-6-9
 * 修改人：xiaoying
 * 修改时间：2013-6-9
 * 版本：v1.0
 */

package com.example.downloaddemo.utils;

/**
 * 功能：
 * @author xiaoying
 *
 */
public class StringUtil {
	
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}
	
	/**
	 * 删除所有在startStr和endStr之间的字符串，包括startStr和endStr,即删除闭区间［startStr，endStr］
	 * @param sb
	 * @param startStr
	 * @param endStr
	 */
	public static void deleteAllIn(StringBuilder sb, String startStr, String endStr) {
		int startIndex = 0;
		int endIndex = 0;
		while((startIndex = sb.indexOf(startStr)) >= 0 && (endIndex = sb.indexOf(endStr)) >= 0) {
			sb.delete(startIndex, endIndex + endStr.length());
		}
	}
	
	/**
	 * 根据相对／绝对路径获取文件名
	 * @param path
	 * @return
	 */
	public static String getFileName(String path) {
		return path.substring(path.lastIndexOf("/") + 1, path.length());
	}
}
