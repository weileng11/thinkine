package wl.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wl.base.BaseActivity;
import wl.thinkine.R;

/**
 * @author: bruce
 * @project: thinkine
 * @package: wl.ui
 * @description: viewStub显示或者收藏,开始学习kotlin,该删除的删除记忆
 * @date: 2020/3/19
 * @time: 10:50
 */
public class ActMain extends BaseActivity {
    ViewStub mViewStub;
    @BindView(R.id.bt_show)
    Button mBtShow;
    @BindView(R.id.bt_hide)
    Button mBtHide;
    private TextView mTvShowTitle;// 标题

    @Override
    public int getLayout() {
        return R.layout.act_main;
    }

    @Override
    public void initData() {
        mViewStub = (ViewStub) findViewById(R.id.viewStub);// 寻找控件
      // 设置加载监听回调，成功加载后回调[只会回调一次]
        mViewStub.setOnInflateListener(new ViewStub.OnInflateListener() {

            /**
             * Listener used to receive a notification after a ViewStub has successfully inflated its layout resource.
             *
             * @param stub ViewStub 对象
             * @param inflated 被加载填充的布局
             */
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                View titleBar = mViewStub.inflate();
                mTvShowTitle = (TextView) titleBar.findViewById(R.id.tv_show_title);
                mTvShowTitle.setText("ShowTitle");
            }
        });
    }


    @OnClick({R.id.bt_show, R.id.bt_hide})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_show:
                try {
                    View titleBar = mViewStub.inflate();
                    mTvShowTitle = (TextView) titleBar.findViewById(R.id.tv_show_title);
                    mTvShowTitle.setTextColor(getResources().getColor(R.color.bg_white));
                    mTvShowTitle.setText("Title22222222");
                } catch (Exception e) {
                    mViewStub.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.bt_hide:
                mViewStub.setVisibility(View.GONE);
                break;
        }
    }
}
