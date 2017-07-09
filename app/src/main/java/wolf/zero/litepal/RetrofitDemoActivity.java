package wolf.zero.litepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author sineom
 * @version 1.0
 * @time 2017/7/8 16:38
 * @des ${TODO}
 * @updateAuthor ${Author}
 * @updataTIme 2017/7/8
 * @updataDes ${描述更新内容}
 */

public class RetrofitDemoActivity extends AppCompatActivity {

    private TextView mTextView;
    public static final String TAG = "RetrofitDemoActivity";
    private String mTitle;
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private SubscriberOnNextListener mSubscriberOnNextListener1;
    private SubscriberOnNextListener mSubscriberOnNextListener2;
    private SubscriberOnCompliteListener mCompliteListener;
    private List<Conment> conmentList;
    private List<Conment1> conmentList1;
    private List<Conment2> conmentList2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mTextView = (TextView) findViewById(R.id.text_show);

        mCompliteListener = new SubscriberOnCompliteListener() {
            @Override
            public void complite() {
                /*List<Conment> all = DataSupport.findAll(Conment.class);
                Log.i(TAG, "complite: "+all.size());
                Intent intent = new Intent(RetrofitDemoActivity.this, LoginActivity.class);
                startActivity(intent);*/
            }
        };
    }

    public void retrofit(View view) {

        // Subscriber<List<ResultMovieBean.SubjectsEntity>> subscriber = getListSubscriber();


        mSubscriberOnNextListener = new SubscriberOnNextListener<List<ResultMovieBean.SubjectsEntity>>() {
            @Override
            public void onNext(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
               /* try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < subjectsEntities.size(); i++) {
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getAlt());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getTitle());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getCasts().get(0).getName());
                }*/
                conmentList = DataSupport.findAll(Conment.class);

                if (conmentList != null) {
                    if (conmentList.size() == subjectsEntities.size()) {
                        Log.i(TAG, "onNext: " + "数据库大小一致");
                        Log.i(TAG, "onNext: " + conmentList.size());
                        return;
                    } else {
                        //DataSupport.deleteAll(Conment.class);
                        initSupportData(subjectsEntities);
                        Log.i(TAG, "onNext: " + "数据库有更新");
                        Log.i(TAG, "onNext: " + conmentList.size());
                    }
                } else {
                    initSupportData(subjectsEntities);
                    Log.i(TAG, "onNext: " + "数据库为空");
                    Log.i(TAG, "onNext: " + conmentList.size());
                }
//                conmentList.notifyAll();
                Log.i(TAG, "onNext: " + conmentList.size());
            //    mTextView.setText(subjectsEntities.get(5).getCasts().get(1).getName());
            }
        };
        mSubscriberOnNextListener1 = new SubscriberOnNextListener<List<ResultMovieBean.SubjectsEntity>>() {
            @Override
            public void onNext(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
               /* try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < subjectsEntities.size(); i++) {
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getAlt());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getTitle());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getCasts().get(0).getName());
                }*/
                conmentList1 = DataSupport.findAll(Conment1.class);

                if (conmentList1 != null) {
                    if (conmentList.size() == subjectsEntities.size()) {
                        Log.i(TAG, "onNext: " + "数据库大小一致1");
                        Log.i(TAG, "onNext: " + conmentList1.size());
                        return;
                    } else {
                        //DataSupport.deleteAll(Conment.class);
                        initSupportData1(subjectsEntities);
                        Log.i(TAG, "onNext: " + "数据库有更新1");
                        Log.i(TAG, "onNext: " + conmentList1.size());
                    }
                } else {
                    initSupportData1(subjectsEntities);
                    Log.i(TAG, "onNext: " + "数据库为空1");
                    Log.i(TAG, "onNext: " + conmentList1.size());
                }
//                conmentList.notifyAll();
                Log.i(TAG, "onNext: " + conmentList1.size());
             //   mTextView.setText(subjectsEntities.get(7).getCasts().get(8).getName());
            }
        };
        mSubscriberOnNextListener2 = new SubscriberOnNextListener<List<ResultMovieBean.SubjectsEntity>>() {
            @Override
            public void onNext(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
               /* try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < subjectsEntities.size(); i++) {
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getAlt());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getTitle());
                    Log.i(TAG, "onNext: " + subjectsEntities.get(i).getCasts().get(0).getName());
                }*/
                conmentList2 = DataSupport.findAll(Conment2.class);

                if (conmentList2 != null) {
                    if (conmentList2.size() == subjectsEntities.size()) {
                        Log.i(TAG, "onNext: " + "数据库大小一致2");
                        Log.i(TAG, "onNext: " + conmentList2.size());
                        return;
                    } else {
                        //DataSupport.deleteAll(Conment.class);
                        initSupportData2(subjectsEntities);
                        Log.i(TAG, "onNext: " + "数据库有更新2");
                        Log.i(TAG, "onNext: " + conmentList2.size());
                    }
                } else {
                    initSupportData2(subjectsEntities);
                    Log.i(TAG, "onNext: " + "数据库为空2");
                    Log.i(TAG, "onNext: " + conmentList2.size());
                }
//                conmentList.notifyAll();
                Log.i(TAG, "onNext: " + conmentList2.size());
             //   mTextView.setText(subjectsEntities.get(3).getCasts().get(1).getName());
            }
        };
        getDoGet(getApiService());

        getDoGet1(getApiService());

        getDoGet2(getApiService());


    }

    private void initSupportData(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
        for (int i = 0; i < subjectsEntities.size(); i++) {
            Conment conment = new Conment();
            conment.setYear(subjectsEntities.get(i).getYear());
            conment.setAlt(subjectsEntities.get(i).getAlt());
            conment.setConmentId(subjectsEntities.get(i).getId());
            conment.setOriginal_title(subjectsEntities.get(i).getOriginal_title());
            conment.setSubtype(subjectsEntities.get(i).getSubtype());
            conment.setTitle(subjectsEntities.get(i).getTitle());
            conment.saveOrUpdate("title=?", conment.getTitle());
        }
    }
    private void initSupportData1(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
        for (int i = 0; i < subjectsEntities.size(); i++) {
            Conment1 conment = new Conment1();
            conment.setYear(subjectsEntities.get(i).getYear());
            conment.setAlt(subjectsEntities.get(i).getAlt());
            conment.setConmentId(subjectsEntities.get(i).getId());
            conment.setOriginal_title(subjectsEntities.get(i).getOriginal_title());
            conment.setSubtype(subjectsEntities.get(i).getSubtype());
            conment.setTitle(subjectsEntities.get(i).getTitle());
            conment.saveOrUpdate("title=?", conment.getTitle());
        }
    }
    private void initSupportData2(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {
        for (int i = 0; i < subjectsEntities.size(); i++) {
            Conment2 conment = new Conment2();
            conment.setYear(subjectsEntities.get(i).getYear());
            conment.setAlt(subjectsEntities.get(i).getAlt());
            conment.setConmentId(subjectsEntities.get(i).getId());
            conment.setOriginal_title(subjectsEntities.get(i).getOriginal_title());
            conment.setSubtype(subjectsEntities.get(i).getSubtype());
            conment.setTitle(subjectsEntities.get(i).getTitle());
            conment.saveOrUpdate("title=?", conment.getTitle());
        }
    }

    private void getDoGet(ApiService apiService) {
        Observable<List<ResultMovieBean.SubjectsEntity>> observable1 = apiService.doGet(0, 10)
                .map(new MyFuncl<List<ResultMovieBean.SubjectsEntity>>());

        ProgressSubscriber<List<ResultMovieBean.SubjectsEntity>> subscriber = new ProgressSubscriber<>(mSubscriberOnNextListener, mCompliteListener, RetrofitDemoActivity.this);

        toSubscrible(observable1, subscriber);
    }
    private void getDoGet1(ApiService apiService) {
        Observable<List<ResultMovieBean.SubjectsEntity>> observable1 = apiService.doGet(0, 9)
                .map(new MyFuncl<List<ResultMovieBean.SubjectsEntity>>());

        ProgressSubscriber<List<ResultMovieBean.SubjectsEntity>> subscriber = new ProgressSubscriber<>(mSubscriberOnNextListener1, mCompliteListener, RetrofitDemoActivity.this);

        toSubscrible(observable1, subscriber);
    }
    private void getDoGet2(ApiService apiService) {
        Observable<List<ResultMovieBean.SubjectsEntity>> observable1 = apiService.doGet(0, 5)
                .map(new MyFuncl<List<ResultMovieBean.SubjectsEntity>>());

        ProgressSubscriber<List<ResultMovieBean.SubjectsEntity>> subscriber = new ProgressSubscriber<>(mSubscriberOnNextListener2, mCompliteListener, RetrofitDemoActivity.this);

        toSubscrible(observable1, subscriber);
    }






   /* @NonNull
    private Subscriber<List<ResultMovieBean.SubjectsEntity>> getListSubscriber() {
        return new Subscriber<List<ResultMovieBean.SubjectsEntity>>() {
                @Override
                public void onCompleted() {
                    Log.i(TAG, "onCompleted: " + "完成！！！");
                    NextRetrofitActivity.TextChangeLisenner lisenner = new NextRetrofitActivity.TextChangeLisenner() {
                        @Override
                        public void textChange(TextView textView) {
                            textView.setText(mTitle);
                        }
                    };
                }

                @Override
                public void onError(Throwable e) {
                    Log.i(TAG, "onError: " + e.getMessage());
                }

                @Override
                public void onNext(List<ResultMovieBean.SubjectsEntity> subjectsEntities) {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < subjectsEntities.size(); i++) {
                        Log.i(TAG, "onNext: " + subjectsEntities.get(i).getAlt());
                        Log.i(TAG, "onNext: " + subjectsEntities.get(i).getTitle());
                        Log.i(TAG, "onNext: " + subjectsEntities.get(i).getCasts().get(0).getName());
                    }

                    mTitle = subjectsEntities.get(0).getTitle();
                }
            };
    }*/

    private ApiService getApiService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl("https://api.douban.com/v2/movie/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }

    private class MyFuncl<T> implements Func1<ResultMovieBean<T>, T> {

        @Override
        public T call(ResultMovieBean<T> tResultMovieBean) {
            return tResultMovieBean.getSubjects();
        }
    }

    public void next_retrofit(View view) {
        Intent intent = new Intent(RetrofitDemoActivity.this, NextRetrofitActivity.class);
        intent.putExtra("text", mTitle);
        Log.i(TAG, "next_retrofit: " + mTitle);
        startActivity(intent);
    }

    private <T> void toSubscrible(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

  /*  public interface CompliteListenner {
        void complite(String title);
    }

    public void setOnCompliteListenner(CompliteListenner listenner) {
        mListenner1 = listenner;
    }*/
}
