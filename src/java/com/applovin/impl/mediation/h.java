package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h {
   private final com.applovin.impl.sdk.j a;
   private final p b;
   private final Object c = new Object();
   private final Map d = new HashMap();
   private final Set e = new HashSet();

   public h(com.applovin.impl.sdk.j var1) {
      if (var1 != null) {
         this.a = var1;
         this.b = var1.v();
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   private i a(com.applovin.impl.mediation.b.e var1, Class var2) {
      try {
         Constructor var7 = var2.getConstructor(new Class[]{AppLovinSdk.class});
         Object[] var8 = new Object[]{this.a.S()};
         i var9 = new i(var1, (MediationAdapterBase)var7.newInstance(var8), this.a);
         if (var9.c()) {
            return var9;
         }

         StringBuilder var10 = new StringBuilder();
         var10.append("Adapter is disabled after initialization: ");
         var10.append(var1);
         p.j("MediationAdapterManager", var10.toString());
      } catch (Throwable var12) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Failed to load adapter: ");
         var4.append(var1);
         p.c("MediationAdapterManager", var4.toString(), var12);
         return null;
      }

      return null;
   }

   private Class a(String var1) {
      try {
         Class var6 = Class.forName(var1);
         if (MaxAdapter.class.isAssignableFrom(var6)) {
            return var6.asSubclass(MaxAdapter.class);
         }

         StringBuilder var7 = new StringBuilder();
         var7.append(var1);
         var7.append(" error: not an instance of '");
         var7.append(MaxAdapter.class.getName());
         var7.append("'.");
         p.j("MediationAdapterManager", var7.toString());
      } catch (Throwable var9) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Failed to load: ");
         var3.append(var1);
         p.c("MediationAdapterManager", var3.toString(), var9);
         return null;
      }

      return null;
   }

   i a(com.applovin.impl.mediation.b.e var1) {
      if (var1 == null) {
         IllegalArgumentException var2 = new IllegalArgumentException("No adapter spec specified");
         throw var2;
      } else {
         String var3 = var1.D();
         String var4 = var1.C();
         p var25;
         String var30;
         if (TextUtils.isEmpty(var3)) {
            var25 = this.b;
            StringBuilder var31 = new StringBuilder();
            var31.append("No adapter name provided for ");
            var31.append(var4);
            var31.append(", not loading the adapter ");
            var30 = var31.toString();
         } else {
            if (!TextUtils.isEmpty(var4)) {
               Object var5 = this.c;
               synchronized(var5){}

               boolean var10001;
               Throwable var10000;
               label749: {
                  Class var12;
                  label738: {
                     label752: {
                        try {
                           if (this.e.contains(var4)) {
                              break label752;
                           }

                           if (this.d.containsKey(var4)) {
                              var12 = (Class)this.d.get(var4);
                              break label738;
                           }
                        } catch (Throwable var107) {
                           var10000 = var107;
                           var10001 = false;
                           break label749;
                        }

                        try {
                           var12 = this.a(var4);
                        } catch (Throwable var106) {
                           var10000 = var106;
                           var10001 = false;
                           break label749;
                        }

                        if (var12 == null) {
                           try {
                              this.e.add(var4);
                              return null;
                           } catch (Throwable var101) {
                              var10000 = var101;
                              var10001 = false;
                              break label749;
                           }
                        }
                        break label738;
                     }

                     try {
                        p var7 = this.b;
                        StringBuilder var8 = new StringBuilder();
                        var8.append("Not attempting to load ");
                        var8.append(var3);
                        var8.append(" due to prior errors");
                        var7.b("MediationAdapterManager", var8.toString());
                        return null;
                     } catch (Throwable var105) {
                        var10000 = var105;
                        var10001 = false;
                        break label749;
                     }
                  }

                  i var14;
                  try {
                     var14 = this.a(var1, var12);
                  } catch (Throwable var104) {
                     var10000 = var104;
                     var10001 = false;
                     break label749;
                  }

                  if (var14 != null) {
                     label714:
                     try {
                        p var15 = this.b;
                        StringBuilder var16 = new StringBuilder();
                        var16.append("Loaded ");
                        var16.append(var3);
                        var15.b("MediationAdapterManager", var16.toString());
                        this.d.put(var4, var12);
                        return var14;
                     } catch (Throwable var102) {
                        var10000 = var102;
                        var10001 = false;
                        break label714;
                     }
                  } else {
                     label716:
                     try {
                        p var20 = this.b;
                        StringBuilder var21 = new StringBuilder();
                        var21.append("Failed to load ");
                        var21.append(var3);
                        var20.e("MediationAdapterManager", var21.toString());
                        this.e.add(var4);
                        return null;
                     } catch (Throwable var103) {
                        var10000 = var103;
                        var10001 = false;
                        break label716;
                     }
                  }
               }

               while(true) {
                  Throwable var6 = var10000;

                  try {
                     throw var6;
                  } catch (Throwable var100) {
                     var10000 = var100;
                     var10001 = false;
                     continue;
                  }
               }
            }

            var25 = this.b;
            StringBuilder var26 = new StringBuilder();
            var26.append("Unable to find default classname for '");
            var26.append(var3);
            var26.append("'");
            var30 = var26.toString();
         }

         var25.e("MediationAdapterManager", var30);
         return null;
      }
   }

   public Collection a() {
      Object var1 = this.c;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label203: {
         Iterator var4;
         HashSet var2;
         try {
            var2 = new HashSet(this.d.size());
            var4 = this.d.values().iterator();
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label203;
         }

         while(true) {
            try {
               if (!var4.hasNext()) {
                  break;
               }

               var2.add(((Class)var4.next()).getName());
            } catch (Throwable var27) {
               var10000 = var27;
               var10001 = false;
               break label203;
            }
         }

         label188:
         try {
            Set var5 = Collections.unmodifiableSet(var2);
            return var5;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label188;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   public Collection b() {
      // $FF: Couldn't be decompiled
   }
}
