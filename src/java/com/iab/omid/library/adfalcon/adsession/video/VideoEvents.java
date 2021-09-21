package com.iab.omid.library.adfalcon.adsession.video;

import com.iab.omid.library.adfalcon.adsession.AdSession;
import com.iab.omid.library.adfalcon.adsession.a;
import com.iab.omid.library.adfalcon.d.b;
import com.iab.omid.library.adfalcon.d.e;
import org.json.JSONObject;

public final class VideoEvents {
   private final a adSession;

   private VideoEvents(a var1) {
      this.adSession = var1;
   }

   private void confirmValidDuration(float var1) {
      if (var1 <= 0.0F) {
         throw new IllegalArgumentException("Invalid Video duration");
      }
   }

   private void confirmValidVolume(float var1) {
      if (var1 < 0.0F || var1 > 1.0F) {
         throw new IllegalArgumentException("Invalid Video volume");
      }
   }

   public static VideoEvents createVideoEvents(AdSession var0) {
      a var1 = (a)var0;
      e.a((Object)var0, "AdSession is null");
      e.g(var1);
      e.a(var1);
      e.b(var1);
      e.e(var1);
      VideoEvents var2 = new VideoEvents(var1);
      var1.getAdSessionStatePublisher().a(var2);
      return var2;
   }

   public void adUserInteraction(InteractionType var1) {
      e.a((Object)var1, "InteractionType is null");
      e.c(this.adSession);
      JSONObject var2 = new JSONObject();
      b.a(var2, "interactionType", var1);
      this.adSession.getAdSessionStatePublisher().a("adUserInteraction", var2);
   }

   public void bufferFinish() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("bufferFinish");
   }

   public void bufferStart() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("bufferStart");
   }

   public void complete() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("complete");
   }

   public void firstQuartile() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("firstQuartile");
   }

   public void loaded(VastProperties var1) {
      e.a((Object)var1, "VastProperties is null");
      e.b(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("loaded", var1.toJSON());
   }

   public void midpoint() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("midpoint");
   }

   public void pause() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("pause");
   }

   public void playerStateChange(PlayerState var1) {
      e.a((Object)var1, "PlayerState is null");
      e.c(this.adSession);
      JSONObject var2 = new JSONObject();
      b.a(var2, "state", var1);
      this.adSession.getAdSessionStatePublisher().a("playerStateChange", var2);
   }

   public void resume() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("resume");
   }

   public void skipped() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("skipped");
   }

   public void start(float var1, float var2) {
      this.confirmValidDuration(var1);
      this.confirmValidVolume(var2);
      e.c(this.adSession);
      JSONObject var3 = new JSONObject();
      b.a(var3, "duration", var1);
      b.a(var3, "videoPlayerVolume", var2);
      b.a(var3, "deviceVolume", com.iab.omid.library.adfalcon.b.e.a().d());
      this.adSession.getAdSessionStatePublisher().a("start", var3);
   }

   public void thirdQuartile() {
      e.c(this.adSession);
      this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
   }

   public void volumeChange(float var1) {
      this.confirmValidVolume(var1);
      e.c(this.adSession);
      JSONObject var2 = new JSONObject();
      b.a(var2, "videoPlayerVolume", var1);
      b.a(var2, "deviceVolume", com.iab.omid.library.adfalcon.b.e.a().d());
      this.adSession.getAdSessionStatePublisher().a("volumeChange", var2);
   }
}
