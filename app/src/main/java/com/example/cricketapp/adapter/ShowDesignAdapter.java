package com.example.cricketapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricketapp.DataModal;
import com.example.cricketapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ntf-19 on 9/5/18.
 */

public class ShowDesignAdapter extends PagerAdapter {
    Context context;
   ArrayList<DataModal> contents;
    LayoutInflater layoutInflater;


    public ShowDesignAdapter(Context context, ArrayList<DataModal> contents) {
        this.context = context;
        this.contents = contents;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.viewpager_layout, container, false);
        DataModal dataModel = contents.get(position);
        ImageView flagt1 = (ImageView) itemView.findViewById(R.id.flagetteam1);
        ImageView flagt2 = (ImageView) itemView.findViewById(R.id.flagetteam2);
        TextView t1name = (TextView) itemView.findViewById(R.id.team1name_tv);
        TextView t2name = (TextView) itemView.findViewById(R.id.team2name_tv);
        TextView t1runandviket = (TextView) itemView.findViewById(R.id.team1runandviket_tv);
        TextView t2runandviket = (TextView) itemView.findViewById(R.id.team2runandviket_tv);
        TextView t1over = (TextView) itemView.findViewById(R.id.team1over_tv);
        TextView t2over = (TextView) itemView.findViewById(R.id.team2over_tv);
        TextView matchstatus = (TextView) itemView.findViewById(R.id.matchstatus_tv);

       /* Picasso.with(context).load(dataModel.getT2flag()).into(flagt2);
        Picasso.with(context).load(dataModel.getT1flag()).into(flagt1);*/
        t1name.setText(dataModel.getT1name());
        t2name.setText(dataModel.getT2name());
        t1runandviket.setText(dataModel.getT1run()+"/"+dataModel.getT1viket());
        t2runandviket.setText(dataModel.getT2run()+"/"+dataModel.getT2viket());
        t1over.setText(dataModel.getT1over());
        t2over.setText(dataModel.getT2over());
        matchstatus.setText(dataModel.getMstatus());







        container.addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}