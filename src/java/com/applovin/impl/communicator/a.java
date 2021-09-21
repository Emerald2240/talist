package com.applovin.impl.communicator;

import android.content.Context;
import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a {
   private final Context a;
   private final Set b = new HashSet(32);
   private final Object c = new Object();

   public a(Context var1) {
      this.a = var1;
   }

   private b a(String var1, AppLovinCommunicatorSubscriber var2) {
      Iterator var3 = this.b.iterator();

      b var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (b)var3.next();
      } while(!var1.equals(var4.a()) || !var2.equals(var4.b()));

      return var4;
   }

   public boolean a(AppLovinCommunicatorSubscriber var1, String var2) {
      if (var1 != null && n.b(var2)) {
         Object var9 = this.c;
         synchronized(var9){}

         boolean var10001;
         Throwable var10000;
         label296: {
            b var11;
            try {
               var11 = this.a(var2, var1);
            } catch (Throwable var50) {
               var10000 = var50;
               var10001 = false;
               break label296;
            }

            if (var11 != null) {
               label289: {
                  try {
                     StringBuilder var12 = new StringBuilder();
                     var12.append("Attempting to re-subscribe subscriber (");
                     var12.append(var1);
                     var12.append(") to topic (");
                     var12.append(var2);
                     var12.append(")");
                     p.g("AppLovinCommunicator", var12.toString());
                     if (!var11.c()) {
                        var11.a(true);
                        AppLovinBroadcastManager.getInstance(this.a).registerReceiver(var11, new IntentFilter(var2));
                     }
                  } catch (Throwable var48) {
                     var10000 = var48;
                     var10001 = false;
                     break label289;
                  }

                  label286:
                  try {
                     return true;
                  } catch (Throwable var47) {
                     var10000 = var47;
                     var10001 = false;
                     break label286;
                  }
               }
            } else {
               label292: {
                  b var18;
                  try {
                     var18 = new b(var2, var1);
                     this.b.add(var18);
                  } catch (Throwable var49) {
                     var10000 = var49;
                     var10001 = false;
                     break label292;
                  }

                  AppLovinBroadcastManager.getInstance(this.a).registerReceiver(var18, new IntentFilter(var2));
                  return true;
               }
            }
         }

         while(true) {
            Throwable var10 = var10000;

            try {
               throw var10;
            } catch (Throwable var46) {
               var10000 = var46;
               var10001 = false;
               continue;
            }
         }
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Unable to subscribe - invalid subscriber (");
         var3.append(var1);
         var3.append(") or topic (");
         var3.append(var2);
         var3.append(")");
         p.j("AppLovinCommunicator", var3.toString());
         return false;
      }
   }

   public void b(AppLovinCommunicatorSubscriber param1, String param2) {
      // $FF: Couldn't be decompiled
   }
}
