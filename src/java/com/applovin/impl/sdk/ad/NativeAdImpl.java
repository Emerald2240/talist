package com.applovin.impl.sdk.ad;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.q;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAdImpl implements j, AppLovinNativeAd {
   public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
   public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
   private final com.applovin.impl.sdk.j a;
   private final d b;
   private final String c;
   private final String d;
   private final String e;
   private final String f;
   private final String g;
   private final String h;
   private final String i;
   private final String j;
   private final String k;
   private final String l;
   private final String m;
   private final String n;
   private final String o;
   private final List p;
   private final List q;
   private final String r;
   private final long s;
   private final List t;
   private String u;
   private String v;
   private float w;
   private String x;
   private AtomicBoolean y;

   private NativeAdImpl(d var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, float var12, String var13, String var14, String var15, String var16, String var17, List var18, List var19, String var20, String var21, long var22, List var24, com.applovin.impl.sdk.j var25) {
      this.y = new AtomicBoolean();
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.h = var7;
      this.i = var8;
      this.j = var9;
      this.u = var10;
      this.v = var11;
      this.w = var12;
      this.x = var13;
      this.l = var14;
      this.m = var15;
      this.n = var16;
      this.o = var17;
      this.p = var18;
      this.q = var19;
      this.r = var20;
      this.k = var21;
      this.s = var22;
      this.t = var24;
      this.a = var25;
   }

   // $FF: synthetic method
   NativeAdImpl(d var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, float var12, String var13, String var14, String var15, String var16, String var17, List var18, List var19, String var20, String var21, long var22, List var24, com.applovin.impl.sdk.j var25, NativeAdImpl$1 var26) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var24, var25);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            NativeAdImpl var2 = (NativeAdImpl)var1;
            d var3 = this.b;
            if (var3 != null) {
               if (!var3.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            String var4 = this.j;
            if (var4 != null) {
               if (!var4.equals(var2.j)) {
                  return false;
               }
            } else if (var2.j != null) {
               return false;
            }

            String var5 = this.r;
            if (var5 != null) {
               if (!var5.equals(var2.r)) {
                  return false;
               }
            } else if (var2.r != null) {
               return false;
            }

            String var6 = this.l;
            if (var6 != null) {
               if (!var6.equals(var2.l)) {
                  return false;
               }
            } else if (var2.l != null) {
               return false;
            }

            String var7 = this.k;
            if (var7 != null) {
               if (!var7.equals(var2.k)) {
                  return false;
               }
            } else if (var2.k != null) {
               return false;
            }

            String var8 = this.i;
            if (var8 != null) {
               if (!var8.equals(var2.i)) {
                  return false;
               }
            } else if (var2.i != null) {
               return false;
            }

            String var9 = this.m;
            if (var9 != null) {
               if (!var9.equals(var2.m)) {
                  return false;
               }
            } else if (var2.m != null) {
               return false;
            }

            String var10 = this.d;
            if (var10 != null) {
               if (!var10.equals(var2.d)) {
                  return false;
               }
            } else if (var2.d != null) {
               return false;
            }

            String var11 = this.e;
            if (var11 != null) {
               if (!var11.equals(var2.e)) {
                  return false;
               }
            } else if (var2.e != null) {
               return false;
            }

            String var12 = this.f;
            if (var12 != null) {
               if (!var12.equals(var2.f)) {
                  return false;
               }
            } else if (var2.f != null) {
               return false;
            }

            String var13 = this.g;
            if (var13 != null) {
               if (!var13.equals(var2.g)) {
                  return false;
               }
            } else if (var2.g != null) {
               return false;
            }

            String var14 = this.h;
            if (var14 != null) {
               if (!var14.equals(var2.h)) {
                  return false;
               }
            } else if (var2.h != null) {
               return false;
            }

            String var15 = this.o;
            if (var15 != null) {
               if (!var15.equals(var2.o)) {
                  return false;
               }
            } else if (var2.o != null) {
               return false;
            }

            String var16 = this.n;
            if (var16 != null) {
               if (!var16.equals(var2.n)) {
                  return false;
               }
            } else if (var2.n != null) {
               return false;
            }

            List var17 = this.p;
            if (var17 != null) {
               if (!var17.equals(var2.p)) {
                  return false;
               }
            } else if (var2.p != null) {
               return false;
            }

            List var18 = this.q;
            if (var18 != null) {
               if (!var18.equals(var2.q)) {
                  return false;
               }
            } else if (var2.q != null) {
               return false;
            }

            List var19 = this.t;
            List var20 = var2.t;
            if (var19 != null) {
               if (!var19.equals(var20)) {
                  return false;
               }
            } else if (var20 != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public long getAdId() {
      return this.s;
   }

   public d getAdZone() {
      return this.b;
   }

   public String getCaptionText() {
      return this.j;
   }

   public String getClCode() {
      return this.r;
   }

   public String getClickUrl() {
      return this.l;
   }

   public String getCtaText() {
      return this.k;
   }

   public String getDescriptionText() {
      return this.i;
   }

   public String getIconUrl() {
      return this.u;
   }

   public String getImageUrl() {
      return this.v;
   }

   public String getImpressionTrackingUrl() {
      return this.m;
   }

   public List getResourcePrefixes() {
      return this.t;
   }

   public String getSourceIconUrl() {
      return this.d;
   }

   public String getSourceImageUrl() {
      return this.e;
   }

   public String getSourceStarRatingImageUrl() {
      return this.f;
   }

   public String getSourceVideoUrl() {
      return this.g;
   }

   public float getStarRating() {
      return this.w;
   }

   public String getTitle() {
      return this.h;
   }

   public String getVideoEndTrackingUrl(int var1, boolean var2) {
      Uri var3;
      if (this.o == null) {
         var3 = Uri.EMPTY;
      } else {
         if (var1 < 0 || var1 > 100) {
            com.applovin.impl.sdk.p.c("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
         }

         var3 = Uri.parse(this.o).buildUpon().appendQueryParameter("pv", Integer.toString(var1)).appendQueryParameter("fp", Boolean.toString(var2)).build();
      }

      return var3.toString();
   }

   public String getVideoStartTrackingUrl() {
      return this.n;
   }

   public String getVideoUrl() {
      return this.x;
   }

   public String getZoneId() {
      return this.c;
   }

   public int hashCode() {
      String var1 = this.d;
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = var2 * 31;
      String var4 = this.e;
      int var5;
      if (var4 != null) {
         var5 = var4.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var3 + var5);
      String var7 = this.f;
      int var8;
      if (var7 != null) {
         var8 = var7.hashCode();
      } else {
         var8 = 0;
      }

      int var9 = 31 * (var6 + var8);
      String var10 = this.g;
      int var11;
      if (var10 != null) {
         var11 = var10.hashCode();
      } else {
         var11 = 0;
      }

      int var12 = 31 * (var9 + var11);
      String var13 = this.h;
      int var14;
      if (var13 != null) {
         var14 = var13.hashCode();
      } else {
         var14 = 0;
      }

      int var15 = 31 * (var12 + var14);
      String var16 = this.i;
      int var17;
      if (var16 != null) {
         var17 = var16.hashCode();
      } else {
         var17 = 0;
      }

      int var18 = 31 * (var15 + var17);
      String var19 = this.j;
      int var20;
      if (var19 != null) {
         var20 = var19.hashCode();
      } else {
         var20 = 0;
      }

      int var21 = 31 * (var18 + var20);
      String var22 = this.k;
      int var23;
      if (var22 != null) {
         var23 = var22.hashCode();
      } else {
         var23 = 0;
      }

      int var24 = 31 * (var21 + var23);
      String var25 = this.l;
      int var26;
      if (var25 != null) {
         var26 = var25.hashCode();
      } else {
         var26 = 0;
      }

      int var27 = 31 * (var24 + var26);
      String var28 = this.m;
      int var29;
      if (var28 != null) {
         var29 = var28.hashCode();
      } else {
         var29 = 0;
      }

      int var30 = 31 * (var27 + var29);
      String var31 = this.n;
      int var32;
      if (var31 != null) {
         var32 = var31.hashCode();
      } else {
         var32 = 0;
      }

      int var33 = 31 * (var30 + var32);
      String var34 = this.o;
      int var35;
      if (var34 != null) {
         var35 = var34.hashCode();
      } else {
         var35 = 0;
      }

      int var36 = 31 * (var33 + var35);
      List var37 = this.p;
      int var38;
      if (var37 != null) {
         var38 = var37.hashCode();
      } else {
         var38 = 0;
      }

      int var39 = 31 * (var36 + var38);
      List var40 = this.q;
      int var41;
      if (var40 != null) {
         var41 = var40.hashCode();
      } else {
         var41 = 0;
      }

      int var42 = 31 * (var39 + var41);
      String var43 = this.r;
      int var44;
      if (var43 != null) {
         var44 = var43.hashCode();
      } else {
         var44 = 0;
      }

      int var45 = 31 * (var42 + var44);
      d var46 = this.b;
      int var47;
      if (var46 != null) {
         var47 = var46.hashCode();
      } else {
         var47 = 0;
      }

      int var48 = 31 * (var45 + var47);
      List var49 = this.t;
      int var50 = 0;
      if (var49 != null) {
         var50 = var49.hashCode();
      }

      return var48 + var50;
   }

   public boolean isImagePrecached() {
      String var1 = this.u;
      boolean var2;
      if (var1 != null && !var1.equals(this.d)) {
         var2 = true;
      } else {
         var2 = false;
      }

      String var3 = this.v;
      boolean var4;
      if (var3 != null && !var3.equals(this.e)) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var2 && var4;
   }

   public boolean isVideoPrecached() {
      String var1 = this.x;
      return var1 != null && !var1.equals(this.g);
   }

   public void launchClickTarget(Context var1) {
      Iterator var2 = this.q.iterator();

      while(var2.hasNext()) {
         com.applovin.impl.sdk.c.a var4 = (com.applovin.impl.sdk.c.a)var2.next();
         this.a.N().a(com.applovin.impl.sdk.network.f.l().a(var4.a()).b(var4.b()).a(false).a());
      }

      com.applovin.impl.sdk.utils.q.a(var1, Uri.parse(this.l), this.a);
   }

   public void setIconUrl(String var1) {
      this.u = var1;
   }

   public void setImageUrl(String var1) {
      this.v = var1;
   }

   public void setStarRating(float var1) {
      this.w = var1;
   }

   public void setVideoUrl(String var1) {
      this.x = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinNativeAd{clCode='");
      var1.append(this.r);
      var1.append('\'');
      var1.append(", adZone='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", sourceIconUrl='");
      var1.append(this.d);
      var1.append('\'');
      var1.append(", sourceImageUrl='");
      var1.append(this.e);
      var1.append('\'');
      var1.append(", sourceStarRatingImageUrl='");
      var1.append(this.f);
      var1.append('\'');
      var1.append(", sourceVideoUrl='");
      var1.append(this.g);
      var1.append('\'');
      var1.append(", title='");
      var1.append(this.h);
      var1.append('\'');
      var1.append(", descriptionText='");
      var1.append(this.i);
      var1.append('\'');
      var1.append(", captionText='");
      var1.append(this.j);
      var1.append('\'');
      var1.append(", ctaText='");
      var1.append(this.k);
      var1.append('\'');
      var1.append(", iconUrl='");
      var1.append(this.u);
      var1.append('\'');
      var1.append(", imageUrl='");
      var1.append(this.v);
      var1.append('\'');
      var1.append(", starRating='");
      var1.append(this.w);
      var1.append('\'');
      var1.append(", videoUrl='");
      var1.append(this.x);
      var1.append('\'');
      var1.append(", clickUrl='");
      var1.append(this.l);
      var1.append('\'');
      var1.append(", impressionTrackingUrl='");
      var1.append(this.m);
      var1.append('\'');
      var1.append(", videoStartTrackingUrl='");
      var1.append(this.n);
      var1.append('\'');
      var1.append(", videoEndTrackingUrl='");
      var1.append(this.o);
      var1.append('\'');
      var1.append(", impressionPostbacks=");
      var1.append(this.p);
      var1.append('\'');
      var1.append(", clickTrackingPostbacks=");
      var1.append(this.q);
      var1.append('\'');
      var1.append(", resourcePrefixes=");
      var1.append(this.t);
      var1.append('}');
      return var1.toString();
   }

   public void trackImpression() {
      this.trackImpression((AppLovinPostbackListener)null);
   }

   public void trackImpression(AppLovinPostbackListener var1) {
      if (!this.y.getAndSet(true)) {
         this.a.v().b("AppLovinNativeAd", "Tracking impression...");
         Iterator var2 = this.p.iterator();

         while(var2.hasNext()) {
            com.applovin.impl.sdk.c.a var3 = (com.applovin.impl.sdk.c.a)var2.next();
            this.a.N().a(com.applovin.impl.sdk.network.f.l().a(var3.a()).b(var3.b()).a(false).a(), true, var1);
         }
      } else if (var1 != null) {
         var1.onPostbackFailure(this.m, -702);
      }

   }
}
