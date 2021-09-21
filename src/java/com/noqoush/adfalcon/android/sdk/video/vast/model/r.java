package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class r {
   public static final int x = 30000;
   private static final int y = 5000;
   private int a;
   private int b;
   private b c;
   private b d;
   private m e;
   private ArrayList f;
   private ArrayList g;
   private ArrayList h;
   private String i;
   private String j;
   private ArrayList k;
   private j l;
   private q m;
   private o n;
   private t o;
   private List p;
   private int q;
   private int r;
   private int s;
   private boolean t;
   private int u;
   private String v;
   private com.noqoush.adfalcon.android.sdk.video.vast.manager.g w;

   private static p a(p var0) throws Exception {
      if (var0 != null && var0.c() != null) {
         if (var0.c().size() == 0) {
            return null;
         }

         a var1 = (a)var0.c().get(0);
         if (var1.c() != null) {
            return var0;
         }

         if (var1.d() != null) {
            return a(var1.d().p());
         }
      }

      return null;
   }

   private static ArrayList a(k var0, int var1) throws Exception {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.h().c().iterator();

      while(var3.hasNext()) {
         e var4 = (e)var3.next();
         if (var4.b() == var1) {
            if (var4.g() != null) {
               var2.add(0, var4);
            } else {
               var2.add(var4);
            }
         }
      }

      return var2;
   }

   private static ArrayList a(p var0, int var1) throws Exception {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.c().iterator();

      while(var3.hasNext()) {
         a var4 = (a)var3.next();
         if (var4.b() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public static Queue a(Context var0, p var1) throws Exception {
      LinkedList var2 = new LinkedList();
      p var3 = a(var1);
      if (var3 == null) {
         return var2;
      } else {
         int var4 = var3.e();
         int var5 = 0;
         boolean var6 = false;
         int var7 = -1;

         p var17;
         for(m var8 = null; var5 <= var4; var3 = var17) {
            Iterator var16 = a(var3, var5).iterator();

            int var18;
            while(true) {
               if (!var16.hasNext()) {
                  var17 = var3;
                  var18 = var4;
                  break;
               }

               a var20 = (a)var16.next();
               if (var20.d() != null) {
                  com.noqoush.adfalcon.android.sdk.k.e("There is a wrapper in VAST ad!");
               } else if (var20.c() == null) {
                  com.noqoush.adfalcon.android.sdk.k.e("No wrapper or inline in VAST ad!");
               } else {
                  List var23;
                  j var21;
                  s var27;
                  o var24;
                  int var26;
                  v var25;
                  q var22;
                  if (var20.c().k() != null) {
                     Iterator var61 = var20.c().k().iterator();
                     var23 = null;
                     var24 = null;
                     q var62 = null;
                     j var63 = null;
                     v var64 = null;
                     int var65 = 0;
                     s var66 = null;

                     while(var61.hasNext()) {
                        i var67 = (i)var61.next();
                        if (var67.c() != null && var67.c().size() > 0) {
                           var23 = var67.c();
                        }

                        if (var67.h() != null) {
                           var24 = var67.h();
                        }

                        if (var67.i() != null) {
                           var62 = var67.i();
                        }

                        if (var67.d() != null) {
                           var63 = var67.d();
                        }

                        if (var67.f() != null) {
                           var64 = var67.f();
                        }

                        if (var67.e() != null) {
                           var66 = var67.e();
                        }

                        if (var67.g() != 0) {
                           var65 = var67.g();
                        }
                     }

                     var22 = var62;
                     var21 = var63;
                     var25 = var64;
                     var26 = var65;
                     var27 = var66;
                  } else {
                     var21 = null;
                     var22 = null;
                     var23 = null;
                     var24 = null;
                     var25 = null;
                     var26 = 0;
                     var27 = null;
                  }

                  if (var20.c().h() != null) {
                     int var28 = var20.c().h().d();
                     boolean var29 = var6;
                     int var30 = 0;

                     label259:
                     while(true) {
                        if (var30 > var28) {
                           var17 = var3;
                           var18 = var4;
                           var6 = var29;
                           break;
                        }

                        ArrayList var31 = a(var20.c(), var30);
                        int var37;
                        v var36;
                        s var38;
                        int var35;
                        if (var31.size() == 0) {
                           var17 = var3;
                           var18 = var4;
                           var35 = var28;
                           var36 = var25;
                           var37 = var26;
                           var38 = var27;
                        } else {
                           var17 = var3;
                           r var32 = new r();
                           Iterator var33 = var31.iterator();
                           var18 = var4;
                           boolean var34 = var29;

                           while(true) {
                              while(var33.hasNext()) {
                                 e var46 = (e)var33.next();
                                 int var47;
                                 if (var46.g() != null) {
                                    var47 = var28;
                                    if (var46.g().b(var0)) {
                                       var32.a(var46.g());
                                       var32.a(var46.h());
                                       if (var8 == null) {
                                          m var59 = var32.o();
                                          n var60 = var59.a(var0);
                                          if (var60 != null) {
                                             var34 = true ^ var60.m();
                                             var8 = var59;
                                          } else {
                                             var8 = var59;
                                          }
                                       }

                                       String var48 = var32.o().g();
                                       m var49 = var32.o();
                                       int var51 = com.noqoush.adfalcon.android.sdk.video.vast.manager.h.a(var48, var49.d());
                                       int var52 = var32.o().d();
                                       var32.f(com.noqoush.adfalcon.android.sdk.video.vast.manager.h.a("75%", var52));
                                       if (var51 > 0) {
                                          var32.a(true);
                                       } else {
                                          var32.a(false);
                                       }

                                       if (var32.h() == null) {
                                          var32.a(var32.o().c("AdChoices"));
                                       }

                                       if (var46.f() != null) {
                                          Iterator var54 = var46.f().iterator();

                                          while(var54.hasNext()) {
                                             i var55 = (i)var54.next();
                                             Iterator var56;
                                             if (var55.f() != null && var32.o().i() != null) {
                                                v var58 = var32.o().i();
                                                var56 = var54;
                                                var58.a(var55.f());
                                             } else {
                                                var56 = var54;
                                             }

                                             if (var55.e() != null) {
                                                if (var32.o().h() == null) {
                                                   var32.o().c(new ArrayList());
                                                }

                                                var32.o().h().add(var55.e());
                                                var54 = var56;
                                             } else {
                                                var54 = var56;
                                             }
                                          }
                                       }

                                       var28 = var28;
                                       var8 = var8;
                                       var34 = var34;
                                       continue;
                                    }
                                 } else {
                                    var47 = var28;
                                 }

                                 if (var46.e() != null) {
                                    if (var32.f() == null) {
                                       var32.a(var46.e().a(var0, var34));
                                    }

                                    if (var32.k() == null) {
                                       var32.b(var46.e().b(var0, var34));
                                    }
                                 }

                                 var28 = var47;
                              }

                              var35 = var28;
                              if (var32.o() != null) {
                                 var32.b(var20.c().e());
                                 var32.c(var20.c().g());
                                 var32.a(var20.c().c());
                                 var32.b(new ArrayList(var20.c().l()));
                                 if (var20.c().m() != null) {
                                    var32.d(var20.c().m());
                                 }

                                 if (var20.c().f() != null) {
                                    var32.d().addAll(var20.c().f());
                                 }

                                 var32.a(new ArrayList(var20.c().j()));
                                 var32.a(var5);
                                 var32.b(var30);
                                 var32.c(new ArrayList());
                                 var32.c(var32.o().d());
                                 if (var23 == null) {
                                    var29 = var34;
                                 } else {
                                    Iterator var41 = var23.iterator();

                                    while(var41.hasNext()) {
                                       u var42 = (u)var41.next();
                                       if (var42.g() != null) {
                                          var32.d(var42.g());
                                       } else {
                                          var32.d().add(var42);
                                          var34 = var34;
                                       }
                                    }

                                    var29 = var34;
                                 }

                                 if (var24 != null) {
                                    var32.a(var24);
                                 }

                                 if (var22 != null) {
                                    var32.a(var22);
                                 }

                                 if (var32.h() == null && var21 != null) {
                                    var32.a(var21);
                                 }

                                 if (var32.o().i() != null) {
                                    var36 = var25;
                                    if (var25 != null && var32.o().i().k() == null && var32.o().i().h() == null && var32.o().i().i() == null) {
                                       var32.o().i().a(var25);
                                    }
                                 } else {
                                    var36 = var25;
                                 }

                                 var38 = var27;
                                 if (var27 != null && !var32.o().h().contains(var27)) {
                                    var32.o().h().add(var27);
                                 }

                                 var37 = var26;
                                 if (var26 != 0) {
                                    var32.e(var26);
                                 }

                                 var2.add(var32);
                                 if (var30 == 0) {
                                    var6 = var29;
                                    break label259;
                                 }
                              } else {
                                 var29 = var34;
                                 var36 = var25;
                                 var37 = var26;
                                 var38 = var27;
                              }
                              break;
                           }
                        }

                        ++var30;
                        var25 = var36;
                        var27 = var38;
                        var26 = var37;
                        var3 = var17;
                        var4 = var18;
                        var28 = var35;
                     }

                     if (var2.size() >= 1 && (var5 == 0 || var7 == var5)) {
                        break;
                     }

                     var3 = var17;
                     var4 = var18;
                  }
               }
            }

            if (var2.size() >= 1 && (var5 == 0 || var7 == var5)) {
               break;
            }

            int var19 = var5 + 1;
            var7 = var5;
            var4 = var18;
            var5 = var19;
         }

         a(var0, var2, var1, var6);
         ArrayList var9 = new ArrayList();
         Iterator var10 = var2.iterator();
         int var11 = 0;

         while(var10.hasNext()) {
            r var14 = (r)var10.next();
            if (var11 > 120) {
               var9.add(var14);
            } else {
               var11 += var14.i();
            }
         }

         Iterator var12 = var9.iterator();

         while(var12.hasNext()) {
            var2.remove((r)var12.next());
         }

         return var2;
      }
   }

   private static void a(Context var0, Queue var1, p var2, boolean var3) throws Exception {
      ArrayList var4 = new ArrayList();
      p var5 = var2;

      a var6;
      do {
         var6 = (a)var5.c().get(0);
         if (var6.d() != null) {
            var5 = var6.d().p();
            var4.add(0, var6.d());
         }
      } while(var6.d() != null);

      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         r var8 = (r)var7.next();
         Iterator var9 = var4.iterator();

         while(var9.hasNext()) {
            y var10 = (y)var9.next();
            ArrayList var11 = var10.k();
            List var12 = null;
            o var13;
            j var15;
            int var18;
            v var17;
            q var14;
            s var16;
            if (var11 != null) {
               Iterator var27 = var10.k().iterator();
               var13 = null;
               var14 = null;
               var15 = null;
               var16 = null;
               var17 = null;
               var18 = 0;

               while(var27.hasNext()) {
                  i var28 = (i)var27.next();
                  if (var28.c() != null) {
                     var12 = var28.c();
                  }

                  if (var28.h() != null) {
                     var13 = var28.h();
                  }

                  if (var28.i() != null) {
                     var14 = var28.i();
                  }

                  if (var28.d() != null) {
                     var15 = var28.d();
                  }

                  if (var28.e() != null) {
                     var16 = var28.e();
                  }

                  if (var28.f() != null) {
                     var17 = var28.f();
                  }

                  if (var28.g() != 0) {
                     var18 = var28.g();
                  }
               }
            } else {
               var13 = null;
               var14 = null;
               var15 = null;
               var16 = null;
               var17 = null;
               var18 = 0;
            }

            if (var12 != null) {
               Iterator var24 = var12.iterator();

               while(var24.hasNext()) {
                  u var25 = (u)var24.next();
                  if (var25.g() != null) {
                     var8.d(var25.g());
                  } else {
                     var8.d().add(var25);
                  }
               }
            }

            if (var8.p() == null && var13 != null) {
               var8.a(var13);
            }

            if (var8.q() == null && var14 != null) {
               var8.a(var14);
            }

            if (var8.h() == null && var15 != null) {
               var8.a(var15);
            }

            if (var16 != null && !var8.o().h().contains(var16)) {
               var8.o().h().add(var16);
            }

            if (var17 != null && var8.o().i() != null && var8.o().i().k() == null && var8.o().i().h() == null && var8.o().i().i() == null) {
               var8.o().i().a(var17);
            }

            if (var8.l() == 0 && var18 != 0) {
               var8.e(var18);
            }

            if (var8.f() == null) {
               var8.a(var10.a(var0, var3));
            }

            if (var8.k() == null) {
               var8.b(var10.b(var0, var3));
            }

            if (var8.u() == null) {
               var8.c(new ArrayList());
            }

            var8.n().addAll(var10.l());
            if (var10.m() != null) {
               var8.d(var10.m());
            }

            if (var10.f() != null) {
               var8.d().addAll(var10.f());
            }

            var8.m().addAll(var10.j());
            var8.u().add(var10);
         }

         if (var8.o().i() != null && var8.o().i().k() == null && var8.o().i().h() == null && var8.o().i().i() == null) {
            var8.o().i().h("Visit Advertiser's Site");
            var8.o().i().g("http://cdn01.adfalcon.com/static/iv2/img/moreInfoBtn.png");
            var8.o().i().f("image/png");
            var8.o().i().c(120);
            var8.o().i().b(30);
         }
      }

   }

   private void d(ArrayList var1) {
      if (this.h == null) {
         this.h = new ArrayList();
      }

      this.h.addAll(var1);
   }

   public int a() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }

   public void a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(Context var1, boolean var2, boolean var3) {
      Exception var10000;
      label71: {
         boolean var10001;
         try {
            if (this.t() == null) {
               return;
            }

            if (this.t().size() == 0) {
               return;
            }
         } catch (Exception var18) {
            var10000 = var18;
            var10001 = false;
            break label71;
         }

         com.noqoush.adfalcon.android.sdk.video.vast.manager.g var5;
         Vector var6;
         Iterator var7;
         try {
            var5 = this.c(var1, (String)null);
            var6 = new Vector();
            var7 = this.t().iterator();
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label71;
         }

         while(true) {
            x var9;
            try {
               if (!var7.hasNext()) {
                  break;
               }

               var9 = (x)var7.next();
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label71;
            }

            String var10;
            if (var2) {
               try {
                  var10 = var9.e();
               } catch (Exception var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label71;
               }
            } else if (!var3) {
               try {
                  var10 = var9.c();
               } catch (Exception var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label71;
               }
            } else {
               try {
                  var10 = var9.d();
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label71;
               }
            }

            if (var10 != null) {
               try {
                  var6.add(var5.a(var10));
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label71;
               }
            }
         }

         try {
            (new com.noqoush.adfalcon.android.sdk.helper.c(var1, var6)).a((com.noqoush.adfalcon.android.sdk.response.b)null, (String)null);
            return;
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
         }
      }

      Exception var4 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var4);
   }

   public void a(b var1) {
      this.c = var1;
   }

   public void a(b var1, Context var2) {
      Exception var10000;
      label127: {
         boolean var10001;
         com.noqoush.adfalcon.android.sdk.video.vast.manager.g var4;
         try {
            var4 = this.c(var2, (String)null);
            var1.a(var2, var4);
            if (this.u() == null) {
               return;
            }
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label127;
         }

         boolean var5 = false;

         Iterator var6;
         try {
            var6 = this.u().iterator();
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
            break label127;
         }

         label117:
         while(true) {
            Iterator var8;
            ArrayList var7;
            try {
               if (!var6.hasNext()) {
                  return;
               }

               var7 = ((y)var6.next()).n();
               var8 = var7.iterator();
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break;
            }

            label114: {
               while(true) {
                  b var11;
                  try {
                     if (!var8.hasNext()) {
                        break label114;
                     }

                     var11 = (b)var8.next();
                     if (var1.g() == var11.g() && var1.l() == var1.l()) {
                        break;
                     }
                  } catch (Exception var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label117;
                  }

                  try {
                     if (var1.a() == null || !var1.a().equalsIgnoreCase(var11.a())) {
                        continue;
                     }
                     break;
                  } catch (Exception var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label117;
                  }
               }

               var5 = true;
            }

            Iterator var9;
            try {
               var9 = var7.iterator();
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break;
            }

            while(true) {
               b var10;
               while(true) {
                  label93: {
                     try {
                        if (!var9.hasNext()) {
                           continue label117;
                        }

                        var10 = (b)var9.next();
                        if (var10.u()) {
                           break label93;
                        }

                        if (var1.g() == var10.g() && var1.l() == var1.l()) {
                           break;
                        }
                     } catch (Exception var18) {
                        var10000 = var18;
                        var10001 = false;
                        break label117;
                     }

                     try {
                        if (var1.a() != null && var1.a().equalsIgnoreCase(var10.a())) {
                           break;
                        }
                     } catch (Exception var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label117;
                     }
                  }

                  try {
                     if (var10.u()) {
                        continue;
                     }
                  } catch (Exception var16) {
                     var10000 = var16;
                     var10001 = false;
                     break label117;
                  }

                  if (!var5) {
                     try {
                        if (var10.a() == null && var10.g() == 0 && var10.l() == 0) {
                           var10.a(var2, var4);
                        }
                     } catch (Exception var15) {
                        var10000 = var15;
                        var10001 = false;
                        break label117;
                     }
                  }
               }

               try {
                  var10.a(var2, var4);
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label117;
               }
            }
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
   }

   public void a(b var1, Context var2, String var3) {
      Exception var10000;
      label127: {
         com.noqoush.adfalcon.android.sdk.video.vast.manager.g var5;
         boolean var10001;
         try {
            var5 = this.c(var2, (String)null);
            var1.a(var2, var3, this.j(), var5);
            if (this.u() == null) {
               return;
            }
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label127;
         }

         boolean var6 = false;

         Iterator var7;
         try {
            var7 = this.u().iterator();
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label127;
         }

         label117:
         while(true) {
            ArrayList var8;
            Iterator var9;
            try {
               if (!var7.hasNext()) {
                  return;
               }

               var8 = ((y)var7.next()).n();
               var9 = var8.iterator();
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break;
            }

            label114: {
               while(true) {
                  b var12;
                  try {
                     if (!var9.hasNext()) {
                        break label114;
                     }

                     var12 = (b)var9.next();
                     if (var1.g() == var12.g() && var1.l() == var1.l()) {
                        break;
                     }
                  } catch (Exception var21) {
                     var10000 = var21;
                     var10001 = false;
                     break label117;
                  }

                  try {
                     if (var1.a() == null || !var1.a().equalsIgnoreCase(var12.a())) {
                        continue;
                     }
                     break;
                  } catch (Exception var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label117;
                  }
               }

               var6 = true;
            }

            Iterator var10;
            try {
               var10 = var8.iterator();
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break;
            }

            while(true) {
               b var11;
               while(true) {
                  label93: {
                     try {
                        if (!var10.hasNext()) {
                           continue label117;
                        }

                        var11 = (b)var10.next();
                        if (var11.u()) {
                           break label93;
                        }

                        if (var1.g() == var11.g() && var1.l() == var1.l()) {
                           break;
                        }
                     } catch (Exception var19) {
                        var10000 = var19;
                        var10001 = false;
                        break label117;
                     }

                     try {
                        if (var1.a() != null && var1.a().equalsIgnoreCase(var11.a())) {
                           break;
                        }
                     } catch (Exception var18) {
                        var10000 = var18;
                        var10001 = false;
                        break label117;
                     }
                  }

                  try {
                     if (var11.u()) {
                        continue;
                     }
                  } catch (Exception var17) {
                     var10000 = var17;
                     var10001 = false;
                     break label117;
                  }

                  if (!var6) {
                     try {
                        if (var11.a() == null && var11.g() == 0 && var11.l() == 0) {
                           var11.a(var2, var3, this.j(), var5);
                        }
                     } catch (Exception var16) {
                        var10000 = var16;
                        var10001 = false;
                        break label117;
                     }
                  }
               }

               try {
                  var11.a(var2, var3, this.j(), var5);
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label117;
               }
            }
         }
      }

      Exception var4 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var4);
   }

   public void a(j var1) {
      this.l = var1;
   }

   public void a(m var1) {
      this.e = var1;
   }

   public void a(o var1) {
      this.n = var1;
   }

   public void a(q var1) {
      this.m = var1;
   }

   public void a(t var1) {
      this.o = var1;
   }

   public void a(String var1) {
      this.v = var1;
   }

   public void a(ArrayList var1) {
      this.g = var1;
   }

   public void a(List var1) {
      this.p = var1;
   }

   public void a(boolean var1) {
      this.t = var1;
   }

   public String b() {
      return this.v;
   }

   public void b(int var1) {
      this.b = var1;
   }

   public void b(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void b(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(b var1) {
      this.d = var1;
   }

   public void b(String var1) {
      this.i = var1;
   }

   public void b(ArrayList var1) {
      this.f = var1;
   }

   public com.noqoush.adfalcon.android.sdk.video.vast.manager.g c(Context var1, String var2) {
      if (this.w == null) {
         this.w = new com.noqoush.adfalcon.android.sdk.video.vast.manager.g(var1, this);
      }

      this.w.a(this.j());
      return this.w;
   }

   public String c() {
      return this.i;
   }

   public void c(int var1) {
      this.r = var1;
   }

   public void c(String var1) {
      this.j = var1;
   }

   public void c(ArrayList var1) {
      this.k = var1;
   }

   public List d() {
      if (this.p == null) {
         this.p = new ArrayList();
      }

      return this.p;
   }

   public void d(int var1) {
      this.s = var1;
   }

   public String e() {
      return this.j;
   }

   public void e(int var1) {
      this.u = var1;
   }

   public b f() {
      return this.c;
   }

   public void f(int var1) {
      this.q = var1;
   }

   public int g() {
      return this.b;
   }

   public j h() {
      return this.l;
   }

   public int i() {
      return this.r;
   }

   public int j() {
      return this.s;
   }

   public b k() {
      return this.d;
   }

   public int l() {
      int var1 = this.u;
      if (var1 < 5000 && var1 != 0) {
         this.u = 5000;
      }

      return this.u;
   }

   public ArrayList m() {
      return this.g;
   }

   public ArrayList n() {
      return this.f;
   }

   public m o() {
      return this.e;
   }

   public o p() {
      return this.n;
   }

   public q q() {
      return this.m;
   }

   public int r() {
      return this.q;
   }

   public t s() {
      return this.o;
   }

   public ArrayList t() {
      return this.h;
   }

   public ArrayList u() {
      return this.k;
   }

   public boolean v() {
      return this.t;
   }
}
