package com.root.crosx.network.api;

import com.root.crosx.BaseActivity;
import com.root.crosx.network.BaseApi;
import com.root.crosx.network.listener.HttpOnNextListener;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by CrosX on 2017/6/23.
 */

public class CodeApi extends BaseApi {

    private String phone;
    private String product;
    private String type;

    public CodeApi(HttpOnNextListener listener, BaseActivity baseActivity) {
        super(listener, baseActivity);
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        return null;
    }
}
