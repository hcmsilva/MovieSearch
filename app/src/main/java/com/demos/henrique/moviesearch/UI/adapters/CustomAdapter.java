package com.demos.henrique.moviesearch.UI.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.UI.adapters.aux.DataGetter;
import com.demos.henrique.moviesearch.UI.adapters.aux.DoubleListable;
import com.demos.henrique.moviesearch.UI.adapters.aux.ItemTOnClickListener;
import com.demos.henrique.moviesearch.UI.adapters.holders.ItemHolder;

import java.util.List;

/**
 * Created by henrique on 09-12-2016.
 */

public class CustomAdapter<T extends DoubleListable & Parcelable> extends RecyclerView.Adapter<ItemHolder<T>>
{



    List<T> dataSet;
    DataGetter getter;
    Context ctx;
    private ItemTOnClickListener<T> genOnClickListener;

    public CustomAdapter(List<T> data, DataGetter host, Context ctx)
    {
        dataSet = data;
        getter = host;
        this.ctx = ctx;
    }


    @Override
    public ItemHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {


        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);

        return new ItemHolder<>(rowView, ctx);
    }

    @Override
    public void onBindViewHolder(ItemHolder<T> holder, int position) {
        T item = getItemAtDataSetPosition(position);
        holder.onBind(item);

        if(position == getDataSet().size()-1 )
        {
            getter.getNextPage();
        }
    }

    @Override
    public int getItemCount() {

        return dataSet.size();
    }



    public T getItemAtDataSetPosition(int position) {
        return dataSet.get(position);
    }

    public List<T> getDataSet() {
        return dataSet;
    }

    private void setDataSet(List<T> dataSet) {
        this.dataSet = dataSet;
        this.notifyDataSetChanged();
    }



    public void resetDataSet()
    {
        int itemCount = dataSet.size();
        dataSet.clear();
        //this.notifyItemRangeRemoved(0,itemCount-1);
        notifyDataSetChanged();
    }


}
