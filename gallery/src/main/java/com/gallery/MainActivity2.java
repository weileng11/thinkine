package com.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.gallery.coverflow.JustCoverFlowActivity;
import com.gallery.coverflow.recyclerview.RecyclerViewActivity;
import com.gallery.coverflow.viewpager.ViewpagerActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onJustCoverFlowClick(View view) {
        Intent intent = new Intent(this, JustCoverFlowActivity.class);
        startActivity(intent);
    }

    public void onViewPagerClick(View view) {
        Intent intent = new Intent(this, ViewpagerActivity.class);
        startActivity(intent);
    }

    public void onRecyclerViewClick(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

}
