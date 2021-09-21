package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.noqoush.adfalcon.android.sdk.response.h;
import com.noqoush.adfalcon.android.sdk.urlactions.g;

class b$a implements OnClickListener {
   // $FF: synthetic field
   final View a;
   // $FF: synthetic field
   final h b;
   // $FF: synthetic field
   final b c;

   b$a(b var1, View var2, h var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void onClick(View var1) {
      (new com.noqoush.adfalcon.android.sdk.handler.c()).a(this.a.getContext(), this.b.b().b(), false, true, (g)null, (WebView)null);
   }
}
