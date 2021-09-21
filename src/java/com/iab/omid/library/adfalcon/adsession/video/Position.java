package com.iab.omid.library.adfalcon.adsession.video;

public enum Position {
   MIDROLL("midroll"),
   POSTROLL("postroll"),
   PREROLL("preroll"),
   STANDALONE;

   private final String position;

   static {
      Position var0 = new Position("STANDALONE", 3, "standalone");
      STANDALONE = var0;
      Position[] var1 = new Position[]{PREROLL, MIDROLL, POSTROLL, var0};
   }

   private Position(String var3) {
      this.position = var3;
   }

   public String toString() {
      return this.position;
   }
}
