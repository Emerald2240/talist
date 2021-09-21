package com.heetch.countrypicker;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class CountryPickerDialog$1 implements Comparator {
   // $FF: synthetic field
   final CountryPickerDialog this$0;

   CountryPickerDialog$1(CountryPickerDialog var1) {
      this.this$0 = var1;
   }

   public int compare(Country var1, Country var2) {
      Locale var3 = this.this$0.getContext().getResources().getConfiguration().locale;
      Collator var4 = Collator.getInstance(var3);
      var4.setStrength(0);
      return var4.compare((new Locale(var3.getLanguage(), var1.getIsoCode())).getDisplayCountry(), (new Locale(var3.getLanguage(), var2.getIsoCode())).getDisplayCountry());
   }
}
