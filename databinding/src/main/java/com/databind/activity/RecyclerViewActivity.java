package com.databind.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import com.databind.R;
import com.databind.adapter.MultiItemAdapter;
import com.databind.adapter.MyAdapter;
import com.databind.bean.FruitItem;
import com.databind.bean.IBaseBindingAdapterItem;
import com.databind.bean.TextItem;
import com.databind.databinding.ActivityRecyclerViewBinding;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private MultiItemAdapter mAdapter;
    private List<IBaseBindingAdapterItem> mList = new ArrayList<>(); //数据源
	
	private MyAdapter mMyAdapter;
	private List<FruitItem> fruitItemList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        initData();
        //mAdapter = new MultiItemAdapter(this, mList);
	    mMyAdapter = new MyAdapter(this, fruitItemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        //binding.recyclerView.setAdapter(mAdapter);
	    binding.recyclerView.setAdapter(mMyAdapter);
    }

    private void initData() {
        mList.add(new TextItem("标题1"));
        mList.add(new FruitItem(R.mipmap.fruit, "苹果"));
        mList.add(new FruitItem(R.mipmap.fruit, "香蕉"));
        mList.add(new TextItem("标题2"));
        mList.add(new TextItem("标题3"));
        mList.add(new FruitItem(R.mipmap.fruit, "桃子"));
        mList.add(new TextItem("标题4"));
        mList.add(new FruitItem(R.mipmap.fruit, "梨"));
        mList.add(new TextItem("标题5"));
        
        
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "1"));
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "2"));
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "1"));
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "1"));
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "1"));
	    fruitItemList.add(new FruitItem(R.mipmap.fruit, "1"));
    }
}
