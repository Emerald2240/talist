package com.applovin.impl.communicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.p;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

public class b extends BroadcastReceiver {
   private boolean a = true;
   private final String b;
   private final WeakReference c;
   private final Set d = new LinkedHashSet();
   private final Object e = new Object();

   b(String var1, AppLovinCommunicatorSubscriber var2) {
      this.b = var1;
      this.c = new WeakReference(var2);
   }

   public String a() {
      return this.b;
   }

   public void a(boolean var1) {
      this.a = var1;
   }

   public AppLovinCommunicatorSubscriber b() {
      return (AppLovinCommunicatorSubscriber)this.c.get();
   }

   public boolean c() {
      return this.a;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         if (this.a().equals(var2.a())) {
            if (this.c.get() != null) {
               if (((AppLovinCommunicatorSubscriber)this.c.get()).equals(var2.c.get())) {
                  return true;
               }
            } else if (this.c.get() == var2.c.get()) {
               return true;
            }
         }

         return false;
      }
   }

   public int hashCode() {
      int var1 = 31 * this.b.hashCode();
      int var2;
      if (this.c.get() != null) {
         var2 = ((AppLovinCommunicatorSubscriber)this.c.get()).hashCode();
      } else {
         var2 = 0;
      }

      return var1 + var2;
   }

   public void onReceive(Context var1, Intent var2) {
      if (this.b() == null) {
         p.j("AppLovinCommunicator", "Message received for GC'd subscriber");
      } else {
         CommunicatorMessageImpl var3 = (CommunicatorMessageImpl)var2;
         Object var4 = this.e;
         synchronized(var4){}

         boolean var7;
         label239: {
            boolean var10001;
            Throwable var10000;
            label240: {
               boolean var6;
               try {
                  var6 = this.d.contains(var3);
               } catch (Throwable var29) {
                  var10000 = var29;
                  var10001 = false;
                  break label240;
               }

               var7 = false;
               if (!var6) {
                  try {
                     this.d.add(var3);
                  } catch (Throwable var28) {
                     var10000 = var28;
                     var10001 = false;
                     break label240;
                  }

                  var7 = true;
               }

               label224:
               try {
                  break label239;
               } catch (Throwable var27) {
                  var10000 = var27;
                  var10001 = false;
                  break label224;
               }
            }

            while(true) {
               Throwable var5 = var10000;

               try {
                  throw var5;
               } catch (Throwable var26) {
                  var10000 = var26;
                  var10001 = false;
                  continue;
               }
            }
         }

         if (var7) {
            this.b().onMessageReceived((AppLovinCommunicatorMessage)var3);
         }

      }
   }
}
