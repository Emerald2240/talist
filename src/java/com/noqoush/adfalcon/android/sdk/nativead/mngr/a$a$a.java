package com.noqoush.adfalcon.android.sdk.nativead.mngr;

import java.net.HttpURLConnection;

class a$a$a implements Runnable {
   // $FF: synthetic field
   final HttpURLConnection a;
   // $FF: synthetic field
   final a$a b;

   a$a$a(a$a var1, HttpURLConnection var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         com.noqoush.adfalcon.android.sdk.nativead.mngr.a.b(this.b.a).a((HttpURLConnection)this.a, (com.noqoush.adfalcon.android.sdk.conn.b)this.b.a);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
