package com.popular.practice.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.popular.R;
import com.popular.comm.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.richeditor.RichEditor;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.practice.ui
 * @description:
 * @date: 2019/1/9  
 * @time: 16:12
 */
public class RicheditorAct extends BaseActivity
{
	@BindView(R.id.editor)
	RichEditor mEditor;
	@BindView(R.id.action_undo)
	ImageButton mActionUndo;
	@BindView(R.id.action_redo)
	ImageButton mActionRedo;
	@BindView(R.id.action_bold)
	ImageButton mActionBold;
	@BindView(R.id.action_italic)
	ImageButton mActionItalic;
	@BindView(R.id.action_subscript)
	ImageButton mActionSubscript;
	@BindView(R.id.action_superscript)
	ImageButton mActionSuperscript;
	@BindView(R.id.action_strikethrough)
	ImageButton mActionStrikethrough;
	@BindView(R.id.action_underline)
	ImageButton mActionUnderline;
	@BindView(R.id.action_heading1)
	ImageButton mActionHeading1;
	@BindView(R.id.action_heading2)
	ImageButton mActionHeading2;
	@BindView(R.id.action_heading3)
	ImageButton mActionHeading3;
	@BindView(R.id.action_heading4)
	ImageButton mActionHeading4;
	@BindView(R.id.action_heading5)
	ImageButton mActionHeading5;
	@BindView(R.id.action_heading6)
	ImageButton mActionHeading6;
	@BindView(R.id.action_txt_color)
	ImageButton mActionTxtColor;
	@BindView(R.id.action_bg_color)
	ImageButton mActionBgColor;
	@BindView(R.id.action_indent)
	ImageButton mActionIndent;
	@BindView(R.id.action_outdent)
	ImageButton mActionOutdent;
	@BindView(R.id.action_align_left)
	ImageButton mActionAlignLeft;
	@BindView(R.id.action_align_center)
	ImageButton mActionAlignCenter;
	@BindView(R.id.action_align_right)
	ImageButton mActionAlignRight;
	@BindView(R.id.action_insert_bullets)
	ImageButton mActionInsertBullets;
	@BindView(R.id.action_insert_numbers)
	ImageButton mActionInsertNumbers;
	@BindView(R.id.action_blockquote)
	ImageButton mActionBlockquote;
	@BindView(R.id.action_insert_image)
	ImageButton mActionInsertImage;
	@BindView(R.id.action_insert_link)
	ImageButton mActionInsertLink;
	@BindView(R.id.action_insert_checkbox)
	ImageButton mActionInsertCheckbox;
	@BindView(R.id.preview)
	TextView mPreview;
	
	@Override
	public int getLayoutRes(){
		return R.layout.act_richeditor;
	}
	
	@Override
	public void initView(){
		//初始化编辑高度
		mEditor.setEditorHeight(200);
		//初始化字体大小
		mEditor.setEditorFontSize(22);
		//初始化字体颜色
		mEditor.setEditorFontColor(Color.BLACK);
		//mEditor.setEditorBackgroundColor(Color.BLUE);
		mEditor.setBold();//设置粗体
		mEditor.setItalic();//设置斜体
		//初始化内边距
		mEditor.setPadding(10, 10, 10, 10);
		//设置编辑框背景，可以是网络图片
		// mEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
		mEditor.setBackgroundColor(Color.BLUE);
		//mEditor.setBackgroundResource(R.drawable.bg);
		//设置默认显示语句
		mEditor.setPlaceholder("Insert text here...");
		//设置编辑器是否可用
		mEditor.setInputEnabled(true);
		mPreview=(TextView)findViewById(R.id.preview);
		mEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener()
		{
			@Override
			public void onTextChange(String text){
				mPreview.setText(text);
			}
		});
		mActionUndo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.undo();
			}
		});
		mActionRedo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.redo();
			}
		});
		mActionBold.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setBold();
			}
		});
		mActionItalic.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setItalic();
			}
		});
		mActionSubscript.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setSubscript();
			}
		});
		mActionSuperscript.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setSuperscript();
			}
		});
		mActionStrikethrough.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setStrikeThrough();
			}
		});
		mActionUnderline.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setUnderline();
			}
		});
		mActionHeading1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(1);
			}
		});
		mActionHeading2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(2);
			}
		});
		mActionHeading3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(3);
			}
		});
		mActionHeading4.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(4);
			}
		});
		mActionHeading5.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(5);
			}
		});
		mActionHeading6.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setHeading(6);
			}
		});
		mActionTxtColor.setOnClickListener(new View.OnClickListener()
		{
			private boolean isChanged;
			
			@Override
			public void onClick(View v){
				mEditor.setTextColor(isChanged? Color.BLACK: Color.RED);
				isChanged=!isChanged;
			}
		});
		mActionBgColor.setOnClickListener(new View.OnClickListener()
		{
			private boolean isChanged;
			
			@Override
			public void onClick(View v){
				mEditor.setTextBackgroundColor(isChanged? Color.TRANSPARENT: Color.YELLOW);
				isChanged=!isChanged;
			}
		});
		mActionIndent.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setIndent();
			}
		});
		mActionOutdent.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setOutdent();
			}
		});
		mActionAlignLeft.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setAlignLeft();
			}
		});
		mActionAlignCenter.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setAlignCenter();
			}
		});
		mActionAlignRight.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setAlignRight();
			}
		});
		mActionBlockquote.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setBlockquote();
			}
		});
		mActionInsertBullets.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setBullets();
			}
		});
		mActionInsertNumbers.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.setNumbers();
			}
		});
		mActionInsertImage.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.insertImage(
						"http://www.1honeywan.com/dachshund/image/7.21/7.21_3_thumb.JPG",
						"dachshund");
			}
		});
		mActionInsertLink.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.insertLink("https://github.com/wasabeef", "wasabeef");
			}
		});
		mActionInsertCheckbox.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v){
				mEditor.insertTodo();
			}
		});
	}
	
	@Override
	public void initListener(){
	}
	
	@Override
	public void initData(){
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}
}
