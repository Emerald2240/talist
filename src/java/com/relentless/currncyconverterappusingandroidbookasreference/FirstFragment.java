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

public class FirstFragment extends Fragment {
    TextView next;
    ImageView talogo1;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_first, viewGroup, false);
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.welcomeviewpager);
        this.next = (TextView) inflate.findViewById(R.id.Next);
        this.talogo1 = (ImageView) inflate.findViewById(R.id.talogo1);
        this.talogo1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        return inflate;
    }
}
