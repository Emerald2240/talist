package com.applovin.impl.sdk.d;

import android.net.Uri;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

abstract class c extends a implements com.applovin.impl.mediation.k.a {
   protected final com.applovin.impl.sdk.ad.f a;
   private AppLovinAdLoadListener c;
   private final com.applovin.impl.sdk.n d;
   private final Collection e;
   private final com.applovin.impl.sdk.c.e f;
   private boolean g;

   c(String var1, com.applovin.impl.sdk.ad.f var2, com.applovin.impl.sdk.j var3, AppLovinAdLoadListener var4) {
      super(var1, var3);
      if (var2 != null) {
         this.a = var2;
         this.c = var4;
         this.d = var3.V();
         this.e = this.j();
         this.f = new com.applovin.impl.sdk.c.e();
      } else {
         throw new IllegalArgumentException("No ad specified.");
      }
   }

   private Uri a(Uri var1, String var2) {
      StringBuilder var3;
      String var6;
      if (var1 != null) {
         String var8 = var1.toString();
         if (com.applovin.impl.sdk.utils.n.b(var8)) {
            StringBuilder var9 = new StringBuilder();
            var9.append("Caching ");
            var9.append(var2);
            var9.append(" image...");
            this.a((String)var9.toString());
            return this.g(var8);
         }

         var3 = new StringBuilder();
         var3.append("Failed to cache ");
         var3.append(var2);
         var6 = " image";
      } else {
         var3 = new StringBuilder();
         var3.append("No ");
         var3.append(var2);
         var6 = " image to cache";
      }

      var3.append(var6);
      this.a((String)var3.toString());
      return null;
   }

   private String a(String var1, String var2) {
      String var3 = var2.replace("/", "_");
      String var4 = this.a.G();
      if (com.applovin.impl.sdk.utils.n.b(var4)) {
         StringBuilder var5 = new StringBuilder();
         var5.append(var4);
         var5.append(var3);
         var3 = var5.toString();
      }

      File var8 = this.d.a(var3, this.b.D());
      if (var8 == null) {
         return null;
      } else {
         StringBuilder var14;
         if (var8.exists()) {
            this.f.b(var8.length());
            var14 = new StringBuilder();
         } else {
            StringBuilder var9 = new StringBuilder();
            var9.append(var1);
            var9.append(var2);
            String var12 = var9.toString();
            List var13 = Arrays.asList(new String[]{var1});
            if (!this.d.a(var8, var12, var13, this.f)) {
               return null;
            }

            var14 = new StringBuilder();
         }

         var14.append("file://");
         var14.append(var8.getAbsolutePath());
         return var14.toString();
      }
   }

   private Uri g(String var1) {
      return this.b(var1, this.a.F(), true);
   }

   private Collection j() {
      HashSet var1 = new HashSet();
      char[] var2 = ((String)this.b.a(com.applovin.impl.sdk.b.d.bI)).toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var1.add(var2[var4]);
      }

