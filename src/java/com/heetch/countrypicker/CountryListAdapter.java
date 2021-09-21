package com.heetch.countrypicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

public class CountryListAdapter extends BaseAdapter {
    private static final String TAG = CountryListAdapter.class.getSimpleName();
    private List<Country> countries;
    private LayoutInflater inflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private final Context mContext;
    private boolean showDialingCode;

    public static class Item {
        private ImageView icon;
        private TextView name;

        public ImageView getIcon() {
            return this.icon;
        }

        public void setIcon(ImageView imageView) {
            this.icon = imageView;
        }

        public TextView getName() {
            return this.name;
        }

        public void setName(TextView textView) {
            this.name = textView;
        }
    }

    public long getItemId(int i) {
        return 0;
    }

    public CountryListAdapter(Context context, List<Country> list, boolean z) {
        this.mContext = context;
        this.countries = list;
        this.showDialingCode = z;
    }

    public int getCount() {
        return this.countries.size();
    }

    public Object getItem(int i) {
        return this.countries.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item;
        View inflate;
        String stringBuilder;
        Country country = (Country) this.countries.get(i);
        if (view == null) {
            item = new Item();
            inflate = this.inflater.inflate(R.layout.item_country, viewGroup, false);
            item.setIcon((ImageView) inflate.findViewById(R.id.icon));
            item.setName((TextView) inflate.findViewById(R.id.name));
            inflate.setTag(item);
        } else {
            inflate = view;
            item = (Item) view.getTag();
        }
        TextView name = item.getName();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(new Locale(this.mContext.getResources().getConfiguration().locale.getLanguage(), country.getIsoCode()).getDisplayCountry());
        if (this.showDialingCode) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(" (+");
            stringBuilder3.append(country.getDialingCode());
            stringBuilder3.append(")");
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        name.setText(stringBuilder2.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(country.getIsoCode().toLowerCase(Locale.ENGLISH));
        stringBuilder4.append("_flag");
        item.getIcon().setImageResource(Utils.getMipmapResId(this.mContext, stringBuilder4.toString()));
        return inflate;
    }
}
