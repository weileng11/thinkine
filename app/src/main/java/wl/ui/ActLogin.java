package wl.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wl.base.BaseActivity;
import wl.thinkine.R;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: wl.ui
 * @description:
 * @date: 2018/11/16 0016
 * @time: 下午 4:01
 */
public class ActLogin extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.tv_register_account)
    TextView mTvRegisterAccount;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.ll_login)
    LinearLayout mLlLogin;

    @Override
    public int getLayout() {
        return R.layout.act_login;
    }

    @Override
    public void initData() {
    }

    @OnClick(R.id.login)
    public void onClick() {
        skipActivity(ActLogin.this,ActMain.class);
    }
}
