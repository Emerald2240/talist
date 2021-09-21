package com.noqoush.adfalcon.android.sdk;

import android.webkit.ValueCallback;

class ADFMraidJSOutListener$a implements ValueCallback {
   // $FF: synthetic field
   final ADFMraidJSOutListener a;

   ADFMraidJSOutListener$a(ADFMraidJSOutListener var1) {
      this.a = var1;
   }

   public void a(String var1) {
      if (var1 != null && !var1.equalsIgnoreCase("null")) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Javascript receive: ");
         var2.append(var1);
         com.noqoush.adfalcon.android.sdk.util.a.a(var2.toString());
      }

   }
}
