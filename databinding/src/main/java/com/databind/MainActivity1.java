package com.databind;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.databind.activity.BasicActivity;
import com.databind.activity.DoubleBindActivity;
import com.databind.activity.RecyclerViewActivity;
import com.databind.databinding.ActivityMain1Binding;

/**
 * DataBinding
 */
public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {
	
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMain1Binding main1Binding= DataBindingUtil.setContentView(this, R.layout.activity_main1);
		main1Binding.setOnClickListener(this);
		mContext=this;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.basic_btn:
			startActivity(new Intent(mContext, BasicActivity.class));
			break;
		case R.id.double_bind_btn:
			startActivity(new Intent(mContext, DoubleBindActivity.class));
			break;
		case R.id.recycler_view_bind_btn:
			startActivity(new Intent(mContext, RecyclerViewActivity.class));
			break;
		}
	}
}
