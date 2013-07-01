/*
 * 文件名：DownloadListener.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-7-1
 * 修改人：xiaoying
 * 修改时间：2013-7-1
 * 版本：v1.0
 */

package com.example.downloaddemo.downloader;

/**
 * 功能：下载进度监听器
 * @author xiaoying
 *
 */
public interface DownloadListener {
	
	/**
	 * 下载进度监听方法 获取和处理下载点数据的大小
	 * @param size 已下载大小
	 */
	public void onDownloadSize(int size);
}
