package com.popular.practice.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.popular.R;
import com.popular.comm.BaseActivity;
import com.popular.practice.ui.fmdialog.CommonDialog;
import com.popular.practice.ui.fmdialog.ConfirmDialog;
import com.popular.practice.ui.widget.BaseDialog;
import com.popular.practice.ui.widget.ViewConvertListener;
import com.popular.practice.ui.widget.ViewHolder;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui
 * @description: dialogFragment测试
 * @date: 2019/2/22  
 * @time: 11:10
 */
public class DialogTestAct extends BaseActivity
{
	@Override
	public int getLayoutRes(){
		return R.layout.act_dialogtest;
	}
	
	@Override
	public void initView(){
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
	}
	
	
	//确定样式一
	public void showConfirmClick(View view) {
		ConfirmDialog.newInstance("1")
				.setMargin(60)
				.setOutCancel(false)
				.show(getSupportFragmentManager());
	}
	
	//确定样式二
	public void showConfirm2Click(View view) {
		ConfirmDialog.newInstance("2")
				.setMargin(60)
				.setOutCancel(true)
				.show(getSupportFragmentManager());
	}
	
	//分享样式
	public void showShareClick(View view) {
		CommonDialog.newInstance()
				.setLayoutId(R.layout.dialog_share)
				.setConvertListener(new ViewConvertListener() {
					@Override
					public void convertView(ViewHolder holder, final BaseDialog dialog) {
						holder.setOnClickListener(R.id.tv_weixin_share, new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								Toast.makeText(DialogTestAct.this, "微信分享", Toast.LENGTH_SHORT).show();
								dialog.dismiss();
							}
						});
					}
				})
				.setDimAmout(0.3f)
				.setShowBottom(true)
				.setAnimStyle(R.style.EnterExitAnimation)
				.show(getSupportFragmentManager());
	}
	
	//好有设置
	public void showFriendClick(View view) {
		CommonDialog.newInstance()
				.setLayoutId(R.layout.dialog_friend)
				.setConvertListener(new ViewConvertListener() {
					@Override
					public void convertView(ViewHolder holder, final BaseDialog dialog) {
					}
				})
				.setShowBottom(true)
				.setSize(0, 310)
				.show(getSupportFragmentManager());
	}
	
	//评论样式
	public void showCommentClick(View view) {
		CommonDialog.newInstance()
				.setLayoutId(R.layout.dialog_comment)
				.setConvertListener(new ViewConvertListener() {
					@Override
					public void convertView(ViewHolder holder, final BaseDialog dialog) {
						final EditText et_input = holder.getView(R.id.edit_input);
						
						holder.setOnClickListener(R.id.tv_commit, new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								String text = et_input.getText().toString().trim();
								text = TextUtils.isEmpty(text) ? "请输入文字" : et_input.getText().toString().trim();
								Toast.makeText(DialogTestAct.this, text, Toast.LENGTH_SHORT).show();
								dialog.dismiss();
							}
						});
					}
				})
				.setShowBottom(true)
				.show(getSupportFragmentManager());
	}
}
