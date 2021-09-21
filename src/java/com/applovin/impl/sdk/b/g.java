package com.applovin.impl.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Set;

public final class g {
   private static SharedPreferences a;
   private final SharedPreferences b;

   public g(j var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("com.applovin.sdk.preferences.");
      var2.append(var1.t());
      String var5 = var2.toString();
      this.b = var1.D().getSharedPreferences(var5, 0);
   }

   private static SharedPreferences a(Context var0) {
      if (a == null) {
         a = var0.getSharedPreferences("com.applovin.sdk.shared", 0);
      }

      return a;
   }

   public static Object a(String var0, Object var1, Class var2, SharedPreferences var3) {
      ThreadPolicy var4 = StrictMode.allowThreadDiskReads();

      label4110: {
         Throwable var10000;
         label4111: {
            Object var11;
            boolean var10001;
            label4112: {
               label4113: {
                  try {
                     if (!var3.contains(var0)) {
                        break label4110;
                     }

                     if (Boolean.class.equals(var2)) {
                        break label4113;
                     }
                  } catch (Throwable var619) {
                     var10000 = var619;
                     var10001 = false;
                     break label4111;
                  }

                  label4114: {
                     try {
                        if (Float.class.equals(var2)) {
                           break label4114;
                        }
                     } catch (Throwable var618) {
                        var10000 = var618;
                        var10001 = false;
                        break label4111;
                     }

                     label4115: {
                        try {
                           if (!Integer.class.equals(var2)) {
                              break label4115;
                           }
                        } catch (Throwable var617) {
                           var10000 = var617;
                           var10001 = false;
                           break label4111;
                        }

                        int var15;
                        if (var1 != null) {
                           int var14;
                           label4061: {
                              try {
                                 if (var1.getClass().equals(Long.class)) {
                                    var14 = ((Long)var1).intValue();
                                    break label4061;
                                 }
                              } catch (Throwable var613) {
                                 var10000 = var613;
                                 var10001 = false;
                                 break label4111;
                              }

                              try {
                                 var14 = (Integer)var1;
                              } catch (Throwable var605) {
                                 var10000 = var605;
                                 var10001 = false;
                                 break label4111;
                              }
                           }

                           try {
                              var15 = var3.getInt(var0, var14);
                           } catch (Throwable var604) {
                              var10000 = var604;
                              var10001 = false;
                              break label4111;
                           }
                        } else {
                           try {
                              var15 = var3.getInt(var0, 0);
                           } catch (Throwable var603) {
                              var10000 = var603;
                              var10001 = false;
                              break label4111;
                           }
                        }

                        try {
                           var11 = var15;
                           break label4112;
                        } catch (Throwable var602) {
                           var10000 = var602;
                           var10001 = false;
                           break label4111;
                        }
                     }

                     label4116: {
                        try {
                           if (!Long.class.equals(var2)) {
                              break label4116;
                           }
                        } catch (Throwable var616) {
                           var10000 = var616;
                           var10001 = false;
                           break label4111;
                        }

                        long var18;
                        if (var1 != null) {
                           long var16;
                           label4070: {
                              try {
                                 if (var1.getClass().equals(Integer.class)) {
                                    var16 = ((Integer)var1).longValue();
                                    break label4070;
                                 }
                              } catch (Throwable var614) {
                                 var10000 = var614;
                                 var10001 = false;
                                 break label4111;
                              }

                              try {
                                 var16 = (Long)var1;
                              } catch (Throwable var601) {
                                 var10000 = var601;
                                 var10001 = false;
                                 break label4111;
                              }
                           }

                           try {
                              var18 = var3.getLong(var0, var16);
                           } catch (Throwable var600) {
                              var10000 = var600;
                              var10001 = false;
                              break label4111;
                           }
                        } else {
                           try {
                              var18 = var3.getLong(var0, 0L);
                           } catch (Throwable var599) {
                              var10000 = var599;
                              var10001 = false;
                              break label4111;
                           }
                        }

                        try {
                           var11 = var18;
                           break label4112;
                        } catch (Throwable var598) {
                           var10000 = var598;
                           var10001 = false;
                           break label4111;
                        }
                     }

                     try {
                        if (String.class.equals(var2)) {
                           var11 = var3.getString(var0, (String)var1);
                           break label4112;
                        }
                     } catch (Throwable var612) {
                        var10000 = var612;
                        var10001 = false;
                        break label4111;
                     }

                     try {
                        if (Set.class.isAssignableFrom(var2)) {
                           var11 = var3.getStringSet(var0, (Set)var1);
                           break label4112;
                        }
                     } catch (Throwable var615) {
                        var10000 = var615;
                        var10001 = false;
                        break label4111;
                     }

                     var11 = var1;
                     break label4112;
                  }

                  float var13;
                  if (var1 != null) {
                     try {
                        var13 = var3.getFloat(var0, (Float)var1);
                     } catch (Throwable var608) {
                        var10000 = var608;
                        var10001 = false;
                        break label4111;
                     }
                  } else {
                     try {
                        var13 = var3.getFloat(var0, 0.0F);
                     } catch (Throwable var607) {
                        var10000 = var607;
                        var10001 = false;
                        break label4111;
                     }
                  }

                  try {
                     var11 = var13;
                     break label4112;
                  } catch (Throwable var606) {
                     var10000 = var606;
                     var10001 = false;
                     break label4111;
                  }
               }

               boolean var10;
               if (var1 != null) {
                  try {
                     var10 = var3.getBoolean(var0, (Boolean)var1);
                  } catch (Throwable var611) {
                     var10000 = var611;
                     var10001 = false;
                     break label4111;
                  }
               } else {
                  try {
                     var10 = var3.getBoolean(var0, false);
                  } catch (Throwable var610) {
                     var10000 = var610;
                     var10001 = false;
                     break label4111;
                  }
               }

               try {
                  var11 = var10;
               } catch (Throwable var609) {
                  var10000 = var609;
                  var10001 = false;
                  break label4111;
               }
            }

            if (var11 == null) {
               StrictMode.setThreadPolicy(var4);
               return var1;
            }

            Object var12;
            try {
               var12 = var2.cast(var11);
            } catch (Throwable var597) {
               var10000 = var597;
               var10001 = false;
               break label4111;
            }

            StrictMode.setThreadPolicy(var4);
            return var12;
         }

         Throwable var5 = var10000;

         try {
            StringBuilder var6 = new StringBuilder();
            var6.append("Error getting value for key: ");
            var6.append(var0);
            p.c("SharedPreferencesManager", var6.toString(), var5);
         } finally {
            StrictMode.setThreadPolicy(var4);
         }

         return var1;
      }

      StrictMode.setThreadPolicy(var4);
      return var1;
   }

