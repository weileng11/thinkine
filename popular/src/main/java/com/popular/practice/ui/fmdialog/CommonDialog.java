package com.popular.practice.ui.fmdialog;

import android.support.annotation.LayoutRes;
import com.popular.practice.ui.widget.BaseDialog;
import com.popular.practice.ui.widget.ViewConvertListener;
import com.popular.practice.ui.widget.ViewHolder;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui.fmdialog
 * @description:
 * @date: 2019/2/22  
 * @time: 11:08
 */
public class CommonDialog extends BaseDialog
{
	private ViewConvertListener convertListener;
	
	public static CommonDialog newInstance() {
		CommonDialog dialog = new CommonDialog();
		return dialog;
	}
	
	/**
	 * 设置Dialog布局
	 *
	 * @param layoutId
	 * @return
	 */
	public CommonDialog setLayoutId(@LayoutRes int layoutId) {
		this.mLayoutResId = layoutId;
		return this;
	}
	
	@Override
	public int setUpLayoutId(){
		return mLayoutResId;
	}
	
	@Override
	public void convertView(ViewHolder holder, BaseDialog dialog){
		if (convertListener != null) {
			convertListener.convertView(holder, dialog);
		}
	}
	
	public CommonDialog setConvertListener(ViewConvertListener convertListener) {
		this.convertListener = convertListener;
		return this;
	}
}
