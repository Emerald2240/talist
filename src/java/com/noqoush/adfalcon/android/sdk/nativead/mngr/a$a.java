package com.noqoush.adfalcon.android.sdk.nativead.mngr;

import java.net.HttpURLConnection;

class a$a implements Runnable {
   // $FF: synthetic field
   final a a;

   a$a(a var1) {
      this.a = var1;
   }

   public void run() {
      try {
         if (this.a.e().b() != null) {
            com.noqoush.adfalcon.android.sdk.nativead.mngr.a.a(this.a, new com.noqoush.adfalcon.android.sdk.conn.a());
            HttpURLConnection var2 = com.noqoush.adfalcon.android.sdk.nativead.mngr.a.a(this.a);
            this.a.e().b().runOnUiThread(new a$a$a(this, var2));
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }
}
