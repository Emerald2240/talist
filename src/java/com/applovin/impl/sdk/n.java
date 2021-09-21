package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class n {
   private final String a = "FileManager";
   private final j b;
   private final p c;
   private final Object d = new Object();

   n(j var1) {
      this.b = var1;
      this.c = var1.v();
   }

   private long a() {
      long var1 = (Long)this.b.a(com.applovin.impl.sdk.b.d.bG);
      return var1 >= 0L && this.b() ? var1 : -1L;
   }

   private long a(long var1) {
      return var1 / 1048576L;
   }

   private void a(long var1, Context var3) {
      if (this.b()) {
         long var4 = (long)(Integer)this.b.a(com.applovin.impl.sdk.b.d.bH);
         String var8;
         p var7;
         if (var4 == -1L) {
            var7 = this.c;
            var8 = "Cache has no maximum size set; skipping drop...";
         } else {
            long var10;
            int var6 = (var10 = this.a(var1) - var4) == 0L ? 0 : (var10 < 0L ? -1 : 1);
            var7 = this.c;
            if (var6 > 0) {
               var7.b("FileManager", "Cache has exceeded maximum size; dropping...");
               Iterator var9 = this.d(var3).iterator();

               while(var9.hasNext()) {
                  this.b((File)var9.next());
               }

               this.b.L().a(com.applovin.impl.sdk.c.g.f);
               return;
            }

            var8 = "Cache is present but under size limit; not dropping...";
         }

         var7.b("FileManager", var8);
      }
   }

   private boolean a(File var1, String var2, List var3, boolean var4, com.applovin.impl.sdk.c.e var5) {
      if (var1 != null && var1.exists() && !var1.isDirectory()) {
         p var7 = this.c;
         StringBuilder var8 = new StringBuilder();
         var8.append("File exists for ");
         var8.append(var2);
         var7.b("FileManager", var8.toString());
         if (var5 != null) {
            var5.b(var1.length());
         }

         return true;
      } else {
         ByteArrayOutputStream var6 = this.a(var2, var3, var4);
         if (var5 != null && var6 != null) {
            var5.a((long)var6.size());
         }

         return this.a(var6, var1);
      }
   }

   private boolean b() {
      return (Boolean)this.b.a(com.applovin.impl.sdk.b.d.bF);
   }

   private boolean b(ByteArrayOutputStream var1, File var2) {
      p var3 = this.c;
      StringBuilder var4 = new StringBuilder();
      var4.append("Writing resource to filesystem: ");
      var4.append(var2.getName());
      var3.b("FileManager", var4.toString());
      Object var7 = this.d;
      synchronized(var7){}
      FileOutputStream var8 = null;

      boolean var10001;
      Throwable var10000;
      label1088: {
         boolean var14;
         label1092: {
            FileOutputStream var9;
            label1093: {
               j var13;
               label1085: {
                  label1094: {
                     label1083: {
                        IOException var10;
                        label1095: {
                           try {
                              try {
                                 var9 = new FileOutputStream(var2);
                              } catch (IOException var171) {
                                 var10 = var171;
                                 break label1095;
                              }
                           } catch (Throwable var172) {
                              Throwable var15 = var172;

                              try {
                                 this.c.b("FileManager", "Unknown failure to write file.", var15);
                              } catch (Throwable var169) {
                                 var10000 = var169;
                                 var10001 = false;
                                 break label1083;
                              }

                              try {
                                 var13 = this.b;
                                 break label1085;
                              } catch (Throwable var165) {
                                 var10000 = var165;
                                 var10001 = false;
                                 break label1088;
                              }
                           }

                           try {
                              var1.writeTo(var9);
                              break label1093;
                           } catch (IOException var167) {
                              var10 = var167;
                           } finally {
                              ;
                           }

                           var8 = var9;
                        }

                        label1077:
                        try {
                           this.c.b("FileManager", "Unable to write data to file.", var10);
                           break label1094;
                        } catch (Throwable var170) {
                           var10000 = var170;
                           var10001 = false;
                           break label1077;
                        }
                     }

                     Throwable var11 = var10000;

                     try {
                        com.applovin.impl.sdk.utils.q.a((Closeable)var8, (j)this.b);
                        throw var11;
                     } catch (Throwable var161) {
                        var10000 = var161;
                        var10001 = false;
                        break label1088;
                     }
                  }

                  try {
                     var13 = this.b;
                  } catch (Throwable var164) {
                     var10000 = var164;
                     var10001 = false;
                     break label1088;
                  }
               }

               try {
                  com.applovin.impl.sdk.utils.q.a((Closeable)var8, (j)var13);
               } catch (Throwable var163) {
                  var10000 = var163;
                  var10001 = false;
                  break label1088;
               }

               var14 = false;
               break label1092;
            }

            var14 = true;

            try {
               com.applovin.impl.sdk.utils.q.a((Closeable)var9, (j)this.b);
            } catch (Throwable var166) {
               var10000 = var166;
               var10001 = false;
               break label1088;
            }
         }

         label1055:
         try {
            return var14;
         } catch (Throwable var162) {
            var10000 = var162;
            var10001 = false;
            break label1055;
         }
      }

      while(true) {
         Throwable var12 = var10000;

         try {
            throw var12;
         } catch (Throwable var160) {
            var10000 = var160;
            var10001 = false;
            continue;
         }
      }
   }

   private boolean b(File var1) {
      p var2 = this.c;
      StringBuilder var3 = new StringBuilder();
      var3.append("Removing file ");
      var3.append(var1.getName());
      var3.append(" from filesystem...");
      var2.b("FileManager", var3.toString());
      Object var7 = this.d;
      synchronized(var7){}

      boolean var10001;
      Throwable var10000;
      label180: {
         boolean var15;
         label179: {
            Exception var8;
            try {
               try {
                  var15 = var1.delete();
                  break label179;
               } catch (Exception var40) {
                  var8 = var40;
               }
            } catch (Throwable var41) {
               var10000 = var41;
               var10001 = false;
               break label180;
            }

            try {
               p var9 = this.c;
               StringBuilder var10 = new StringBuilder();
               var10.append("Failed to remove file ");
               var10.append(var1.getName());
               var10.append(" from filesystem!");
               var9.b("FileManager", var10.toString(), var8);
               return false;
            } catch (Throwable var38) {
               var10000 = var38;
               var10001 = false;
               break label180;
            }
         }

         label173:
         try {
            return var15;
         } catch (Throwable var39) {
            var10000 = var39;
            var10001 = false;
            break label173;
         }
      }

      while(true) {
         Throwable var14 = var10000;

         try {
            throw var14;
         } catch (Throwable var37) {
            var10000 = var37;
            var10001 = false;
            continue;
         }
      }
   }

   private long c(Context var1) {
      long var2 = this.a();
      boolean var4;
      if (var2 != -1L) {
         var4 = true;
      } else {
         var4 = false;
      }

      long var5 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      Object var7 = this.d;
      synchronized(var7){}

      boolean var10001;
      Throwable var10000;
      label579: {
         List var9;
         Iterator var10;
         try {
            var9 = this.b.b(com.applovin.impl.sdk.b.d.bN);
            var10 = this.d(var1).iterator();
         } catch (Throwable var78) {
            var10000 = var78;
            var10001 = false;
            break label579;
         }

         long var11 = 0L;

         while(true) {
            File var13;
            try {
               if (!var10.hasNext()) {
                  break;
               }

               var13 = (File)var10.next();
            } catch (Throwable var76) {
               var10000 = var76;
               var10001 = false;
               break label579;
            }

            boolean var14;
            label566: {
               if (var4) {
                  try {
                     if (!var9.contains(var13.getName()) && var5 - TimeUnit.MILLISECONDS.toSeconds(var13.lastModified()) > var2) {
                        p var17 = this.c;
                        StringBuilder var18 = new StringBuilder();
                        var18.append("File ");
                        var18.append(var13.getName());
                        var18.append(" has expired, removing...");
                        var17.b("FileManager", var18.toString());
                        var14 = this.b(var13);
                        break label566;
                     }
                  } catch (Throwable var77) {
                     var10000 = var77;
                     var10001 = false;
                     break label579;
                  }
               }

               var14 = false;
            }

            if (var14) {
               try {
                  this.b.L().a(com.applovin.impl.sdk.c.g.e);
               } catch (Throwable var75) {
                  var10000 = var75;
                  var10001 = false;
                  break label579;
               }
            } else {
               try {
                  var11 += var13.length();
               } catch (Throwable var74) {
                  var10000 = var74;
                  var10001 = false;
                  break label579;
               }
            }
         }

         label550:
         try {
            return var11;
         } catch (Throwable var73) {
            var10000 = var73;
            var10001 = false;
            break label550;
         }
      }

      while(true) {
         Throwable var8 = var10000;

         try {
            throw var8;
         } catch (Throwable var72) {
            var10000 = var72;
            var10001 = false;
            continue;
         }
      }
   }

   private List d(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private File e(Context var1) {
      return new File(var1.getFilesDir(), "al");
   }

   public ByteArrayOutputStream a(File param1) {
      // $FF: Couldn't be decompiled
   }

   public ByteArrayOutputStream a(String param1, List param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   public File a(String var1, Context var2) {
      if (!com.applovin.impl.sdk.utils.n.b(var1)) {
         this.c.b("FileManager", "Nothing to look up, skipping...");
         return null;
      } else {
         p var3 = this.c;
         StringBuilder var4 = new StringBuilder();
         var4.append("Looking up cached resource: ");
         var4.append(var1);
         var3.b("FileManager", var4.toString());
         if (var1.contains("icon")) {
            var1 = var1.replace("/", "_").replace(".", "_");
         }

         Object var7 = this.d;
         synchronized(var7){}

         boolean var10001;
         Throwable var10000;
         label278: {
            File var9;
            File var10;
            try {
               var9 = this.e(var2);
               var10 = new File(var9, var1);
            } catch (Throwable var47) {
               var10000 = var47;
               var10001 = false;
               break label278;
            }

            try {
               var9.mkdirs();
            } catch (Throwable var46) {
               Throwable var11 = var46;

               try {
                  p var12 = this.c;
                  StringBuilder var13 = new StringBuilder();
                  var13.append("Unable to make cache directory at ");
                  var13.append(var9);
                  var12.b("FileManager", var13.toString(), var11);
                  return null;
               } catch (Throwable var44) {
                  var10000 = var44;
                  var10001 = false;
                  break label278;
               }
            }

            label265:
            try {
               return var10;
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label265;
            }
         }

         while(true) {
            Throwable var8 = var10000;

            try {
               throw var8;
            } catch (Throwable var43) {
               var10000 = var43;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public String a(Context var1, String var2, String var3, List var4, boolean var5, com.applovin.impl.sdk.c.e var6) {
      return this.a(var1, var2, var3, var4, var5, false, var6);
   }

   public String a(Context var1, String var2, String var3, List var4, boolean var5, boolean var6, com.applovin.impl.sdk.c.e var7) {
      if (!com.applovin.impl.sdk.utils.n.b(var2)) {
         this.c.b("FileManager", "Nothing to cache, skipping...");
         return null;
      } else {
         String var8 = Uri.parse(var2).getLastPathSegment();
         if (com.applovin.impl.sdk.utils.n.b(var8) && com.applovin.impl.sdk.utils.n.b(var3)) {
            StringBuilder var15 = new StringBuilder();
            var15.append(var3);
            var15.append(var8);
            var8 = var15.toString();
         }

         String var9 = var8;
         File var10 = this.a(var8, var1);
         if (this.a(var10, var2, var4, var5, var7)) {
            p var11 = this.c;
            StringBuilder var12 = new StringBuilder();
            var12.append("Caching succeeded for file ");
            var12.append(var8);
            var11.b("FileManager", var12.toString());
            if (var6) {
               var9 = Uri.fromFile(var10).toString();
            }

            return var9;
         } else {
            return null;
         }
      }
   }

   public void a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean a(ByteArrayOutputStream var1, File var2) {
      if (var2 == null) {
         return false;
      } else {
         p var3 = this.c;
         StringBuilder var4 = new StringBuilder();
         var4.append("Caching ");
         var4.append(var2.getAbsolutePath());
         var4.append("...");
         var3.b("FileManager", var4.toString());
         if (var1 != null && var1.size() > 0) {
            if (!this.b(var1, var2)) {
               p var16 = this.c;
               StringBuilder var17 = new StringBuilder();
               var17.append("Unable to cache ");
               var17.append(var2.getAbsolutePath());
               var16.e("FileManager", var17.toString());
               return false;
            } else {
               p var12 = this.c;
               StringBuilder var13 = new StringBuilder();
               var13.append("Caching completed for ");
               var13.append(var2);
               var12.b("FileManager", var13.toString());
               return true;
            }
         } else {
            p var8 = this.c;
            StringBuilder var9 = new StringBuilder();
            var9.append("No data for ");
            var9.append(var2.getAbsolutePath());
            var8.d("FileManager", var9.toString());
            return false;
         }
      }
   }

   public boolean a(File var1, String var2, List var3, com.applovin.impl.sdk.c.e var4) {
      return this.a(var1, var2, var3, true, var4);
   }

   public void b(Context var1) {
      try {
         this.a(".nomedia", var1);
         File var4 = new File(this.e(var1), ".nomedia");
         if (!var4.exists()) {
            p var5 = this.c;
            StringBuilder var6 = new StringBuilder();
            var6.append("Creating .nomedia file at ");
            var6.append(var4.getAbsolutePath());
            var5.b("FileManager", var6.toString());
            if (var4.createNewFile()) {
               return;
            }

            this.c.e("FileManager", "Failed to create .nomedia file");
            return;
         }
      } catch (IOException var7) {
         this.c.b("FileManager", "Failed to create .nomedia file", var7);
      }

   }
}
