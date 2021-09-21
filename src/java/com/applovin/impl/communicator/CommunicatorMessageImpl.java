package com.applovin.impl.communicator;

import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import java.lang.ref.WeakReference;
import java.util.UUID;

public abstract class CommunicatorMessageImpl extends Intent {
   private final String a = UUID.randomUUID().toString();
   protected final Bundle data;
   protected final WeakReference publisherRef;
   protected boolean sticky;

   public CommunicatorMessageImpl(Bundle var1, String var2, AppLovinCommunicatorPublisher var3, boolean var4) {
      super(var2);
      this.publisherRef = new WeakReference(var3);
      this.sticky = var4;
      this.data = var1;
   }

   public static AppLovinCommunicatorMessage create(Bundle var0, String var1, AppLovinCommunicatorPublisher var2, boolean var3) {
      AppLovinCommunicatorMessage var4 = new AppLovinCommunicatorMessage(var0, var1, var2);
      var4.sticky = var3;
      return var4;
   }

   boolean a() {
      return this.sticky;
   }

   public abstract Bundle getMessageData();

   public abstract String getPublisherId();

   public abstract String getTopic();

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinCommunicatorMessage{publisherId=");
      var1.append(this.getPublisherId());
      var1.append(", topic=");
      var1.append(this.getTopic());
      var1.append('\'');
      var1.append(", uniqueId='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", data=");
      var1.append(this.data);
      var1.append(", sticky=");
      var1.append(this.sticky);
      var1.append('}');
      return var1.toString();
   }
}
