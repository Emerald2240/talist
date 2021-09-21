package com.applovin.impl.sdk.c;

public final class e {
   private long a;
   private long b;
   private boolean c;
   private long d;
   private long e;

   public void a() {
      this.c = true;
   }

   public void a(long var1) {
      this.a += var1;
   }

   public void b(long var1) {
      this.b += var1;
   }

   public boolean b() {
      return this.c;
   }

   public long c() {
      return this.a;
   }

   public long d() {
      return this.b;
   }

   public void e() {
      ++this.d;
   }

   public void f() {
      ++this.e;
   }

   public long g() {
      return this.d;
   }

   public long h() {
      return this.e;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CacheStatsTracker{totalDownloadedBytes=");
      var1.append(this.a);
      var1.append(", totalCachedBytes=");
      var1.append(this.b);
      var1.append(", isHTMLCachingCancelled=");
      var1.append(this.c);
      var1.append(", htmlResourceCacheSuccessCount=");
      var1.append(this.d);
      var1.append(", htmlResourceCacheFailureCount=");
      var1.append(this.e);
      var1.append('}');
      return var1.toString();
   }
}
