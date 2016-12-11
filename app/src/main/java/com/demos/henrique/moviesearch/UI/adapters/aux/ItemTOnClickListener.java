package com.demos.henrique.moviesearch.UI.adapters.aux;

import android.os.Parcelable;
import android.view.View;

/**
 * Created by henrique on 11-12-2016.
 */

public interface ItemTOnClickListener<T extends DoubleListable & Parcelable> extends View.OnClickListener
{
    public void setItem(T item);
}
