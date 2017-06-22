package com.root.crosx.network;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by CrosX on 2017/6/20.
 */

public class NetWork {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory fastJsonConverterFactory = FastJsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
}
