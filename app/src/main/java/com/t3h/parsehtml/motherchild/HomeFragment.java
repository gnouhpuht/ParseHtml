package com.t3h.parsehtml.motherchild;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.t3h.parsehtml.R;
import com.t3h.parsehtml.motherchild.adapter.HomeAdapter;

public class HomeFragment extends Fragment {
    private ViewPager vp;
    private TabLayout tab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,
                container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp = view.findViewById(R.id.vp);
        vp.setAdapter(new HomeAdapter(getChildFragmentManager()));
        tab = view.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

    }
}
