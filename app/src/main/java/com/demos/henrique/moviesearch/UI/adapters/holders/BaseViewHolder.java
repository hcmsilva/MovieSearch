package com.demos.henrique.moviesearch.UI.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by henrique on 09-12-2016.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{


    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    //abstract ItemHolder onCreate(ViewGroup parent, int viewType);

    //abstract void onBind(RecyclerView.ViewHolder holder, int position);

    abstract void onBind(T mRes);

}
