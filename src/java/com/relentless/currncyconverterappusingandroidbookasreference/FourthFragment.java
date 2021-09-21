package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class FourthFragment extends Fragment {
    TextView back;
    TextView next;
    ImageView talogo4;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_fourth, viewGroup, false);
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.welcomeviewpager);
        this.talogo4 = (ImageView) inflate.findViewById(R.id.talogo4);
        this.next = (TextView) inflate.findViewById(R.id.Next);
        this.back = (TextView) inflate.findViewById(R.id.Back);
        this.talogo4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FourthFragment.this.startActivity(new Intent(FourthFragment.this.getActivity(), MainActivity.class));
                FourthFragment.this.getActivity().finish();
            }
        });
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FourthFragment.this.startActivity(new Intent(FourthFragment.this.getActivity(), MainActivity.class));
                FourthFragment.this.getActivity().finish();
            }
        });
        this.back.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });
        return inflate;
    }
}
