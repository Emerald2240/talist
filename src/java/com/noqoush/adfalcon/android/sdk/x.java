package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.constant.ADFAdSize;

public class x {
   private static boolean E;
   private int A;
   private int B;
   private int C;
   private boolean D;
   private ADFListener a;
   private ADFAd b;
   private ADFView c;
   private ADFView d;
   private g e;
   private ADFTargetingParams f;
   private com.noqoush.adfalcon.android.sdk.response.k g;
   private ADFAdSize h;
   private com.noqoush.adfalcon.android.sdk.constant.a i;
   private m j;
   private Context k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private boolean q;
   private boolean r;
   private boolean s;
   private boolean t;
   private boolean u;
   private boolean v;
   private String w;
   private boolean x;
   private int y;
   private w.e z;

   public x() {
      this.h = ADFAdSize.AD_UNIT_320x50;
      this.n = 5;
      this.o = 0;
      this.p = 0;
      this.q = true;
      this.r = false;
      this.s = false;
      this.t = true;
      this.u = true;
      this.w = "";
      this.x = false;
      this.y = 0;
      this.z = w.e.a;
      this.A = -1;
      this.B = -1;
      this.C = 0;
      this.D = false;
   }

   public static boolean F() {
      return E;
   }

   public static void i(boolean var0) {
      E = var0;
   }

   public boolean A() {
      return this.t;
   }

   protected boolean B() {
      return this.v;
   }

   public boolean C() {
      return this.x;
   }

   protected boolean D() {
      return this.u;
   }

   public void E() {
      this.y = 0;
   }

   protected ADFAd a() {
      return this.b;
   }

   protected void a(int var1) {
      this.p = var1;
   }

   public void a(Context var1) {
      this.k = var1;
   }

   protected void a(ADFAd var1) {
      this.b = var1;
   }

   public void a(ADFListener var1) {
      this.a = var1;
   }

   public void a(ADFTargetingParams var1) {
      this.f = var1;
   }

   public void a(ADFView var1) {
      this.c = var1;
   }

   public void a(ADFAdSize var1) {
      this.h = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.constant.a var1) {
      this.i = var1;
   }

   public void a(g var1) {
      this.e = var1;
   }

   public void a(m var1) {
      this.j = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.response.k var1) {
      this.g = var1;
   }

   public void a(w.e var1) {
      this.z = var1;
   }

   public void a(String var1) {
      this.w = var1;
   }

   public void a(boolean var1) {
      this.s = var1;
   }

   public int b() {
      return this.y;
   }

   protected void b(int var1) {
      this.o = var1;
   }

   public void b(ADFView var1) {
      this.d = var1;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   protected int c() {
      return this.p;
   }

   public void c(int var1) {
      this.n = var1;
   }

   public void c(boolean var1) {
      this.r = var1;
   }

   protected int d() {
      return this.o;
   }

   public void d(int var1) {
      this.A = var1;
   }

   public void d(boolean var1) {
      this.t = var1;
   }

   public ADFView e() {
      return this.c;
   }

   public void e(int var1) {
      this.B = var1;
   }

   public void e(boolean var1) {
      this.D = var1;
   }

   public Context f() {
      return this.k;
   }

   public void f(int var1) {
      this.C = var1;
   }

   protected void f(boolean var1) {
      this.v = var1;
   }

   public g g() {
      return this.e;
   }

   public void g(int var1) {
      this.l = var1;
   }

   public void g(boolean var1) {
      this.x = var1;
   }

   protected com.noqoush.adfalcon.android.sdk.constant.a h() {
      return this.i;
   }

   protected void h(boolean var1) {
      this.u = var1;
   }

   public ADFListener i() {
      return this.a;
   }

   public m j() {
      return this.j;
   }

   public int k() {
      return this.n;
   }

   public com.noqoush.adfalcon.android.sdk.response.k l() {
      return this.g;
   }

   public int m() {
      return this.A;
   }

   public int n() {
      return this.B;
   }

   public int o() {
      return this.C;
   }

   public String p() {
      return this.w;
   }

   public ADFAdSize q() {
      return this.h;
   }

   public int r() {
      return this.l;
   }

   public w.e s() {
      return this.z;
   }

   public ADFTargetingParams t() {
      return this.f;
   }

   public ADFView u() {
      return this.d;
   }

   public boolean v() {
      return this.D;
   }

   public void w() {
      ++this.y;
   }

   public boolean x() {
      return this.s;
   }

   public boolean y() {
      return this.q;
   }

   public boolean z() {
      return this.r;
   }
}
