package com.noqoush.adfalcon.android.sdk.nativead.mngr;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.noqoush.adfalcon.android.sdk.nativead.assets.ADFAssetsBinder;
import com.noqoush.adfalcon.android.sdk.response.f;
import com.noqoush.adfalcon.android.sdk.response.g;
import com.noqoush.adfalcon.android.sdk.util.d;
import java.util.Hashtable;
import java.util.Iterator;

public class c {
   private com.noqoush.adfalcon.android.sdk.nativead.data.a a;
   private ADFAssetsBinder b;
   private View c;
   private Button d;

   public c(com.noqoush.adfalcon.android.sdk.nativead.data.a var1) {
      this.a = var1;
      this.b = var1.e();
      this.c();
   }

   private com.noqoush.adfalcon.android.sdk.handler.b a(boolean var1) {
      return new c$a(this, var1);
   }

   // $FF: synthetic method
   static com.noqoush.adfalcon.android.sdk.nativead.data.a a(c var0) {
      return var0.a;
   }

   private void a(Hashtable var1, f var2) {
      if (var2 instanceof g) {
         g var3 = (g)var2;
         var1.put(var3.b(), var3.c());
      }

   }

   private void b() {
      try {
         Object var2 = this.c;
         if (this.d != null) {
            var2 = this.d;
            this.c.setOnClickListener(new com.noqoush.adfalcon.android.sdk.handler.a(this.a(true)));
         }

         ((View)var2).setOnClickListener(new com.noqoush.adfalcon.android.sdk.handler.a(this.a(false)));
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   private void c() {
      this.c = com.noqoush.adfalcon.android.sdk.util.d.c(this.a.h().getContext()).getLayoutInflater().inflate(this.b.getLayoutId(), (ViewGroup)null);
   }

   public void a() {
      Exception var10000;
      label104: {
         boolean var10001;
         Iterator var2;
         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("Ad is being drawn");
            this.a.h().removeAllViews();
            this.a.h().addView(this.c);
            var2 = this.a.e().getAssets().keySet().iterator();
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label104;
         }

         while(true) {
            try {
               if (!var2.hasNext()) {
                  break;
               }

               String var8 = (String)var2.next();
               ((com.noqoush.adfalcon.android.sdk.nativead.assets.a)this.a.e().getAssets().get(var8)).a(this.c, 8);
            } catch (Exception var19) {
               var10000 = var19;
               var10001 = false;
               break label104;
            }
         }

         Hashtable var3;
         try {
            var3 = new Hashtable();
            if (this.a.i() == null) {
               return;
            }
         } catch (Exception var18) {
            var10000 = var18;
            var10001 = false;
            break label104;
         }

         Iterator var4;
         try {
            var4 = this.a.i().m().a().iterator();
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
            break label104;
         }

         while(true) {
            f var5;
            try {
               if (!var4.hasNext()) {
                  break;
               }

               var5 = (f)var4.next();
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label104;
            }

            label81: {
               com.noqoush.adfalcon.android.sdk.nativead.assets.a var7;
               try {
                  var7 = (com.noqoush.adfalcon.android.sdk.nativead.assets.a)this.a.e().getAssets().get(var5.a());
                  if (var5.a().equalsIgnoreCase("d12")) {
                     this.d = (Button)this.c.findViewById(var7.d());
                  }
               } catch (Exception var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label81;
               }

               if (var7 != null) {
                  try {
                     var7.a(this.c, 0);
                     if (!var7.a(this.c, var5)) {
                        this.a(var3, var5);
                     }
                     continue;
                  } catch (Exception var14) {
                     var10000 = var14;
                     var10001 = false;
                  }
               } else {
                  try {
                     this.a(var3, var5);
                     continue;
                  } catch (Exception var15) {
                     var10000 = var15;
                     var10001 = false;
                  }
               }
            }

            Exception var6 = var10000;

            try {
               com.noqoush.adfalcon.android.sdk.util.a.a(var6);
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label104;
            }
         }

         try {
            if (this.a.c() != null && var3.size() > 0) {
               this.a.c().a(this.c, var3);
            }
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label104;
         }

         try {
            this.b();
            return;
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }
}
