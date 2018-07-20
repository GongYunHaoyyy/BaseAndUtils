package com.gongyunhao.baseandutils.provider;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * @author: Gong Yunhao
 * @version: V1.0
 * @date: 2018/7/13
 * @github https://github.com/GongYunHaoyyy
 * @blog https://www.jianshu.com/u/52a8fa1f29fb
 */
public interface IFileProvider {
    boolean saveImageToGallery(Context context, Bitmap bmp);

}
