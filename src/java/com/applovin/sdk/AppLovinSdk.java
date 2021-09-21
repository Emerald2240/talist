package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.c;
import com.applovin.impl.sdk.utils.e;
import com.applovin.nativeAds.AppLovinNativeAdService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppLovinSdk {
   private static final String TAG = "AppLovinSdk";
   public static final String VERSION = getVersion();
   public static final int VERSION_CODE = getVersionCode();
   private static final Map sdkInstances = new HashMap();
   private static final Object sdkInstancesLock = new Object();
   private final j mSdkImpl;

   private AppLovinSdk(j var1) {
      this.mSdkImpl = var1;
   }

   public static List a() {
      return new ArrayList(sdkInstances.values());
   }

   public static AppLovinSdk getInstance(Context var0) {
      return getInstance(new AppLovinSdkSettings(var0) {
      }, var0);
   }

   public static AppLovinSdk getInstance(AppLovinSdkSettings var0, Context var1) {
      if (var1 != null) {
         return getInstance(c.a(var1).a("applovin.sdk.key", ""), var0, var1);
      } else {
         throw new IllegalArgumentException("No context specified");
      }
   }

   public static AppLovinSdk getInstance(String var0, AppLovinSdkSettings var1, Context var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("No userSettings specified");
      } else if (var2 != null) {
         Object var3 = sdkInstancesLock;
         synchronized(var3){}

         boolean var10001;
         Throwable var10000;
         label362: {
            try {
               if (sdkInstances.containsKey(var0)) {
                  AppLovinSdk var13 = (AppLovinSdk)sdkInstances.get(var0);
                  return var13;
               }
            } catch (Throwable var43) {
               var10000 = var43;
               var10001 = false;
               break label362;
            }

            label352: {
               try {
                  if (TextUtils.isEmpty(var0) || !var0.contains(File.separator)) {
                     break label352;
                  }

                  StringBuilder var8 = new StringBuilder();
                  var8.append("\n**************************************************\nINVALID SDK KEY: ");
                  var8.append(var0);
                  var8.append("\n**************************************************\n");
                  p.j("AppLovinSdk", var8.toString());
                  if (!sdkInstances.isEmpty()) {
                     AppLovinSdk var12 = (AppLovinSdk)sdkInstances.values().iterator().next();
                     return var12;
                  }
               } catch (Throwable var44) {
                  var10000 = var44;
                  var10001 = false;
                  break label362;
               }

               try {
                  var0 = var0.replace(File.separator, "");
               } catch (Throwable var42) {
                  var10000 = var42;
                  var10001 = false;
                  break label362;
               }
            }

            label338:
            try {
               j var5 = new j();
               var5.a(var0, var1, var2);
               AppLovinSdk var6 = new AppLovinSdk(var5);
               var5.a(var6);
               sdkInstances.put(var0, var6);
               return var6;
            } catch (Throwable var41) {
               var10000 = var41;
               var10001 = false;
               break label338;
            }
         }

         while(true) {
            Throwable var4 = var10000;

            try {
               throw var4;
            } catch (Throwable var40) {
               var10000 = var40;
               var10001 = false;
               continue;
            }
         }
      } else {
         throw new IllegalArgumentException("No context specified");
      }
   }

   private static String getVersion() {
      return "9.11.4";
   }

   private static int getVersionCode() {
      return 91104;
   }

   public static void initializeSdk(Context var0) {
      initializeSdk(var0, (AppLovinSdk.SdkInitializationListener)null);
   }

   public static void initializeSdk(Context var0, AppLovinSdk.SdkInitializationListener var1) {
      if (var0 != null) {
         AppLovinSdk var2 = getInstance(var0);
         if (var2 != null) {
            var2.initializeSdk(var1);
         } else {
            p.j("AppLovinSdk", "Unable to initialize AppLovin SDK: SDK object not created");
         }
      } else {
         throw new IllegalArgumentException("No context specified");
      }
   }

   static void reinitializeAll() {
      reinitializeAll((Boolean)null, (Boolean)null);
   }

   static void reinitializeAll(Boolean var0, Boolean var1) {
      Object var2 = sdkInstancesLock;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label373: {
         Iterator var4;
         try {
            var4 = sdkInstances.values().iterator();
         } catch (Throwable var49) {
            var10000 = var49;
            var10001 = false;
            break label373;
         }

         while(true) {
            AppLovinSdk var5;
            try {
               if (!var4.hasNext()) {
                  break;
               }

               var5 = (AppLovinSdk)var4.next();
               var5.mSdkImpl.b();
            } catch (Throwable var50) {
               var10000 = var50;
               var10001 = false;
               break label373;
            }

            if (var0 != null) {
               try {
                  Map var6 = e.a((Object)"value", (Object)var0.toString());
                  var5.getEventService().trackEvent("huc", var6);
               } catch (Throwable var48) {
                  var10000 = var48;
                  var10001 = false;
                  break label373;
               }
            }

            if (var1 != null) {
               try {
                  Map var7 = e.a((Object)"value", (Object)var1.toString());
                  var5.getEventService().trackEvent("dns", var7);
               } catch (Throwable var47) {
                  var10000 = var47;
                  var10001 = false;
                  break label373;
               }
            }
         }

         label352:
         try {
            return;
         } catch (Throwable var46) {
            var10000 = var46;
            var10001 = false;
            break label352;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var45) {
            var10000 = var45;
            var10001 = false;
            continue;
         }
      }
   }

   public AppLovinAdService getAdService() {
      return this.mSdkImpl.o();
   }

   @Deprecated
   Context getApplicationContext() {
      return this.mSdkImpl.D();
   }

   public AppLovinSdkConfiguration getConfiguration() {
      return this.mSdkImpl.m();
   }

   public AppLovinEventService getEventService() {
      return this.mSdkImpl.q();
   }

   @Deprecated
   public p getLogger() {
      return this.mSdkImpl.v();
   }

   public String getMediationProvider() {
      return this.mSdkImpl.n();
   }

   public AppLovinNativeAdService getNativeAdService() {
      return this.mSdkImpl.p();
   }

   public AppLovinPostbackService getPostbackService() {
      return this.mSdkImpl.R();
   }

   public String getSdkKey() {
      return this.mSdkImpl.t();
   }

   public AppLovinSdkSettings getSettings() {
      return this.mSdkImpl.l();
   }

   public String getUserIdentifier() {
      return this.mSdkImpl.i();
   }

   public AppLovinUserService getUserService() {
      return this.mSdkImpl.r();
   }

   public AppLovinVariableService getVariableService() {
      return this.mSdkImpl.s();
   }

   public boolean hasCriticalErrors() {
      return this.mSdkImpl.u();
   }

   public void initializeSdk() {
   }

   public void initializeSdk(AppLovinSdk.SdkInitializationListener var1) {
      this.mSdkImpl.a(var1);
   }

   public boolean isEnabled() {
      return this.mSdkImpl.d();
   }

   public void setMediationProvider(String var1) {
      this.mSdkImpl.c(var1);
   }

   public void setPluginVersion(String var1) {
      this.mSdkImpl.a(var1);
   }

   public void setUserIdentifier(String var1) {
      this.mSdkImpl.b(var1);
   }

   public void showMediationDebugger() {
      this.mSdkImpl.h();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinSdk{sdkKey='");
      var1.append(this.getSdkKey());
      var1.append("', isEnabled=");
      var1.append(this.isEnabled());
      var1.append(", isFirstSession=");
      var1.append(this.mSdkImpl.H());
      var1.append('}');
      return var1.toString();
   }

   public interface SdkInitializationListener {
      void onSdkInitialized(AppLovinSdkConfiguration var1);
   }
}
