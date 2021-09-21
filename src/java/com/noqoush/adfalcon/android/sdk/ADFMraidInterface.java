package com.noqoush.adfalcon.android.sdk;

import com.noqoush.adfalcon.android.sdk.constant.ADFMraidPlacementType;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;

interface ADFMraidInterface {
   void close(boolean var1);

   void createCalendarEvent(String var1);

   void expand(String var1);

   void fireSizeChangeEvent(int var1, int var2);

   void open(String var1);

   void playVideo(String var1);

   void ready();

   void resize();

   void runTiltSensor();

   void setCurrentPosition(int var1, int var2, int var3, int var4);

   void setDefaultPosition(int var1, int var2, int var3, int var4);

   void setMaxSize(int var1, int var2);

   void setOrientationProperties(String var1);

   void setPlacementType(ADFMraidPlacementType var1);

   void setResizeProperties(String var1);

   void setScreenSize(int var1, int var2);

   void setState(ADFMraidState var1);

   void setViewableChange(boolean var1);

   void stopTiltSensor();

   void storePicture(String var1);

   void useCustomClose(boolean var1);
}
