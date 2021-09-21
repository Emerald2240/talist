package com.relentless.currncyconverterappusingandroidbookasreference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MainActivity$10 implements OnItemClickListener {
   // $FF: synthetic field
   final MainActivity this$0;
   // $FF: synthetic field
   final currencyListviewAdapter val$flashadapter;
   // $FF: synthetic field
   final currencyListviewAdapter val$searchadapter;

   MainActivity$10(MainActivity var1, currencyListviewAdapter var2, currencyListviewAdapter var3) {
      this.this$0 = var1;
      this.val$searchadapter = var2;
      this.val$flashadapter = var3;
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      this.this$0.getAdderClassObjectSEARCH = this.val$searchadapter.getItem(var3);
      this.this$0.adderClassObject = this.val$flashadapter.getItem(var3);
      this.this$0.showDialog(1);
   }
}
