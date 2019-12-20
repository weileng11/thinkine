package com.drawlayout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.drawlayout
 * @description:
 * @date: 2019/8/6
 * @time: 16:39
 */
public class Constraintlayout extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.viewstub);

        // 方式1，获取ViewStub,
        ViewStub listStub = (ViewStub) findViewById(R.id.stub_import);
        // 加载评论列表布局
        listStub.setVisibility(View.VISIBLE);
        // 获取到评论ListView，注意这里是通过ViewStub的inflatedId来获取
        FrameLayout commLv = findViewById(R.id.stub_comm_lv);
        if ( listStub.getVisibility() == View.VISIBLE ) {
            // 已经加载, 否则还没有加载
            Log.i("info","listview");
            TextView tv1=commLv.findViewById(R.id.tv1);
            tv1.setText("测试测试xxxx");
        }else{
            Log.i("info","no");
        }
    }
}
