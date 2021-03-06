package com.gallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import com.gallery.fancycoverflow.FancyCoverFlow;
import com.gallery.model.FilmInfo;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author LittleLiByte
 * 
 */
public class MainActivity extends Activity {

	private FancyCoverFlow fancyCoverFlow;

	private List<FilmInfo> filmList;

	private ImageAdapter adapter;


	private int cur_index = 0;
	private int count_drawble;
	private static int MSG_UPDATE = 1;
	// 定时任务
	private ScheduledExecutorService scheduledExecutorService;

	//	// ͨ��handler������������
	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			if (msg.what == MSG_UPDATE) {
				fancyCoverFlow.setSelection(cur_index);
			}
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		filmList = FilmInfoTest.getfilmInfo();

		adapter = new ImageAdapter(this, filmList);

		fancyCoverFlow = (FancyCoverFlow) findViewById(R.id.fancyCoverFlow);

		fancyCoverFlow.setSpacing(-300);
		fancyCoverFlow.setAdapter(adapter);
		fancyCoverFlow.setSelection(1002);
		fancyCoverFlow.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				cur_index = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		fancyCoverFlow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						filmList.get(position % filmList.size()).getFilmName(),
						0).show();
			}
		});

		//count_drawble = adapter.getCount();
		//startPlay();
	}

	private void startPlay() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(new AutoPlayTask(), 1, 4,
				TimeUnit.SECONDS);
	}

	private void stopPlay() {
		scheduledExecutorService.shutdown();
	}

	private class AutoPlayTask implements Runnable {

		@Override
		public void run() {

			cur_index = cur_index % count_drawble; // ͼƬ����[0,count_drawable)
			Message msg = handler.obtainMessage(MSG_UPDATE);
			handler.sendMessage(msg);
			cur_index++;
		}

	}

}