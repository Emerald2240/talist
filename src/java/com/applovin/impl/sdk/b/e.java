package com.applovin.impl.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.q;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
   protected final j a;
   protected final p b;
   protected final Context c;
   protected final SharedPreferences d;
   private final Map e = new HashMap();
   private final Object f = new Object();
   private Map g;
   private final b h;

   public e(j var1) {
      this.a = var1;
      this.b = var1.v();
      this.c = var1.D();
      this.d = this.c.getSharedPreferences("com.applovin.sdk.1", 0);

      label53:
      try {
         Class.forName(d.class.getName());
         Class.forName(c.class.getName());
      } finally {
         break label53;
      }

      label50:
      try {
         Field var4 = q.a(var1.l().getClass(), "localSettings");
         var4.setAccessible(true);
         this.g = (HashMap)var4.get(var1.l());
      } finally {
         break label50;
      }

      this.h = new b(this, var1);
   }

   private static Object a(String var0, JSONObject var1, Object var2) throws JSONException {
      if (var2 instanceof Boolean) {
         return var1.getBoolean(var0);
      } else if (var2 instanceof Float) {
         return (float)var1.getDouble(var0);
      } else if (var2 instanceof Integer) {
         return var1.getInt(var0);
      } else if (var2 instanceof Long) {
         return var1.getLong(var0);
      } else if (var2 instanceof String) {
         return var1.getString(var0);
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("SDK Error: unknown value type: ");
         var3.append(var2.getClass());
         throw new RuntimeException(var3.toString());
      }
   }

   private Object c(d var1) {
      try {
         Object var3 = var1.a(this.g.get(var1.a()));
         return var3;
      } finally {
         ;
      }
   }

   private String f() {
      StringBuilder var1 = new StringBuilder();
      var1.append("com.applovin.sdk.");
      var1.append(q.a(this.a.t()));
      var1.append(".");
      return var1.toString();
   }

   public d a(String var1, d var2) {
      Object var3 = this.f;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label204: {
         Iterator var5;
         try {
            var5 = com.applovin.impl.sdk.b.d.c().iterator();
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label204;
         }

         try {
            while(var5.hasNext()) {
               d var6 = (d)var5.next();
               if (var6.a().equals(var1)) {
                  return var6;
               }
            }
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label204;
         }

         label194:
         try {
            return var2;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label194;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   public Object a(d var1) {
      if (var1 != null) {
         Object var2 = this.f;
         synchronized(var2){}

         boolean var10001;
         Throwable var10000;
         label657: {
            Object var4;
            try {
               var4 = this.c(var1);
            } catch (Throwable var99) {
               var10000 = var99;
               var10001 = false;
               break label657;
            }

            if (var4 != null) {
               label636:
               try {
                  return var4;
               } catch (Throwable var92) {
                  var10000 = var92;
                  var10001 = false;
                  break label636;
               }
            } else {
               label653: {
                  Object var5;
                  try {
                     var5 = this.e.get(var1.a());
                  } catch (Throwable var98) {
                     var10000 = var98;
                     var10001 = false;
                     break label653;
                  }

                  if (var5 == null) {
                     label663: {
                        Object var6;
                        try {
                           var6 = this.h.a(var1);
                        } catch (Throwable var96) {
                           var10000 = var96;
                           var10001 = false;
                           break label663;
                        }

                        Object var7;
                        if (var6 != null) {
                           try {
                              var7 = var1.a(var6);
                           } catch (Throwable var95) {
                              var10000 = var95;
                              var10001 = false;
                              break label663;
                           }
                        } else {
                           try {
                              var7 = var1.b();
                           } catch (Throwable var94) {
                              var10000 = var94;
                              var10001 = false;
                              break label663;
                           }
                        }

                        label638:
                        try {
                           return var7;
                        } catch (Throwable var93) {
                           var10000 = var93;
                           var10001 = false;
                           break label638;
                        }
                     }
                  } else {
                     label649:
                     try {
                        Object var8 = var1.a(var5);
                        return var8;
                     } catch (Throwable var97) {
                        var10000 = var97;
                        var10001 = false;
                        break label649;
                     }
                  }
               }
            }
         }

         while(true) {
            Throwable var3 = var10000;

            try {
               throw var3;
            } catch (Throwable var91) {
               var10000 = var91;
               var10001 = false;
               continue;
            }
         }
      } else {
         throw new IllegalArgumentException("No setting type specified");
      }
   }

   public void a() {
      this.h.a();
   }

   public void a(d param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(AppLovinSdkSettings var1) {
      if (var1 != null) {
         Object var2 = this.f;
         synchronized(var2){}

         boolean var10001;
         Throwable var10000;
         label2121: {
            try {
               if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.Z)) {
                  this.e.put(com.applovin.impl.sdk.b.d.Z.a(), var1.isVerboseLoggingEnabled());
               }
            } catch (Throwable var228) {
               var10000 = var228;
               var10001 = false;
               break label2121;
            }

            label2126: {
               String var14;
               label2110: {
                  try {
                     if (!(Boolean)this.a.a(com.applovin.impl.sdk.b.d.bD)) {
                        break label2126;
                     }

                     var14 = var1.getAutoPreloadSizes();
                     if (n.b(var14)) {
                        break label2110;
                     }
                  } catch (Throwable var227) {
                     var10000 = var227;
                     var10001 = false;
                     break label2121;
                  }

                  var14 = "NONE";
               }

               try {
                  if (var14.equals("NONE")) {
                     this.e.put(com.applovin.impl.sdk.b.d.bd.a(), "");
                     break label2126;
                  }
               } catch (Throwable var226) {
                  var10000 = var226;
                  var10001 = false;
                  break label2121;
               }

               try {
                  this.e.put(com.applovin.impl.sdk.b.d.bd.a(), var14);
               } catch (Throwable var225) {
                  var10000 = var225;
                  var10001 = false;
                  break label2121;
               }
            }

            label2129: {
               String var4;
               label2091: {
                  try {
                     if (!(Boolean)this.a.a(com.applovin.impl.sdk.b.d.bE)) {
                        break label2129;
                     }

                     var4 = var1.getAutoPreloadTypes();
                     if (n.b(var4)) {
                        break label2091;
                     }
                  } catch (Throwable var224) {
                     var10000 = var224;
                     var10001 = false;
                     break label2121;
                  }

                  var4 = "NONE";
               }

               boolean var5;
               try {
                  var5 = "NONE".equals(var4);
               } catch (Throwable var220) {
                  var10000 = var220;
                  var10001 = false;
                  break label2121;
               }

               boolean var6 = false;
               boolean var8;
               boolean var9;
               if (var5) {
                  var8 = false;
                  var6 = false;
                  var9 = false;
               } else {
                  Iterator var7;
                  try {
                     var7 = com.applovin.impl.sdk.utils.e.a(var4).iterator();
                  } catch (Throwable var219) {
                     var10000 = var219;
                     var10001 = false;
                     break label2121;
                  }

                  var8 = false;
                  var9 = false;

                  label2081:
                  while(true) {
                     while(true) {
                        String var13;
                        try {
                           if (!var7.hasNext()) {
                              break label2081;
                           }

                           var13 = (String)var7.next();
                           if (var13.equals(AppLovinAdType.REGULAR.getLabel())) {
                              break;
                           }
                        } catch (Throwable var222) {
                           var10000 = var222;
                           var10001 = false;
                           break label2121;
                        }

                        label2076: {
                           try {
                              if (!var13.equals(AppLovinAdType.INCENTIVIZED.getLabel()) && !var13.contains("INCENT") && !var13.contains("REWARD")) {
                                 break label2076;
                              }
                           } catch (Throwable var223) {
                              var10000 = var223;
                              var10001 = false;
                              break label2121;
                           }

                           var8 = true;
                           continue;
                        }

                        try {
                           if (!var13.equals(AppLovinAdType.NATIVE.getLabel())) {
                              continue;
                           }
                        } catch (Throwable var221) {
                           var10000 = var221;
                           var10001 = false;
                           break label2121;
                        }

                        var9 = true;
                     }

                     var6 = true;
                  }
               }

               if (!var6) {
                  try {
                     this.e.put(com.applovin.impl.sdk.b.d.bd.a(), "");
                  } catch (Throwable var218) {
                     var10000 = var218;
                     var10001 = false;
                     break label2121;
                  }
               }

               try {
                  this.e.put(com.applovin.impl.sdk.b.d.be.a(), var8);
                  this.e.put(com.applovin.impl.sdk.b.d.bf.a(), var9);
               } catch (Throwable var217) {
                  var10000 = var217;
                  var10001 = false;
                  break label2121;
               }
            }

            label2048:
            try {
               return;
            } catch (Throwable var216) {
               var10000 = var216;
               var10001 = false;
               break label2048;
            }
         }

         while(true) {
            Throwable var3 = var10000;

            try {
               throw var3;
            } catch (Throwable var215) {
               var10000 = var215;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void a(JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   public List b(d var1) {
      return com.applovin.impl.sdk.utils.e.a((String)this.a(var1));
   }

   public void b() {
      if (this.c != null) {
         String var2 = this.f();
         Object var3 = this.f;
         synchronized(var3){}

         boolean var10001;
         Throwable var10000;
         label303: {
            Editor var5;
            Iterator var6;
            try {
               var5 = this.d.edit();
               var6 = com.applovin.impl.sdk.b.d.c().iterator();
            } catch (Throwable var42) {
               var10000 = var42;
               var10001 = false;
               break label303;
            }

            while(true) {
               Object var8;
               d var7;
               try {
                  if (!var6.hasNext()) {
                     break;
                  }

                  var7 = (d)var6.next();
                  var8 = this.e.get(var7.a());
               } catch (Throwable var43) {
                  var10000 = var43;
                  var10001 = false;
                  break label303;
               }

               if (var8 != null) {
                  try {
                     StringBuilder var9 = new StringBuilder();
                     var9.append(var2);
                     var9.append(var7.a());
                     String var12 = var9.toString();
                     this.a.a(var12, var8, var5);
                  } catch (Throwable var41) {
                     var10000 = var41;
                     var10001 = false;
                     break label303;
                  }
               }
            }

            label283:
            try {
               var5.apply();
               return;
            } catch (Throwable var40) {
               var10000 = var40;
               var10001 = false;
               break label283;
            }
         }

         while(true) {
            Throwable var4 = var10000;

            try {
               throw var4;
            } catch (Throwable var39) {
               var10000 = var39;
               var10001 = false;
               continue;
            }
         }
      } else {
         IllegalArgumentException var1 = new IllegalArgumentException("No context specified");
         throw var1;
      }
   }

   public void c() {
      // $FF: Couldn't be decompiled
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }

   public boolean e() {
      return this.a.l().isVerboseLoggingEnabled() || (Boolean)this.a(com.applovin.impl.sdk.b.d.Z);
   }
}
