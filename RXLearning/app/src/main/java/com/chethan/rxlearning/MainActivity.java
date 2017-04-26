package com.chethan.rxlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.performRXCall();
    }

    private void performRXCall() {
        Observable.just(this.populateData(1000))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<DataModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<DataModel> dataModels) {
                        Log.v("SIZE", "" + dataModels.size());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private List<DataModel> populateData(int dataCount) {
        List<DataModel> dataModelList = new ArrayList<>();

        for (int index = 0; index < dataCount; index++) {
            DataModel dataModel = new DataModel();
            dataModel.id = index;
            dataModelList.add(dataModel);
        }

        return dataModelList;
    }
}
