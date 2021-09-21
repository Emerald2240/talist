package com.applovin.impl.mediation.b;

import com.applovin.impl.sdk.j;
import org.json.JSONObject;

public class g extends e {
   public g(JSONObject var1, JSONObject var2, j var3) {
      super(var1, var2, var3);
   }

   int a() {
      return this.b("max_signal_length", 2048);
   }

   public boolean b() {
      return this.b("only_collect_signal_when_initialized", false);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("SignalProviderSpec{specObject=");
      var1.append(this.B());
      var1.append('}');
      return var1.toString();
   }
}
