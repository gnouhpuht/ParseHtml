package com.t3h.parsehtml.motherchild.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.t3h.parsehtml.motherchild.ExpStudyFragment;
import com.t3h.parsehtml.motherchild.MagazineFragment;

public class HomeAdapter extends FragmentPagerAdapter {
    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MagazineFragment f = new MagazineFragment();
                Bundle b = new Bundle();
                b.putString("link",
                        "https://mevabe.vn/the-gioi-cua-be/be-khoe--dep/page-"
                );
                b.putString("content", "over-box");
                f.setArguments(b);
                return f;
            case 1:
                ExpStudyFragment fE = new ExpStudyFragment();
                Bundle bE = new Bundle();
                bE.putString("link",
                        "https://www.mevabe.vn/the-gioi-cua-me/kinh-nghiem-hay/page-"
                );
                bE.putString("content", "content-box");
                fE.setArguments(bE);
                return fE;
            default:
                ExpStudyFragment fS = new ExpStudyFragment();
                Bundle bS = new Bundle();
                bS.putString("link",
                        "https://mevabe.vn/the-gioi-cua-be/be-chao-doi/page-"
                );
                bS.putString("content", "over-box");
                fS.setArguments(bS);
                return fS;
        }


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Tạp Chí";
        } else {
            if ( position == 1){
                return "Kinh nghiệm";
            }
          return "Bắt đầu sinh";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
