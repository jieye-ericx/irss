package com.radoapx.irss.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.radoapx.irss.R;
import com.radoapx.irss.model.RecyclerViewFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainAcitivity";
    public static int TAPS = 3;

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlowManager.init(this);
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FlowManager.destroy();
    }

    private void initData() {
//        getRssData();
    }

    //------------------------------------------------------------------------
    private void initView(){
        mViewPager =findViewById(R.id.materialViewPager);
        toolbar = mViewPager.getToolbar();
    }
    //---------------------------------------------------------------------------
    private void initEvent(){
        //点击不同tab时
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(R.color.blue, ContextCompat.getDrawable(MainActivity.this, R.drawable.daily));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(R.color.green, ContextCompat.getDrawable(MainActivity.this, R.drawable.sspai));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(R.color.cyan,ContextCompat.getDrawable(MainActivity.this, R.drawable.pengai));
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(R.color.lime,ContextCompat.getDrawable(MainActivity.this, R.drawable.star_a));

                }
//四种设置图片的方法
//        HeaderDesign.fromColorAndUrl(Color.BLUE,"http:...);
//        HeaderDesign.fromColorResAndUrl(R.color.blue,"http:...);
//        HeaderDesign.fromColorAndDrawable(Color.BLUE,myDrawable);
//        HeaderDesign.fromColorResAndDrawable(R.color.blue,myDrawable);
                //execute others actions if needed (ex : modify your header logo)
                return null;
            }
        });
        //设置toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(false);

        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position ) {
                    case 0:
                        return RecyclerViewFragment.newInstance(MainActivity.this,"https://www.qdaily.com/feed");
                    case 1:
                        return RecyclerViewFragment.newInstance(MainActivity.this,"https://sspai.com/feed");
                    case 2:
                        return RecyclerViewFragment.newInstance(MainActivity.this,"https://www.ruanyifeng.com/blog/atom.xml");
//                    case 3:
//                        return RecyclerViewFragment.newInstance(MainActivity.this,"https://feedmaker.kindle4rss.com/feeds/choice.thepaper.xml");
//                    case 4:
//                        return RecyclerViewFragment.newInstance(MainActivity.this,"http://feedmaker.kindle4rss.com/feeds/hot.infzm.com.xml");
                    default:
//                        Log.e(TAG, "getItem: "+position );
////                        return RecyclerViewFragment.newInstance(MainActivity.this,"https://sspai.com/feed");
                        return new Fragment();
                }
            }

            @Override
            public int getCount() {
                return TAPS;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % TAPS) {
                    case 0:
                        return "好奇心日报";
                    case 1:
                        return "少数派";
                    case 2:
                        return "阮一峰博客";
                    default:
                            return "空空";
                }
            }
        });

        //设置setViewPager
        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
//                    Log.e("1", "run:---------> "+ dataStringExtra2);
                    int isStared=data.getIntExtra("isStared",-1);
                    if(isStared!=1&&isStared!=0) Toast.makeText(this,"返回主活动时发生错误",Toast.LENGTH_SHORT).show();
                    int position=data.getIntExtra("position",-1);
                    if(isStared==1){
                        // TODO: 2019/4/15
                    }else{

                    }
//                    Toast.makeText(this,"运行到了",Toast.LENGTH_SHORT).show();
//                    list.get(position).save();
                }
                break;
            default:
                break;
        }
    }
}
