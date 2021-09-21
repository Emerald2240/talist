package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import java.net.HttpURLConnection;

class d$a$a implements Runnable {
   // $FF: synthetic field
   final HttpURLConnection a;
   // $FF: synthetic field
   final d$a b;

   d$a$a(d$a var1, HttpURLConnection var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         d.b(this.b.b).a((HttpURLConnection)this.a, (com.noqoush.adfalcon.android.sdk.conn.b)this.b.b);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
