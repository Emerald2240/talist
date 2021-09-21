package com.heetch.countrypicker;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.Locale;

class CountryPickerDialog$2 implements OnItemClickListener {
   // $FF: synthetic field
   final CountryPickerDialog this$0;

   CountryPickerDialog$2(CountryPickerDialog var1) {
      this.this$0 = var1;
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      this.this$0.hide();
      Country var6 = (Country)CountryPickerDialog.access$000(this.this$0).get(var3);
      CountryPickerCallbacks var7 = CountryPickerDialog.access$100(this.this$0);
      Context var8 = this.this$0.getContext();
      StringBuilder var9 = new StringBuilder();
      var9.append(var6.getIsoCode().toLowerCase(Locale.ENGLISH));
      var9.append("_flag");
      var7.onCountrySelected(var6, Utils.getMipmapResId(var8, var9.toString()));
   }
}
