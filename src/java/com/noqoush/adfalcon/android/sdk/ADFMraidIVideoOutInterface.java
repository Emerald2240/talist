package com.noqoush.adfalcon.android.sdk;

import com.noqoush.adfalcon.android.sdk.constant.ADFIVideoTracking;

interface ADFMraidIVideoOutInterface {
   void firePlayIVideoError(String var1) throws Exception;

   void setIVideoDuration(long var1) throws Exception;

   void setIVideoTimeUpdate(long var1) throws Exception;

   void setIVideoTracking(ADFIVideoTracking var1) throws Exception;
}
