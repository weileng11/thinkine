package com.gallery;

import com.gallery.model.FilmInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LittleLiByte
 * 测试数据
 */
public class FilmInfoTest {
	
	public static String[] urls = new String[] {
			//			"http://img31.mtime.cn/mg/2014/09/01/093630.14934540_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/09/30/145438.41392832_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/09/09/095439.24895990_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/10/13/151034.85474901_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/09/23/084444.96794628_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/08/15/104026.33444853_270X405X4.jpg",
			//			"http://img31.mtime.cn/mg/2014/09/26/151251.44963343_270X405X4.jpg"
		
	};
	
	//	// 图片数组
	//		private static int[] resIds = new int[] { R.drawable.gallery_photo_1, R.drawable.gallery_photo_2,
	//				R.drawable.gallery_photo_3, R.drawable.gallery_photo_4, R.drawable.gallery_photo_5,
	//				};
	
	// 图片数组
	private static int[] resIds = new int[] { R.drawable.ic_1, R.drawable.ic_2,
			R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5
	};
	
	public static String[] names = new String[] { "银河护卫队", "3D食人虫", "心花路放",
			"忍者神龟", "移动迷宫"
	};
	
	public static List<FilmInfo> getfilmInfo() {
		List<FilmInfo> filmList = new ArrayList<FilmInfo>();
		for (int i = 0; i < 5; i++) {
			FilmInfo film = new FilmInfo(names[i], null,null,resIds[i]);
			filmList.add(film);
		}
		return filmList;
	}
}
