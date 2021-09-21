package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.os.Bundle;

public class ADFActivity extends Activity {
   public static a b;
   private a a;

   public a a() {
      if (this.a == null) {
         this.a = b;
         b = null;
      }

      return this.a;
   }

   public void finish() {
      super.finish();
   }

   public void onBackPressed() {
      this.a().e();
   }

   protected void onCreate(Bundle var1) {
      try {
         this.a().b(var1, this, this.getWindow(), this.getIntent());
         super.onCreate(var1);
         this.a().a(var1, this, this.getWindow(), this.getIntent());
      } catch (Exception var4) {
         var4.printStackTrace();
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFActivity->contr->");
         var3.append(var4.toString());
         k.b(var3.toString());
      }
   }

   protected void onDestroy() {
      this.a().f();
      super.onDestroy();
   }

   protected void onPause() {
      super.onPause();
      this.a().c();
   }

   protected void onRestoreInstanceState(Bundle var1) {
      this.a().a(var1);
      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      super.onResume();
      this.a().d();
   }

   protected void onSaveInstanceState(Bundle var1) {
      this.a().b(var1);
      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      super.onStart();
      this.a().a();
   }

   protected void onStop() {
      super.onStop();
      this.a().b();
   }
}
