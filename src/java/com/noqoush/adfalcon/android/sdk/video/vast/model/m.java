package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class m extends g {
   private String c;
   private ArrayList d = new ArrayList();
   private ArrayList e = new ArrayList();
   private String f;
   private v g;
   private ArrayList h = new ArrayList();
   private n i;

   public n a(Context var1) {
      n var2 = this.i;
      if (var2 != null) {
         return var2;
      } else {
         Exception var10000;
         label166: {
            boolean var10001;
            int var6;
            int var5;
            try {
               com.noqoush.adfalcon.android.sdk.g var4 = com.noqoush.adfalcon.android.sdk.g.c(var1);
               var5 = Math.max(var4.v(), var4.u());
               var6 = Math.min(var4.v(), var4.u());
            } catch (Exception var40) {
               var10000 = var40;
               var10001 = false;
               break label166;
            }

            double var7 = (double)var5;
            Double.isNaN(var7);
            int var10 = (int)(var7 * 1.5D);
            double var11 = (double)var6;
            Double.isNaN(var11);
            int var14 = (int)(var11 * 1.5D);

            Iterator var15;
            try {
               var15 = this.f().iterator();
            } catch (Exception var33) {
               var10000 = var33;
               var10001 = false;
               break label166;
            }

            label155:
            while(true) {
               n var17;
               boolean var19;
               label153: {
                  label168: {
                     int var24;
                     while(true) {
                        try {
                           if (!var15.hasNext()) {
                              break label155;
                           }

                           var17 = (n)var15.next();
                           if (!var17.o()) {
                              continue;
                           }

                           if (var17.m()) {
                              var24 = var17.g();
                              break;
                           }
                        } catch (Exception var39) {
                           var10000 = var39;
                           var10001 = false;
                           break label166;
                        }

                        int var18;
                        try {
                           var18 = var17.g();
                        } catch (Exception var31) {
                           var10000 = var31;
                           var10001 = false;
                           break label166;
                        }

                        var19 = false;
                        if (var18 > var10) {
                           break label153;
                        }

                        int var20;
                        try {
                           var20 = var17.l();
                        } catch (Exception var30) {
                           var10000 = var30;
                           var10001 = false;
                           break label166;
                        }

                        var19 = false;
                        if (var20 > var14) {
                           break label153;
                        }
                        break label168;
                     }

                     var19 = false;
                     if (var24 > var14) {
                        break label153;
                     }

                     int var25;
                     try {
                        var25 = var17.l();
                     } catch (Exception var32) {
                        var10000 = var32;
                        var10001 = false;
                        break label166;
                     }

                     var19 = false;
                     if (var25 > var10) {
                        break label153;
                     }
                  }

                  var19 = true;
               }

               label131: {
                  try {
                     if (this.i != null) {
                        break label131;
                     }
                  } catch (Exception var38) {
                     var10000 = var38;
                     var10001 = false;
                     break label166;
                  }

                  if (var19) {
                     try {
                        this.i = var17;
                        continue;
                     } catch (Exception var29) {
                        var10000 = var29;
                        var10001 = false;
                        break label166;
                     }
                  }
               }

               if (var19) {
                  try {
                     if (var17.n() && !this.i.n()) {
                        this.i = var17;
                        continue;
                     }
                  } catch (Exception var37) {
                     var10000 = var37;
                     var10001 = false;
                     break label166;
                  }

                  label116: {
                     try {
                        if (var17.n() && this.i.n()) {
                           break label116;
                        }
                     } catch (Exception var36) {
                        var10000 = var36;
                        var10001 = false;
                        break label166;
                     }

                     try {
                        if (var17.n() || this.i.n()) {
                           continue;
                        }
                     } catch (Exception var35) {
                        var10000 = var35;
                        var10001 = false;
                        break label166;
                     }
                  }

                  int var23;
                  try {
                     double var21 = (double)(this.i.l() * this.i.g());
                     double var41;
                     var23 = (var41 = (double)(var17.l() * var17.g()) - var21) == 0.0D ? 0 : (var41 < 0.0D ? -1 : 1);
                  } catch (Exception var28) {
                     var10000 = var28;
                     var10001 = false;
                     break label166;
                  }

                  if (var23 > 0) {
                     try {
                        this.i = var17;
                     } catch (Exception var27) {
                        var10000 = var27;
                        var10001 = false;
                        break label166;
                     }
                  } else if (var23 == 0) {
                     try {
                        if (this.i.d() > var17.d()) {
                           this.i = var17;
                        }
                     } catch (Exception var34) {
                        var10000 = var34;
                        var10001 = false;
                        break label166;
                     }
                  }
               }
            }

            try {
               n var16 = this.i;
               return var16;
            } catch (Exception var26) {
               var10000 = var26;
               var10001 = false;
            }
         }

         Exception var3 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         return null;
      }
   }

   public void a(Context var1, String var2, int var3, com.noqoush.adfalcon.android.sdk.video.vast.manager.g var4, int var5) {
      Iterator var6 = this.h().iterator();

      while(var6.hasNext()) {
         ((s)var6.next()).a(var1, var2, var3, var4, var5);
      }

   }

   public void a(v var1) {
      this.g = var1;
   }

   public void a(ArrayList var1) {
      this.h = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("linear")) {
               return;
            }
         } else if (var3 != null) {
            if (var3.equalsIgnoreCase("linear")) {
               super.a(var1);
               this.e(var1.getAttributeValue((String)null, "skipoffset"));
            } else if (var3.equalsIgnoreCase("duration")) {
               this.d(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("tracking")) {
               if (this.h() == null) {
                  this.c(new ArrayList());
               }

               s var8 = new s();
               var8.a(var1.getAttributeValue((String)null, "event"));
               String var9 = var1.getAttributeValue((String)null, "offset");
               if (var9 != null && var9.length() > 0) {
                  var8.b(var9);
               }

               var8.c(var1.nextText().trim());
               this.h().add(var8);
            } else if (var3.equalsIgnoreCase("videoclicks")) {
               this.a(new v());
               this.i().a(var1);
            } else if (var3.equalsIgnoreCase("mediafile")) {
               if (this.f() == null) {
                  this.b(new ArrayList());
               }

               n var6 = new n();
               var6.a(var1);
               this.f().add(var6);
            } else if (var3.equalsIgnoreCase("icon")) {
               if (this.e() == null) {
                  this.a(new ArrayList());
               }

               j var4 = new j();
               var4.a(var1);
               this.e().add(var4);
            }
         }
      }

   }

   public void b(ArrayList var1) {
      this.e = var1;
   }

   public boolean b(Context var1) {
      return this.a(var1) != null;
   }

   public j c(String var1) {
      if (this.e() == null) {
         return null;
      } else {
         Iterator var2 = this.e().iterator();

         j var3;
         do {
            if (!var2.hasNext()) {
               return null;
            }

            var3 = (j)var2.next();
         } while(!var3.t().equalsIgnoreCase(var1));

         return var3;
      }
   }

   public String c() {
      return this.c;
   }

   public void c(ArrayList var1) {
      this.d = var1;
   }

   public int d() {
      return this.a(this.c());
   }

   public void d(String var1) {
      this.c = var1;
   }

   public ArrayList e() {
      return this.h;
   }

   public void e(String var1) {
      this.f = var1;
   }

   public ArrayList f() {
      return this.e;
   }

   public String g() {
      return this.f;
   }

   public ArrayList h() {
      return this.d;
   }

   public v i() {
      return this.g;
   }

   public boolean j() {
      return this.f() == null || this.f().size() == 0;
   }
}
