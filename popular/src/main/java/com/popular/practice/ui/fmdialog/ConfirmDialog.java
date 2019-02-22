package com.popular.practice.ui.fmdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.popular.R;
import com.popular.practice.ui.widget.BaseDialog;
import com.popular.practice.ui.widget.ViewHolder;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui.fmdialog
 * @description:
 * @date: 2019/2/22  
 * @time: 11:06
 */
public class ConfirmDialog extends BaseDialog
{
	private String type;
	
	public static ConfirmDialog newInstance(String type) {
		Bundle bundle = new Bundle();
		bundle.putString("type", type);
		ConfirmDialog dialog = new ConfirmDialog();
		dialog.setArguments(bundle);
		return dialog;
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getArguments();
		if (bundle == null) {
			return;
		}
		type = bundle.getString("type");
	}
	
	@Override
	public int setUpLayoutId(){
		return R.layout.dialog_confirm;
	}
	
	@Override
	public void convertView(ViewHolder holder, final BaseDialog dialog){
		if ("1".equals(type)) {
			holder.setText(R.id.title, "提示");
			holder.setText(R.id.message, "您已支付成功!");
		} else if ("2".equals(type)) {
			holder.setText(R.id.title, "警告");
			holder.setText(R.id.message, "您的帐号已被冻结!");
		}
		
		holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		holder.setOnClickListener(R.id.confirm, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				Toast.makeText(getContext(), "确定", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
