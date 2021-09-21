package com.relentless.currncyconverterappusingandroidbookasreference;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationManagerCompat;

public class CurrencyService extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationManagerCompat.from(context).notify(200, new Builder(context, "New Rates").setSmallIcon(R.mipmap.ta_currency_launcher_round_logo).setContentTitle("Auto Update Completed...").setContentText("Click to Open App").setPriority(0).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0)).setAutoCancel(true).build());
    }
}
