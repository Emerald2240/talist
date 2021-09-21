package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.os.Handler;
import java.net.HttpURLConnection;

class d$a implements Runnable {
   // $FF: synthetic field
   final Handler a;
   // $FF: synthetic field
   final d b;

   d$a(d var1, Handler var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         d.a(this.b, new com.noqoush.adfalcon.android.sdk.conn.a());
         HttpURLConnection var2 = d.a(this.b);
         this.a.post(new d$a$a(this, var2));
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }
}
