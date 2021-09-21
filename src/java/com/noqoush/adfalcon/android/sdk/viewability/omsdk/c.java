package com.noqoush.adfalcon.android.sdk.viewability.omsdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.VideoView;
import com.iab.omid.library.adfalcon.adsession.AdEvents;
import com.iab.omid.library.adfalcon.adsession.AdSession;
import com.iab.omid.library.adfalcon.adsession.AdSessionConfiguration;
import com.iab.omid.library.adfalcon.adsession.AdSessionContext;
import com.iab.omid.library.adfalcon.adsession.Owner;
import com.iab.omid.library.adfalcon.adsession.VerificationScriptResource;
import com.iab.omid.library.adfalcon.adsession.video.PlayerState;
import com.iab.omid.library.adfalcon.adsession.video.Position;
import com.iab.omid.library.adfalcon.adsession.video.VastProperties;
import com.iab.omid.library.adfalcon.adsession.video.VideoEvents;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import com.noqoush.adfalcon.android.sdk.video.vast.model.u;
import com.noqoush.adfalcon.android.sdk.viewability.ViewabilityVideoView;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c implements com.noqoush.adfalcon.android.sdk.viewability.b {
   private static boolean k;
   static AdSessionConfiguration l;
   private float a;
   private boolean b;
   private Position c;
   private int d;
   private AdSession e;
   private AdEvents f;
   private VideoEvents g;
   private SoftReference h;
   private List i;
   boolean j;

   public c() {
      this.c = Position.PREROLL;
      this.e = null;
      this.i = new ArrayList();
      this.j = false;
   }

   private void a(u var1) throws MalformedURLException {
      if (var1.c() != null && var1.c().c() != null) {
         if (!var1.c().c().equalsIgnoreCase("omid")) {
            return;
         }

         String var2 = var1.c().d();
         String var3 = var1.e();
         String var4 = var1.f();
         VerificationScriptResource var5;
         if (var4 != null && var4.length() > 0) {
            var5 = VerificationScriptResource.createVerificationScriptResourceWithParameters(var3, new URL(var2), var4);
         } else {
            var5 = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(var3, new URL(var2));
         }

         this.i.add(var5);
      }

   }

   private void t() throws Exception {
      if (this.e == null) {
         AdSessionContext var1 = this.v();
         AdSession var2 = AdSession.createAdSession(this.u(), var1);
         this.e = var2;
         var2.registerAdView(((ViewabilityVideoView)this.h.get()).getRootView());
         this.f = AdEvents.createAdEvents(this.e);
         this.g = VideoEvents.createVideoEvents(this.e);
      }
   }

   private AdSessionConfiguration u() throws Exception {
      Owner var1 = Owner.NATIVE;
      if (l == null) {
         l = AdSessionConfiguration.createAdSessionConfiguration(var1, var1, false);
      }

      return l;
   }

   private AdSessionContext v() throws Exception {
      return AdSessionContext.createNativeAdSessionContext(com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.b(), com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a(), this.w(), "");
   }

   private List w() throws Exception {
      return this.i;
   }

   public void a() {
      try {
         if (!k) {
            return;
         }

         if (this.e != null) {
            this.e.finish();
            this.e = null;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void a(Context var1) {
      k = com.noqoush.adfalcon.android.sdk.viewability.omsdk.b.a(var1);
   }

   public void a(Context var1, p var2, r var3, int var4, VideoView var5, MediaPlayer var6) {
      Iterator var7 = var3.d().iterator();

      while(var7.hasNext()) {
         u var8 = (u)var7.next();

         try {
            this.a(var8);
         } catch (MalformedURLException var10) {
            var10.printStackTrace();
         }
      }

      this.h = new SoftReference((ViewabilityVideoView)var5);
      this.a = (float)var3.r();
      this.b = true;
      this.c = Position.PREROLL;
      this.d = var3.i();
   }

   public void a(Double var1) {
      try {
         this.g.volumeChange(this.m());
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void a(Object var1) {
      try {
         this.h = new SoftReference((ViewabilityVideoView)var1);
         if (k) {
            this.t();
            this.e.start();
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void b() {
      try {
         if (!k) {
            return;
         }

         if (!this.j) {
            this.f.impressionOccurred();
            this.j = true;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void c() {
      try {
         this.g.bufferStart();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void d() {
      try {
         this.g.playerStateChange(PlayerState.FULLSCREEN);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void e() {
      try {
         this.g.thirdQuartile();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void f() {
      try {
         this.g.playerStateChange(PlayerState.NORMAL);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void g() {
      try {
         VastProperties var2 = VastProperties.createVastPropertiesForSkippableVideo(this.a, this.b, this.c);
         this.g.loaded(var2);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public int getDuration() {
      return ((ViewabilityVideoView)this.h.get()).getDuration();
   }

   public void h() {
   }

   public void i() {
      try {
         this.g.resume();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void j() {
      try {
         this.g.bufferFinish();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void k() {
      this.a(1.0D);
   }

   public void l() {
      try {
         this.g.pause();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public float m() {
      return ((ViewabilityVideoView)this.h.get()).getVolume();
   }

   public void n() {
      try {
         this.g.skipped();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void o() {
      try {
         this.g.complete();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void p() {
      this.a(0.0D);
   }

   public void q() {
      try {
         this.g.midpoint();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void r() {
      try {
         this.g.firstQuartile();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void s() {
      try {
         this.g.start((float)this.getDuration(), this.m());
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
