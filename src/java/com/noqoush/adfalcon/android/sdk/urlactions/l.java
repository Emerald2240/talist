package com.noqoush.adfalcon.android.sdk.urlactions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.List;
import java.util.Vector;

public class l {
   public static Uri a(Intent var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append("market://details?id=");
      var1.append(var0.getPackage());
      return Uri.parse(var1.toString());
   }

   public static void a(Context var0, Intent var1) throws Exception {
      if (!(var0 instanceof Activity)) {
         var1.addFlags(268435456);
      }

      var0.startActivity(var1);
   }

   public static void a(Context var0, Uri var1) throws Exception {
      Intent var2 = new Intent("android.intent.action.VIEW", var1);
      var2.addFlags(268435456);
      var0.startActivity(var2);
   }

   public static void a(e var0, List var1) throws Exception {
      if (var1 != null) {
         (new com.noqoush.adfalcon.android.sdk.helper.c(var0.a(), new Vector(var1))).a((com.noqoush.adfalcon.android.sdk.response.b)null, (String)null);
      }

   }
}
