package com.t3h.parsehtml.motherchild;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t3h.parsehtml.CommonCrawl;
import com.t3h.parsehtml.R;
import com.t3h.parsehtml.model.MotherChildModel;
import com.t3h.parsehtml.motherchild.adapter.MotherChilAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseMotherChildFragment extends
        Fragment implements MotherChilAdapter.IMotherChilAdapter {
    private List<MotherChildModel> motherChildModels;
    private RecyclerView rc;
    private MotherChilAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_magazine,
                container,
                false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        motherChildModels = new ArrayList<>();
        rc = view.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MotherChilAdapter(this);
        rc.setAdapter(adapter);
        inits();
    }

    private void inits(){
        final String link = getArguments().getString("link");
        final String content = getArguments().getString("content");
        new AsyncTask<Void, Void, List<MotherChildModel>>(){
            @Override
            protected List<MotherChildModel> doInBackground(Void... voids) {
                List<MotherChildModel> mcs = new ArrayList<>();
                for ( int i = 1; i <= 1; i++){
                    CommonCrawl.getData(
//                            "https://mevabe.vn/the-gioi-cua-be/be-khoe--dep/page-"+i+".html",
                            link+i+".html",
                            mcs,
//                            "over-box"
                            content
                    );
                }
                return mcs;
            }

            @Override
            protected void onPostExecute(List<MotherChildModel> mcs) {
                motherChildModels = mcs;
                adapter.notifyDataSetChanged();

            }
        }.execute();

    }

    private void getData(String link,
                         List<MotherChildModel> mcs){

    }

    @Override
    public int getCount() {
        if ( motherChildModels == null ){
            return 0;
        }
        return motherChildModels.size();
    }

    @Override
    public MotherChildModel getData(int position) {
        return motherChildModels.get(position);
    }
}
