package com.demos.henrique.moviesearch.UI.adapters.aux;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by henrique on 11-12-2016.
 */

public class OnItemClickListener<T extends DoubleListable & Parcelable>
        implements ItemTOnClickListener<T> {

    private Context ctx;
    T item;
    Class actClass;
    String key;

    public OnItemClickListener(Context ctx, Class activityClass, String itemKey)
    {
        this.ctx = ctx;
        //this.item = item;
        this.key = itemKey;
        this.actClass = activityClass;
    }

    @Override
    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public void onClick(View view) {
        Intent starterIntent = new Intent(ctx, actClass);
        starterIntent.putExtra(key, item);

        ctx.startActivity(starterIntent);
    }

}
