package com.noqoush.adfalcon.android.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class j$b implements OnClickListener {
   // $FF: synthetic field
   final j a;

   j$b(j var1) {
      this.a = var1;
   }

   public void onClick(DialogInterface var1, int var2) {
      this.a.h().onClick((View)null);
      var1.dismiss();
   }
}
