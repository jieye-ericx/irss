package com.radoapx.irss.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.radoapx.irss.R;
import com.radoapx.irss.adapter.RecyclerViewPagerAdapter;
import com.radoapx.irss.db.StaredRssItem;
import com.radoapx.irss.utils.RSSFeed;
import com.radoapx.irss.utils.XmlPullParserUtil;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecyclerViewFragment extends Fragment {
    static Context mcontext;
    private String URL;

    public static Fragment newInstance(Context mcontext,String url) {
        RecyclerViewFragment.mcontext = mcontext;
        RecyclerViewFragment fragment=new RecyclerViewFragment();
        Bundle bundle=new Bundle();
        bundle.putString("URL",url);
        fragment.setArguments(bundle);
//        Log.e("22222222222222", "newInstance: "+RecyclerViewFragment.i );
        return fragment;
    }

    private List<RSSItem> dataList = new ArrayList<>();
    private List<StaredRssItem> list = new ArrayList<>();
    private final String TAG = "RecyclerViewFragment";
    private static final int RSS_MESSAGE = 1;

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        URL=getArguments().getString("URL");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        getRssData();
    }

    public void getRssData() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .get()
//                    .url("https://sspai.com/feed")
//                    .url("https://www.qdaily.com/feed")
                    .url(URL)
                    .build();
            Log.e(TAG, "getRssData: "+URL );

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d(TAG, "onFailure: " + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.d(TAG, "onSuccess: " + response.body().byteStream());
                    try {
                        RSSFeed rf = XmlPullParserUtil.parseXml(response.body().byteStream());
                        dataList = rf.getAllItems();
                        Message msg = new Message();
                        msg.what = RSS_MESSAGE;

                        uiHandler.sendMessage(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(mcontext, "网络错误", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler uiHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case RSS_MESSAGE:
                    list=new ArrayList<>();
                    for(RSSItem e:dataList){
                        StaredRssItem s=new StaredRssItem();
                        s.setLink(e.getLink());
                        s.setTitle(e.getTitle());
                        s.setDescription(e.getDescription());
                        s.setCategory(e.getCategory());
//                        Log.e(TAG, "handleMessage: "+e.getPubDate() );
                        s.setPubDate(e.getPubDate());
//                        Log.e(TAG, "handleMessage: "+s.getPubDate());
                        list.add(s);
                    }
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
                    mRecyclerView.setAdapter(new RecyclerViewPagerAdapter(list, mcontext));
                    break;
            }
        }
    };

}
