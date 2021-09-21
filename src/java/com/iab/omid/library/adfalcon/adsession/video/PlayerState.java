package com.iab.omid.library.adfalcon.adsession.video;

public enum PlayerState {
   COLLAPSED("collapsed"),
   EXPANDED("expanded"),
   FULLSCREEN,
   MINIMIZED("minimized"),
   NORMAL("normal");

   private final String playerState;

   static {
      PlayerState var0 = new PlayerState("FULLSCREEN", 4, "fullscreen");
      FULLSCREEN = var0;
      PlayerState[] var1 = new PlayerState[]{MINIMIZED, COLLAPSED, NORMAL, EXPANDED, var0};
   }

   private PlayerState(String var3) {
      this.playerState = var3;
   }

   public String toString() {
      return this.playerState;
   }
}
