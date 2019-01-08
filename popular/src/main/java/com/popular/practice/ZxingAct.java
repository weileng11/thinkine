package com.popular.practice;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.popular.R;
import com.popular.comm.BaseActivity;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice
 * @description:
 * @date: 2019/1/8  
 * @time: 17:02
 */
public class ZxingAct extends BaseActivity
{
	@BindView(R.id.fl_my_container)
	FrameLayout mFlMyContainer;
	@BindView(R.id.iv_lighting)
	ImageView mIvLighting;
	private CaptureFragment mCaptureFragment;
	private Fragment mSuccessFragment;
	private String mGatewayId;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_zxing;
	}
	
	@Override
	public void initView(){
		mCaptureFragment=new CaptureFragment();
		CodeUtils.setFragmentArgs(mCaptureFragment, R.layout.layout_scan);
		mCaptureFragment.setAnalyzeCallback(new CodeUtils.AnalyzeCallback()
		{
			@Override
			public void onAnalyzeSuccess(Bitmap mBitmap, String result){
				mGatewayId=getParamByUrl(result, "serialNum");
				Log.d("L-WL", "onAnalyzeSuccess: mGatewayId"+mGatewayId);
				//mPresenter.bindGateway(mGatewayId, null);
			}
			
			@Override
			public void onAnalyzeFailed(){
			}
		});
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fl_my_container, mCaptureFragment)
				.commit();
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
	}
	
	private String getParamByUrl(String url, String name){
		url+="&";
		String pattern="(\\?|&){1}#{0,1}"+name+"=[a-zA-Z0-9]*(&{1})";
		Pattern r=Pattern.compile(pattern);
		Matcher m=r.matcher(url);
		if(m.find()){
			System.out.println(m.group(0));
			return m.group(0).split("=")[1].replace("&", "");
		}else{
			return null;
		}
	}
	
	private boolean isOpenLighting = false;
	@OnClick(R.id.iv_lighting)
	public void onClick(){
		if (!isOpenLighting) {
			CodeUtils.isLightEnable(true);
			isOpenLighting = true;
		} else {
			CodeUtils.isLightEnable(false);
			isOpenLighting = false;
		}
		
	}
}
