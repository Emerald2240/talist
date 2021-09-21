package com.relentless.currncyconverterappusingandroidbookasreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class ThirdFragment extends Fragment {
    TextView back;
    TextView next;
    ImageView talogo3;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_third, viewGroup, false);
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.welcomeviewpager);
        this.talogo3 = (ImageView) inflate.findViewById(R.id.talogo3);
        this.next = (TextView) inflate.findViewById(R.id.Next);
        this.back = (TextView) inflate.findViewById(R.id.Back);
        this.talogo3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });
        this.back.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        return inflate;
    }
}
