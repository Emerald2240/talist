package com.iab.omid.library.adfalcon.walking;

import com.iab.omid.library.adfalcon.walking.a.d;
import com.iab.omid.library.adfalcon.walking.a.e;
import com.iab.omid.library.adfalcon.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements com.iab.omid.library.adfalcon.walking.a.b.b {
   private JSONObject a;
   private final com.iab.omid.library.adfalcon.walking.a.c b;

   public b(com.iab.omid.library.adfalcon.walking.a.c var1) {
      this.b = var1;
   }

   public void a() {
      this.b.b(new d(this));
   }

   public void a(JSONObject var1) {
      this.a = var1;
   }

   public void a(JSONObject var1, HashSet var2, long var3) {
      com.iab.omid.library.adfalcon.walking.a.c var5 = this.b;
      f var6 = new f(this, var2, var1, var3);
      var5.b(var6);
   }

   public JSONObject b() {
      return this.a;
   }

   public void b(JSONObject var1, HashSet var2, long var3) {
      com.iab.omid.library.adfalcon.walking.a.c var5 = this.b;
      e var6 = new e(this, var2, var1, var3);
      var5.b(var6);
   }
}