   public static void a(f var0, Context var1) {
      a(var1).edit().remove(var0.a()).apply();
   }

   public static void a(f var0, Object var1, Context var2) {
      a(var0.a(), var1, (SharedPreferences)a(var2), (Editor)null);
   }

   private static void a(String var0, Object var1, SharedPreferences var2, Editor var3) {
      boolean var4 = true;
      boolean var5;
      if (var3 != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (!var5) {
         var3 = var2.edit();
      }

      if (var1 instanceof Boolean) {
         var3.putBoolean(var0, (Boolean)var1);
      } else if (var1 instanceof Float) {
         var3.putFloat(var0, (Float)var1);
      } else if (var1 instanceof Integer) {
         var3.putInt(var0, (Integer)var1);
      } else if (var1 instanceof Long) {
         var3.putLong(var0, (Long)var1);
      } else if (var1 instanceof String) {
         var3.putString(var0, (String)var1);
      } else if (var1 instanceof Set) {
         var3.putStringSet(var0, (Set)var1);
      } else {
         StringBuilder var6 = new StringBuilder();
         var6.append("Unable to put default value of invalid type: ");
         var6.append(var1);
         p.j("SharedPreferencesManager", var6.toString());
         var4 = false;
      }

      if (var4 && !var5) {
         var3.apply();
      }

   }

   public static Object b(f var0, Object var1, Context var2) {
      return a(var0.a(), var1, var0.b(), a(var2));
   }

   public void a(SharedPreferences var1) {
      var1.edit().clear().apply();
   }

   public void a(f var1) {
      this.b.edit().remove(var1.a()).apply();
   }

   public void a(f var1, Object var2) {
      this.a(var1, var2, this.b);
   }

   public void a(f var1, Object var2, SharedPreferences var3) {
      this.a(var1.a(), var2, var3);
   }

   public void a(String var1, Object var2, Editor var3) {
      a(var1, var2, (SharedPreferences)null, (Editor)var3);
   }

   public void a(String var1, Object var2, SharedPreferences var3) {
      a(var1, var2, (SharedPreferences)var3, (Editor)null);
   }

   public Object b(f var1, Object var2) {
      return this.b(var1, var2, this.b);
   }

   public Object b(f var1, Object var2, SharedPreferences var3) {
      return a(var1.a(), var2, var1.b(), var3);
   }
}
