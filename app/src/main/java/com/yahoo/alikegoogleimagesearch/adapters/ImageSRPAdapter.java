package com.yahoo.alikegoogleimagesearch.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yahoo.alikegoogleimagesearch.R;
import com.yahoo.alikegoogleimagesearch.models.ImageSRP;

import java.util.List;

/**
 * Created by aliku on 2015/8/6.
 */
public class ImageSRPAdapter extends ArrayAdapter<ImageSRP> {

    public ImageSRPAdapter(Context context, List<ImageSRP> images) {
        super(context, R.layout.item_image_srp, images);
    }

    @Override
    public View getView(int position, View cView, ViewGroup parent) {
        ImageSRP imageInfo = getItem(position);

        if (cView == null) {
            cView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_srp, parent, false);
        }

        ImageView ivImage = (ImageView) cView.findViewById(R.id.ivImage);
        TextView tvTitle = (TextView) cView.findViewById(R.id.tvTitle);

        ivImage.setImageResource(0);
        Picasso.with(getContext()).load(imageInfo.thumbUrl).into(ivImage);
        tvTitle.setText(Html.fromHtml(imageInfo.title));

        return cView;
    }
}
