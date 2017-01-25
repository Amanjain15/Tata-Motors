package com.tata.motors.helper.image_loader;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by aman on 31/12/16.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView, ProgressBar progressBar);
}
