package com.noqoush.adfalcon.android.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j$a implements OnClickListener {
   // $FF: synthetic field
   final j a;

   j$a(j var1) {
      this.a = var1;
   }

   public void onClick(DialogInterface var1, int var2) {
      var1.cancel();
      this.a.g();
   }
}
