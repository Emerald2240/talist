package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class l {
   public static String a(String var0, String var1) {
      return a(var0, var1, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
   }

   public static String a(String var0, String var1, long var2) {
      return a(var0, var1, var2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
   }

   private static String a(String var0, String var1, long var2, byte[] var4) {
      String var5 = var0;
      if (var1 != null) {
         if (var1.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
         } else if (var4 != null) {
            int var7 = var4.length;
            byte var8 = 32;
            if (var7 < var8) {
               throw new IllegalArgumentException("Salt is too short");
            } else {
               if (var0 != null) {
                  if (var0.isEmpty()) {
                     return var0;
                  }

                  label239: {
                     boolean var10001;
                     ByteArrayOutputStream var14;
                     byte[] var13;
                     byte[] var12;
                     String var10;
                     try {
                        var10 = var1.substring(var8);
                        String var11 = var1.substring(0, var8);
                        var12 = var5.getBytes("UTF-8");
                        var13 = a(var11, var4);
                        var14 = new ByteArrayOutputStream();
                        var14.write((byte)((int)(255L & var2 >> 0)) ^ var13[0]);
                        var14.write((byte)((int)(255L & var2 >> 8)) ^ var13[1]);
                        var14.write((byte)((int)(255L & var2 >> 16)) ^ var13[2]);
                        var14.write((byte)((int)(255L & var2 >> 24)) ^ var13[3]);
                        var14.write((byte)((int)(255L & var2 >> var8)) ^ var13[4]);
                        var14.write((byte)((int)(255L & var2 >> 40)) ^ var13[5]);
                        var14.write((byte)((int)(255L & var2 >> 48)) ^ var13[6]);
                        var14.write((byte)((int)(255L & var2 >> 56)) ^ var13[7]);
                     } catch (IOException var76) {
                        var10001 = false;
                        break label239;
                     }

                     int var15 = 0;

                     while(true) {
                        try {
                           if (var15 >= var12.length) {
                              break;
                           }
                        } catch (IOException var67) {
                           var10001 = false;
                           break label239;
                        }

                        long var16 = var2 + (long)var15;
                        long var18 = -4417276706812531889L * (var16 ^ var16 >> 33);
                        long var20 = -8796714831421723037L * (var18 ^ var18 >> 29);
                        long var22 = var20 ^ var20 >> var8;
                        int var24 = var15 + 0;

                        byte var25;
                        label216: {
                           label215: {
                              try {
                                 if (var24 < var12.length) {
                                    break label215;
                                 }
                              } catch (IOException var75) {
                                 var10001 = false;
                                 break label239;
                              }

                              var25 = 0;
                              break label216;
                           }

                           try {
                              var25 = var12[var24];
                           } catch (IOException var66) {
                              var10001 = false;
                              break label239;
                           }
                        }

                        try {
                           var14.write((byte)((int)((long)(var25 ^ var13[var24 % var13.length]) ^ 255L & var22 >> 0)));
                        } catch (IOException var65) {
                           var10001 = false;
                           break label239;
                        }

                        int var26 = var15 + 1;

                        byte var27;
                        label208: {
                           label207: {
                              try {
                                 if (var26 >= var12.length) {
                                    break label207;
                                 }
                              } catch (IOException var74) {
                                 var10001 = false;
                                 break label239;
                              }

                              try {
                                 var27 = var12[var26];
                                 break label208;
                              } catch (IOException var64) {
                                 var10001 = false;
                                 break label239;
                              }
                           }

                           var27 = 0;
                        }

                        try {
                           var14.write((byte)((int)((long)(var27 ^ var13[var26 % var13.length]) ^ 255L & var22 >> 8)));
                        } catch (IOException var63) {
                           var10001 = false;
                           break label239;
                        }

                        int var28 = var15 + 2;

                        byte var29;
                        label200: {
                           label199: {
                              try {
                                 if (var28 < var12.length) {
                                    break label199;
                                 }
                              } catch (IOException var73) {
                                 var10001 = false;
                                 break label239;
                              }

                              var29 = 0;
                              break label200;
                           }

                           try {
                              var29 = var12[var28];
                           } catch (IOException var62) {
                              var10001 = false;
                              break label239;
                           }
                        }

                        try {
                           var14.write((byte)((int)((long)(var29 ^ var13[var28 % var13.length]) ^ 255L & var22 >> 16)));
                        } catch (IOException var61) {
                           var10001 = false;
                           break label239;
                        }

                        int var30 = var15 + 3;

                        byte var31;
                        label192: {
                           label191: {
                              try {
                                 if (var30 < var12.length) {
                                    break label191;
                                 }
                              } catch (IOException var72) {
                                 var10001 = false;
                                 break label239;
                              }

                              var31 = 0;
                              break label192;
                           }

                           try {
                              var31 = var12[var30];
                           } catch (IOException var60) {
                              var10001 = false;
                              break label239;
                           }
                        }

                        try {
                           var14.write((byte)((int)((long)(var31 ^ var13[var30 % var13.length]) ^ 255L & var22 >> 24)));
                        } catch (IOException var59) {
                           var10001 = false;
                           break label239;
                        }

                        int var32 = var15 + 4;

                        byte var33;
                        label184: {
                           label183: {
                              try {
                                 if (var32 >= var12.length) {
                                    break label183;
                                 }
                              } catch (IOException var71) {
                                 var10001 = false;
                                 break label239;
                              }

                              try {
                                 var33 = var12[var32];
                                 break label184;
                              } catch (IOException var58) {
                                 var10001 = false;
                                 break label239;
                              }
                           }

                           var33 = 0;
                        }

                        try {
                           var14.write((byte)((int)((long)(var33 ^ var13[var32 % var13.length]) ^ 255L & var22 >> 32)));
                        } catch (IOException var57) {
                           var10001 = false;
                           break label239;
                        }

                        int var34 = var15 + 5;

                        byte var35;
                        label176: {
                           label175: {
                              try {
                                 if (var34 < var12.length) {
                                    break label175;
                                 }
                              } catch (IOException var70) {
                                 var10001 = false;
                                 break label239;
                              }

                              var35 = 0;
                              break label176;
                           }

                           try {
                              var35 = var12[var34];
                           } catch (IOException var56) {
                              var10001 = false;
                              break label239;
                           }
                        }

                        try {
                           var14.write((byte)((int)((long)(var35 ^ var13[var34 % var13.length]) ^ 255L & var22 >> 40)));
                        } catch (IOException var55) {
                           var10001 = false;
                           break label239;
                        }

                        int var36 = var15 + 6;

                        byte var37;
                        label168: {
                           label167: {
                              try {
                                 if (var36 < var12.length) {
                                    break label167;
                                 }
                              } catch (IOException var69) {
                                 var10001 = false;
                                 break label239;
                              }

                              var37 = 0;
                              break label168;
                           }

                           try {
                              var37 = var12[var36];
                           } catch (IOException var54) {
                              var10001 = false;
                              break label239;
                           }
                        }

                        try {
                           var14.write((byte)((int)((long)(var37 ^ var13[var36 % var13.length]) ^ 255L & var22 >> 48)));
                        } catch (IOException var53) {
                           var10001 = false;
                           break label239;
                        }

                        int var38 = var15 + 7;

                        byte var39;
                        label160: {
                           label159: {
                              try {
                                 if (var38 >= var12.length) {
                                    break label159;
                                 }
                              } catch (IOException var68) {
                                 var10001 = false;
                                 break label239;
                              }

                              try {
                                 var39 = var12[var38];
                                 break label160;
                              } catch (IOException var52) {
                                 var10001 = false;
                                 break label239;
                              }
                           }

                           var39 = 0;
                        }

                        try {
                           var14.write((byte)((int)((long)(var39 ^ var13[var38 % var13.length]) ^ 255L & var22 >> 56)));
                        } catch (IOException var51) {
                           var10001 = false;
                           break label239;
                        }

                        var15 += 8;
                        var8 = 32;
                     }

                     try {
                        String var40 = b(var14.toByteArray());
                        String var41 = a(var4);
                        StringBuilder var42 = new StringBuilder();
                        var42.append("1:");
                        var42.append(var41);
                        var42.append(":");
                        var42.append(var10);
                        var42.append(":");
                        var42.append(var40);
                        String var49 = var42.toString();
                        return var49;
                     } catch (IOException var50) {
                        var10001 = false;
                     }
                  }

                  var5 = null;
               }

               return var5;
            }
         } else {
            throw new IllegalArgumentException("No salt specified");
         }
      } else {
         IllegalArgumentException var6 = new IllegalArgumentException("No SDK key specified");
         throw var6;
      }
   }

   private static String a(String var0, String var1, byte[] var2) {
      if (var1 == null) {
         IllegalArgumentException var3 = new IllegalArgumentException("No SDK key specified");
         throw var3;
      } else if (var1.length() >= 80) {
         if (var2 == null) {
            throw new IllegalArgumentException("No salt specified");
         } else if (var2.length >= 32) {
            if (TextUtils.isEmpty(var0)) {
               return var0;
            } else if (var0.trim().startsWith("{")) {
               return var0;
            } else {
               String[] var4 = var0.split(":");
               String var5 = var4[0];

               boolean var10001;
               try {
                  if (!"1".equals(var5)) {
                     return null;
                  }

                  if (var4.length != 4) {
                     return null;
                  }
               } catch (IOException var50) {
                  var10001 = false;
                  return null;
               }

               byte var7 = 1;

               String var8;
               byte[] var10;
               try {
                  var8 = var4[var7];
                  String var9 = var4[2];
                  var10 = a(var4[3]);
                  if (!var1.endsWith(var9)) {
                     return null;
                  }
               } catch (IOException var49) {
                  var10001 = false;
                  return null;
               }

               byte[] var11;
               long var15;
               long var13;
               ByteArrayInputStream var12;
               try {
                  if (!a(var2).equals(var8)) {
                     return null;
                  }

                  var11 = a(var1.substring(0, 32), var2);
                  var12 = new ByteArrayInputStream(var10);
                  var13 = (long)(255 & (var12.read() ^ var11[0])) << 0;
                  var15 = (long)(255 & (var12.read() ^ var11[var7]));
               } catch (IOException var51) {
                  var10001 = false;
                  return null;
               }

               byte var17 = 8;

               byte var21;
               int var20;
               long var18;
               try {
                  var18 = var13 | var15 << var17 | (long)(255 & (var12.read() ^ var11[2])) << 16 | (long)(255 & (var12.read() ^ var11[3])) << 24 | (long)(255 & (var12.read() ^ var11[4])) << 32;
                  var20 = var12.read();
                  var21 = var11[5];
               } catch (IOException var48) {
                  var10001 = false;
                  return null;
               }

               long var22 = var18 | (long)(255 & (var20 ^ var21)) << 40;

               byte[] var28;
               long var25;
               int var29;
               ByteArrayOutputStream var27;
               try {
                  var25 = var22 | (long)(255 & (var12.read() ^ var11[6])) << 48 | (long)(255 & (var12.read() ^ var11[7])) << 56;
                  var27 = new ByteArrayOutputStream();
                  var28 = new byte[var17];
                  var29 = var12.read(var28);
               } catch (IOException var47) {
                  var10001 = false;
                  return null;
               }

               for(int var30 = 0; var29 >= 0; var7 = 1) {
                  long var32 = var25 + (long)var30;
                  long var34 = -4417276706812531889L * (var32 ^ var32 >> 33);
                  long var36 = -8796714831421723037L * (var34 ^ var34 >> 29);
                  long var38 = var36 ^ var36 >> 32;

                  int var40;
                  try {
                     var27.write((byte)((int)((long)(var28[0] ^ var11[(var30 + 0) % var11.length]) ^ 255L & var38 >> 0)));
                     var27.write((byte)((int)((long)(var28[var7] ^ var11[(var30 + 1) % var11.length]) ^ 255L & var38 >> var17)));
                     var40 = var28[2] ^ var11[(var30 + 2) % var11.length];
                  } catch (IOException var46) {
                     var10001 = false;
                     return null;
                  }

                  int var43;
                  try {
                     var27.write((byte)((int)((long)var40 ^ 255L & var38 >> 16)));
                     var27.write((byte)((int)((long)(var28[3] ^ var11[(var30 + 3) % var11.length]) ^ 255L & var38 >> 24)));
                     var27.write((byte)((int)((long)(var28[4] ^ var11[(var30 + 4) % var11.length]) ^ 255L & var38 >> 32)));
                     var27.write((byte)((int)((long)(var28[5] ^ var11[(var30 + 5) % var11.length]) ^ 255L & var38 >> 40)));
                     var27.write((byte)((int)((long)(var28[6] ^ var11[(var30 + 6) % var11.length]) ^ 255L & var38 >> 48)));
                     var27.write((byte)((int)((long)(var28[7] ^ var11[(var30 + 7) % var11.length]) ^ 255L & var38 >> 56)));
                     var43 = var12.read(var28);
                  } catch (IOException var45) {
                     var10001 = false;
                     return null;
                  }

                  var30 += 8;
                  var29 = var43;
                  var25 = var25;
                  var17 = 8;
               }

               try {
                  String var31 = (new String(var27.toByteArray(), "UTF-8")).trim();
                  return var31;
               } catch (IOException var44) {
                  var10001 = false;
                  return null;
               }
            }
         } else {
            throw new IllegalArgumentException("Salt is too short");
         }
      } else {
         throw new IllegalArgumentException("SDK key is too short");
      }
   }

   private static String a(byte[] var0) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-1");
         var2.update(var0);
         String var3 = n.a(var2.digest());
         return var3;
      } catch (NoSuchAlgorithmException var4) {
         throw new RuntimeException("SHA-1 algorithm not found", var4);
      }
   }

   private static byte[] a(String var0) {
      return Base64.decode(b(var0), 0);
   }

   private static byte[] a(String var0, byte[] var1) {
      try {
         MessageDigest var4 = MessageDigest.getInstance("SHA-256");
         var4.update(var1);
         var4.update(var0.getBytes("UTF-8"));
         byte[] var5 = var4.digest();
         return var5;
      } catch (NoSuchAlgorithmException var6) {
         throw new RuntimeException("SHA-1 algorithm not found", var6);
      } catch (UnsupportedEncodingException var7) {
         throw new RuntimeException("UTF-8 encoding not found", var7);
      }
   }

   private static String b(String var0) {
      return var0.replace('-', '+').replace('_', '/').replace('*', '=');
   }

   private static String b(byte[] var0) throws UnsupportedEncodingException {
      return c(Base64.encode(var0, 2));
   }

   private static String c(byte[] var0) throws UnsupportedEncodingException {
      return (new String(var0, "UTF-8")).replace('+', '-').replace('/', '_').replace('=', '*');
   }
}
