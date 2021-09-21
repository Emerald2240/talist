package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e extends BroadcastReceiver {
   public static int a = -1;
   private final AudioManager b;
   private final Context c;
   private final j d;
   private final Set e = new HashSet();
   private final Object f = new Object();
   private boolean g;
   private int h;

   e(j var1) {
      this.d = var1;
      this.c = var1.D();
      this.b = (AudioManager)this.c.getSystemService("audio");
   }

   private void a() {
      this.d.v().b("AudioSessionManager", "Observing ringer mode...");
      this.h = a;
      Context var1 = this.c;
      AudioManager var10000 = this.b;
      var1.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
      this.d.af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
      this.d.af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
   }

   public static boolean a(int var0) {
      byte var1 = 1;
      if (var0 != 0) {
         if (var0 == var1) {
            return (boolean)var1;
         }

         var1 = 0;
      }

      return (boolean)var1;
   }

   private void b() {
      this.d.v().b("AudioSessionManager", "Stopping observation of mute switch state...");
      this.c.unregisterReceiver(this);
      this.d.af().unregisterReceiver(this);
   }

   private void b(final int var1) {
      if (!this.g) {
         p var2 = this.d.v();
         StringBuilder var3 = new StringBuilder();
         var3.append("Ringer mode is ");
         var3.append(var1);
         var2.b("AudioSessionManager", var3.toString());
         Object var6 = this.f;
         synchronized(var6){}

         boolean var10001;
         Throwable var10000;
         label218: {
            Iterator var8;
            try {
               var8 = this.e.iterator();
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               break label218;
            }

            while(true) {
               try {
                  if (var8.hasNext()) {
                     AppLovinSdkUtils.runOnUiThread(new Runnable((e.a)var8.next()) {
                        // $FF: synthetic field
                        final e.a a;

                        {
                           this.a = var2;
                        }

                        public void run() {
                           this.a.onRingerModeChanged(var1);
                        }
                     });
                     continue;
                  }
               } catch (Throwable var29) {
                  var10000 = var29;
                  var10001 = false;
                  break;
               }

               try {
                  return;
               } catch (Throwable var27) {
                  var10000 = var27;
                  var10001 = false;
                  break;
               }
            }
         }

         while(true) {
            Throwable var7 = var10000;

            try {
               throw var7;
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void a(e.a var1) {
      Object var2 = this.f;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label197: {
         try {
            if (this.e.contains(var1)) {
               return;
            }
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label197;
         }

         try {
            this.e.add(var1);
            if (this.e.size() == 1) {
               this.a();
            }
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label197;
         }

         label187:
         try {
            return;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            break label187;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            continue;
         }
      }
   }

   public void b(e.a var1) {
      Object var2 = this.f;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label197: {
         try {
            if (!this.e.contains(var1)) {
               return;
            }
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label197;
         }

         try {
            this.e.remove(var1);
            if (this.e.isEmpty()) {
               this.b();
            }
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label197;
         }

         label187:
         try {
            return;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            break label187;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            continue;
         }
      }
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      AudioManager var10000 = this.b;
      if (!"android.media.RINGER_MODE_CHANGED".equals(var3)) {
         if ("com.applovin.application_paused".equals(var3)) {
            this.g = true;
            this.h = this.b.getRingerMode();
            return;
         }

         if (!"com.applovin.application_resumed".equals(var3)) {
            return;
         }

         this.g = false;
         if (this.h == this.b.getRingerMode()) {
            return;
         }

         this.h = a;
      }

      this.b(this.b.getRingerMode());
   }

   public interface a {
      void onRingerModeChanged(int var1);
   }
}
