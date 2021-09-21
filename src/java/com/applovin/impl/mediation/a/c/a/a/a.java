package com.applovin.impl.mediation.a.c.a.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.applovin.impl.mediation.a.a.c;
import com.applovin.impl.mediation.a.a.d;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;

public class a extends c {
   private final d d;
   private final Context e;

   public a(d var1, Context var2) {
      c.a var3;
      if (var1.a() == d.a.a) {
         var3 = c.a.b;
      } else {
         var3 = c.a.c;
      }

      super(var3);
      this.d = var1;
      this.e = var2;
   }

   private SpannedString a(String var1, int var2) {
      return this.a(var1, var2, 16);
   }

   private SpannedString a(String var1, int var2, int var3) {
      SpannableString var4 = new SpannableString(var1);
      var4.setSpan(new ForegroundColorSpan(var2), 0, var4.length(), 33);
      var4.setSpan(new AbsoluteSizeSpan(var3, true), 0, var4.length(), 33);
      return new SpannedString(var4);
   }

   private SpannedString j() {
      int var1;
      String var2;
      if (this.d.b()) {
         if (!TextUtils.isEmpty(this.d.f())) {
            StringBuilder var3 = new StringBuilder();
            var3.append("SDK ");
            var3.append(this.d.f());
            var2 = var3.toString();
         } else if (this.d.c()) {
            var2 = "Retrieving SDK Version...";
         } else {
            var2 = "SDK Found";
         }

         var1 = -7829368;
      } else {
         var1 = -65536;
         var2 = "SDK Missing";
      }

      return this.a(var2, var1);
   }

   private SpannedString k() {
      int var1;
      String var2;
      if (this.d.c()) {
         if (!TextUtils.isEmpty(this.d.g())) {
            StringBuilder var3 = new StringBuilder();
            var3.append("Adapter ");
            var3.append(this.d.g());
            var2 = var3.toString();
         } else {
            var2 = "Adapter Found";
         }

         var1 = -7829368;
      } else {
         var1 = -65536;
         var2 = "Adapter Missing";
      }

      return this.a(var2, var1);
   }

   private SpannedString l() {
      return this.a("Invalid Integration", -65536);
   }

   private SpannedString m() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Latest Version: Adapter ");
      var1.append(this.d.h());
      return this.a(var1.toString(), Color.rgb(255, 127, 0));
   }

   public boolean b() {
      return this.d.a() != d.a.a;
   }

   public SpannedString c() {
      if (this.b != null) {
         return this.b;
      } else {
         int var1;
         if (this.d.a() == d.a.a) {
            var1 = -7829368;
         } else {
            var1 = -16777216;
         }

         this.b = this.a(this.d.e(), var1, 18);
         return this.b;
      }
   }

   public SpannedString d() {
      if (this.c != null) {
         return this.c;
      } else {
         if (this.d.a() != d.a.a) {
            SpannableStringBuilder var1 = new SpannableStringBuilder();
            var1.append(this.j());
            var1.append(this.a(", ", -7829368));
            var1.append(this.k());
            if (this.d.d()) {
               var1.append(new SpannableString("\n"));
               var1.append(this.m());
            }

            if (this.d.a() == d.a.c) {
               var1.append(new SpannableString("\n"));
               var1.append(this.l());
            }

            this.c = new SpannedString(var1);
         } else {
            this.c = new SpannedString("");
         }

         return this.c;
      }
   }

   public int g() {
      return this.b() ? R.drawable.applovin_ic_disclosure_arrow : super.g();
   }

   public int h() {
      return f.a(R.color.applovin_sdk_disclosureButtonColor, this.e);
   }

   public d i() {
      return this.d;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedNetworkListItemViewModel{text=");
      var1.append(this.b);
      var1.append(", detailText=");
      var1.append(this.c);
      var1.append(", network=");
      var1.append(this.d);
      var1.append("}");
      return var1.toString();
   }
}
