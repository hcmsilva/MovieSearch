package com.demos.henrique.moviesearch.UI.adapters.holders;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.UI.MovieDetailActivity;
import com.demos.henrique.moviesearch.UI.adapters.aux.DoubleListable;
import com.demos.henrique.moviesearch.UI.adapters.aux.ItemTOnClickListener;
import com.demos.henrique.moviesearch.UI.adapters.aux.OnItemClickListener;
import com.demos.henrique.moviesearch.model.MovieResult;
import com.squareup.picasso.Picasso;

/**
 * Created by henrique on 09-12-2016.
 */

public class ItemHolder<T extends DoubleListable & Parcelable> extends BaseViewHolder<T> {

    public TextView mainText;
    public TextView smallText;
    public ImageView thumbnailImage;
    private Context ctx;

    T item;



    public ItemHolder(View itemView, Context ctx) {
        super(itemView);

        thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
        mainText = (TextView) itemView.findViewById(R.id.text1);
        smallText = (TextView) itemView.findViewById(R.id.text2);
        this.ctx = ctx;
    }



    @Override
    public void onBind(T mRes)
    {

        item = mRes;
        mainText.setText(item.getMainText());
        smallText.setText(item.getSmallText());

        if(item.getThumbUrl().contains("http"))
            Picasso.with((ctx)).load(item.getThumbUrl())
                    .resize(150,150)
                    .centerCrop()
                    .into(thumbnailImage);
        else
            Picasso.with((ctx)).load(ctx.getString(R.string.no_thumbnail_img_url))
                    .resize(150,150)
                    .centerCrop()
                    .into(thumbnailImage);

        setListener();
    }


    private void setListener() {

        ItemTOnClickListener<T> genericOnClickListener = new OnItemClickListener<T>(
                ctx,
                MovieDetailActivity.class,
                ctx.getString(R.string.movie_result_key));

        genericOnClickListener.setItem(item);
        itemView.setOnClickListener(genericOnClickListener);
    }

}















