package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.view.ViewParent;
import android.webkit.WebView;
import java.lang.ref.SoftReference;

public class p extends u {
   private boolean d;
   private SoftReference e;
   private w f;
   private n g;

   public p(Context var1, w var2, n var3, int var4) {
      super(var4);

      try {
         this.a(var1);
         this.a(var2);
         this.a(var3);
      } catch (Exception var7) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFWebViewClient->constr->");
         var6.append(var7.toString());
         k.b(var6.toString());
      }
   }

   public p(Context var1, w var2, n var3, int var4, boolean var5) {
      super(var4, var5);

      try {
         this.a(var1);
         this.a(var2);
         this.a(var3);
      } catch (Exception var8) {
         StringBuilder var7 = new StringBuilder();
         var7.append("ADFWebViewClient->constr->");
         var7.append(var8.toString());
         k.b(var7.toString());
      }
   }

   private void a(w var1) {
      this.f = var1;
   }

   private void b(boolean var1) {
      this.d = var1;
   }

   private w e() {
      return this.f;
   }

   private boolean f() {
      return this.d;
   }

   public void a(Context var1) {
      this.e = new SoftReference(var1);
   }

   public void a(WebView var1) {
   }

   public void a(n var1) {
      this.g = var1;
   }

   public Context c() {
      SoftReference var1 = this.e;
      return var1 == null ? null : (Context)var1.get();
   }

   public n d() {
      return this.g;
   }

   public void onPageFinished(WebView var1, String var2) {
      try {
         super.onPageFinished(var1, var2);
         if (!this.f() && this.d() != null) {
            this.d().ready();
         }

         this.b(true);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFWebViewClient->onPageFinished->");
         var4.append(var5.toString());
         k.b(var4.toString());
      }
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      try {
         super.onReceivedError(var1, var2, var3, var4);
         if (!this.f() && this.e() != null) {
            w var9 = this.e();
            StringBuilder var10 = new StringBuilder();
            var10.append("errorCode: ");
            var10.append(var2);
            var10.append(", description: ");
            var10.append(var3);
            var9.a(new Exception(var10.toString()));
            return;
         }
      } catch (Exception var11) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFWebViewClient->onReceivedError->");
         var6.append(var11.toString());
         k.b(var6.toString());
      }

   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Exception var10000;
      label103: {
         boolean var10001;
         ViewParent var7;
         try {
            if (!this.f()) {
               return false;
            }

            var7 = var1.getParent();
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label103;
         }

         if (var7 == null) {
            return false;
         }

         label104: {
            label105: {
               com.noqoush.adfalcon.android.sdk.response.a var14;
               try {
                  if (this.e() == null) {
                     break label104;
                  }

                  var14 = this.e().g().l().a();
               } catch (Exception var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label105;
               }

               if (var14 == null) {
                  break label104;
               }

               try {
                  if (var14.e().size() > 0) {
                     (new com.noqoush.adfalcon.android.sdk.helper.c(this.e().g().f(), var14.e())).a(this.e().g().l().b(), var2);
                  }
                  break label104;
               } catch (Exception var21) {
                  var10000 = var21;
                  var10001 = false;
               }
            }

            Exception var8 = var10000;

            try {
               com.noqoush.adfalcon.android.sdk.util.a.a(var8);
            } catch (Exception var20) {
               var10000 = var20;
               var10001 = false;
               break label103;
            }
         }

         try {
            if (!var1.isClickable()) {
               return true;
            }
         } catch (Exception var19) {
            var10000 = var19;
            var10001 = false;
            break label103;
         }

         boolean var11;
         com.noqoush.adfalcon.android.sdk.handler.c var9;
         com.noqoush.adfalcon.android.sdk.urlactions.g var10;
         label77: {
            label76: {
               label75: {
                  try {
                     var9 = new com.noqoush.adfalcon.android.sdk.handler.c();
                     var10 = new com.noqoush.adfalcon.android.sdk.urlactions.g() {
                        public void a() {
                        }

                        public void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
                           Exception var10000;
                           label40: {
                              boolean var10001;
                              int var7;
                              try {
                                 var7 = p$b.a[var1.ordinal()];
                              } catch (Exception var10) {
                                 var10000 = var10;
                                 var10001 = false;
                                 break label40;
                              }

                              if (var7 != 1) {
                                 if (var7 != 2) {
                                    return;
                                 }

                                 try {
                                    if (p.this.e() != null) {
                                       p.this.e().f();
                                       return;
                                    }

                                    return;
                                 } catch (Exception var8) {
                                    var10000 = var8;
                                    var10001 = false;
                                 }
                              } else {
                                 try {
                                    if (p.this.e() != null && var2 != com.noqoush.adfalcon.android.sdk.urlactions.m.a && p.this.e().i() == w.e.c) {
                                       ADFBrowser.c = p.this.e();
                                       p.this.e().o();
                                       p.this.e().e();
                                       return;
                                    }

                                    return;
                                 } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                 }
                              }
                           }

                           Exception var3 = var10000;
                           StringBuilder var4 = new StringBuilder();
                           var4.append("ADFWebViewClient->shouldOverrideUrlLoading->onSuccess:");
                           var4.append(var3.toString());
                           k.b(var4.toString());
                        }
                     };
                     if (this.e() == null) {
                        break label75;
                     }
                  } catch (Exception var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label103;
                  }

                  try {
                     if (!this.e().g().l().q().g()) {
                        break label76;
                     }
                  } catch (Exception var17) {
                     var10000 = var17;
                     var10001 = false;
                     break label103;
                  }
               }

               var11 = false;
               break label77;
            }

            var11 = true;
         }

         boolean var12;
         label65: {
            label64: {
               try {
                  if (this.c() == null || !(this.c() instanceof ADFBrowser)) {
                     break label64;
                  }
               } catch (Exception var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label103;
               }

               var12 = true;
               break label65;
            }

            var12 = false;
         }

         try {
            boolean var13 = var9.a(this.c(), var2, var12, var11, var10, var1);
            return var13;
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
         }
      }

      Exception var3 = var10000;
      StringBuilder var4 = new StringBuilder();
      var4.append("ADFWebViewClient->shouldOverrideUrlLoading->");
      var4.append(var3.toString());
      k.b(var4.toString());
      return false;
   }
}
