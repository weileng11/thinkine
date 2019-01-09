package com.popular.practice.ui;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.widget.TextView;
import android.widget.Toast;
import com.popular.R;
import com.popular.comm.BaseActivity;
import com.popular.comm.Global;
import com.popular.practice.ui.fm.FingerprintDialogFragment;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice
 * @description: 指纹识别  针对23-》27 9.0暂不支持
 * @date: 2019/1/9  
 * @time: 15:33
 */
public class FingerprintAct extends BaseActivity
{
	private static final String DEFAULT_KEY_NAME="default_key";
	KeyStore keyStore;
	@BindView(R.id.tv_fingerprnt)
	TextView mTvFingerprnt;
	private Cipher cipher;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_fingerprint;
	}
	
	@Override
	public void initView(){
		if(supportFingerprint()){
			initKey();
			initCipher();
		}
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
	}
	
	public boolean supportFingerprint(){
		if(Build.VERSION.SDK_INT<23){
			Toast.makeText(this, "您的系统版本过低，不支持指纹功能", Toast.LENGTH_SHORT).show();
			return false;
		}else{
			KeyguardManager keyguardManager=getSystemService(KeyguardManager.class);
			FingerprintManager fingerprintManager=getSystemService(FingerprintManager.class);
			if(!fingerprintManager.isHardwareDetected()){
				Toast.makeText(this, "您的手机不支持指纹功能", Toast.LENGTH_SHORT).show();
				return false;
			}else if(!keyguardManager.isKeyguardSecure()){
				Toast.makeText(this, "您还未设置锁屏，请先设置锁屏并添加一个指纹", Toast.LENGTH_SHORT).show();
				return false;
			}else if(!fingerprintManager.hasEnrolledFingerprints()){
				Toast.makeText(this, "您至少需要在系统设置中添加一个指纹", Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		return true;
	}
	
	@TargetApi(23)
	private void initKey(){
		try{
			keyStore=KeyStore.getInstance("AndroidKeyStore");
			keyStore.load(null);
			KeyGenerator keyGenerator=
					KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
			KeyGenParameterSpec.Builder builder=new KeyGenParameterSpec.Builder(DEFAULT_KEY_NAME,
					KeyProperties.PURPOSE_ENCRYPT|KeyProperties.PURPOSE_DECRYPT).setBlockModes(
					KeyProperties.BLOCK_MODE_CBC)
					.setUserAuthenticationRequired(true)
					.setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);
			keyGenerator.init(builder.build());
			keyGenerator.generateKey();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@TargetApi(23)
	private void initCipher(){
		try{
			SecretKey key=(SecretKey)keyStore.getKey(DEFAULT_KEY_NAME, null);
			cipher=Cipher.getInstance(
					KeyProperties.KEY_ALGORITHM_AES+"/"+KeyProperties.BLOCK_MODE_CBC+"/"+
					KeyProperties.ENCRYPTION_PADDING_PKCS7);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			showFingerPrintDialog(cipher);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private void showFingerPrintDialog(Cipher cipher){
		FingerprintDialogFragment fragment=new FingerprintDialogFragment();
		fragment.setCipher(cipher);
		fragment.show(getFragmentManager(), "fingerprint");
	}
	
	public void onAuthenticated(){
		Global.showToast("成功");
		mTvFingerprnt.setText("指纹认证成功了，开心吧...");
		//finish();
	}
	
	@OnClick(R.id.tv_fingerprnt)
	public void onClick(){
		showFingerPrintDialog(cipher);
	}
}
