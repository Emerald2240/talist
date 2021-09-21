package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class s {
   public static final s a = new s();
   protected String b;
   protected final List c;
   private final s d;
   private final String e;
   private final Map f;

   private s() {
      this.d = null;
      this.e = "";
      this.f = Collections.emptyMap();
      this.b = "";
      this.c = Collections.emptyList();
   }

   public s(String var1, Map var2, s var3) {
      this.d = var3;
      this.e = var1;
      this.f = Collections.unmodifiableMap(var2);
      this.c = new ArrayList();
   }

   public String a() {
      return this.e;
   }

   public List a(String var1) {
      if (var1 != null) {
         ArrayList var2 = new ArrayList(this.c.size());
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            s var4 = (s)var3.next();
            if (var1.equalsIgnoreCase(var4.a())) {
               var2.add(var4);
            }
         }

         return var2;
      } else {
         IllegalArgumentException var6 = new IllegalArgumentException("No name specified.");
         throw var6;
      }
   }

   public s b(String var1) {
      if (var1 != null) {
         Iterator var3 = this.c.iterator();

         s var4;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            var4 = (s)var3.next();
         } while(!var1.equalsIgnoreCase(var4.a()));

         return var4;
      } else {
         IllegalArgumentException var2 = new IllegalArgumentException("No name specified.");
         throw var2;
      }
   }

   public Map b() {
      return this.f;
   }

   public s c(String var1) {
      if (var1 == null) {
         IllegalArgumentException var2 = new IllegalArgumentException("No name specified.");
         throw var2;
      } else {
         if (this.c.size() > 0) {
            ArrayList var3 = new ArrayList();
            var3.add(this);

            while(!var3.isEmpty()) {
               s var5 = (s)var3.get(0);
               var3.remove(0);
               if (var1.equalsIgnoreCase(var5.a())) {
                  return var5;
               }

               var3.addAll(var5.d());
            }
         }

         return null;
      }
   }

   public String c() {
      return this.b;
   }

   public List d() {
      return Collections.unmodifiableList(this.c);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("XmlNode{elementName='");
      var1.append(this.e);
      var1.append('\'');
      var1.append(", text='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", attributes=");
      var1.append(this.f);
      var1.append('}');
      return var1.toString();
   }
}
