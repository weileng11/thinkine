package com.popular.practice;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.orhanobut.dialogplus.*;
import com.popular.R;
import com.popular.comm.BaseActivity;
import com.popular.comm.Global;
import com.popular.comm.SaveUtil;
import com.popular.practice.annotation.BindEventBus;
import com.popular.practice.bean.EventBusTest;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zyyoona7.popup.EasyPopup;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice
 * @description: 练习
 * @date: 2019/1/8  
 * @time: 10:20
 */
@BindEventBus
public class PracticeAct extends BaseActivity implements EasyPermissions.PermissionCallbacks
{
	private static int REQUEST_CODE = 101;
	private static int PERMISSION_CODE = 1010;
	private static final String[] PERMISSIONS = new String[]{
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			Manifest.permission.CAMERA,
			};
	
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
	@BindView(R.id.btn_fingerprint)
	Button btnFingerprint;
	@BindView(R.id.ll_count)
	LinearLayout mLlCount;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_practice;
	}
	
	@Override
	public void initView(){
		checkPer();
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
			         R.id.btn_mmkv,R.id.btn_fingerprint
	         })
	public void onClick(View view){
		switch(view.getId()){
		//eventbus
		case R.id.btn_eventbus:
			EventBus.getDefault().post(new EventBusTest());
			break;
		//pop
		case R.id.btn_pop:
			showGroupType();
			break;
		//圆
		case R.id.btn_yuan:
			showActivity(this,YuanAct.class);
			break;
		//选择图片
		case R.id.btn_select_tp:
			photoAndCamera();
			break;
		//手势锁
		case R.id.btn_lock:
			showActivity(this,GestureAct.class);
			break;
		//权限
		case R.id.btn_quanxian:
			checkPer();
			break;
		//滑动
		case R.id.btn_hd:
			Global.showToast(SaveUtil.loadKey2());
			break;
		//zxing
		case R.id.btn_zxing:
			showActivity(this,ZxingAct.class);
			break;
		//dialog
		case R.id.btn_dialog:
			showBaseDialog();
			break;
		//mmkv
		case R.id.btn_mmkv:
			SaveUtil.saveKey("2222","33333");
			Global.showToast(SaveUtil.loadKey());
			break;
		//指纹识别
		case R.id.btn_fingerprint:
			showActivity(this,FingerprintAct.class);
			break;
		}
	}
	
	@Subscribe(threadMode=ThreadMode.MAIN)
	public void onEventBle(Object obj){
		if(obj instanceof EventBusTest){
			Global.showToast("测试EventBus");
		}
	}
	
	EasyPopup mPopup;
	
	private void showGroupType(){
		mPopup=EasyPopup.create()
				.setContentView(this, R.layout.pop_show)
				.setOnViewListener(new EasyPopup.OnViewListener()
				{
					@Override
					public void initViews(View view, final EasyPopup easyPopup){
					}
				})
				.setBackgroundDimEnable(true)
				.setFocusAndOutsideEnable(true)
				//变暗的透明度(0-1)，0为完全透明
				//.setDimValue(0.4f)
				////变暗的背景颜色
				//.setDimColor(Color.YELLOW)
				//.setWidth(200)
				//.setHeight(200)
				.apply();
		mPopup.showAtLocation(mLlCount, Gravity.CENTER, 0, 0);
	}
	
	//    启动相册、拍照：
	public void photoAndCamera(){
		//PictureSelector.create(PracticeAct.this)
		//		.openGallery(PictureMimeType.ofImage())
		//		.forResult(PictureConfig.CHOOSE_REQUEST);
		initPic();
	}
	
	private List<LocalMedia> selectList;
	private ArrayList<String> imagePaths=new ArrayList<>();
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case PictureConfig.CHOOSE_REQUEST:
				// 图片选择结果回调
				selectList = PictureSelector.obtainMultipleResult(data);
				// 例如 LocalMedia 里面返回三种 path
				// 1.media.getPath(); 为原图 path
				// 2.media.getCutPath();为裁剪后 path，需判断 media.isCut();是否为 true
				// 3.media.getCompressPath();为压缩后 path，需判断 media.isCompressed();是否为 true
				// 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
				for(int i=0;i<selectList.size();i++){
					
					imagePaths.add(selectList.get(i).getPath());
				}
				//gridAdapter.notifyDataSetChanged();
				//RequestOptions options = new RequestOptions();
				//options.placeholder(R.mipmap.ic_launcher)
				//		.centerCrop();
				//Glide.with(MainActivity.this)
				//		.load(path)
				//		.apply(options)
				//		.into(holder.image);
				break;
			}
		}else if(resultCode==REQUEST_CODE){
			//处理扫描结果（在界面上显示）
			if (null != data) {
				Bundle bundle = data.getExtras();
				if (bundle == null) {
					return;
				}
				if (bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS) {
					String result = bundle.getString(CodeUtils.RESULT_STRING);
					Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
				} else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
					Toast.makeText(PracticeAct.this, "解析二维码失败", Toast.LENGTH_LONG).show();
				}
			}
		}
	}
	
	private void initPic(){
		// 进入相册 以下是例子：用不到的 api 可以不写
		PictureSelector.create(this)
				.openGallery(PictureMimeType.ofAll())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
				//.theme()//主题样式(不设置为默认样式) 也可参考 demo values/styles 下 例如：R.style.picture.white.style
				.maxSelectNum(9)// 最大图片选择数量 int
				.minSelectNum(1)// 最小选择数量 int
				.imageSpanCount(4)// 每行显示个数 int
				.selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
				.previewImage(true)// 是否可预览图片 true or false
				.previewVideo(true)// 是否可预览视频 true or false
				.enablePreviewAudio(false) // 是否可播放音频 true or false
				//.compressGrade()// luban 压缩档次，默认 3 档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
				.isCamera(true)// 是否显示拍照按钮 true or false
				.isZoomAnim(true)// 图片列表点击 缩放效果 默认 true
				.sizeMultiplier(0.5f)// glide 加载图片大小 0~1 之间 如设置 .glideOverride()无效
				.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
				.enableCrop(true)// 是否裁剪 true or false
				.compress(true)// 是否压缩 true or false
				//.compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
				.glideOverride(100,100)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
				.withAspectRatio(3,4)// int 裁剪比例 如 16:9 3:2 3:4 1:1 可自定义
				.hideBottomControls(true)// 是否显示 uCrop 工具栏，默认不显示 true or false
				.isGif(false)// 是否显示 gif 图片 true or false
				.freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
				.circleDimmedLayer(true)// 是否圆形裁剪 true or false
				.showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为 false   true or false
				.showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为 false    true or false
				.openClickSound(false)// 是否开启点击声音 true or false
				//.selectionMedia()// 是否传入已选图片 List<LocalMedia> list
				.previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
				.cropCompressQuality(90)// 裁剪压缩质量 默认 90 int
				//.compressMaxKB()//压缩最大值 kb compressGrade()为 Luban.CUSTOM_GEAR 有效 int
				//.compressWH() // 压缩宽高比 compressGrade()为 Luban.CUSTOM_GEAR 有效  int
				//.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
				.rotateEnabled(true) // 裁剪是否可旋转图片 true or false
				.scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
				.videoQuality(1)// 视频录制质量 0 or 1 int
				//.videoSecond()// 显示多少秒以内的视频 or 音频也可适用 int
				.recordVideoSecond(60)//视频秒数录制 默认 60s int
				.forResult(PictureConfig.CHOOSE_REQUEST);//结果回调 onActivityResult code
	}
	
	private void checkPer() {
		if (Build.VERSION.SDK_INT >= 23) {
			if (!EasyPermissions.hasPermissions(this, PERMISSIONS)) {
				Toast.makeText(this, "获取授权！", Toast.LENGTH_SHORT).show();
				EasyPermissions.requestPermissions(this,
						"APP 申请权限！",
						PERMISSION_CODE, PERMISSIONS);
			}
		}
	}
	
	//==================权限================//
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		//将请求结果传递EasyPermission库处理
		EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
	}
	
	@Override
	public void onPermissionsGranted(int requestCode, @NonNull List<String> perms){
		Global.showToast("用户授权ok");
		EventBus.getDefault().post(new EventBusTest());
	}
	
	@Override
	public void onPermissionsDenied(int requestCode, @NonNull List<String> perms){
		Global.showToast("用户授权失败");
	}
	//==================权限================//
	
	//====dialog===//
	private void showBaseDialog(){
		//根据自己dialog中展示的内容自定义适配器
		//DialogAdapter adapter = new DialogAdapter(this);
		DialogPlus dialog = DialogPlus.newDialog(this)
				.setGravity(Gravity.CENTER)// 可选TOP/BOTTOM
				.setContentHolder(new ViewHolder(R.layout.content))
				.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(DialogPlus dialog, View view){
					     view.findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener(){
						     @Override
						     public void onClick(View v){
						     	Global.showToast("sasasasa");
						     }
					     });
					}
				})
				//.setContentHolder(new ListHolder()) //或者 new GridHolder(3)，参数列数
				//.setHeader(R.layout.header)//自定义头部
				//.setFooter(R.layout.footer)//自定义尾部
				//.setAdapter(adapter)//自定义
				//.setContentWidth(ViewGroup.LayoutParams.WRAP_CONTENT)  // or any custom width ie: 300
				//.setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
				.setContentBackgroundResource(R.color.blue)//默认白色
				.setInAnimation(R.anim.slide_in_top)//in动画
				.setOutAnimation(R.anim.slide_out_bottom)//out动画
				.setMargin(20,20,20,20)
				.setPadding(20,20,20,20)
				.setOutMostMargin(2,2,2,2)//半透明边框
				.setExpanded(true)//默认false展开
				.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
						dialog.dismiss();
						Toast.makeText(PracticeAct.this, item.toString() + " | " + position, Toast.LENGTH_SHORT).show();
					}
				})
				.setExpanded(true)  // This will enable the expand feature, (similar to android L share dialog)
				.create();
		dialog.show();
	}
}
