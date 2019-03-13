package com.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gallery.fancycoverflow.FancyCoverFlowAdapter;
import com.gallery.model.FilmInfo;
import java.util.List;

/**
 * @author LittleLiByte
 * 
 */
public class ImageAdapter extends FancyCoverFlowAdapter
{
	private Context context;
	private List<FilmInfo> filmList;
	private LayoutInflater mLayoutInflater;
	//private ImageLoader imageLoader;
	//private DisplayImageOptions options;

	public ImageAdapter(Context context, List<FilmInfo> filmList
			) {
		this.context = context;
		this.filmList = filmList;
		mLayoutInflater=LayoutInflater.from(context);
		//this.options = options;
		//this.imageLoader = imageLoader;
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
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position % filmList.size();
	}

	@Override
	public View getCoverFlowItem(int position, View container,
			ViewGroup parent) {
		View view =mLayoutInflater.inflate(R.layout.item_flow, parent, false);
		//ImageView imageView = (ImageView) reusableView;
		//
		//if (imageView == null) {
		//	imageView = new ImageView(context);
		//}
		//imageView.setLayoutParams(new Gallery.LayoutParams(180, 240));
		//imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		//;
		//Glide.with(context).load(filmList.get(position%filmList.size()).getFilmImageLink()).into(imageView);
		//
		//// �첽����ͼƬ
		//imageLoader.displayImage(filmList.get(position % filmList.size())
		//		.getFilmImageLink(), imageView, options);
		return view;
	}

}