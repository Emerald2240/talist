package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

abstract class r implements m, AppLovinNativeAdLoadListener {
   protected final j a;
   protected final p b;
   private final Object c;
   private final Map d;
   private final Map e;
   private final Map f;
   private final Set g;

   r(j var1) {
      this.a = var1;
      this.b = var1.v();
      this.c = new Object();
      this.d = new HashMap();
      this.e = new HashMap();
      this.f = new HashMap();
      this.g = new HashSet();
   }

   // $FF: synthetic method
   static Object a(r var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static Map b(r var0) {
      return var0.f;
   }

   private void b(com.applovin.impl.sdk.ad.d var1, AppLovinAdLoadListener var2) {
      Object var3 = this.c;
      synchronized(var3){}

      label152: {
         boolean var10001;
         Throwable var10000;
         label147: {
            try {
               if (this.f.containsKey(var1)) {
                  this.b.d("PreloadManager", "Possibly missing prior registered preload callback.");
               }
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               break label147;
            }

            label144:
            try {
               this.f.put(var1, var2);
               break label152;
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               break label144;
            }
         }

         while(true) {
            Throwable var4 = var10000;

            try {
               throw var4;
            } catch (Throwable var19) {
               var10000 = var19;
               var10001 = false;
               continue;
            }
         }
      }

      int var6 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.bb);
      if (var6 > 0) {
         long var7 = TimeUnit.SECONDS.toMillis((long)var6);
         AppLovinSdkUtils.runOnUiThreadDelayed(new r$1(this, var1, var6), var7);
      }

   }

   private s j(com.applovin.impl.sdk.ad.d var1) {
      return (s)this.d.get(var1);
   }

   private s k(com.applovin.impl.sdk.ad.d var1) {
      return (s)this.e.get(var1);
   }

