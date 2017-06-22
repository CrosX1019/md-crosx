package com.root.crosx.ui.rxjava;

import android.widget.Button;

import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.root.crosx.BaseActivity;
import com.root.crosx.R;
import com.root.crosx.bean.TestParent;
import com.root.crosx.bean.TestSub;
import com.root.crosx.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;


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

    private Observer<String> observer;

    private Subscriber<String> subscriber;

    @Override
    public int setLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        initObserver();
        initObservable();
    }

    @Override
    public void initListener() {

    }

    /**
     * RxJava 的观察者模式
     * RxJava 有四个基本概念：
     * Observable (可观察者，即被观察者)
     * Observer (观察者)
     * subscribe (订阅)
     * 事件。
     * Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
     * 与传统观察者模式不同，
     * RxJava 的事件回调方法除了普通事件 onNext() （相当于 onClick() / onEvent()）之外，
     * 还定义了两个特殊的事件：onCompleted() 和 onError()。
     * onCompleted():
     * 事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。
     * RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
     * onError():
     * 事件队列异常。在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出。
     * 在一个正确运行的事件序列中, onCompleted() 和 onError() 有且只有一个，并且是事件序列中的最后一个。
     * 需要注意的是，onCompleted() 和 onError() 二者也是互斥的，即在队列中调用了其中一个，就不应该再调用另一个。
     * <p>
     * <p>
     * RxJava 的基本实现主要有三点：
     * 1.创建 Observer
     * Observer 即观察者，它决定事件触发的时候将有怎样的行为。
     * 除了 Observer 接口之外，RxJava 还内置了一个实现了 Observer 的抽象类：Subscriber。
     * Subscriber 对 Observer 接口进行了一些扩展，但他们的基本使用方式是完全一样的
     */

    private void initObserver() {
        //Observer
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogUtil.i("Completed!");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.e("Error! e : " + e);
            }

            @Override
            public void onNext(String s) {
                LogUtil.i("item : " + s);
            }
        };

        /**
         * Subscriber和Observer的主要区别
         *
         * 1.onStart(): 这是 Subscriber 增加的方法。
         * 它会在 subscribe 刚开始，而事件还未发送之前被调用，可以用于做一些准备工作，例如数据的清零或重置。
         * 这是一个可选方法，默认情况下它的实现为空。
         * 需要注意的是，如果对准备工作的线程有要求（例如弹出一个显示进度的对话框，这必须在主线程执行）
         * onStart() 就不适用了，因为它总是在 subscribe 所发生的线程被调用，而不能指定线程。
         * 要在指定的线程来做准备工作，可以使用 doOnSubscribe() 方法，具体可以在后面的文中看到。
         * 2.unsubscribe(): 这是 Subscriber 所实现的另一个接口 Subscription 的方法
         * 用于取消订阅。在这个方法被调用后，Subscriber 将不再接收事件。
         * 一般在这个方法调用前，可以使用 isUnsubscribed() 先判断一下状态。
         * unsubscribe() 这个方法很重要，因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
         * 这个引用如果不能及时被释放，将有内存泄露的风险。
         * 所以最好保持一个原则：
         * 要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。
         */
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtil.i("Completed!");

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.e("Error! e : " + e);
            }

            @Override
            public void onNext(String s) {
                LogUtil.i("item : " + s);
            }
        };

    }

    /**
     * 2.创建 Observable
     * Observable 即被观察者，它决定什么时候触发事件以及触发怎样的事件。
     */
    private void initObservable() {
//        //1.create方法
//        Observable<String> observable0 = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("One");
//                subscriber.onNext("Two");
//                subscriber.onNext("Three");
//                subscriber.onCompleted();
//            }
//        });
//        //2.just方法
//        Observable<String> observable1 = Observable.just("One","Two","Three");
//        /*
//            相当于：
//            onNext("One");
//            onNext("Two");
//            onNext("Three");
//            onCompleted();
//         */
//
//        //3.from方法
//        String[] content = {"One", "Two", "Three"};
//        Observable<String> observable2 = Observable.from(content);
//
//        /**
//         * 3. Subscribe (订阅)
//         * 创建了 Observable 和 Observer 之后，再用 subscribe() 方法将它们联结起来，整条链子就可以工作了。
//         */
//
//        observable0.subscribe(observer);
//        observable1.subscribe(subscriber);
//        observable2.subscribe(subscriber);
//
//
//        Observable<Integer> integerObservable  = Observable.just(1,2,3);
//
//        integerObservable.map(new Func1<Integer, String>() {
//
//            @Override
//            public String call(Integer integer) {
//                return integer+"哈哈哈";
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                LogUtil.i(s);
//            }
//        });

        List<TestParent> testList = new ArrayList<>();

        TestParent testParent = new TestParent();
        testParent.setName("部落");

        List<TestSub> subList = new ArrayList<>();
        TestSub sub0 = new TestSub();
        sub0.setName("兽人");
        TestSub sub1 = new TestSub();
        sub1.setName("巨魔");
        TestSub sub2 = new TestSub();
        sub2.setName("亡灵");
        TestSub sub3 = new TestSub();
        sub3.setName("血精灵");
        TestSub sub4 = new TestSub();
        sub4.setName("牛头人");
        TestSub sub5 = new TestSub();
        sub5.setName("地精");

        subList.add(sub0);
        subList.add(sub1);
        subList.add(sub2);
        subList.add(sub3);
        subList.add(sub4);
        subList.add(sub5);

        testParent.setSubList(subList);

        testList.add(testParent);

        TestParent[] t = testList.toArray(new TestParent[testList.size()]);


        Observable<TestParent> o = Observable.from(t);

        Subscriber<TestSub> s = new Subscriber<TestSub>() {
            @Override
            public void onCompleted() {
                LogUtil.i("成功");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TestSub testSub) {
                LogUtil.i(testSub.getName());
            }
        };

        o.flatMap(new Func1<TestParent, Observable<TestSub>>() {
            @Override
            public Observable<TestSub> call(TestParent testParent) {

                return Observable.from(testParent.getSubList());
            }
        })
                .subscribe(s);


    }
}
