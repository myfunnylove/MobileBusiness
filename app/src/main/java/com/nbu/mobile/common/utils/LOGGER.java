package com.nbu.mobile.common.utils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

/**
 * Created by Sarvar on 31.08.2017.
 */

public class LOGGER {

    private static final boolean DEBUG = true;

    public static void d(String msg){
        if (DEBUG){

            LogUtils.d(msg);
        }

    }
}
