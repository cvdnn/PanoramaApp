package com.deepai.paipai.support.imageloader;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class UniversalImageLoadTool {
    private static ImageLoader imageLoader = ImageLoader.getInstance();

    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    public static boolean checkImageLoader() {
        return imageLoader.isInited();
    }

    public static void disPlay(String uri, ImageAware imageAware, int default_pic, Context context) {
        DisplayImageOptions options = new Builder().showImageOnLoading(default_pic).showImageForEmptyUri(default_pic).showImageOnFail(default_pic).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context, imageLoader);
        imageLoader.displayImage(uri, imageAware, options);
    }

    public static void disPlay(String uri, ImageView imageview, int resource, Context context) {
        DisplayImageOptions options = new Builder().showImageOnLoading(resource).showImageForEmptyUri(resource).showImageOnFail(resource).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context, imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

    public static void disPlay(String uri, ImageView imageview, Context context, int resource) {
        DisplayImageOptions options = new Builder().showImageOnLoading(resource).showImageForEmptyUri(resource).showImageOnFail(resource).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context, imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

    public static void disRoundedPlay(String uri, ImageView imageview, int default_pic, Context context) {
        DisplayImageOptions options = new Builder().showImageOnLoading(default_pic).showImageForEmptyUri(default_pic).showImageOnFail(default_pic).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).displayer(new RoundedBitmapDisplayer(15)).build();
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context, imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

    public static void disCirclePlay(String uri, ImageView imageview, int default_pic, Context context) {
        DisplayImageOptions options = new Builder().showImageOnLoading(default_pic).showImageForEmptyUri(default_pic).showImageOnFail(default_pic).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).displayer(new CircleBitmapDisplayer()).build();
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context, imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

    public static void clear() {
        imageLoader.clearMemoryCache();
        imageLoader.clearDiskCache();
    }

    public static void resume() {
        imageLoader.resume();
    }

    public static void pause() {
        imageLoader.pause();
    }

    public static void stop() {
        imageLoader.stop();
    }

    public static void destroy() {
        imageLoader.destroy();
    }
}
