package com.root.crosx.network;

import com.root.crosx.bean.BaseResult;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by CrosX on 2017/6/23.
 */

public interface HttpPostService {

    @POST("user/code.action")
    Observable<BaseResult> getCode(@Query("phone") String phone, @Query("product") String produce, @Query("type") String type);


}
