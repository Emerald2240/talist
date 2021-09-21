package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AppLovinBroadcastManager {
   private static AppLovinBroadcastManager f;
   private static final Object g = new Object();
   private final Context a;
   private final HashMap b = new HashMap();
   private final HashMap c = new HashMap();
   private final ArrayList d = new ArrayList();
   private final Handler e = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message var1) {
         if (var1.what == 1) {
            AppLovinBroadcastManager.this.a();
         } else {
            super.handleMessage(var1);
         }
      }
   };

   private AppLovinBroadcastManager(Context var1) {
      this.a = var1;
   }

   private List a(Intent var1) {
      HashMap var2 = this.b;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label1361: {
         Uri var6;
         String var7;
         Set var8;
         String var5;
         String var4;
         List var9;
         try {
            var4 = var1.getAction();
            var5 = var1.resolveTypeIfNeeded(this.a.getContentResolver());
            var6 = var1.getData();
            var7 = var1.getScheme();
            var8 = var1.getCategories();
            var9 = (List)this.c.get(var4);
         } catch (Throwable var172) {
            var10000 = var172;
            var10001 = false;
            break label1361;
         }

         if (var9 == null) {
            label1314:
            try {
               return null;
            } catch (Throwable var162) {
               var10000 = var162;
               var10001 = false;
               break label1314;
            }
         } else {
            label1365: {
               Iterator var10;
               try {
                  var10 = var9.iterator();
               } catch (Throwable var171) {
                  var10000 = var171;
                  var10001 = false;
                  break label1365;
               }

               ArrayList var11 = null;

               label1352:
               while(true) {
                  AppLovinBroadcastManager.b var13;
                  while(true) {
                     try {
                        if (!var10.hasNext()) {
                           break label1352;
                        }

                        var13 = (AppLovinBroadcastManager.b)var10.next();
                        if (!var13.c) {
                           break;
                        }
                     } catch (Throwable var170) {
                        var10000 = var170;
                        var10001 = false;
                        break label1365;
                     }
                  }

                  try {
                     if (var13.a.match(var4, var5, var7, var6, var8, "AppLovinBroadcastManager") < 0) {
                        continue;
                     }
                  } catch (Throwable var169) {
                     var10000 = var169;
                     var10001 = false;
                     break label1365;
                  }

                  ArrayList var14;
                  if (var11 == null) {
                     try {
                        var14 = new ArrayList();
                     } catch (Throwable var168) {
                        var10000 = var168;
                        var10001 = false;
                        break label1365;
                     }
                  } else {
                     var14 = var11;
                  }

                  try {
                     var14.add(var13);
                     var13.c = true;
                  } catch (Throwable var167) {
                     var10000 = var167;
                     var10001 = false;
                     break label1365;
                  }

                  var11 = var14;
               }

               if (var11 == null) {
                  label1316:
                  try {
                     return null;
                  } catch (Throwable var163) {
                     var10000 = var163;
                     var10001 = false;
                     break label1316;
                  }
               } else {
                  label1368: {
                     Iterator var12;
                     try {
                        var12 = var11.iterator();
                     } catch (Throwable var165) {
                        var10000 = var165;
                        var10001 = false;
                        break label1368;
                     }

                     while(true) {
                        try {
                           if (!var12.hasNext()) {
                              break;
                           }

                           ((AppLovinBroadcastManager.b)var12.next()).c = false;
                        } catch (Throwable var166) {
                           var10000 = var166;
                           var10001 = false;
                           break label1368;
                        }
                     }

                     label1318:
                     try {
                        return var11;
                     } catch (Throwable var164) {
                        var10000 = var164;
                        var10001 = false;
                        break label1318;
                     }
                  }
               }
            }
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var161) {
            var10000 = var161;
            var10001 = false;
            continue;
         }
      }
   }

   private void a() {
      label275:
      while(true) {
         HashMap var1 = this.b;
         synchronized(var1){}

         boolean var10001;
         Throwable var10000;
         label272: {
            int var3;
            try {
               var3 = this.d.size();
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label272;
            }

            if (var3 <= 0) {
               label265:
               try {
                  return;
               } catch (Throwable var29) {
                  var10000 = var29;
                  var10001 = false;
                  break label265;
               }
            } else {
               label277: {
                  AppLovinBroadcastManager.a[] var4;
                  try {
                     var4 = new AppLovinBroadcastManager.a[var3];
                     this.d.toArray(var4);
                     this.d.clear();
                  } catch (Throwable var30) {
                     var10000 = var30;
                     var10001 = false;
                     break label277;
                  }

                  int var6 = var4.length;
                  int var7 = 0;

                  while(true) {
                     if (var7 >= var6) {
                        continue label275;
                     }

                     AppLovinBroadcastManager.a var8 = var4[var7];
                     Iterator var9 = var8.b.iterator();

                     while(var9.hasNext()) {
                        AppLovinBroadcastManager.b var10 = (AppLovinBroadcastManager.b)var9.next();
                        if (!var10.d) {
                           var10.b.onReceive(this.a, var8.a);
                        }
                     }

                     ++var7;
                  }
               }
            }
         }

         while(true) {
            Throwable var2 = var10000;

            try {
               throw var2;
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public static AppLovinBroadcastManager getInstance(Context var0) {
      Object var1 = g;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label122: {
         try {
            if (f == null) {
               f = new AppLovinBroadcastManager(var0.getApplicationContext());
            }
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            AppLovinBroadcastManager var3 = f;
            return var3;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }

   public void registerReceiver(BroadcastReceiver var1, IntentFilter var2) {
      HashMap var3 = this.b;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label560: {
         AppLovinBroadcastManager.b var4;
         ArrayList var6;
         try {
            var4 = new AppLovinBroadcastManager.b(var2, var1);
            var6 = (ArrayList)this.b.get(var1);
         } catch (Throwable var86) {
            var10000 = var86;
            var10001 = false;
            break label560;
         }

         if (var6 == null) {
            try {
               var6 = new ArrayList(1);
               this.b.put(var1, var6);
            } catch (Throwable var85) {
               var10000 = var85;
               var10001 = false;
               break label560;
            }
         }

         Iterator var9;
         try {
            var6.add(var4);
            var9 = var2.actionsIterator();
         } catch (Throwable var83) {
            var10000 = var83;
            var10001 = false;
            break label560;
         }

         while(true) {
            ArrayList var11;
            String var10;
            try {
               if (!var9.hasNext()) {
                  break;
               }

               var10 = (String)var9.next();
               var11 = (ArrayList)this.c.get(var10);
            } catch (Throwable var84) {
               var10000 = var84;
               var10001 = false;
               break label560;
            }

            if (var11 == null) {
               try {
                  var11 = new ArrayList(1);
                  this.c.put(var10, var11);
               } catch (Throwable var82) {
                  var10000 = var82;
                  var10001 = false;
                  break label560;
               }
            }

            try {
               var11.add(var4);
            } catch (Throwable var81) {
               var10000 = var81;
               var10001 = false;
               break label560;
            }
         }

         label534:
         try {
            return;
         } catch (Throwable var80) {
            var10000 = var80;
            var10001 = false;
            break label534;
         }
      }

      while(true) {
         Throwable var5 = var10000;

         try {
            throw var5;
         } catch (Throwable var79) {
            var10000 = var79;
            var10001 = false;
            continue;
         }
      }
   }

   public boolean sendBroadcast(Intent var1) {
      HashMap var2 = this.b;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label251: {
         List var4;
         try {
            var4 = this.a(var1);
         } catch (Throwable var37) {
            var10000 = var37;
            var10001 = false;
            break label251;
         }

         if (var4 == null) {
            label242:
            try {
               return false;
            } catch (Throwable var34) {
               var10000 = var34;
               var10001 = false;
               break label242;
            }
         } else {
            label247: {
               try {
                  this.d.add(new AppLovinBroadcastManager.a(var1, var4));
                  if (!this.e.hasMessages(1)) {
                     this.e.sendEmptyMessage(1);
                  }
               } catch (Throwable var36) {
                  var10000 = var36;
                  var10001 = false;
                  break label247;
               }

               label244:
               try {
                  return true;
               } catch (Throwable var35) {
                  var10000 = var35;
                  var10001 = false;
                  break label244;
               }
            }
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var33) {
            var10000 = var33;
            var10001 = false;
            continue;
         }
      }
   }

   public void sendBroadcastSync(Intent var1) {
      List var2 = this.a(var1);
      if (var2 != null) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            AppLovinBroadcastManager.b var4 = (AppLovinBroadcastManager.b)var3.next();
            if (!var4.d) {
               var4.b.onReceive(this.a, var1);
            }
         }

      }
   }

   public void sendBroadcastSyncWithPendingBroadcasts(Intent var1) {
      if (this.sendBroadcast(var1)) {
         this.a();
      }

   }

   public void unregisterReceiver(BroadcastReceiver var1) {
      HashMap var2 = this.b;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label1023: {
         List var4;
         try {
            var4 = (List)this.b.remove(var1);
         } catch (Throwable var122) {
            var10000 = var122;
            var10001 = false;
            break label1023;
         }

         if (var4 == null) {
            label979:
            try {
               return;
            } catch (Throwable var114) {
               var10000 = var114;
               var10001 = false;
               break label979;
            }
         } else {
            label1027: {
               Iterator var5;
               try {
                  var5 = var4.iterator();
               } catch (Throwable var117) {
                  var10000 = var117;
                  var10001 = false;
                  break label1027;
               }

               label1017:
               while(true) {
                  AppLovinBroadcastManager.b var6;
                  Iterator var7;
                  try {
                     if (!var5.hasNext()) {
                        break;
                     }

                     var6 = (AppLovinBroadcastManager.b)var5.next();
                     var6.d = true;
                     var7 = var6.a.actionsIterator();
                  } catch (Throwable var119) {
                     var10000 = var119;
                     var10001 = false;
                     break label1027;
                  }

                  while(true) {
                     while(true) {
                        String var8;
                        List var9;
                        do {
                           try {
                              if (!var7.hasNext()) {
                                 continue label1017;
                              }

                              var8 = (String)var7.next();
                              var9 = (List)this.c.get(var8);
                           } catch (Throwable var118) {
                              var10000 = var118;
                              var10001 = false;
                              break label1027;
                           }
                        } while(var9 == null);

                        Iterator var10;
                        try {
                           var10 = var9.iterator();
                        } catch (Throwable var116) {
                           var10000 = var116;
                           var10001 = false;
                           break label1027;
                        }

                        label1006:
                        while(true) {
                           try {
                              do {
                                 if (!var10.hasNext()) {
                                    break label1006;
                                 }
                              } while(((AppLovinBroadcastManager.b)var10.next()).b != var1);

                              var6.d = true;
                              var10.remove();
                           } catch (Throwable var120) {
                              var10000 = var120;
                              var10001 = false;
                              break label1027;
                           }
                        }

                        try {
                           if (var9.size() <= 0) {
                              this.c.remove(var8);
                           }
                        } catch (Throwable var121) {
                           var10000 = var121;
                           var10001 = false;
                           break label1027;
                        }
                     }
                  }
               }

               label981:
               try {
                  return;
               } catch (Throwable var115) {
                  var10000 = var115;
                  var10001 = false;
                  break label981;
               }
            }
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var113) {
            var10000 = var113;
            var10001 = false;
            continue;
         }
      }
   }

   private static class a {
      final Intent a;
      final List b;

      a(Intent var1, List var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   private static class b {
      final IntentFilter a;
      final BroadcastReceiver b;
      boolean c;
      boolean d;

      b(IntentFilter var1, BroadcastReceiver var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
