package com.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.gallery.fancycoverflow.FancyCoverFlowAdapter;
import com.gallery.model.FilmInfo;
import java.util.List;

/**
 * @author LittleLiByte
 *
 */
public class ImageAdapter1 extends FancyCoverFlowAdapter
{
	private Context context;
	private List<FilmInfo> filmList;
	//private ImageLoader imageLoader;
	//private DisplayImageOptions options;

	public ImageAdapter1(Context context, List<FilmInfo> filmList
			) {
		this.context = context;
		this.filmList = filmList;
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
	public View getCoverFlowItem(int position, View reusableView,
			ViewGroup parent) {
		ImageView imageView = (ImageView) reusableView;
		if (imageView == null) {
			imageView = new ImageView(context);
		}
		// ps.电影海报宽高比例一般为3：4
		imageView.setLayoutParams(new Gallery.LayoutParams(180, 240));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		Glide.with(context).load(filmList.get(position%filmList.size()).getFilmImageLink()).into(imageView);
		return imageView;
	}

}