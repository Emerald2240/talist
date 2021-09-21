package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

public class ADFTargetingParams {
   public static final int GENDER_FEMALE = 2;
   public static final int GENDER_MALE = 1;
   public static final int NONE = -1;
   private String a;
   private String b;
   private String c;
   private int d;
   private Vector e = new Vector();
   private String f;
   private int g = -1;
   private String h;
   private Date i;
   private Vector j = new Vector();
   private double k;
   private double l;
   private Map m = new Hashtable();

   public void addTestDevice(String var1) {
      if (this.j == null) {
         this.j = new Vector();
      }

      this.j.add(var1);
   }

   public void clearTestDevices() {
      Vector var1 = this.j;
      if (var1 != null) {
         var1.clear();
      }
   }

   public Map getAdditionalInfo() {
      return this.m;
   }

   public int getAge() {
      return this.d;
   }

   public String getAreaCode() {
      return this.c;
   }

   public Date getBirthdate() {
      return this.i;
   }

   public String getCountryCode() {
      return this.h;
   }

   public int getGender() {
      return this.g;
   }

   public Vector getKeywords() {
      return this.e;
   }

   public String getLanguage() {
      if (com.noqoush.adfalcon.android.sdk.g.c((Context)null) != null && com.noqoush.adfalcon.android.sdk.g.c((Context)null).t() < 7) {
         this.setLanguage("en");
      }

      return this.a;
   }

   public double getLocationLatitude() {
      return this.k;
   }

   public double getLocationLongitude() {
      return this.l;
   }

   public String getPostalCode() {
      return this.b;
   }

   public String getSearch() {
      return this.f;
   }

   public Vector getTestDevices() {
      return this.j;
   }

   public boolean isTestDevice(Context var1) {
      Vector var2 = this.j;
      if (var2 == null) {
         return false;
      } else {
         try {
            boolean var4 = var2.contains(com.noqoush.adfalcon.android.sdk.g.c(var1).a(var1).getId());
            return var4;
         } catch (Exception var5) {
            return false;
         }
      }
   }

   public void removeTestDevice(String var1) {
      Vector var2 = this.j;
      if (var2 != null) {
         var2.remove(var1);
      }
   }

   public void setAdditionalInfo(Map var1) {
      this.m = var1;
   }

   public void setAge(int var1) {
      this.d = var1;
   }

   public void setAreaCode(String var1) {
      this.c = var1;
   }

   public void setBirthdate(Date var1) {
      this.i = var1;
   }

   public void setCountryCode(String var1) {
      this.h = var1;
   }

   public void setGender(int var1) {
      this.g = var1;
   }

   public void setKeywords(Vector var1) {
      this.e = var1;
   }

   public void setLanguage(String var1) {
      this.a = var1;
   }

   public void setLocationLatitude(double var1) {
      this.k = var1;
   }

   public void setLocationLongitude(double var1) {
      this.l = var1;
   }

   public void setPostalCode(String var1) {
      this.b = var1;
   }

   public void setSearch(String var1) {
      this.f = var1;
   }

   public Hashtable toHashtable() throws Exception {
      Hashtable var1 = new Hashtable();
      if (this.getLanguage() != null && this.getLanguage().trim().length() == 2) {
         var1.put("U_LN", this.getLanguage());
      } else {
         try {
            if (Locale.getDefault() != null && Locale.getDefault().getLanguage() != null && Locale.getDefault().getLanguage().length() > 1) {
               var1.put("U_LN", Locale.getDefault().getLanguage());
            }
         } catch (Exception var29) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var29);
         }
      }

      if (this.getPostalCode() != null && this.getPostalCode().trim().length() != 0) {
         var1.put("U_PC", this.getPostalCode());
      }

      if (this.getAreaCode() != null && this.getAreaCode().trim().length() != 0) {
         var1.put("U_AC", this.getAreaCode());
      }

      if (this.getAge() > 3 && this.getAge() < 100) {
         StringBuilder var28 = new StringBuilder();
         var28.append("");
         var28.append(this.getAge());
         var1.put("U_AGE", var28.toString());
      }

      Vector var3 = this.e;
      if (var3 != null && !var3.isEmpty()) {
         String var20 = "";

         for(int var21 = 0; var21 < this.e.size(); ++var21) {
            StringBuilder var22 = new StringBuilder();
            var22.append(var20);
            String var24;
            if (var20.length() > 0) {
               var24 = ",";
            } else {
               var24 = "";
            }

            var22.append(var24);
            var22.append((String)this.e.get(var21));
            var20 = var22.toString();
         }

         var1.put("U_KW", var20);
      }

      if (this.getGender() != -1) {
         if (this.getGender() == 1) {
            var1.put("U_G", "m");
         } else if (this.getGender() == 2) {
            var1.put("U_G", "f");
         }
      }

      if (this.getCountryCode() != null && this.getCountryCode().trim().length() != 0) {
         var1.put("U_CC", this.getCountryCode());
      }

      if (this.i != null) {
         var1.put("U_BD", (new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)).format(this.i));
      }

      Map var4 = this.getAdditionalInfo();
      int var5 = 0;
      if (var4 != null) {
         while(var5 < this.getAdditionalInfo().size()) {
            String var14 = (String)this.m.keySet().toArray()[var5];
            var1.put(var14, this.m.get(var14));
            ++var5;
         }
      }

      if (com.noqoush.adfalcon.android.sdk.g.c((Context)null).i() == -1.0D && com.noqoush.adfalcon.android.sdk.g.c((Context)null).j() == -1.0D && this.getLocationLatitude() != -1.0D && this.getLocationLongitude() != -1.0D) {
         StringBuilder var6 = new StringBuilder();
         var6.append("");
         var6.append(this.getLocationLatitude());
         var1.put("U_LA", var6.toString());
         StringBuilder var10 = new StringBuilder();
         var10.append("");
         var10.append(this.getLocationLongitude());
         var1.put("U_LO", var10.toString());
      }

      return var1;
   }
}
