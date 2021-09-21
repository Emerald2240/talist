package com.applovin.impl.sdk.utils;

import android.content.pm.PackageManager;

public class k {
   public static int a(String var0, String var1, PackageManager var2) {
      try {
         int var4 = var2.checkPermission(var0, var1);
         return var4;
      } finally {
         ;
      }
   }
}
