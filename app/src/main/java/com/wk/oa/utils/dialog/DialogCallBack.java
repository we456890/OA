package com.wk.oa.utils.dialog;

/**
 * DialogCallBack
 * dialog的回调监听
 * @author nfhu
 * @time 2014-1-16 下午11:34:35
 **/
public interface DialogCallBack {
	
	/**
	 * <callBack>
	 * 页面回调函数，确定页面回调
	 * @param state true, 确定 false, 取消
	 **/
	public void callBack(boolean state);
}
