package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class i {
   public static final i A = a("aia");
   public static final i B = a("cs");
   public static final i C = a("fnma");
   public static final i D = a("lad");
   public static final i E = a("pmw");
   public static final i F = a("pnma");
   public static final i G = a("tma");
   public static final i H = a("tsc");
   public static final i I = a("fmp");
   public static final i J = a("fmdi");
   public static final i K = a("vmr");
   public static final i L = a("rmr");
   private static final Set N = new HashSet(64);
   public static final i a = a("is");
   public static final i b = a("cai");
   public static final i c = a("dp");
   public static final i d = a("fbs");
   public static final i e = a("rr");
   public static final i f = a("rt");
   public static final i g = a("ito");
   public static final i h = a("asd");
   public static final i i = a("caa");
   public static final i j = a("cnai");
   public static final i k = a("cnav");
   public static final i l = a("cva");
   public static final i m = a("fma");
   public static final i n = a("fna");
   public static final i o = a("fnna");
   public static final i p = a("fta");
   public static final i q = a("fvs");
   public static final i r = a("par");
   public static final i s = a("psvr");
   public static final i t = a("pvwr");
   public static final i u = a("raa");
   public static final i v = a("rna");
   public static final i w = a("rva");
   public static final i x = a("rrwd");
   public static final i y = a("rvw");
   public static final i z = a("vr");
   private final String M;

   static {
      a("das");
      a("bt");
   }

   protected i(String var1) {
      this.M = var1;
   }

   private static i a(String var0) {
      if (!TextUtils.isEmpty(var0)) {
         if (!N.contains(var0)) {
            N.add(var0);
            return new i(var0);
         } else {
            StringBuilder var1 = new StringBuilder();
            var1.append("Key has already been used: ");
            var1.append(var0);
            throw new IllegalArgumentException(var1.toString());
         }
      } else {
         throw new IllegalArgumentException("No key name specified");
      }
   }

   public String a() {
      return this.M;
   }
}