      var1.add('"');
      return var1;
   }

   Uri a(String var1, List var2, boolean var3) {
      Exception var10000;
      label68: {
         boolean var10001;
         String var10;
         label67: {
            File var11;
            String var9;
            label71: {
               try {
                  if (!com.applovin.impl.sdk.utils.n.b(var1)) {
                     return null;
                  }

                  StringBuilder var5 = new StringBuilder();
                  var5.append("Caching video ");
                  var5.append(var1);
                  var5.append("...");
                  this.a((String)var5.toString());
                  var9 = this.d.a(this.g(), var1, this.a.G(), var2, var3, this.f);
                  if (com.applovin.impl.sdk.utils.n.b(var9)) {
                     var11 = this.d.a(var9, this.g());
                     break label71;
                  }
               } catch (Exception var28) {
                  var10000 = var28;
                  var10001 = false;
                  break label68;
               }

               try {
                  if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.bL)) {
                     this.d("Failed to cache video");
                     com.applovin.impl.sdk.utils.q.a(this.c, this.a.getAdZone(), -202, this.b);
                     this.c = null;
                     return null;
                  }
               } catch (Exception var27) {
                  var10000 = var27;
                  var10001 = false;
                  break label68;
               }

               var10 = "Failed to cache video, but not failing ad load";
               break label67;
            }

            if (var11 != null) {
               Uri var12;
               try {
                  var12 = Uri.fromFile(var11);
               } catch (Exception var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label68;
               }

               if (var12 != null) {
                  try {
                     StringBuilder var13 = new StringBuilder();
                     var13.append("Finish caching video for ad #");
                     var13.append(this.a.getAdIdNumber());
                     var13.append(". Updating ad with cachedVideoFilename = ");
                     var13.append(var9);
                     this.a((String)var13.toString());
                     return var12;
                  } catch (Exception var22) {
                     var10000 = var22;
                     var10001 = false;
                     break label68;
                  }
               }

               try {
                  StringBuilder var18 = new StringBuilder();
                  var18.append("Unable to create URI from cached video file = ");
                  var18.append(var11);
                  var10 = var18.toString();
               } catch (Exception var25) {
                  var10000 = var25;
                  var10001 = false;
                  break label68;
               }
            } else {
               try {
                  StringBuilder var21 = new StringBuilder();
                  var21.append("Unable to cache video = ");
                  var21.append(var1);
                  var21.append("Video file was missing or null");
                  var10 = var21.toString();
               } catch (Exception var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label68;
               }
            }
         }

         try {
            this.d(var10);
            return null;
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
         }
      }

      Exception var4 = var10000;
      this.a((String)"Encountered exception while attempting to cache video.", (Throwable)var4);
      return null;
   }

   String a(String var1, List var2) {
      if (com.applovin.impl.sdk.utils.n.b(var1)) {
         Uri var3 = Uri.parse(var1);
         if (var3 == null) {
            this.a((String)"Nothing to cache, skipping...");
            return null;
         }

         String var4 = var3.getLastPathSegment();
         if (com.applovin.impl.sdk.utils.n.b(this.a.G())) {
            StringBuilder var5 = new StringBuilder();
            var5.append(this.a.G());
            var5.append(var4);
            var4 = var5.toString();
         }

         File var8 = this.d.a(var4, this.g());
         ByteArrayOutputStream var9;
         if (var8 != null && var8.exists()) {
            var9 = this.d.a(var8);
         } else {
            var9 = null;
         }

         if (var9 == null) {
            var9 = this.d.a(var1, var2, true);
            if (var9 != null) {
               this.d.a(var9, var8);
               this.f.a((long)var9.size());
            }
         } else {
            this.f.b((long)var9.size());
         }

         UnsupportedEncodingException var10;
         try {
            try {
               String var16 = var9.toString("UTF-8");
               return var16;
            } catch (UnsupportedEncodingException var19) {
               var10 = var19;
            }
         } catch (Throwable var20) {
            StringBuilder var12 = new StringBuilder();
            var12.append("String resource at ");
            var12.append(var1);
            var12.append(" failed to load.");
            this.a((String)var12.toString(), (Throwable)var20);
            return null;
         }

         this.a((String)"UTF-8 encoding not supported.", (Throwable)var10);
      }

      return null;
   }

   String a(String var1, List var2, com.applovin.impl.sdk.ad.f var3) {
      if (!com.applovin.impl.sdk.utils.n.b(var1)) {
         return var1;
      } else if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.bK)) {
         this.a((String)"Resource caching is disabled, skipping cache...");
         return var1;
      } else {
         StringBuilder var4 = new StringBuilder(var1);
         boolean var5 = var3.shouldCancelHtmlCachingIfShown();
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            int var8 = 0;

            int var11;
            for(int var9 = 0; var8 < var4.length(); var9 = var11) {
               if (this.c()) {
                  return var1;
               }

               var8 = var4.indexOf(var7, var9);
               if (var8 == -1) {
                  break;
               }

               int var10 = var4.length();

               for(var11 = var8; !this.e.contains(var4.charAt(var11)) && var11 < var10; ++var11) {
               }

               if (var11 <= var8 || var11 == var10) {
                  this.d("Unable to cache resource; ad HTML is invalid.");
                  return var1;
               }

               String var12 = var4.substring(var8 + var7.length(), var11);
               if (com.applovin.impl.sdk.utils.n.b(var12)) {
                  if (var5 && var3.hasShown()) {
                     this.a((String)"Cancelling HTML caching due to ad being shown already");
                     this.f.a();
                     return var1;
                  }

                  String var16 = this.a(var7, var12);
                  if (var16 != null) {
                     var4.replace(var8, var11, var16);
                     this.f.e();
                  } else {
                     this.f.f();
                  }
               } else {
                  StringBuilder var13 = new StringBuilder();
                  var13.append("Skip caching of non-resource ");
                  var13.append(var12);
                  this.a((String)var13.toString());
               }
            }
         }

         return var4.toString();
      }
   }

   public void a(com.applovin.impl.mediation.b.a var1) {
      if (var1.b().equalsIgnoreCase(this.a.K())) {
         this.d("Updating flag for timeout...");
         this.g = true;
      }

      this.b.A().b(this);
   }

   void a(AppLovinAdBase var1) {
      com.applovin.impl.sdk.c.d.a(this.f, var1, this.b);
   }

   Uri b(String var1, List var2, boolean var3) {
      Throwable var10000;
      label205: {
         String var8;
         boolean var10001;
         File var9;
         try {
            var8 = this.d.a(this.g(), var1, this.a.G(), var2, var3, this.f);
            if (!com.applovin.impl.sdk.utils.n.b(var8)) {
               return null;
            }

            var9 = this.d.a(var8, this.g());
         } catch (Throwable var32) {
            var10000 = var32;
            var10001 = false;
            break label205;
         }

         String var11;
         if (var9 != null) {
            Uri var10;
            try {
               var10 = Uri.fromFile(var9);
            } catch (Throwable var30) {
               var10000 = var30;
               var10001 = false;
               break label205;
            }

            if (var10 != null) {
               return var10;
            }

            var11 = "Unable to extract Uri from image file";
         } else {
            try {
               StringBuilder var12 = new StringBuilder();
               var12.append("Unable to retrieve File from cached image filename = ");
               var12.append(var8);
               var11 = var12.toString();
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label205;
            }
         }

         label192:
         try {
            this.d(var11);
            return null;
         } catch (Throwable var29) {
            var10000 = var29;
            var10001 = false;
            break label192;
         }
      }

      Throwable var4 = var10000;
      StringBuilder var5 = new StringBuilder();
      var5.append("Failed to cache image at url = ");
      var5.append(var1);
      this.a((String)var5.toString(), (Throwable)var4);
      return null;
   }

   protected void b() {
      this.b.A().b(this);
   }

   protected boolean c() {
      return this.g;
   }

   void d() {
      this.a((String)"Caching mute images...");
      Uri var1 = this.a(this.a.aF(), "mute");
      if (var1 != null) {
         this.a.b(var1);
      }

      Uri var2 = this.a(this.a.aG(), "unmute");
      if (var2 != null) {
         this.a.c(var2);
      }

      StringBuilder var3 = new StringBuilder();
      var3.append("Ad updated with muteImageFilename = ");
      var3.append(this.a.aF());
      var3.append(", unmuteImageFilename = ");
      var3.append(this.a.aG());
      this.a((String)var3.toString());
   }

   Uri e(String var1) {
      return this.a(var1, this.a.F(), true);
   }

   String f(final String var1) {
      if (!com.applovin.impl.sdk.utils.n.b(var1)) {
         return null;
      } else {
         com.applovin.impl.sdk.network.b var2 = com.applovin.impl.sdk.network.b.a(this.b).a(var1).b("GET").a((Object)"").a(0).a();
         final AtomicReference var3 = new AtomicReference((Object)null);
         this.b.J().a(var2, new com.applovin.impl.sdk.network.a.a(), new com.applovin.impl.sdk.network.a.c() {
            public void a(int var1x) {
               c var2 = c.this;
               StringBuilder var3x = new StringBuilder();
               var3x.append("Failed to load resource from '");
               var3x.append(var1);
               var3x.append("'");
               var2.d(var3x.toString());
            }

            public void a(String var1x, int var2) {
               var3.set(var1x);
            }
         });
         String var4 = (String)var3.get();
         if (var4 != null) {
            this.f.a((long)var4.length());
         }

         return var4;
      }
   }

   void i() {
      if (this.c != null) {
         StringBuilder var1 = new StringBuilder();
         var1.append("Rendered new ad:");
         var1.append(this.a);
         this.a((String)var1.toString());
         this.c.adReceived(this.a);
         this.c = null;
      }

   }

   public void run() {
      if (this.a.J()) {
         this.a((String)"Subscribing to timeout events...");
         this.b.A().a((com.applovin.impl.mediation.k.a)this);
      }

   }
}
