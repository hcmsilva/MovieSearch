package com.demos.henrique.moviesearch.UI.adapters.holders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.UI.adapters.aux.DoubleListable;
import com.squareup.picasso.Picasso;

/**
 * Created by henrique on 09-12-2016.
 */

public class ItemHolder<T extends DoubleListable> extends BaseViewHolder<T> {

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
    }

}














