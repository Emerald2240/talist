package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.io.Serializable;
import java.util.Vector;

public class s implements Serializable {
   public static final String d = "creativeView";
   public static final String e = "start";
   public static final String f = "firstQuartile";
   public static final String g = "midpoint";
   public static final String h = "thirdQuartile";
   public static final String i = "complete";
   public static final String j = "mute";
   public static final String k = "unmute";
   public static final String l = "pause";
   public static final String m = "rewind";
   public static final String n = "resume";
   public static final String o = "fullscreen";
   public static final String p = "exitFullscreen";
   public static final String q = "expand";
   public static final String r = "collapse";
   public static final String s = "acceptInvitationLinear";
   public static final String t = "closeLinear";
   public static final String u = "close";
   public static final String v = "skip";
   public static final String w = "progress";
   private String a;
   private String b;
   private String c;

   private int a(int var1) {
      return com.noqoush.adfalcon.android.sdk.video.vast.manager.h.a(this.b(), var1);
   }

   public String a() {
      return this.a;
   }

   public void a(Context var1, String var2, int var3, com.noqoush.adfalcon.android.sdk.video.vast.manager.g var4, int var5) {
      try {
         if (this.a().equalsIgnoreCase(var2)) {
            if (this.a(var5) <= 0 || this.a(var5) == var3) {
               if (!var2.equalsIgnoreCase("progress") || var3 == this.a(var5)) {
                  Vector var7 = new Vector();
                  var7.add(var4.a(this.c()));
                  (new com.noqoush.adfalcon.android.sdk.helper.c(var1, var7)).a((com.noqoush.adfalcon.android.sdk.response.b)null, (String)null);
               }
            }
         }
      } catch (Exception var8) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var8);
      }
   }

   public void a(String var1) {
      this.a = var1;
   }

   public String b() {
      return this.c;
   }

   public void b(String var1) {
      this.c = var1;
   }

   public String c() {
      return this.b;
   }

   public void c(String var1) {
      this.b = var1;
   }

   public boolean equals(Object var1) {
      boolean var2 = false;
      if (var1 != null) {
         if (!(var1 instanceof s)) {
            return false;
         }

         s var3 = (s)var1;
         String var4 = this.c();
         var2 = false;
         if (var4 != null) {
            boolean var5 = this.c().equalsIgnoreCase(var3.c());
            var2 = false;
            if (var5) {
               var2 = true;
            }
         }
      }

      return var2;
   }
}
