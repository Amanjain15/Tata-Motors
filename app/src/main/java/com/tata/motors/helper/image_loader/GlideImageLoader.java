package com.tata.motors.helper.image_loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by aman on 31/12/16.
 */

public class GlideImageLoader implements ImageLoader{

    private static final String TAG = "GlideImageLoader";
    Context mContext;
    private RequestManager requestManager;

    public GlideImageLoader(Context mContext) {

        this.mContext = mContext;
        requestManager = Glide.with(mContext);
    }

    @Override
    public void loadImage(String url, final ImageView imageView, final ProgressBar progressBar) {


        requestManager.load(url).crossFade().thumbnail(1f).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }

                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
                return false;
            }
        }).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //.animate(R.anim.image_animation)
                .fitCenter().crossFade().into(imageView);

    }




}
