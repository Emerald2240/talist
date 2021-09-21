package com.applovin.impl.sdk.utils;

import android.util.Xml;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class t {
   private final com.applovin.impl.sdk.p a;
   private Stack b;
   private StringBuilder c;
   private long d;
   private t.a e;

   t(com.applovin.impl.sdk.j var1) {
      if (var1 != null) {
         this.a = var1.v();
      } else {
         throw new IllegalArgumentException("No sdk specified.");
      }
   }

   public static s a(String var0, com.applovin.impl.sdk.j var1) throws SAXException {
      return (new t(var1)).a(var0);
   }

   private Map a(Attributes var1) {
      if (var1 == null) {
         return Collections.emptyMap();
      } else {
         int var2 = var1.getLength();
         HashMap var3 = new HashMap(var2);

         for(int var4 = 0; var4 < var2; ++var4) {
            var3.put(var1.getQName(var4), var1.getValue(var4));
         }

         return var3;
      }
   }

   public s a(String var1) throws SAXException {
      if (var1 != null) {
         this.c = new StringBuilder();
         this.b = new Stack();
         this.e = null;
         Xml.parse(var1, new ContentHandler() {
            public void characters(char[] var1, int var2, int var3) {
               String var4 = (new String(Arrays.copyOfRange(var1, var2, var3))).trim();
               if (n.b(var4)) {
                  t.this.c.append(var4);
               }

            }

            public void endDocument() {
               long var1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - t.this.d;
               com.applovin.impl.sdk.p var3 = t.this.a;
               StringBuilder var4 = new StringBuilder();
               var4.append("Finished parsing in ");
               var4.append(var1);
               var4.append(" seconds");
               var3.b("XmlParser", var4.toString());
            }

            public void endElement(String var1, String var2, String var3) {
               t var4 = t.this;
               var4.e = (t.a)var4.b.pop();
               t.this.e.d(t.this.c.toString().trim());
               t.this.c.setLength(0);
            }

            public void endPrefixMapping(String var1) {
            }

            public void ignorableWhitespace(char[] var1, int var2, int var3) {
            }

            public void processingInstruction(String var1, String var2) {
            }

            public void setDocumentLocator(Locator var1) {
            }

            public void skippedEntity(String var1) {
            }

            public void startDocument() {
               t.this.a.b("XmlParser", "Begin parsing...");
               t.this.d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            }

            public void startElement(String var1, String var2, String var3, Attributes var4) throws SAXException {
               Exception var10000;
               label41: {
                  boolean var11;
                  boolean var10001;
                  try {
                     var11 = t.this.b.isEmpty();
                  } catch (Exception var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label41;
                  }

                  t.a var12 = null;
                  if (!var11) {
                     try {
                        var12 = (t.a)t.this.b.peek();
                     } catch (Exception var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label41;
                     }
                  }

                  t.a var13;
                  try {
                     var13 = new t.a(var2, t.this.a(var4), var12);
                  } catch (Exception var16) {
                     var10000 = var16;
                     var10001 = false;
                     break label41;
                  }

                  if (var12 != null) {
                     try {
                        var12.a(var13);
                     } catch (Exception var15) {
                        var10000 = var15;
                        var10001 = false;
                        break label41;
                     }
                  }

                  try {
                     t.this.b.push(var13);
                     return;
                  } catch (Exception var14) {
                     var10000 = var14;
                     var10001 = false;
                  }
               }

               Exception var5 = var10000;
               com.applovin.impl.sdk.p var6 = t.this.a;
               StringBuilder var7 = new StringBuilder();
               var7.append("Unable to process element <");
               var7.append(var2);
               var7.append(">");
               var6.b("XmlParser", var7.toString(), var5);
               throw new SAXException("Failed to start element", var5);
            }

            public void startPrefixMapping(String var1, String var2) {
            }
         });
         t.a var2 = this.e;
         if (var2 != null) {
            return var2;
         } else {
            throw new SAXException("Unable to parse XML into node");
         }
      } else {
         throw new IllegalArgumentException("Unable to parse. No XML specified.");
      }
   }

   private static class a extends s {
      a(String var1, Map var2, s var3) {
         super(var1, var2, var3);
      }

      void a(s var1) {
         if (var1 != null) {
            this.c.add(var1);
         } else {
            throw new IllegalArgumentException("None specified.");
         }
      }

      void d(String var1) {
         this.b = var1;
      }
   }
}
