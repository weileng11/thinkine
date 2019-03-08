package com.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.gallery.fancycoverflow.BitmapUtil;
import com.gallery.fancycoverflow.FancyCoverFlowAdapter;
import com.gallery.model.FilmInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.InputStream;
import java.util.List;

/**
 * @author LittleLiByte
 * 
 */
public class ImageAdapter extends FancyCoverFlowAdapter {
	private Context context;
	private List<FilmInfo> filmList;
	//	private ImageLoader imageLoader;
	//	private DisplayImageOptions options;
	
	public ImageAdapter(Context context, List<FilmInfo> filmList,
			DisplayImageOptions options, ImageLoader imageLoader) {
		this.context = context;
		this.filmList = filmList;
		//		this.options = options;
		//		this.imageLoader = imageLoader;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return filmList.get(position);
		//		return position;
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position % filmList.size();
		//		return position;
	}
	
	@Override
	public View getCoverFlowItem(int position, View reusableView,
			ViewGroup parent) {
		ImageView imageView = (ImageView) reusableView;
		
		if (imageView == null) {
			imageView = new ImageView(context);
		}
		Resources re = context.getResources();
		InputStream is = re.openRawResource(filmList.get(position%filmList.size()).getRs());
		//		InputStream is = re.openRawResource(mImagesId[position%mImagesId.length]);
		BitmapDrawable mapdraw = new BitmapDrawable(is);
		Bitmap bitmap = mapdraw.getBitmap();
		
		imageView.setImageBitmap(BitmapUtil.createReflectedBitmap(bitmap));
		//		imageView.setImageBitmap(bitmap);
		
		// ps.电影海报宽高比例一般为3：4
		imageView.setLayoutParams(new Gallery.LayoutParams(410, 713));
		
		//		// 异步加载图片
		//		imageLoader.displayImage(filmList.get(position % filmList.size())
		//				.getFilmImageLink(), imageView, options);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		return imageView;
	}
	
	public Integer[] getImagesId(){
		return mImagesId;
	}
	
	public void setImagesId(Integer[] mImagesId){
		this.mImagesId = mImagesId;
	}
	
	private Integer mImagesId[] = {
			R.drawable.ic_1,
			R.drawable.ic_3,
			R.drawable.ic_2,
			R.drawable.ic_4,
			R.drawable.ic_5
	};
}