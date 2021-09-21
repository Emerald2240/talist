package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
import java.text.DecimalFormat;

class MainActivity$11 implements OnItemLongClickListener {
   // $FF: synthetic field
   final MainActivity this$0;
   // $FF: synthetic field
   final currencyListviewAdapter val$flashadapter;
   // $FF: synthetic field
   final currencyListviewAdapter val$flashadapterSEARCH;

   MainActivity$11(MainActivity var1, currencyListviewAdapter var2, currencyListviewAdapter var3) {
      this.this$0 = var1;
      this.val$flashadapterSEARCH = var2;
      this.val$flashadapter = var3;
   }

   public boolean onItemLongClick(AdapterView var1, View var2, int var3, long var4) {
      this.this$0.getAdderClassObjectSEARCH = this.val$flashadapterSEARCH.getItem(var3);
      this.this$0.adderClassObject = this.val$flashadapter.getItem(var3);
      DecimalFormat var6 = new DecimalFormat("#,###.####");
      ClipboardManager var7 = (ClipboardManager)this.this$0.getSystemService("clipboard");
      String var8 = this.this$0.adderClassObject.getCurrencyName();
      Double var9 = this.this$0.adderClassObject.getRate();
      StringBuilder var10 = new StringBuilder();
      var10.append(var6.format(var9));
      var10.append(" ");
      var10.append(var8);
      ClipData var14 = ClipData.newPlainText("Currency Conversion", var10.toString());
      Toast.makeText(this.this$0, "Rate Copied to ClipBoard", 0).show();
      var7.setPrimaryClip(var14);
      return true;
   }
}
