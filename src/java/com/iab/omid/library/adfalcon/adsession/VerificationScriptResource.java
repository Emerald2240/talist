package com.iab.omid.library.adfalcon.adsession;

import com.iab.omid.library.adfalcon.d.e;
import java.net.URL;

public final class VerificationScriptResource {
   private final URL resourceUrl;
   private final String vendorKey;
   private final String verificationParameters;

   private VerificationScriptResource(String var1, URL var2, String var3) {
      this.vendorKey = var1;
      this.resourceUrl = var2;
      this.verificationParameters = var3;
   }

   public static VerificationScriptResource createVerificationScriptResourceWithParameters(String var0, URL var1, String var2) {
      e.a(var0, "VendorKey is null or empty");
      e.a((Object)var1, "ResourceURL is null");
      e.a(var2, "VerificationParameters is null or empty");
      return new VerificationScriptResource(var0, var1, var2);
   }

   public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(String var0, URL var1) {
      e.a(var0, "VendorKey is null or empty");
      e.a((Object)var1, "ResourceURL is null");
      return new VerificationScriptResource(var0, var1, (String)null);
   }

   public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL var0) {
      e.a((Object)var0, "ResourceURL is null");
      return new VerificationScriptResource((String)null, var0, (String)null);
   }

   public URL getResourceUrl() {
      return this.resourceUrl;
   }

   public String getVendorKey() {
      return this.vendorKey;
   }

   public String getVerificationParameters() {
      return this.verificationParameters;
   }
}
