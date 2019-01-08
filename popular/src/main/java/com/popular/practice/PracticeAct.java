package com.popular.practice;

import android.view.View;
import android.widget.Button;
import com.popular.R;
import com.popular.comm.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice
 * @description: 练习
 * @date: 2019/1/8  
 * @time: 10:20
 */
public class PracticeAct extends BaseActivity
{
	@BindView(R.id.btn_eventbus)
	Button mBtnEventbus;
	@BindView(R.id.btn_pop)
	Button mBtnPop;
	@BindView(R.id.btn_yuan)
	Button mBtnYuan;
	@BindView(R.id.btn_select_tp)
	Button mBtnSelectTp;
	@BindView(R.id.btn_lock)
	Button mBtnLock;
	@BindView(R.id.btn_quanxian)
	Button mBtnQuanxian;
	@BindView(R.id.btn_hd)
	Button mBtnHd;
	@BindView(R.id.btn_zxing)
	Button mBtnZxing;
	@BindView(R.id.btn_dialog)
	Button mBtnDialog;
	@BindView(R.id.btn_mmkv)
	Button mBtnMmkv;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_practice;
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
	
	@OnClick({
			         R.id.btn_eventbus, R.id.btn_pop, R.id.btn_yuan, R.id.btn_select_tp,
			         R.id.btn_lock, R.id.btn_quanxian, R.id.btn_hd, R.id.btn_zxing, R.id.btn_dialog,
			         R.id.btn_mmkv
	         })
	public void onClick(View view){
		switch(view.getId()){
		//eventbus
		case R.id.btn_eventbus:
			break;
		//pop
		case R.id.btn_pop:
			break;
		//圆
		case R.id.btn_yuan:
			break;
		//选择图片
		case R.id.btn_select_tp:
			break;
		//手势锁
		case R.id.btn_lock:
			break;
		//权限
		case R.id.btn_quanxian:
			break;
		//滑动
		case R.id.btn_hd:
			break;
		//zxing
		case R.id.btn_zxing:
			break;
		//dialog
		case R.id.btn_dialog:
			break;
		//mmkv
		case R.id.btn_mmkv:
			break;
		}
	}
}
