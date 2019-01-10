package com.popular.practice.ui;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.*;
import android.opengl.GLSurfaceView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.popular.R;
import com.popular.comm.BaseActivity;
import java.io.IOException;
import java.io.InputStream;
import butterknife.BindView;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageGrayscaleFilter;
import jp.wasabeef.glide.transformations.*;
import jp.wasabeef.glide.transformations.gpu.*;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui
 * @description:
 * @date: 2019/1/10  
 * @time: 10:01
 */
public class ActImageDispose extends BaseActivity
{
	@BindView(R.id.iv_disposex)
	GLSurfaceView mIvDisposex;
	@BindView(R.id.iv_dispose1)
	ImageView mIvDispose1;
	@BindView(R.id.iv_dispose2)
	ImageView mIvDispose2;
	@BindView(R.id.iv_dispose3)
	ImageView mIvDispose3;
	@BindView(R.id.iv_dispose4)
	ImageView mIvDispose4;
	@BindView(R.id.iv_dispose5)
	ImageView mIvDispose5;
	@BindView(R.id.iv_dispose6)
	ImageView mIvDispose6;
	@BindView(R.id.iv_dispose7)
	ImageView mIvDispose7;
	@BindView(R.id.iv_dispose8)
	ImageView mIvDispose8;
	@BindView(R.id.iv_dispose9)
	ImageView mIvDispose9;
	@BindView(R.id.iv_dispose10)
	ImageView mIvDispose10;
	@BindView(R.id.iv_dispose11)
	ImageView mIvDispose11;
	@BindView(R.id.iv_dispose12)
	ImageView mIvDispose12;
	@BindView(R.id.iv_dispose13)
	ImageView mIvDispose13;
	@BindView(R.id.iv_dispose14)
	ImageView mIvDispose14;
	@BindView(R.id.iv_dispose15)
	ImageView mIvDispose15;
	@BindView(R.id.iv_dispose16)
	ImageView mIvDispose16;
	@BindView(R.id.iv_dispose17)
	ImageView mIvDispose17;
	@BindView(R.id.iv_dispose18)
	ImageView mIvDispose18;
	@BindView(R.id.iv_dispose19)
	ImageView mIvDispose19;
	@BindView(R.id.iv_dispose20)
	ImageView mIvDispose20;
	@BindView(R.id.iv_dispose21)
	ImageView mIvDispose21;
	@BindView(R.id.iv_dispose22)
	ImageView mIvDispose22;
	@BindView(R.id.iv_dispose23)
	ImageView mIvDispose23;
	
	private Bitmap bitmap;
	@Override
	public int getLayoutRes(){
		return R.layout.act_image_dispose;
	}
	
	@Override
	public void initView(){
		//GPUImage  图像滤镜框架
		showGPUImage();
		
		showDisposeImage();
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
	}
	
	private void showGPUImage(){
		//也可以直接从Drawable中通过Bitmap的获取方式直接获取
		//bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.android26);
		
		/**核心代码：使用GPUImage处理图像
		 *setImage()：Sets the image on which the filter should be applied.
		 *setFilter()：Sets the filter which should be applied to the image.
		 *getBitmapWithFilterApplied():Gets the current displayed image with applied filter as a Bitmap.
		 */
		GPUImage gpuImage = new GPUImage(this);
		gpuImage.setGLSurfaceView(mIvDisposex);
		openNativeImage();
		//mGPUImage.setFilter(new GPUImageGaussianBlurFilter());
		//滤镜类型 看下面
		gpuImage.setFilter(new GPUImageGrayscaleFilter());
		//mGPUImage.setFilter(new GPUImageSaturationFilter(30));
		
		gpuImage.setImage(bitmap);
	}
	
