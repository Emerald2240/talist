package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class j {
   private List a;
   private List b;
   private int c;
   private Uri d;
   private final Set e;
   private final Map f;

   private j() {
      this.a = Collections.EMPTY_LIST;
      this.b = Collections.EMPTY_LIST;
      this.e = new HashSet();
      this.f = new HashMap();
   }

   private j(c var1) {
      this.a = Collections.EMPTY_LIST;
      this.b = Collections.EMPTY_LIST;
      this.e = new HashSet();
      this.f = new HashMap();
      this.b = var1.h();
   }

   private static int a(String var0, com.applovin.impl.sdk.j var1) {
      boolean var17 = false;

      try {
         var17 = true;
         List var8 = com.applovin.impl.sdk.utils.e.a(var0, ":");
         if (var8.size() != 3) {
            var17 = false;
            return 0;
         }

         int var9 = n.a((String)var8.get(0));
         int var10 = n.a((String)var8.get(1));
         int var11 = n.a((String)var8.get(2));
         long var12 = TimeUnit.HOURS.toSeconds((long)var9);
         long var14 = TimeUnit.MINUTES.toSeconds((long)var10);
         var17 = false;
      } finally {
         if (var17) {
            p var3 = var1.v();
            StringBuilder var4 = new StringBuilder();
            var4.append("Unable to parse duration from \"");
            var4.append(var0);
            var4.append("\"");
            var3.e("VastVideoCreative", var4.toString());
            return 0;
         }
      }

   }

   public static j a(s var0, j var1, c var2, com.applovin.impl.sdk.j var3) {
      if (var0 == null) {
         throw new IllegalArgumentException("No node specified.");
      } else if (var2 != null) {
         if (var3 == null) {
            throw new IllegalArgumentException("No sdk specified.");
         } else {
            Throwable var10000;
            label1583: {
               boolean var10001;
               if (var1 == null) {
                  try {
                     var1 = new j(var2);
                  } catch (Throwable var194) {
                     var10000 = var194;
                     var10001 = false;
                     break label1583;
                  }
               }

               label1570: {
                  s var11;
                  try {
                     if (var1.c != 0) {
                        break label1570;
                     }

                     var11 = var0.b("Duration");
                  } catch (Throwable var193) {
                     var10000 = var193;
                     var10001 = false;
                     break label1583;
                  }

                  if (var11 != null) {
                     int var12;
                     try {
                        var12 = a(var11.c(), var3);
                     } catch (Throwable var192) {
                        var10000 = var192;
                        var10001 = false;
                        break label1583;
                     }

                     if (var12 > 0) {
                        try {
                           var1.c = var12;
                        } catch (Throwable var191) {
                           var10000 = var191;
                           var10001 = false;
                           break label1583;
                        }
                     }
                  }
               }

               s var5;
               try {
                  var5 = var0.b("MediaFiles");
               } catch (Throwable var190) {
                  var10000 = var190;
                  var10001 = false;
                  break label1583;
               }

               if (var5 != null) {
                  List var6;
                  try {
                     var6 = a(var5, var3);
                  } catch (Throwable var188) {
                     var10000 = var188;
                     var10001 = false;
                     break label1583;
                  }

                  if (var6 != null) {
                     label1552: {
                        try {
                           if (var6.size() <= 0) {
                              break label1552;
                           }

                           if (var1.a != null) {
                              var6.addAll(var1.a);
                           }
                        } catch (Throwable var189) {
                           var10000 = var189;
                           var10001 = false;
                           break label1583;
                        }

                        try {
                           var1.a = var6;
                        } catch (Throwable var187) {
                           var10000 = var187;
                           var10001 = false;
                           break label1583;
                        }
                     }
                  }
               }

               s var7;
               try {
                  var7 = var0.b("VideoClicks");
               } catch (Throwable var186) {
                  var10000 = var186;
                  var10001 = false;
                  break label1583;
               }

               if (var7 != null) {
                  label1538: {
                     s var8;
                     try {
                        if (var1.d != null) {
                           break label1538;
                        }

                        var8 = var7.b("ClickThrough");
                     } catch (Throwable var185) {
                        var10000 = var185;
                        var10001 = false;
                        break label1583;
                     }

                     if (var8 != null) {
                        try {
                           String var9 = var8.c();
                           if (n.b(var9)) {
                              var1.d = Uri.parse(var9);
                           }
                        } catch (Throwable var184) {
                           var10000 = var184;
                           var10001 = false;
                           break label1583;
                        }
                     }
                  }

                  try {
                     i.a(var7.a("ClickTracking"), var1.e, var2, var3);
                  } catch (Throwable var183) {
                     var10000 = var183;
                     var10001 = false;
                     break label1583;
                  }
               }

               label1529:
               try {
                  i.a(var0, var1.f, var2, var3);
                  return var1;
               } catch (Throwable var182) {
                  var10000 = var182;
                  var10001 = false;
                  break label1529;
               }
            }

            Throwable var4 = var10000;
            var3.v().b("VastVideoCreative", "Error occurred while initializing", var4);
            return null;
         }
      } else {
         throw new IllegalArgumentException("No context specified.");
      }
   }

   private static List a(s var0, com.applovin.impl.sdk.j var1) {
      List var2 = var0.a("MediaFile");
      ArrayList var3 = new ArrayList(var2.size());
      List var4 = com.applovin.impl.sdk.utils.e.a((String)var1.a(com.applovin.impl.sdk.b.d.eM));
      List var5 = com.applovin.impl.sdk.utils.e.a((String)var1.a(com.applovin.impl.sdk.b.d.eL));
      Iterator var6 = var2.iterator();

      while(true) {
         k var7;
         do {
            if (!var6.hasNext()) {
               return var3;
            }

            var7 = k.a((s)var6.next(), var1);
         } while(var7 == null);

         Throwable var10000;
         label279: {
            boolean var10001;
            label278: {
               label285: {
                  try {
                     String var13 = var7.d();
                     if (n.b(var13) && !var4.contains(var13)) {
                        break label285;
                     }
                  } catch (Throwable var38) {
                     var10000 = var38;
                     var10001 = false;
                     break label279;
                  }

                  try {
                     if (!(Boolean)var1.a(com.applovin.impl.sdk.b.d.eN)) {
                        break label278;
                     }

                     String var18 = MimeTypeMap.getFileExtensionFromUrl(var7.b().toString());
                     if (!n.b(var18) || var5.contains(var18)) {
                        break label278;
                     }
                  } catch (Throwable var37) {
                     var10000 = var37;
                     var10001 = false;
                     break label279;
                  }
               }

               try {
                  var3.add(var7);
                  continue;
               } catch (Throwable var35) {
                  var10000 = var35;
                  var10001 = false;
                  break label279;
               }
            }

            label261:
            try {
               p var14 = var1.v();
               StringBuilder var15 = new StringBuilder();
               var15.append("Video file not supported: ");
               var15.append(var7);
               var14.d("VastVideoCreative", var15.toString());
               continue;
            } catch (Throwable var36) {
               var10000 = var36;
               var10001 = false;
               break label261;
            }
         }

         Throwable var8 = var10000;
         p var9 = var1.v();
         StringBuilder var10 = new StringBuilder();
         var10.append("Failed to validate vidoe file: ");
         var10.append(var7);
         var9.b("VastVideoCreative", var10.toString(), var8);
      }
   }

   public k a(j.a var1) {
      List var2 = this.a;
      if (var2 != null && var2.size() != 0) {
         Object var3 = new ArrayList(3);
         Iterator var4 = this.b.iterator();

         while(var4.hasNext()) {
            String var6 = (String)var4.next();
            Iterator var7 = this.a.iterator();

            while(var7.hasNext()) {
               k var8 = (k)var7.next();
               String var9 = var8.d();
               if (n.b(var9) && var6.equalsIgnoreCase(var9)) {
                  ((List)var3).add(var8);
               }
            }

            if (!((List)var3).isEmpty()) {
               break;
            }
         }

         if (((List)var3).isEmpty()) {
            var3 = this.a;
         }

         if (com.applovin.impl.sdk.utils.g.c()) {
            Collections.sort((List)var3, new Comparator() {
               public int a(k var1, k var2) {
                  return Integer.compare(var1.e(), var2.e());
               }

               // $FF: synthetic method
               public int compare(Object var1, Object var2) {
                  return this.a((k)var1, (k)var2);
               }
            });
         }

         int var5;
         if (var1 == j.a.b) {
            var5 = 0;
         } else if (var1 == j.a.c) {
            var5 = ((List)var3).size() / 2;
         } else {
            var5 = -1 + ((List)var3).size();
         }

         return (k)((List)var3).get(var5);
      } else {
         return null;
      }
   }

   public List a() {
      return this.a;
   }

   public int b() {
      return this.c;
   }

   public Uri c() {
      return this.d;
   }

   public Set d() {
      return this.e;
   }

   public Map e() {
      return this.f;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof j)) {
         return false;
      } else {
         j var2 = (j)var1;
         if (this.c != var2.c) {
            return false;
         } else {
            List var3 = this.a;
            if (var3 != null) {
               if (!var3.equals(var2.a)) {
                  return false;
               }
            } else if (var2.a != null) {
               return false;
            }

            Uri var4 = this.d;
            if (var4 != null) {
               if (!var4.equals(var2.d)) {
                  return false;
               }
            } else if (var2.d != null) {
               return false;
            }

            Set var5 = this.e;
            if (var5 != null) {
               if (!var5.equals(var2.e)) {
                  return false;
               }
            } else if (var2.e != null) {
               return false;
            }

            Map var6 = this.f;
            Map var7 = var2.f;
            if (var6 != null) {
               return var6.equals(var7);
            } else {
               return var7 == null;
            }
         }
      }
   }

   public int hashCode() {
      List var1 = this.a;
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = 31 * (var2 * 31 + this.c);
      Uri var4 = this.d;
      int var5;
      if (var4 != null) {
         var5 = var4.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var3 + var5);
      Set var7 = this.e;
      int var8;
      if (var7 != null) {
         var8 = var7.hashCode();
      } else {
         var8 = 0;
      }

      int var9 = 31 * (var6 + var8);
      Map var10 = this.f;
      int var11 = 0;
      if (var10 != null) {
         var11 = var10.hashCode();
      }

      return var9 + var11;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastVideoCreative{videoFiles=");
      var1.append(this.a);
      var1.append(", durationSeconds=");
      var1.append(this.c);
      var1.append(", destinationUri=");
      var1.append(this.d);
      var1.append(", clickTrackers=");
      var1.append(this.e);
      var1.append(", eventTrackers=");
      var1.append(this.f);
      var1.append('}');
      return var1.toString();
   }

   public static enum a {
      a,
      b,
      c,
      d;

      static {
         j.a[] var0 = new j.a[]{a, b, c, d};
      }
   }
}
