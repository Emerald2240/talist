package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.communicator.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AppLovinCommunicator {
   private static AppLovinCommunicator a;
   private static final Object b = new Object();
   private j c;
   private final a d;
   private final MessagingServiceImpl e;

   private AppLovinCommunicator(Context var1) {
      this.d = new a(var1);
      this.e = new MessagingServiceImpl(var1);
   }

   public static AppLovinCommunicator getInstance(Context var0) {
      Object var1 = b;
      synchronized(var1){}

      Throwable var10000;
      boolean var10001;
      label131: {
         try {
            if (a == null) {
               a = new AppLovinCommunicator(var0.getApplicationContext());
            }
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label131;
         }

         label128:
         try {
            return a;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label128;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            continue;
         }
      }
   }

   public void a(j var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Attaching SDK instance: ");
      var2.append(var1);
      var2.append("...");
      p.g("AppLovinCommunicator", var2.toString());
      this.c = var1;
   }

   public AppLovinCommunicatorMessagingService getMessagingService() {
      return this.e;
   }

   public void subscribe(AppLovinCommunicatorSubscriber var1, String var2) {
      this.subscribe(var1, Collections.singletonList(var2));
   }

   public void subscribe(AppLovinCommunicatorSubscriber var1, List var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         StringBuilder var5 = new StringBuilder();
         var5.append("Subscribing ");
         var5.append(var1);
         var5.append(" to topic: ");
         var5.append(var4);
         p.g("AppLovinCommunicator", var5.toString());
         if (this.d.a(var1, var4)) {
            StringBuilder var10 = new StringBuilder();
            var10.append("Subscribed ");
            var10.append(var1);
            var10.append(" to topic: ");
            var10.append(var4);
            p.g("AppLovinCommunicator", var10.toString());
            this.e.maybeFlushStickyMessages(var4);
         } else {
            StringBuilder var15 = new StringBuilder();
            var15.append("Unable to subscribe ");
            var15.append(var1);
            var15.append(" to topic: ");
            var15.append(var4);
            p.g("AppLovinCommunicator", var15.toString());
         }
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinCommunicator{sdk=");
      var1.append(this.c);
      var1.append('}');
      return var1.toString();
   }

   public void unsubscribe(AppLovinCommunicatorSubscriber var1, String var2) {
      this.unsubscribe(var1, Collections.singletonList(var2));
   }

   public void unsubscribe(AppLovinCommunicatorSubscriber var1, List var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         StringBuilder var5 = new StringBuilder();
         var5.append("Unsubscribing ");
         var5.append(var1);
         var5.append(" from topic: ");
         var5.append(var4);
         p.g("AppLovinCommunicator", var5.toString());
         this.d.b(var1, var4);
      }

   }
}
