package com.relentless.currncyconverterappusingandroidbookasreference;

import android.text.Editable;
import android.text.TextWatcher;

class MainActivity$12 implements TextWatcher {
   // $FF: synthetic field
   final MainActivity this$0;
   // $FF: synthetic field
   final currencyListviewAdapter val$flashadapter;

   MainActivity$12(MainActivity var1, currencyListviewAdapter var2) {
      this.this$0 = var1;
      this.val$flashadapter = var2;
   }

   public void afterTextChanged(Editable var1) {
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      currencyListviewAdapter var5 = new currencyListviewAdapter(this.this$0, 2131427362, MainActivity.adderClassArrayList);
      var5.getFilter().filter(var1);
      this.val$flashadapter.getFilter().filter(var1);
      this.this$0.currencylistview.setAdapter(var5);
   }
}
