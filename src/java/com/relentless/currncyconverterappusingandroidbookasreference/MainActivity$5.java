package com.relentless.currncyconverterappusingandroidbookasreference;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.blongho.country_data.World;

class MainActivity$5 implements OnClickListener {
   // $FF: synthetic field
   final MainActivity this$0;

   MainActivity$5(MainActivity var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      this.this$0.progressBar.setVisibility(0);
      TextUtils.isEmpty(this.this$0.edit.getText());
      if (TextUtils.isEmpty(this.this$0.edit.getText())) {
         this.this$0.enteredValue = 1.0D;
         this.this$0.edit.setText("1");
      } else {
         MainActivity var3 = this.this$0;
         var3.enteredValue = Double.parseDouble(String.valueOf(var3.edit.getText()));
      }

      MainActivity.adderClassArrayList.clear();
      MainActivity.access$100(this.this$0);
      this.this$0.loadJSONOffline();
      currencyListviewAdapter var4 = new currencyListviewAdapter(this.this$0, 2131427362, MainActivity.adderClassArrayList);
      var4.notifyDataSetChanged();
      this.this$0.currencylistview.setAdapter(var4);
      this.this$0.baseCountryImageView.setImageResource(World.getFlagOf(this.this$0.basecountry));
      if (this.this$0.basecountry.contains("NG")) {
         this.this$0.Basecu.setText("Nigerian Naira");
      }

      if (this.this$0.basecountry.contains("US")) {
         this.this$0.Basecu.setText("United States Dollar");
      }

      if (this.this$0.basecountry.contains("EU")) {
         this.this$0.Basecu.setText("European Union Euro");
      }

      if (this.this$0.basecountry.contains("GB")) {
         this.this$0.Basecu.setText("United Kingdom Sterling");
      }

      if (this.this$0.basecountry.contains("JP")) {
         this.this$0.Basecu.setText("Japanese Yen");
      }

      if (this.this$0.basecountry.contains("CN")) {
         this.this$0.Basecu.setText("Chinese Yuan Renminbi");
      }

      if (this.this$0.basecountry.contains("KW")) {
         this.this$0.Basecu.setText("Kuwaiti Dinar");
      }

      if (this.this$0.basecountry.contains("ZA")) {
         this.this$0.Basecu.setText("South African Rand");
      }

      if (this.this$0.basecountry.contains("IL")) {
         this.this$0.Basecu.setText("Isreali Shekel");
      }

   }
}
