package com.root.crosx.ui.retrofit;

import android.view.View;
import android.widget.Button;

import com.root.crosx.BaseActivity;
import com.root.crosx.R;
import com.root.crosx.bean.BaseResult;
import com.root.crosx.network.HttpPostService;
import com.root.crosx.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by CrosX on 2017/6/23.
 */

public class RetrofitActivity extends BaseActivity {

    private Button asd;

    @Override
    public int setLayoutId() {
        return R.layout.activiry_retrofit;
    }

    @Override
    public void initView() {
        asd = $(R.id.asd);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        asd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://114.55.74.89/dapail/")
                        .addConverterFactory(FastJsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                HttpPostService service = retrofit.create(HttpPostService.class);
                Observable<BaseResult> call = service.getCode("13160058535", "打牌啦用户端", "2");
                call.subscribe(new Subscriber<BaseResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseResult baseResult) {
                        if (baseResult.isSuccess()) {
                            ToastUtil.show("success");
                        } else {
                            ToastUtil.show(baseResult.getMsg());
                        }
                    }
                });
            }
        });
    }
}
