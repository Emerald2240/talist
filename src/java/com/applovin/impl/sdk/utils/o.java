package com.applovin.impl.sdk.utils;

import java.util.Timer;
import java.util.TimerTask;

public class o {
   private final com.applovin.impl.sdk.j a;
   private Timer b;
   private long c;
   private long d;
   private final Runnable e;
   private long f;
   private final Object g = new Object();

   private o(com.applovin.impl.sdk.j var1, Runnable var2) {
      this.a = var1;
      this.e = var2;
   }

   public static o a(long var0, com.applovin.impl.sdk.j var2, Runnable var3) {
      if (var0 >= 0L) {
         if (var3 != null) {
            o var8 = new o(var2, var3);
            var8.c = System.currentTimeMillis();
            var8.d = var0;

            try {
               var8.b = new Timer();
               var8.b.schedule(var8.e(), var0);
               return var8;
            } catch (OutOfMemoryError var10) {
               var2.v().b("Timer", "Failed to create timer due to OOM error", var10);
               return var8;
            }
         } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
         }
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append("Cannot create a scheduled timer. Invalid fire time passed in: ");
         var4.append(var0);
         var4.append(".");
         throw new IllegalArgumentException(var4.toString());
      }
   }

   // $FF: synthetic method
   static Runnable a(o var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static Timer a(o var0, Timer var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.j b(o var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static Object c(o var0) {
      return var0.g;
   }

   private TimerTask e() {
      return new TimerTask() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      };
   }

   public long a() {
      if (this.b != null) {
         long var1 = System.currentTimeMillis() - this.c;
         return this.d - var1;
      } else {
         return this.d - this.f;
      }
   }

   public void b() {
      Object var1 = this.g;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label415: {
         Timer var3;
         try {
            var3 = this.b;
         } catch (Throwable var59) {
            var10000 = var59;
            var10001 = false;
            break label415;
         }

         if (var3 != null) {
            try {
               this.b.cancel();
               this.f = System.currentTimeMillis() - this.c;
            } catch (Throwable var58) {
               Throwable var4 = var58;

               label403:
               try {
                  if (this.a != null) {
                     this.a.v().b("Timer", "Encountered error while pausing timer", var4);
                  }
                  break label403;
               } finally {
                  try {
                     this.b = null;
                  } catch (Throwable var55) {
                     var10000 = var55;
                     var10001 = false;
                     break label415;
                  }
               }
            }
         }

         label401:
         try {
            return;
         } catch (Throwable var56) {
            var10000 = var56;
            var10001 = false;
            break label401;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var54) {
            var10000 = var54;
            var10001 = false;
            continue;
         }
      }
   }

   public void c() {
      Object var1 = this.g;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label578: {
         long var3;
         try {
            var3 = this.f;
         } catch (Throwable var75) {
            var10000 = var75;
            var10001 = false;
            break label578;
         }

         if (var3 > 0L) {
            label579: {
               label568: {
                  try {
                     this.d -= this.f;
                     if (this.d < 0L) {
                        this.d = 0L;
                     }
                  } catch (Throwable var74) {
                     var10000 = var74;
                     var10001 = false;
                     break label568;
                  }

                  label565:
                  try {
                     this.b = new Timer();
                     this.b.schedule(this.e(), this.d);
                     this.c = System.currentTimeMillis();
                     break label579;
                  } catch (Throwable var73) {
                     var10000 = var73;
                     var10001 = false;
                     break label565;
                  }
               }

               Throwable var5 = var10000;

               try {
                  if (this.a != null) {
                     this.a.v().b("Timer", "Encountered error while resuming timer", var5);
                  }
               } finally {
                  try {
                     this.f = 0L;
                  } catch (Throwable var70) {
                     var10000 = var70;
                     var10001 = false;
                     break label578;
                  }
               }
            }
         }

         label556:
         try {
            return;
         } catch (Throwable var71) {
            var10000 = var71;
            var10001 = false;
            break label556;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var69) {
            var10000 = var69;
            var10001 = false;
            continue;
         }
      }
   }

   public void d() {
      Object var1 = this.g;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label654: {
         Timer var3;
         try {
            var3 = this.b;
         } catch (Throwable var97) {
            var10000 = var97;
            var10001 = false;
            break label654;
         }

         if (var3 != null) {
            label644: {
               try {
                  this.b.cancel();
               } catch (Throwable var96) {
                  Throwable var4 = var96;
                  boolean var70 = false;

                  try {
                     var70 = true;
                     if (this.a != null) {
                        this.a.v().b("Timer", "Encountered error while cancelling timer", var4);
                        var70 = false;
                     } else {
                        var70 = false;
                     }
                  } finally {
                     if (var70) {
                        try {
                           this.b = null;
                           this.f = 0L;
                        } catch (Throwable var90) {
                           var10000 = var90;
                           var10001 = false;
                           break label654;
                        }
                     }
                  }

                  try {
                     this.b = null;
                     break label644;
                  } catch (Throwable var93) {
                     var10000 = var93;
                     var10001 = false;
                     break label654;
                  }
               }

               try {
                  this.b = null;
               } catch (Throwable var95) {
                  var10000 = var95;
                  var10001 = false;
                  break label654;
               }
            }

            try {
               this.f = 0L;
            } catch (Throwable var92) {
               var10000 = var92;
               var10001 = false;
               break label654;
            }
         }

         label634:
         try {
            return;
         } catch (Throwable var91) {
            var10000 = var91;
            var10001 = false;
            break label634;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var89) {
            var10000 = var89;
            var10001 = false;
            continue;
         }
      }
   }
}
