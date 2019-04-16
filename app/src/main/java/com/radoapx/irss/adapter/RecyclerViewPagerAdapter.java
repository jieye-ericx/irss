package com.radoapx.irss.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.radoapx.irss.R;
import com.radoapx.irss.activity.MainActivity;
import com.radoapx.irss.activity.WebViewActivity;
import com.radoapx.irss.db.StaredRssItem;
import com.radoapx.irss.utils.MyImageView;

import java.util.List;

public class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.ViewHolder> {

    private List<StaredRssItem> list;
    //    private List<RSSItem> mData;
    private Context mContext;

    public RecyclerViewPagerAdapter(List<StaredRssItem> list, Context context) {
        this.list = list;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView des;
        MyImageView imageView;
        TextView date;
        TextView type;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.rss_title);
            date = (TextView) view.findViewById(R.id.rss_time);
            type = (TextView) view.findViewById(R.id.rss_type);
            imageView=(MyImageView) view.findViewById(R.id.card_view_image);
//            des = (TextView) view.findViewById(R.id.rss_des);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_cardview, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StaredRssItem rssItem = list.get(position);
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                mContext.startActivity(intent);
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.setData(Uri.parse(rssItem.getLink()));
                intent.putExtra("position", position);
                intent.putExtra("isStared",rssItem.getIsStared());
                ((MainActivity) mContext).startActivityForResult(intent, 1);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StaredRssItem rssItem = list.get(position);
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                mContext.startActivity(intent);
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.setData(Uri.parse(rssItem.getLink()));
                intent.putExtra("position", position);
                intent.putExtra("isStared",rssItem.getIsStared());
                ((MainActivity) mContext).startActivityForResult(intent, 1);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StaredRssItem rssItem = list.get(i);
        viewHolder.title.setText(rssItem.getTitle());
        viewHolder.date.setText(rssItem.getPubDate());
        viewHolder.type.setText(rssItem.getCategory());
//        handleImageURI(rssItem.getDescription());
        String s=handleImageURI(rssItem.getDescription());
        if(s.equals("")){
            viewHolder.imageView.setImageResource(R.drawable.not_found);
        }else{
            viewHolder.imageView.setImageURL(s);
        }

//        viewHolder.des.setText(rssItem.getDescription());
    }

    public String handleImageURI(String s){
        if(s==null) return "";
        String suri="",c="i";
        int flag=0;
        for(int i=0;i<s.length();i++){
//            Log.e("33333333333333", "handleImageURI: "+s.substring(i+11,i+13) );
//            break;
            if(i+8>=s.length()) break;
            if(s.substring(i,i+8).equals("img src=")){
//                Log.e("44444444444444", "handleImageURI: "+s.substring(i,i+8)+"  ====" );
                c=s.substring(i+8,i+9);
                for(int j=i+9;;j++){
                    if(s.substring(j,j+1).equals(c)){
                        flag=1;
                        break;
                    }
                    suri+=s.substring(j,j+1);
                }
            }
            if(flag==1) break;
        }
//        Log.e("222222222222222", "handleImageURI: "+suri );
//        Uri uri = Uri.parse(suri);
        return suri;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}