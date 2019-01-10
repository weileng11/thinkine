package com.popular.practice.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.popular.R;
import com.popular.comm.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui
 * @description:
 * @date: 2019/1/9
 * @time: 16:48
 */
public class ToastAct extends BaseActivity
{
	@BindView(R.id.t1)
	Button mT1;
	@BindView(R.id.t2)
	Button mT2;
	@BindView(R.id.t3)
	Button mT3;
	@BindView(R.id.t4)
	Button mT4;
	@BindView(R.id.t5)
	Button mT5;

	@Override
	public int getLayoutRes(){
		return R.layout.act_toast;
	}

	@Override
	public void initView(){
		Toasty.Config.getInstance()
				//.setErrorColor(@ColorIntint errorColor) // optional
    //.setInfoColor(@ColorInt int infoColor) // optional
    //.setSuccessColor(@ColorInt int successColor) // optional
    //.setWarningColor(@ColorInt int warningColor) // optional
    //.setTextColor(@ColorInt int textColor) // optional
    //.tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
    //.setToastTypeface(@NonNull Typeface typeface) // optional
		//		.setTextSize(int sizeInSp) // optional
    .apply(); // required
	}

	@Override
	public void initListener(){
	}

	@Override
	public void initData(){
	}

	@OnClick({R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5})
	public void onClick(View view){
		switch(view.getId()){
		case R.id.t1:
			Toasty.error(this,"错误", Toast.LENGTH_SHORT,true).show();
			break;
		case R.id.t2:
			Toasty.success(this,"成功",Toast.LENGTH_SHORT,true).show();
			break;
		case R.id.t3:
			Toasty.info(this,"33333",Toast.LENGTH_SHORT,true).show();
			break;
		case R.id.t4:
			Toasty.warning(this,"44444").show();
			break;
		case R.id.t5:
			//Toasty.normal(this,"555555",Toast.LENGTH_SHORT).show();
			//Toasty.normal(this,mT5.getText().toString(), getResources().getDrawable(R.drawable.bg)).show();
			showCustom();
			break;
		}
	}

	/**
	 * 创建自定义Toasts ：
	 */
	private void showCustom(){
		Toasty.custom(this, "xxxxxxxxx",  getResources().getDrawable(R.drawable.bg), Color.BLUE, Color.RED,true,
				true).show();
	}
}
