package com.noqoush.adfalcon.android.sdk;

class n$a implements Runnable {
   // $FF: synthetic field
   final n a;

   n$a(n var1) {
      this.a = var1;
   }

   public void run() {
      try {
         n.a(this.a).fireStateChangedEvent();
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->setState->");
         var2.append(var3.toString());
         k.b(var2.toString());
      }
   }
}
