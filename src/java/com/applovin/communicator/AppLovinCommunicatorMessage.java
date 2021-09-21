package com.applovin.communicator;

import android.os.Bundle;
import com.applovin.impl.communicator.CommunicatorMessageImpl;

public class AppLovinCommunicatorMessage extends CommunicatorMessageImpl {
   public AppLovinCommunicatorMessage(Bundle var1, String var2, AppLovinCommunicatorPublisher var3) {
      super(var1, var2, var3, true);
   }

   public Bundle getMessageData() {
      return this.data;
   }

   public String getPublisherId() {
      AppLovinCommunicatorPublisher var1 = (AppLovinCommunicatorPublisher)this.publisherRef.get();
      return var1 != null ? var1.getCommunicatorId() : "";
   }

   public String getTopic() {
      return this.getAction();
   }
}
