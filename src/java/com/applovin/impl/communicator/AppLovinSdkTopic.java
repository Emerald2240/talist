package com.applovin.impl.communicator;

import java.util.ArrayList;
import java.util.List;

public class AppLovinSdkTopic {
   public static final List ALL_TOPICS = new ArrayList();
   public static final String HTTP_REQUEST = "send_http_request";
   public static final String RECEIVE_HTTP_RESPONSE = "receive_http_response";
   public static final String TEST_MODE_NETWORK = "test_mode_network";

   static {
      ALL_TOPICS.add("send_http_request");
   }

   private AppLovinSdkTopic() {
   }
}
