package com.gdgand.rxjava.rxjavasample.scroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdgand.rxjava.rxjavasample.R;
import com.gdgand.rxjava.rxjavasample.scroll.realm.FasterListData;
import com.gdgand.rxjava.rxjavasample.util.repository.DatabaseRealm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FasterAdapter extends RecyclerView.Adapter<FasterListViewHolder> {

    private Context context;

    private List<String> list;

    private DatabaseRealm databaseRealm;

    public FasterAdapter(Context context, DatabaseRealm databaseRealm) {
        this.context = context;
        list = new ArrayList<>();
        this.databaseRealm = databaseRealm;
    }

    @Override
    public FasterListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fasterlist, parent, false);
        return new FasterListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FasterListViewHolder holder, int position) {
        Observable.just(position)
                .subscribeOn(Schedulers.io())
                .map(index -> {
                    try {
                        long count = databaseRealm.findCountGreaterThanOrEqualTo(FasterListData.class,"position", position);
                        Thread.sleep(10);
                        return getItem(position) + ", count : " + count;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "";

                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    holder.tvTitle.setText(s);
                });
    }

    private String getItem(int position) {
        return list.get(position);
    }

    public void addAll(List<String> list) {
        this.list.addAll(list);
    }

    public void add(String value) {
        this.list.add(value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
