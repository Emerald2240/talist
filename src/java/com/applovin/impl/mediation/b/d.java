package com.applovin.impl.mediation.b;

import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.j;
import org.json.JSONObject;

public class d extends a {
   private d(d var1, i var2) {
      super(var1.B(), var1.A(), var2, var1.b);
   }

   public d(JSONObject var1, JSONObject var2, j var3) {
      super(var1, var2, (i)null, var3);
   }

   public a a(i var1) {
      return new d(this, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedNativeAd{format=");
      var1.append(this.getFormat());
      var1.append(", adUnitId=");
      var1.append(this.getAdUnitId());
      var1.append(", isReady=");
      var1.append(this.a());
      var1.append(", adapterClass='");
      var1.append(this.C());
      var1.append("', adapterName='");
      var1.append(this.D());
      var1.append("', isTesting=");
      var1.append(this.E());
      var1.append(", isRefreshEnabled=");
      var1.append(this.I());
      var1.append(", getAdRefreshMillis=");
      var1.append(this.J());
      var1.append('}');
      return var1.toString();
   }
}