   private boolean l(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label220: {
         s var4;
         try {
            var4 = this.j(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label220;
         }

         boolean var5;
         label223: {
            if (var4 != null) {
               label222: {
                  try {
                     if (!var4.c()) {
                        break label222;
                     }
                  } catch (Throwable var25) {
                     var10000 = var25;
                     var10001 = false;
                     break label220;
                  }

                  var5 = true;
                  break label223;
               }
            }

            var5 = false;
         }

         label203:
         try {
            return var5;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label203;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   private s m(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label187: {
         s var4;
         try {
            var4 = this.k(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label187;
         }

         if (var4 != null) {
            try {
               if (var4.a() > 0) {
                  return var4;
               }
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               break label187;
            }
         }

         label176:
         try {
            s var5 = this.j(var1);
            return var5;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label176;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   private boolean n(com.applovin.impl.sdk.ad.d param1) {
      // $FF: Couldn't be decompiled
   }

   abstract com.applovin.impl.sdk.ad.d a(com.applovin.impl.sdk.ad.j var1);

   abstract com.applovin.impl.sdk.d.a a(com.applovin.impl.sdk.ad.d var1);

   abstract void a(Object var1, com.applovin.impl.sdk.ad.d var2, int var3);

   abstract void a(Object var1, com.applovin.impl.sdk.ad.j var2);

   public void a(LinkedHashSet var1) {
      Map var2 = this.f;
      if (var2 != null) {
         if (!var2.isEmpty()) {
            Object var3 = this.c;
            synchronized(var3){}

            boolean var10001;
            Throwable var10000;
            label275: {
               Iterator var5;
               try {
                  var5 = this.f.keySet().iterator();
               } catch (Throwable var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label275;
               }

               while(true) {
                  try {
                     if (!var5.hasNext()) {
                        break;
                     }

                     com.applovin.impl.sdk.ad.d var6 = (com.applovin.impl.sdk.ad.d)var5.next();
                     if (!var6.i() && !var1.contains(var6)) {
                        Object var7 = this.f.get(var6);
                        var5.remove();
                        StringBuilder var8 = new StringBuilder();
                        var8.append("Failed to load ad for zone (");
                        var8.append(var6.a());
                        var8.append("). Please check that the zone has been added to your AppLovin account and given at least 30 minutes to fully propagate.");
                        p.j("AppLovinAdService", var8.toString());
                        this.a(var7, var6, -7);
                     }
                  } catch (Throwable var32) {
                     var10000 = var32;
                     var10001 = false;
                     break label275;
                  }
               }

               label253:
               try {
                  return;
               } catch (Throwable var30) {
                  var10000 = var30;
                  var10001 = false;
                  break label253;
               }
            }

            while(true) {
               Throwable var4 = var10000;

               try {
                  throw var4;
               } catch (Throwable var29) {
                  var10000 = var29;
                  var10001 = false;
                  continue;
               }
            }
         }
      }
   }

   public boolean a(com.applovin.impl.sdk.ad.d var1, AppLovinAdLoadListener var2) {
      Object var3 = this.c;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label146: {
         boolean var5;
         label145: {
            label144: {
               try {
                  if (!this.n(var1)) {
                     this.b(var1, var2);
                     break label144;
                  }
               } catch (Throwable var18) {
                  var10000 = var18;
                  var10001 = false;
                  break label146;
               }

               var5 = false;
               break label145;
            }

            var5 = true;
         }

         label136:
         try {
            return var5;
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label136;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            continue;
         }
      }
   }

   public void b(com.applovin.impl.sdk.ad.d var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         this.i(var1);
      }

   }

   void b(com.applovin.impl.sdk.ad.j param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean b(com.applovin.impl.sdk.ad.d var1) {
      return this.f.containsKey(var1);
   }

   public com.applovin.impl.sdk.ad.j c(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label191: {
         s var4;
         try {
            var4 = this.m(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label191;
         }

         com.applovin.impl.sdk.ad.j var5;
         if (var4 != null) {
            try {
               var5 = var4.f();
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               break label191;
            }
         } else {
            var5 = null;
         }

         label179:
         try {
            return var5;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label179;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   void c(com.applovin.impl.sdk.ad.d param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public com.applovin.impl.sdk.ad.j d(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label191: {
         s var4;
         try {
            var4 = this.m(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label191;
         }

         com.applovin.impl.sdk.ad.j var5;
         if (var4 != null) {
            try {
               var5 = var4.e();
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               break label191;
            }
         } else {
            var5 = null;
         }

         label179:
         try {
            return var5;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label179;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   public com.applovin.impl.sdk.ad.j e(com.applovin.impl.sdk.ad.d param1) {
      // $FF: Couldn't be decompiled
   }

   public void f(com.applovin.impl.sdk.ad.d var1) {
      if (var1 != null) {
         Object var2 = this.c;
         synchronized(var2){}

         int var5;
         label209: {
            boolean var10001;
            Throwable var10000;
            label210: {
               s var4;
               try {
                  var4 = this.j(var1);
               } catch (Throwable var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label210;
               }

               var5 = 0;
               if (var4 != null) {
                  try {
                     var5 = var4.b() - var4.a();
                  } catch (Throwable var25) {
                     var10000 = var25;
                     var10001 = false;
                     break label210;
                  }
               }

               label195:
               try {
                  break label209;
               } catch (Throwable var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label195;
               }
            }

            while(true) {
               Throwable var3 = var10000;

               try {
                  throw var3;
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  continue;
               }
            }
         }

         this.b(var1, var5);
      }
   }

   public boolean g(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label407: {
         s var4;
         try {
            var4 = this.k(var1);
         } catch (Throwable var49) {
            var10000 = var49;
            var10001 = false;
            break label407;
         }

         boolean var5 = true;
         if (var4 != null) {
            try {
               if (var4.a() > 0) {
                  return var5;
               }
            } catch (Throwable var48) {
               var10000 = var48;
               var10001 = false;
               break label407;
            }
         }

         s var6;
         try {
            var6 = this.j(var1);
         } catch (Throwable var47) {
            var10000 = var47;
            var10001 = false;
            break label407;
         }

         label409: {
            if (var6 != null) {
               label388:
               try {
                  if (var6.d()) {
                     break label388;
                  }
                  break label409;
               } catch (Throwable var46) {
                  var10000 = var46;
                  var10001 = false;
                  break label407;
               }
            }

            var5 = false;
         }

         label383:
         try {
            return var5;
         } catch (Throwable var45) {
            var10000 = var45;
            var10001 = false;
            break label383;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var44) {
            var10000 = var44;
            var10001 = false;
            continue;
         }
      }
   }

   public void h(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label514: {
         s var4;
         try {
            var4 = this.j(var1);
         } catch (Throwable var80) {
            var10000 = var80;
            var10001 = false;
            break label514;
         }

         if (var4 != null) {
            try {
               var4.a(var1.e());
            } catch (Throwable var79) {
               var10000 = var79;
               var10001 = false;
               break label514;
            }
         } else {
            try {
               this.d.put(var1, new s(var1.e()));
            } catch (Throwable var78) {
               var10000 = var78;
               var10001 = false;
               break label514;
            }
         }

         s var5;
         try {
            var5 = this.k(var1);
         } catch (Throwable var77) {
            var10000 = var77;
            var10001 = false;
            break label514;
         }

         if (var5 != null) {
            try {
               var5.a(var1.f());
            } catch (Throwable var76) {
               var10000 = var76;
               var10001 = false;
               break label514;
            }
         } else {
            try {
               this.e.put(var1, new s(var1.f()));
            } catch (Throwable var75) {
               var10000 = var75;
               var10001 = false;
               break label514;
            }
         }

         label492:
         try {
            return;
         } catch (Throwable var74) {
            var10000 = var74;
            var10001 = false;
            break label492;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var73) {
            var10000 = var73;
            var10001 = false;
            continue;
         }
      }
   }

   public void i(com.applovin.impl.sdk.ad.d var1) {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.bc) && !this.l(var1)) {
         p var2 = this.b;
         StringBuilder var3 = new StringBuilder();
         var3.append("Preloading ad for zone ");
         var3.append(var1);
         var3.append("...");
         var2.b("PreloadManager", var3.toString());
         this.a.K().a(this.a(var1), com.applovin.impl.sdk.d.r.a.a, 500L);
      }

   }
}
