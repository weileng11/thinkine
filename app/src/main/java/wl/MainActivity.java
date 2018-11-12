package wl;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import wl.base.BaseTitleActivity;
import wl.thinkine.R;

public class MainActivity extends BaseTitleActivity
{
	@BindView(R.id.toolbar_title_text)
	TextView toolbarTitleText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbarTitleText.setText("首页");
	}
}
