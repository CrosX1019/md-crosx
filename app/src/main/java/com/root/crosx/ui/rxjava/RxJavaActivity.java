package com.root.crosx.ui.rxjava;

import com.root.crosx.BaseActivity;
import com.root.crosx.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by CrosX on 2017/6/16.
 * rxJava解读 @扔物线
 * {@link "http://gank.io/post/560e15be2dca930e00da1083#toc_31"}
 * 1. 概念：扩展的观察者模式
 * RxJava 的异步实现，是通过一种扩展的观察者模式来实现的。
 * 观察者模式
 * 先简述一下观察者模式，已经熟悉的可以跳过这一段。
 * 观察者模式面向的需求是：A 对象（观察者）对 B 对象（被观察者）的某种变化高度敏感，需要在 B 变化的一瞬间做出反应。
 * 举个例子，新闻里喜闻乐见的警察抓小偷，警察需要在小偷伸手作案的时候实施抓捕。
 * 在这个例子里，警察是观察者，小偷是被观察者，警察需要时刻盯着小偷的一举一动，才能保证不会漏过任何瞬间。
 * 程序的观察者模式和这种真正的『观察』略有不同，
 * 观察者不需要时刻盯着被观察者（例如 A 不需要每过 2ms 就检查一次 B 的状态），
 * 而是采用注册(Register)或者称为订阅(Subscribe)的方式，告诉被观察者：我需要你的某某状态，你要在它变化的时候通知我。
 * Android 开发中一个比较典型的例子是点击监听器 OnClickListener 。
 * 对设置 OnClickListener 来说， View 是被观察者， OnClickListener 是观察者，二者通过 setOnClickListener() 方法达成订阅关系。
 * 订阅之后用户点击按钮的瞬间，Android Framework 就会将点击事件发送给已经注册的 OnClickListener 。
 * 采取这样被动的观察方式，既省去了反复检索状态的资源消耗，也能够得到最高的反馈速度。
 * 当然，这也得益于我们可以随意定制自己程序中的观察者和被观察者，而警察叔叔明显无法要求小偷『你在作案的时候务必通知我』。
 * <p>
 * RxJava 的观察者模式
 * RxJava 有四个基本概念：Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
 * Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
 * 与传统观察者模式不同， RxJava 的事件回调方法除了普通事件 onNext() （相当于 onClick() / onEvent()）之外，还定义了两个特殊的事件：onCompleted() 和 onError()。
 * onCompleted(): 事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
 * onError(): 事件队列异常。在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出。
 * 在一个正确运行的事件序列中, onCompleted() 和 onError() 有且只有一个，并且是事件序列中的最后一个。
 * 需要注意的是，onCompleted() 和 onError() 二者也是互斥的，即在队列中调用了其中一个，就不应该再调用另一个。
 */

public class RxJavaActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    /**
     * Observer 即观察者，它决定事件触发的时候将有怎样的行为。
     */
    private void initObserver() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
