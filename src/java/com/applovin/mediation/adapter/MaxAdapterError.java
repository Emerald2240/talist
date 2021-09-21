package com.applovin.mediation.adapter;

import com.applovin.impl.mediation.e;
import com.applovin.impl.sdk.utils.n;

public class MaxAdapterError extends e {
   public static final MaxAdapterError AD_EXPIRED = new MaxAdapterError(-5213);
   public static final MaxAdapterError AD_FREQUENCY_CAPPED = new MaxAdapterError(-5214);
   public static final MaxAdapterError AD_NOT_READY = new MaxAdapterError(-5205);
   public static final MaxAdapterError BAD_REQUEST = new MaxAdapterError(-5203);
   public static final int ERROR_CODE_AD_EXPIRED = -5213;
   public static final int ERROR_CODE_AD_FREQUENCY_CAPPED = -5214;
   public static final int ERROR_CODE_AD_NOT_READY = -5205;
   public static final int ERROR_CODE_BAD_REQUEST = -5203;
   public static final int ERROR_CODE_INTERNAL_ERROR = -5209;
   public static final int ERROR_CODE_INVALID_CONFIGURATION = -5202;
   public static final int ERROR_CODE_INVALID_LOAD_STATE = -5201;
   public static final int ERROR_CODE_NOT_INITIALIZED = -5204;
   public static final int ERROR_CODE_NO_CONNECTION = -5207;
   public static final int ERROR_CODE_NO_FILL = 204;
   public static final int ERROR_CODE_REWARD_ERROR = -5302;
   public static final int ERROR_CODE_SERVER_ERROR = -5208;
   public static final int ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED = -5211;
   public static final int ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT = -5210;
   public static final int ERROR_CODE_TIMEOUT = -5206;
   public static final int ERROR_CODE_UNSPECIFIED = -5200;
   public static final int ERROR_CODE_WEBVIEW_ERROR = -5212;
   public static final MaxAdapterError INTERNAL_ERROR = new MaxAdapterError(-5209);
   public static final MaxAdapterError INVALID_CONFIGURATION = new MaxAdapterError(-5202);
   public static final MaxAdapterError INVALID_LOAD_STATE = new MaxAdapterError(-5201);
   public static final MaxAdapterError NOT_INITIALIZED = new MaxAdapterError(-5204);
   public static final MaxAdapterError NO_CONNECTION = new MaxAdapterError(-5207);
   public static final MaxAdapterError NO_FILL = new MaxAdapterError(204);
   public static final MaxAdapterError REWARD_ERROR = new MaxAdapterError(-5302);
   public static final MaxAdapterError SERVER_ERROR = new MaxAdapterError(-5208);
   public static final MaxAdapterError SIGNAL_COLLECTION_NOT_SUPPORTED = new MaxAdapterError(-5211);
   public static final MaxAdapterError SIGNAL_COLLECTION_TIMEOUT = new MaxAdapterError(-5210);
   public static final MaxAdapterError TIMEOUT = new MaxAdapterError(-5206);
   public static final MaxAdapterError UNSPECIFIED = new MaxAdapterError(-5200);
   public static final MaxAdapterError WEBVIEW_ERROR = new MaxAdapterError(-5212);
   private final int thirdPartySdkErrorCode;
   private final String thirdPartySdkErrorMessage;

   public MaxAdapterError(int var1) {
      this(var1, "", 0, "");
   }

   public MaxAdapterError(int var1, int var2) {
      this(var1, "", var2, "");
   }

   public MaxAdapterError(int var1, String var2) {
      this(var1, var2, 0, "");
   }

   public MaxAdapterError(int var1, String var2, int var3, String var4) {
      super(var1, var2);
      this.thirdPartySdkErrorCode = var3;
      this.thirdPartySdkErrorMessage = n.c(var4);
   }

   public int getThirdPartySdkErrorCode() {
      return this.thirdPartySdkErrorCode;
   }

   public String getThirdPartySdkErrorMessage() {
      return this.thirdPartySdkErrorMessage;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxAdapterError{errorCode=");
      var1.append(this.getErrorCode());
      var1.append(", errorMessage='");
      var1.append(this.getErrorMessage());
      var1.append('\'');
      var1.append(", thirdPartySdkErrorCode=");
      var1.append(this.thirdPartySdkErrorCode);
      var1.append(", thirdPartySdkErrorMessage='");
      var1.append(this.thirdPartySdkErrorMessage);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
