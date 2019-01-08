package com.popular;

import android.widget.Button;
import com.popular.comm.BaseActivity;
import com.popular.practice.PracticeAct;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
{
	@BindView(R.id.btn_practice)
	Button mBtnPractice;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_main;
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
	
	@OnClick(R.id.btn_practice)
	public void onClick(){
		showActivity(this, PracticeAct.class);
	}
}
