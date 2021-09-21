package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {
   private final j a;
   private final AtomicBoolean b = new AtomicBoolean();
   private final AtomicBoolean c = new AtomicBoolean();
   private AppLovinVariableService.OnVariablesUpdateListener d;
   private Bundle e;
   private final Object f = new Object();

   VariableServiceImpl(j var1) {
      this.a = var1;
      String var2 = (String)var1.a(com.applovin.impl.sdk.b.f.i);
      if (com.applovin.impl.sdk.utils.n.b(var2)) {
         this.updateVariables(com.applovin.impl.sdk.utils.i.a(var2, var1));
      }

   }

   private Object a(String var1, Object var2, Class var3) {
      if (TextUtils.isEmpty(var1)) {
         p.j("AppLovinVariableService", "Unable to retrieve variable value for empty name");
         return var2;
      } else {
         if (!this.a.d()) {
            p.i("AppLovinSdk", "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
         }

         Object var4 = this.f;
         synchronized(var4){}

         boolean var10001;
         Throwable var10000;
         label333: {
            try {
               if (this.e == null) {
                  StringBuilder var6 = new StringBuilder();
                  var6.append("Unable to retrieve variable value for name \"");
                  var6.append(var1);
                  var6.append("\", none retrieved from server yet. Please set a listener to be notified when values are retrieved from the server.");
                  p.j("AppLovinVariableService", var6.toString());
                  return var2;
               }
            } catch (Throwable var44) {
               var10000 = var44;
               var10001 = false;
               break label333;
            }

            try {
               if (var3.equals(String.class)) {
                  String var14 = this.e.getString(var1, (String)var2);
                  return var14;
               }
            } catch (Throwable var43) {
               var10000 = var43;
               var10001 = false;
               break label333;
            }

            try {
               if (var3.equals(Boolean.class)) {
                  Boolean var13 = this.e.getBoolean(var1, (Boolean)var2);
                  return var13;
               }
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label333;
            }

            label312:
            try {
               StringBuilder var10 = new StringBuilder();
               var10.append("Unable to retrieve variable value for ");
               var10.append(var1);
               throw new IllegalStateException(var10.toString());
            } catch (Throwable var42) {
               var10000 = var42;
               var10001 = false;
               break label312;
            }
         }

         while(true) {
            Throwable var5 = var10000;

            try {
               throw var5;
            } catch (Throwable var41) {
               var10000 = var41;
               var10001 = false;
               continue;
            }
         }
      }
   }

   private void a() {
      Object var1 = this.f;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label199: {
         label203: {
            try {
               if (this.d != null && this.e != null) {
                  break label203;
               }
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label199;
            }

            try {
               return;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label199;
            }
         }

         label187:
         try {
            AppLovinSdkUtils.runOnUiThread(true, new VariableServiceImpl$2(this, (Bundle)this.e.clone()));
            return;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            break label187;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var20) {
            var10000 = var20;
            var10001 = false;
            continue;
         }
      }
   }

   // $FF: synthetic method
   static AppLovinVariableService.OnVariablesUpdateListener b(VariableServiceImpl var0) {
      return var0.d;
   }

   public boolean getBoolean(String var1) {
      return this.getBoolean(var1, false);
   }

   public boolean getBoolean(String var1, boolean var2) {
      return (Boolean)this.a(var1, var2, Boolean.class);
   }

   public String getString(String var1) {
      return this.getString(var1, (String)null);
   }

   public String getString(String var1, String var2) {
      return (String)this.a(var1, var2, String.class);
   }

   public void loadVariables() {
      String var1;
      if (this.a.d()) {
         if (this.b.compareAndSet(false, true)) {
            com.applovin.impl.sdk.d.p var2 = new com.applovin.impl.sdk.d.p(this.a, new com.applovin.impl.sdk.d.p.a() {
               public void a() {
                  VariableServiceImpl.this.b.set(false);
               }
            });
            this.a.K().a((com.applovin.impl.sdk.d.a)var2, com.applovin.impl.sdk.d.r.a.c);
            return;
         }

         var1 = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
      } else {
         var1 = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
      }

      p.j("AppLovinVariableService", var1);
   }

   public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener var1) {
      boolean var10001;
      Throwable var10000;
      label119: {
         this.d = var1;
         Object var2 = this.f;
         synchronized(var2){}
         if (var1 != null) {
            try {
               if (this.e != null && this.c.compareAndSet(false, true)) {
                  this.a.v().b("AppLovinVariableService", "Setting initial listener");
                  this.a();
               }
            } catch (Throwable var16) {
               var10000 = var16;
               var10001 = false;
               break label119;
            }
         }

         label115:
         try {
            return;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label115;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VariableService{variables=");
      var1.append(this.e);
      var1.append(", listener=");
      var1.append(this.d);
      var1.append('}');
      return var1.toString();
   }

   public void updateVariables(JSONObject param1) {
      // $FF: Couldn't be decompiled
   }
}
