package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class currencyListviewAdapter extends ArrayAdapter<adderClass> {
    String FAVORITE = "npcgr";
    String NOTFAVORITE = "npcg";
    DecimalFormat decimalFormat = new DecimalFormat("#,###.####");
    private Context mContext;
    int mResource;

    public currencyListviewAdapter(Context context, int i, ArrayList arrayList) {
        super(context, i, arrayList);
        this.mContext = context;
        this.mResource = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String countryName = getItem(i).getCountryName();
        String countryCode = getItem(i).getCountryCode();
        String currencyName = getItem(i).getCurrencyName();
        String currencyCode = getItem(i).getCurrencyCode();
        Double rate = getItem(i).getRate();
        int countryflag = getItem(i).getCountryflag();
        Double originalrate = getItem(i).getOriginalrate();
        int progress = getItem(i).getProgress();
        getItem(i).getDifference();
        int i2 = progress;
        int i3 = progress;
        String valueOf = String.valueOf(currencyCode.charAt(2));
        adderClass adderclass = new adderClass(countryName, countryCode, currencyName, currencyCode, rate, countryflag, originalrate, i2, Double.valueOf(0.0d));
        View inflate = LayoutInflater.from(this.mContext).inflate(this.mResource, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.rateTextview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.currencyNameTextView);
        TextView textView3 = (TextView) inflate.findViewById(R.id.currencysigntextview);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.flagimageview);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.progressImageView);
        ((TextView) inflate.findViewById(R.id.currencycodetextview)).setText(currencyCode);
        textView.setText(this.decimalFormat.format(rate));
        textView2.setText(currencyName);
        textView3.setText(valueOf);
        imageView.setImageResource(countryflag);
        imageView2.setImageResource(i3);
        return inflate;
    }

    public adderClass getItem(int i) {
        return (adderClass) super.getItem(i);
    }
}
