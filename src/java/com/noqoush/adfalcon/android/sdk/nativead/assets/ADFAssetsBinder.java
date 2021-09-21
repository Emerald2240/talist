package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.app.Activity;
import java.util.Hashtable;

public class ADFAssetsBinder {
   public static final int DATA_ID_ADDRESS = 9;
   public static final int DATA_ID_CTA = 12;
   protected static final int DATA_ID_DESC = 2;
   public static final int DATA_ID_DESC2 = 10;
   public static final int DATA_ID_DISPLAYURL = 11;
   public static final int DATA_ID_DOWNLOADS = 5;
   public static final int DATA_ID_LIKES = 4;
   public static final int DATA_ID_PHONE = 8;
   public static final int DATA_ID_PRICE = 6;
   protected static final int DATA_ID_RATING = 3;
   public static final int DATA_ID_SALEPRICE = 7;
   public static final int DATA_ID_SPONSORED = 1;
   public static final int DATA_ID_VIEWS = 13;
   private Hashtable assets;
   private int layoutId;

   private ADFAssetsBinder(ADFAssetsBinder.Builder var1) {
      this.setLayoutId(var1.layoutId);
      this.setAssets(var1.assets);
   }

   // $FF: synthetic method
   ADFAssetsBinder(ADFAssetsBinder.Builder var1, Object var2) {
      this(var1);
   }

   public Hashtable getAssets() {
      return this.assets;
   }

   public int getLayoutId() {
      return this.layoutId;
   }

   public void setAssets(Hashtable var1) {
      this.assets = var1;
   }

   public void setLayoutId(int var1) {
      this.layoutId = var1;
   }

   public static class Builder {
      private Activity activity;
      private Hashtable assets = new Hashtable();
      private int layoutId;

      public Builder(Activity var1, int var2) {
         this.layoutId = var2;
         this.activity = var1;
      }

      private void addAsset(a var1) {
         this.assets.put(var1.a(), var1);
      }

      public ADFAssetsBinder.Builder addActionButton(int var1, int var2) {
         try {
            this.addAsset(new c(var1, 12, var2));
            return this;
         } catch (Exception var4) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var4);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addAdChoicesRelativeLayout(int var1) {
         try {
            this.addAsset(new b(var1));
            return this;
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addDescriptionTextView(int var1, int var2) {
         try {
            this.addAsset(new c(var1, 2, var2));
            return this;
         } catch (Exception var4) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var4);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addExtraDataTextView(int var1, int var2, int var3) {
         try {
            this.addAsset(new c(var2, var1, var3));
            return this;
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var5);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addIconImageView(int var1, int var2, int var3) {
         try {
            this.addAsset(new d(var1, com.noqoush.adfalcon.android.sdk.util.d.a(this.activity, var2), com.noqoush.adfalcon.android.sdk.util.d.a(this.activity, var3)));
            return this;
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var5);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addMainAssetRelativeLayout(int var1, int var2, int var3) {
         try {
            this.addAsset(new e(var1, com.noqoush.adfalcon.android.sdk.util.d.a(this.activity, var2), com.noqoush.adfalcon.android.sdk.util.d.a(this.activity, var3)));
            return this;
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var5);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addStarRatingBar(int var1) {
         try {
            this.addAsset(new c(var1, 3, -1));
            return this;
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
            return this;
         }
      }

      public ADFAssetsBinder.Builder addTitleTextView(int var1, int var2) {
         try {
            this.addAsset(new f(var1, var2));
            return this;
         } catch (Exception var4) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var4);
            return this;
         }
      }

      public ADFAssetsBinder build() throws Exception {
         if (this.layoutId != 0) {
            if (this.isReady()) {
               return new ADFAssetsBinder(this);
            } else {
               throw new Exception("You must use ad choices asset and at least one of the following title, icon or main asset");
            }
         } else {
            throw new Exception("Invalid layout id");
         }
      }

      public boolean isReady() {
         return (this.assets.containsKey("I") || this.assets.containsKey("T") || this.assets.containsKey("MASS")) && this.assets.containsKey("DAA_ICON");
      }
   }
}
