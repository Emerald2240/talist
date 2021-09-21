package com.applovin.mediation.adapters;

import android.app.Activity;
import android.view.View;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.sdk.AppLovinSdk;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MediationAdapterRouter {
   private static final Map sharedInstances = new HashMap();
   private static final Object sharedInstancesLock = new Object();
   private final Map listeners = new HashMap();
   private final Object listenersLock = new Object();
   private final Set loadedAdapters = new HashSet();
   private final Object loadedAdaptersLock = new Object();
   protected MaxAdapter.OnCompletionListener mOnCompletionListener;
   protected j mSdk;
   protected final String mTag = this.getClass().getSimpleName();
   private final Set showingAdapters = new HashSet();
   private final Object showingAdaptersLock = new Object();

   protected MediationAdapterRouter() {
      Iterator var1 = AppLovinSdk.a().iterator();

      while(var1.hasNext()) {
         AppLovinSdk var2 = (AppLovinSdk)var1.next();
         if ("max".equalsIgnoreCase(var2.getMediationProvider())) {
            this.mSdk = q.a(var2);
         }
      }

      if (this.mSdk == null) {
         p.j(this.mTag, "Invalid mediation provider detected. Please set AppLovin SDK mediation provider to MAX via AppLovinSdk.getInstance(context).setMediationProvider( AppLovinMediationProvider.MAX )");
      }

   }

   private void addAdapter(MaxAdapter var1, MaxAdapterListener var2, String var3, MediationAdapterRouter.RouterAdLoadType var4, View var5) {
      Object var6 = this.listenersLock;
      synchronized(var6){}

      boolean var10001;
      Throwable var10000;
      label195: {
         Object var9;
         MediationAdapterRouter.MediationAdapterRouterListenerWrapper var7;
         label189: {
            try {
               var7 = new MediationAdapterRouter.MediationAdapterRouterListenerWrapper(var1, var2, var4, var5);
               if (this.listeners.get(var3) != null) {
                  var9 = (List)this.listeners.get(var3);
                  break label189;
               }
            } catch (Throwable var32) {
               var10000 = var32;
               var10001 = false;
               break label195;
            }

            try {
               var9 = new ArrayList(1);
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label195;
            }
         }

         label180:
         try {
            ((List)var9).add(var7);
            this.listeners.put(var3, var9);
            return;
         } catch (Throwable var30) {
            var10000 = var30;
            var10001 = false;
            break label180;
         }
      }

      while(true) {
         Throwable var8 = var10000;

         try {
            throw var8;
         } catch (Throwable var29) {
            var10000 = var29;
            var10001 = false;
            continue;
         }
      }
   }

   private void addLoadedAdapter(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   private List getListenerWrappers(String var1) {
      return this.listeners.containsKey(var1) ? new ArrayList((Collection)this.listeners.get(var1)) : null;
   }

   private List getLoadingListenerWrappers(String var1) {
      ArrayList var2 = new ArrayList();
      Object var3 = this.listenersLock;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label418: {
         List var5;
         try {
            var5 = this.getListenerWrappers(var1);
         } catch (Throwable var51) {
            var10000 = var51;
            var10001 = false;
            break label418;
         }

         Iterator var6;
         label410: {
            if (var5 != null) {
               try {
                  if (var5.size() > 0) {
                     var6 = var5.iterator();
                     break label410;
                  }
               } catch (Throwable var50) {
                  var10000 = var50;
                  var10001 = false;
                  break label418;
               }
            }

            try {
               return null;
            } catch (Throwable var48) {
               var10000 = var48;
               var10001 = false;
               break label418;
            }
         }

         while(true) {
            try {
               if (!var6.hasNext()) {
                  break;
               }

               MediationAdapterRouter.MediationAdapterRouterListenerWrapper var7 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var6.next();
               if (!this.isAdLoaded(var7.getAdapter())) {
                  var2.add(var7);
               }
            } catch (Throwable var49) {
               var10000 = var49;
               var10001 = false;
               break label418;
            }
         }

         label393:
         try {
            return var2;
         } catch (Throwable var47) {
            var10000 = var47;
            var10001 = false;
            break label393;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var46) {
            var10000 = var46;
            var10001 = false;
            continue;
         }
      }
   }

   static MediationAdapterRouter getSharedInstance(Class var0) {
      Object var1 = sharedInstancesLock;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label253: {
         String var3;
         MediationAdapterRouter var4;
         try {
            var3 = var0.getName();
            var4 = (MediationAdapterRouter)sharedInstances.get(var3);
         } catch (Throwable var39) {
            var10000 = var39;
            var10001 = false;
            break label253;
         }

         if (var4 == null) {
            label243: {
               try {
                  Constructor var7 = var0.getDeclaredConstructor(new Class[0]);
                  var7.setAccessible(true);
                  MediationAdapterRouter var8 = (MediationAdapterRouter)var7.newInstance(new Object[0]);
               } finally {
                  break label243;
               }

            }

            try {
               sharedInstances.put(var3, var4);
            } catch (Throwable var37) {
               var10000 = var37;
               var10001 = false;
               break label253;
            }
         }

         label238:
         try {
            return var4;
         } catch (Throwable var36) {
            var10000 = var36;
            var10001 = false;
            break label238;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var35) {
            var10000 = var35;
            var10001 = false;
            continue;
         }
      }
   }

   private List getShowingListenerWrappers(String var1) {
      ArrayList var2 = new ArrayList();
      Object var3 = this.listenersLock;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label418: {
         List var5;
         try {
            var5 = this.getListenerWrappers(var1);
         } catch (Throwable var51) {
            var10000 = var51;
            var10001 = false;
            break label418;
         }

         Iterator var6;
         label410: {
            if (var5 != null) {
               try {
                  if (var5.size() > 0) {
                     var6 = var5.iterator();
                     break label410;
                  }
               } catch (Throwable var50) {
                  var10000 = var50;
                  var10001 = false;
                  break label418;
               }
            }

            try {
               return null;
            } catch (Throwable var48) {
               var10000 = var48;
               var10001 = false;
               break label418;
            }
         }

         while(true) {
            try {
               if (!var6.hasNext()) {
                  break;
               }

               MediationAdapterRouter.MediationAdapterRouterListenerWrapper var7 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var6.next();
               if (this.isAdShowing(var7.getAdapter())) {
                  var2.add(var7);
               }
            } catch (Throwable var49) {
               var10000 = var49;
               var10001 = false;
               break label418;
            }
         }

         label393:
         try {
            return var2;
         } catch (Throwable var47) {
            var10000 = var47;
            var10001 = false;
            break label393;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var46) {
            var10000 = var46;
            var10001 = false;
            continue;
         }
      }
   }

   private boolean isAdLoaded(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean isAdShowing(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   private void removeLoadedAdapter(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   private void removeShowingAdapter(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   public void addAdViewAdapter(MaxAdapter var1, MaxAdViewAdapterListener var2, String var3, View var4) {
      this.addAdapter(var1, var2, var3, MediationAdapterRouter.RouterAdLoadType.ADVIEW, var4);
   }

   public void addInterstitialAdapter(MaxAdapter var1, MaxInterstitialAdapterListener var2, String var3) {
      this.addAdapter(var1, var2, var3, MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL, (View)null);
   }

   public void addRewardedAdapter(MaxAdapter var1, MaxRewardedAdapterListener var2, String var3) {
      this.addAdapter(var1, var2, var3, MediationAdapterRouter.RouterAdLoadType.REWARDED, (View)null);
   }

   public void addShowingAdapter(MaxAdapter param1) {
      // $FF: Couldn't be decompiled
   }

   protected MaxReward getReward(String var1) {
      Object var2 = this.listenersLock;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label211: {
         List var4;
         try {
            var4 = this.getListenerWrappers(var1);
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label211;
         }

         if (var4 != null) {
            try {
               if (var4.size() > 0) {
                  MaxAdapter var5 = ((MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var4.get(0)).getAdapter();
                  if (var5 instanceof MediationAdapterBase) {
                     MaxReward var6 = ((MediationAdapterBase)var5).getReward();
                     return var6;
                  }
               }
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label211;
            }
         }

         label198:
         try {
            return MaxReward.createDefault();
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label198;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   abstract void initialize(MaxAdapterInitializationParameters var1, Activity var2, MaxAdapter.OnCompletionListener var3);

   protected void log(String var1) {
      j var2 = this.mSdk;
      if (var2 != null) {
         var2.v().c(this.mTag, var1);
      }

   }

   protected void log(String var1, Throwable var2) {
      j var3 = this.mSdk;
      if (var3 != null) {
         var3.v().b(this.mTag, var1, var2);
      }

   }

   protected void onAdClicked(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               this.log("Interstitial clicked");
               ((MaxInterstitialAdapterListener)var6).onInterstitialAdClicked();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded clicked");
               ((MaxRewardedAdapterListener)var6).onRewardedAdClicked();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView clicked");
               ((MaxAdViewAdapterListener)var6).onAdViewAdClicked();
            }
         }
      }

   }

   protected void onAdDisplayFailed(String var1, MaxAdapterError var2) {
      List var3 = this.getShowingListenerWrappers(var1);
      if (var3 != null && var3.size() > 0) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var5 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var4.next();
            MediationAdapterRouter.RouterAdLoadType var6 = var5.getLoadType();
            MaxAdapterListener var7 = var5.getListener();
            if (var6 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               StringBuilder var8 = new StringBuilder();
               var8.append("Interstitial failed to display with error: ");
               var8.append(var2.toString());
               this.log(var8.toString());
               ((MaxInterstitialAdapterListener)var7).onInterstitialAdDisplayFailed(var2);
            } else if (var6 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               StringBuilder var11 = new StringBuilder();
               var11.append("Rewarded failed to display with error: ");
               var11.append(var2.toString());
               this.log(var11.toString());
               ((MaxRewardedAdapterListener)var7).onRewardedAdDisplayFailed(var2);
            } else if (var6 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               StringBuilder var14 = new StringBuilder();
               var14.append("AdView failed to display with error: ");
               var14.append(var2.toString());
               this.log(var14.toString());
               ((MaxAdViewAdapterListener)var7).onAdViewAdDisplayFailed(var2);
            }
         }
      }

   }

   protected void onAdDisplayed(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               this.log("Interstitial shown");
               ((MaxInterstitialAdapterListener)var6).onInterstitialAdDisplayed();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded shown");
               ((MaxRewardedAdapterListener)var6).onRewardedAdDisplayed();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView shown");
               ((MaxAdViewAdapterListener)var6).onAdViewAdDisplayed();
            }
         }
      }

   }

   protected void onAdHidden(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               this.log("Interstitial hidden");
               ((MaxInterstitialAdapterListener)var6).onInterstitialAdHidden();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded hidden");
               ((MaxRewardedAdapterListener)var6).onRewardedAdHidden();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView hidden");
               ((MaxAdViewAdapterListener)var6).onAdViewAdHidden();
            }
         }
      }

   }

   protected void onAdLoadFailed(String var1, MaxAdapterError var2) {
      List var3 = this.getLoadingListenerWrappers(var1);
      if (var3 != null && var3.size() > 0) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var5 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var4.next();
            MediationAdapterRouter.RouterAdLoadType var6 = var5.getLoadType();
            MaxAdapterListener var7 = var5.getListener();
            if (var6 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               StringBuilder var8 = new StringBuilder();
               var8.append("Interstitial failed to load with error: ");
               var8.append(var2.toString());
               this.log(var8.toString());
               ((MaxInterstitialAdapterListener)var7).onInterstitialAdLoadFailed(var2);
            } else if (var6 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               StringBuilder var11 = new StringBuilder();
               var11.append("Rewarded failed to load with error: ");
               var11.append(var2.toString());
               this.log(var11.toString());
               ((MaxRewardedAdapterListener)var7).onRewardedAdLoadFailed(var2);
            } else if (var6 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               StringBuilder var14 = new StringBuilder();
               var14.append("AdView failed to load with error: ");
               var14.append(var2.toString());
               this.log(var14.toString());
               ((MaxAdViewAdapterListener)var7).onAdViewAdLoadFailed(var2);
            }
         }
      }

   }

   protected void onAdLoaded(String var1) {
      List var2 = this.getLoadingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            this.addLoadedAdapter(var4.getAdapter());
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.INTERSTITIAL) {
               this.log("Interstitial loaded");
               ((MaxInterstitialAdapterListener)var6).onInterstitialAdLoaded();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded loaded");
               ((MaxRewardedAdapterListener)var6).onRewardedAdLoaded();
            } else if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView loaded");
               ((MaxAdViewAdapterListener)var6).onAdViewAdLoaded(var4.getAdView());
            }
         }
      }

   }

   protected void onAdViewAdCollapsed(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView collapsed");
               ((MaxAdViewAdapterListener)var6).onAdViewAdCollapsed();
            }
         }
      }

   }

   protected void onAdViewAdExpanded(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.ADVIEW) {
               this.log("AdView expanded");
               ((MaxAdViewAdapterListener)var6).onAdViewAdExpanded();
            }
         }
      }

   }

   protected void onRewardedAdVideoCompleted(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded video completed");
               ((MaxRewardedAdapterListener)var6).onRewardedAdVideoCompleted();
            }
         }
      }

   }

   protected void onRewardedAdVideoStarted(String var1) {
      List var2 = this.getShowingListenerWrappers(var1);
      if (var2 != null && var2.size() > 0) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var4 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var3.next();
            MediationAdapterRouter.RouterAdLoadType var5 = var4.getLoadType();
            MaxAdapterListener var6 = var4.getListener();
            if (var5 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               this.log("Rewarded video started");
               ((MaxRewardedAdapterListener)var6).onRewardedAdVideoStarted();
            }
         }
      }

   }

   protected void onUserRewarded(String var1, MaxReward var2) {
      List var3 = this.getShowingListenerWrappers(var1);
      if (var3 != null && var3.size() > 0) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            MediationAdapterRouter.MediationAdapterRouterListenerWrapper var5 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var4.next();
            MediationAdapterRouter.RouterAdLoadType var6 = var5.getLoadType();
            MaxAdapterListener var7 = var5.getListener();
            if (var6 == MediationAdapterRouter.RouterAdLoadType.REWARDED) {
               StringBuilder var8 = new StringBuilder();
               var8.append("Rewarded user with reward: ");
               var8.append(var2);
               this.log(var8.toString());
               ((MaxRewardedAdapterListener)var7).onUserRewarded(var2);
            }
         }
      }

   }

   public void removeAdapter(MaxAdapter var1, String var2) {
      this.removeLoadedAdapter(var1);
      this.removeShowingAdapter(var1);
      Object var3 = this.listenersLock;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label505: {
         List var5;
         try {
            var5 = (List)this.listeners.get(var2);
         } catch (Throwable var67) {
            var10000 = var67;
            var10001 = false;
            break label505;
         }

         if (var5 != null) {
            label506: {
               Iterator var6;
               try {
                  if (var5.size() <= 0) {
                     break label506;
                  }

                  var6 = var5.iterator();
               } catch (Throwable var65) {
                  var10000 = var65;
                  var10001 = false;
                  break label505;
               }

               MediationAdapterRouter.MediationAdapterRouterListenerWrapper var8;
               while(true) {
                  boolean var7;
                  try {
                     var7 = var6.hasNext();
                  } catch (Throwable var64) {
                     var10000 = var64;
                     var10001 = false;
                     break label505;
                  }

                  var8 = null;
                  if (!var7) {
                     break;
                  }

                  MediationAdapterRouter.MediationAdapterRouterListenerWrapper var9;
                  try {
                     var9 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var6.next();
                     if (var9.getAdapter() != var1) {
                        continue;
                     }
                  } catch (Throwable var66) {
                     var10000 = var66;
                     var10001 = false;
                     break label505;
                  }

                  var8 = var9;
                  break;
               }

               if (var8 != null) {
                  try {
                     var5.remove(var8);
                  } catch (Throwable var63) {
                     var10000 = var63;
                     var10001 = false;
                     break label505;
                  }
               }
            }
         }

         label478:
         try {
            return;
         } catch (Throwable var62) {
            var10000 = var62;
            var10001 = false;
            break label478;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var61) {
            var10000 = var61;
            var10001 = false;
            continue;
         }
      }
   }

   protected boolean shouldAlwaysRewardUser(String var1) {
      Object var2 = this.listenersLock;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label197: {
         List var4;
         try {
            var4 = this.getListenerWrappers(var1);
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label197;
         }

         if (var4 != null) {
            try {
               if (var4.size() > 0) {
                  MaxAdapter var5 = ((MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var4.get(0)).getAdapter();
                  if (var5 instanceof MediationAdapterBase) {
                     boolean var6 = ((MediationAdapterBase)var5).shouldAlwaysRewardUser();
                     return var6;
                  }
               }
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label197;
            }
         }

         label186:
         try {
            return false;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label186;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   public void updateAdView(View var1, String var2) {
      Object var3 = this.listenersLock;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label297: {
         List var5;
         try {
            var5 = this.getListenerWrappers(var2);
         } catch (Throwable var38) {
            var10000 = var38;
            var10001 = false;
            break label297;
         }

         if (var5 != null) {
            label288: {
               Iterator var6;
               try {
                  if (var5.size() <= 0) {
                     break label288;
                  }

                  var6 = var5.iterator();
               } catch (Throwable var37) {
                  var10000 = var37;
                  var10001 = false;
                  break label297;
               }

               try {
                  while(var6.hasNext()) {
                     MediationAdapterRouter.MediationAdapterRouterListenerWrapper var7 = (MediationAdapterRouter.MediationAdapterRouterListenerWrapper)var6.next();
                     if (var7.getAdView() == null) {
                        var7.setAdView(var1);
                        break;
                     }
                  }
               } catch (Throwable var36) {
                  var10000 = var36;
                  var10001 = false;
                  break label297;
               }
            }
         }

         label277:
         try {
            return;
         } catch (Throwable var35) {
            var10000 = var35;
            var10001 = false;
            break label277;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var34) {
            var10000 = var34;
            var10001 = false;
            continue;
         }
      }
   }

   private final class MediationAdapterRouterListenerWrapper {
      private View mAdView;
      private final MaxAdapter mAdapter;
      private final MaxAdapterListener mListener;
      private final MediationAdapterRouter.RouterAdLoadType mLoadType;

      MediationAdapterRouterListenerWrapper(MaxAdapter var2, MaxAdapterListener var3, MediationAdapterRouter.RouterAdLoadType var4, View var5) {
         this.mAdapter = var2;
         this.mListener = var3;
         this.mLoadType = var4;
         this.mAdView = var5;
      }

      View getAdView() {
         return this.mAdView;
      }

      MaxAdapter getAdapter() {
         return this.mAdapter;
      }

      MaxAdapterListener getListener() {
         return this.mListener;
      }

      MediationAdapterRouter.RouterAdLoadType getLoadType() {
         return this.mLoadType;
      }

      void setAdView(View var1) {
         this.mAdView = var1;
      }
   }

   private static enum RouterAdLoadType {
      ADVIEW,
      INTERSTITIAL,
      REWARDED;

      static {
         MediationAdapterRouter.RouterAdLoadType[] var0 = new MediationAdapterRouter.RouterAdLoadType[]{INTERSTITIAL, REWARDED, ADVIEW};
      }
   }
}
