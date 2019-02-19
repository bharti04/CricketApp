package com.example.cricketapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cricketapp.DataModal
import com.example.cricketapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_match_layout.view.*

class MatchAdapter(val items : ArrayList<DataModal>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var needrun=""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val contentItemView = LayoutInflater.from(parent.context).inflate(
                R.layout.single_match_layout, parent, false)
        return ViewHolder(contentItemView)    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemsData = items!![position]
        val viewHolder =holder  as ViewHolder

        viewHolder.runt1.text = itemsData.t1run+"/"+itemsData.t1viket+"("+itemsData.t1over+")"
        viewHolder.runt2.text = itemsData.t2run+"/"+itemsData.t2viket+"("+itemsData.t2over+")"
        viewHolder.runtowin.text = itemsData.needruntowin
        viewHolder.t1annt2name.text = itemsData.t1name+"v/s"+itemsData.t2name
       /* Picasso.with(context).load(itemsData.t1flag).into(viewHolder.flagt1mage);
        Picasso.with(context).load(itemsData.t2flag).into(viewHolder.flagt2mage);
*/
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val flagt1mage = view.flaget1
        val flagt2mage = view.flaget2
        val runt1 = view.runt1
        val runt2 = view.runt2
        val runtowin = view.runtowin_tv
        val t1annt2name = view.t1vst2

        // val itemimage = view.item_image

    }
    fun needRun(run:Int):Int{
        var needrun1=run+1
        return needrun1
    }
    fun Run(t1run:Int,t2run:Int):Int{
        var needrun2=t1run.toInt()-t2run.toInt()
        return needrun2
    }
    fun balls(t2over:Int):Int{
        var needrun3=t2over*6
        return needrun3
    }


}