package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c extends BroadcastReceiver {
   private final List a = Collections.synchronizedList(new ArrayList());

   public c(Context var1) {
      var1.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
   }

   private static boolean a(Intent var0) {
      Bundle var1 = var0.getExtras();
      if (var1 != null) {
         Object var2 = var1.get("networkInfo");
         if (var2 instanceof NetworkInfo) {
            return ((NetworkInfo)var2).isConnected();
         }
      }

      return false;
   }

   public void a(c.a var1) {
      this.a.add(var1);
   }

   public void b(c.a var1) {
      this.a.remove(var1);
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2.getAction() != null) {
         if (!var2.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            return;
         }

         if (this.isInitialStickyBroadcast()) {
            return;
         }

         ArrayList var3 = new ArrayList(this.a);
         boolean var4 = a(var2);
         Iterator var5 = var3.iterator();
         if (var4) {
            while(var5.hasNext()) {
               ((c.a)var5.next()).a();
            }
         } else {
            while(var5.hasNext()) {
               ((c.a)var5.next()).b();
            }
         }
      }

   }

   public interface a {
      void a();

      void b();
   }
}
