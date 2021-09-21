package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class t extends g {
   private String c = "unkown";
   private String d = "unkown";
   private String e = "unkown";

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      this.c = var1.getAttributeValue((String)null, "idRegistry");
      this.d = var1.getAttributeValue((String)null, "idValue");
      this.e = var1.nextText().trim();
   }

   public String c() {
      return this.d;
   }

   public String d() {
      return this.c;
   }

   public String e() {
      return this.e;
   }
}
