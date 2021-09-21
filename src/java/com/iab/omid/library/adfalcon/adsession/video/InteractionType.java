package com.iab.omid.library.adfalcon.adsession.video;

public enum InteractionType {
   CLICK("click"),
   INVITATION_ACCEPTED;

   String interactionType;

   static {
      InteractionType var0 = new InteractionType("INVITATION_ACCEPTED", 1, "invitationAccept");
      INVITATION_ACCEPTED = var0;
      InteractionType[] var1 = new InteractionType[]{CLICK, var0};
   }

   private InteractionType(String var3) {
      this.interactionType = var3;
   }

   public String toString() {
      return this.interactionType;
   }
}