	private void openNativeImage() {
		AssetManager asset = this.getAssets();
		try {
			InputStream is = asset.open("showing.jpeg");
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressLint("CheckResult")
	private void showDisposeImage(){
		
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new BlurTransformation(25, 3)))
				.into(mIvDispose1);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(RequestOptions.overrideOf(266, 252))
				.apply(bitmapTransform(new MaskTransformation(R.drawable.bullets)))
				.into(mIvDispose2);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(RequestOptions.overrideOf(300, 200))
				.apply(bitmapTransform(new MaskTransformation(R.drawable.bullets)))
				.into(mIvDispose3);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(
						new CropTransformation(300, 100, CropTransformation.CropType.TOP)))
				.into(mIvDispose4);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(
						new CropTransformation(300, 100, CropTransformation.CropType.CENTER)))
				.into(mIvDispose5);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(
						new CropTransformation(300, 100, CropTransformation.CropType.BOTTOM)))
				.into(mIvDispose6);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new CropSquareTransformation()))
				.into(mIvDispose7);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new CropCircleTransformation()))
				.into(mIvDispose8);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new ColorFilterTransformation(Color.argb(80, 255, 0, 0))))
				.into(mIvDispose9);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new GrayscaleTransformation()))
				.into(mIvDispose10);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new RoundedCornersTransformation(45, 0,
						RoundedCornersTransformation.CornerType.BOTTOM)))
				.into(mIvDispose11);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new BlurTransformation(25)))
				.into(mIvDispose12);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new SupportRSBlurTransformation(25, 10)))
				.into(mIvDispose13);
		
		//GPUImage
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new ToonFilterTransformation()))
				.into(mIvDispose14);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new SepiaFilterTransformation()))
				.into(mIvDispose15);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new ContrastFilterTransformation(2.0f)))
				.into(mIvDispose16);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new InvertFilterTransformation()))
				.into(mIvDispose17);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new PixelationFilterTransformation(20f)))
				.into(mIvDispose18);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new SketchFilterTransformation()))
				.into(mIvDispose19);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new SwirlFilterTransformation(0.5f, 1.0f,
						new PointF(0.5f, 0.5f))).dontAnimate())
				.into(mIvDispose20);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new BrightnessFilterTransformation(0.5f)).dontAnimate())
				.into(mIvDispose21);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new KuwaharaFilterTransformation(25)).dontAnimate())
				.into(mIvDispose22);
		Glide.with(this)
				.load(R.drawable.ic_key)
				.apply(bitmapTransform(new VignetteFilterTransformation(new PointF(0.5f, 0.5f),
						new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f)).dontAnimate())
				.into(mIvDispose23);
	}
	
	/**
	 附上部分滤镜类型的API中文参照，便于查阅：
	 
	 "GPUImageFastBlurFilter"                               【模糊】
	 "GPUImageGaussianBlurFilter"                       【高斯模糊】
	 "GPUImageGaussianSelectiveBlurFilter"        【高斯模糊，选择部分清晰】
	 "GPUImageBoxBlurFilter"                                【盒状模糊】
	 "GPUImageTiltShiftFilter"                                【条纹模糊，中间清晰，上下两端模糊】
	 "GPUImageMedianFilter.h"                             【中间值，有种稍微模糊边缘的效果】
	 "GPUImageBilateralFilter"                               【双边模糊】
	 "GPUImageErosionFilter"                                【侵蚀边缘模糊，变黑白】
	 "GPUImageRGBErosionFilter"                         【RGB侵蚀边缘模糊，有色彩】
	 "GPUImageDilationFilter"                               【扩展边缘模糊，变黑白】
	 "GPUImageRGBDilationFilter"                        【RGB扩展边缘模糊，有色彩】
	 "GPUImageOpeningFilter"                             【黑白色调模糊】
	 "GPUImageRGBOpeningFilter"                      【彩色模糊】
	 "GPUImageClosingFilter"                               【黑白色调模糊，暗色会被提亮】
	 "GPUImageRGBClosingFilter"                        【彩色模糊，暗色会被提亮】
	 "GPUImageLanczosResamplingFilter"          【Lanczos重取样，模糊效果】
	 "GPUImageNonMaximumSuppressionFilter"     【非最大抑制，只显示亮度最高的像素，其他为黑】
	 "GPUImageThresholdedNonMaximumSuppressionFilter" 【与上相比，像素丢失更多】
	 
	 
	 "GPUImageCrosshairGenerator"              【十字】
	 "GPUImageLineGenerator"                       【线条】
	 "GPUImageTransformFilter"                     【形状变化】
	 "GPUImageCropFilter"                              【剪裁】
	 "GPUImageSharpenFilter"                        【锐化】
	 "GPUImageUnsharpMaskFilter"               【反遮罩锐化】
	 
	 
	 "GPUImageSobelEdgeDetectionFilter"           【Sobel边缘检测算法(白边，黑内容，有点漫画的反色效果)】
	 "GPUImageCannyEdgeDetectionFilter"          【Canny边缘检测算法（比上更强烈的黑白对比度）】
	 "GPUImageThresholdEdgeDetectionFilter"    【阈值边缘检测（效果与上差别不大）】
	 "GPUImagePrewittEdgeDetectionFilter"         【普瑞维特(Prewitt)边缘检测(效果与Sobel差不多，貌似更平滑)】
	 "GPUImageXYDerivativeFilter"                        【XYDerivative边缘检测，画面以蓝色为主，绿色为边缘，带彩色】
	 "GPUImageHarrisCornerDetectionFilter"       【Harris角点检测，会有绿色小十字显示在图片角点处】
	 "GPUImageNobleCornerDetectionFilter"      【Noble角点检测，检测点更多】
	 "GPUImageShiTomasiFeatureDetectionFilter" 【ShiTomasi角点检测，与上差别不大】
	 "GPUImageMotionDetector"                             【动作检测】
	 "GPUImageHoughTransformLineDetector"      【线条检测】
	 "GPUImageParallelCoordinateLineTransformFilter" 【平行线检测】
	 
	 
	 "GPUImageLocalBinaryPatternFilter"        【图像黑白化，并有大量噪点】
	 "GPUImageLowPassFilter"                          【用于图像加亮】
	 "GPUImageHighPassFilter"                        【图像低于某值时显示为黑】
	 
	 
	 
	 
	 "GPUImageSketchFilter"                          【素描】
	 "GPUImageThresholdSketchFilter"         【阀值素描，形成有噪点的素描】
	 "GPUImageToonFilter"                             【卡通效果（黑色粗线描边）】
	 "GPUImageSmoothToonFilter"                【相比上面的效果更细腻，上面是粗旷的画风】
	 "GPUImageKuwaharaFilter"                     【桑原(Kuwahara)滤波,水粉画的模糊效果；处理时间比较长，慎用】
	 
	 
	 "GPUImageMosaicFilter"                         【黑白马赛克】
	 "GPUImagePixellateFilter"                       【像素化】
	 "GPUImagePolarPixellateFilter"              【同心圆像素化】
	 "GPUImageCrosshatchFilter"                  【交叉线阴影，形成黑白网状画面】
	 "GPUImageColorPackingFilter"              【色彩丢失，模糊（类似监控摄像效果）】
	 
	 
	 "GPUImageVignetteFilter"                        【晕影，形成黑色圆形边缘，突出中间图像的效果】
	 "GPUImageSwirlFilter"                               【漩涡，中间形成卷曲的画面】
	 "GPUImageBulgeDistortionFilter"            【凸起失真，鱼眼效果】
	 "GPUImagePinchDistortionFilter"            【收缩失真，凹面镜】
	 "GPUImageStretchDistortionFilter"         【伸展失真，哈哈镜】
	 "GPUImageGlassSphereFilter"                  【水晶球效果】
	 "GPUImageSphereRefractionFilter"         【球形折射，图形倒立】
	     
	 "GPUImagePosterizeFilter"                 【色调分离，形成噪点效果】
	 "GPUImageCGAColorspaceFilter"      【CGA色彩滤镜，形成黑、浅蓝、紫色块的画面】
	 "GPUImagePerlinNoiseFilter"              【柏林噪点，花边噪点】
	 "GPUImage3x3ConvolutionFilter"      【3x3卷积，高亮大色块变黑，加亮边缘、线条等】
	 "GPUImageEmbossFilter"                   【浮雕效果，带有点3d的感觉】
	 "GPUImagePolkaDotFilter"                 【像素圆点花样】
	 "GPUImageHalftoneFilter"                  【点染,图像黑白化，由黑点构成原图的大致图形】
	 
	 
	 混合模式 Blend
	 
	 "GPUImageMultiplyBlendFilter"            【通常用于创建阴影和深度效果】
	 "GPUImageNormalBlendFilter"               【正常】
	 "GPUImageAlphaBlendFilter"                 【透明混合,通常用于在背景上应用前景的透明度】
	 "GPUImageDissolveBlendFilter"             【溶解】
	 "GPUImageOverlayBlendFilter"              【叠加,通常用于创建阴影效果】
	 "GPUImageDarkenBlendFilter"               【加深混合,通常用于重叠类型】
	 "GPUImageLightenBlendFilter"              【减淡混合,通常用于重叠类型】
	 "GPUImageSourceOverBlendFilter"       【源混合】
	 "GPUImageColorBurnBlendFilter"          【色彩加深混合】
	 "GPUImageColorDodgeBlendFilter"      【色彩减淡混合】
	 "GPUImageScreenBlendFilter"                【屏幕包裹,通常用于创建亮点和镜头眩光】
	 "GPUImageExclusionBlendFilter"            【排除混合】
	 "GPUImageDifferenceBlendFilter"          【差异混合,通常用于创建更多变动的颜色】
	 "GPUImageSubtractBlendFilter"            【差值混合,通常用于创建两个图像之间的动画变暗模糊效果】
	 "GPUImageHardLightBlendFilter"         【强光混合,通常用于创建阴影效果】
	 "GPUImageSoftLightBlendFilter"           【柔光混合】
	 "GPUImageChromaKeyBlendFilter"       【色度键混合】
	 "GPUImageMaskFilter"                           【遮罩混合】
	 "GPUImageHazeFilter"                            【朦胧加暗】
	 "GPUImageLuminanceThresholdFilter" 【亮度阈】
	 "GPUImageAdaptiveThresholdFilter"     【自适应阈值】
	 "GPUImageAddBlendFilter"                    【通常用于创建两个图像之间的动画变亮模糊效果】
	 "GPUImageDivideBlendFilter"                 【通常用于创建两个图像之间的动画变暗模糊效果】
	 ---------------------
	 原文：https://blog.csdn.net/it_zjyang/article/details/52268918
	 */
	
	//	enum class Type {
	//	Mask,
	//	NinePatchMask,
	//	CropTop,
	//	CropCenter,
	//	CropBottom,
	//	CropSquare,
	//	CropCircle,
	//	ColorFilter,
	//	Grayscale,
	//	RoundedCorners,
	//	Blur,
	//	SupportRSBlur,
	//	Toon,
	//	Sepia,
	//	Contrast,
	//	Invert,
	//	Pixel,
	//	Sketch,
	//	Swirl,
	//	Brightness,
	//	Kuawahara,
	//	Vignette
	//}
}
