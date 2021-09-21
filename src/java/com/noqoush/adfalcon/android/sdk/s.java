package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Calendar;

class s implements SensorEventListener {
   private static final int j = 800;
   private SensorManager a;
   private Context b;
   private t c;
   private boolean d = false;
   private float e = -100.0F;
   private float f = -100.0F;
   private float g = -100.0F;
   private long h = 0L;
   private long i = 0L;

   public s(Context var1, t var2) throws Exception {
      if (var1 != null) {
         if (var2 != null) {
            this.b = var1;
            this.c = var2;
            this.a = (SensorManager)var1.getSystemService("sensor");
         } else {
            throw new Exception("Missing sensorListener");
         }
      } else {
         throw new Exception("Missing context");
      }
   }

   protected boolean a() throws Exception {
      if (!this.d) {
         SensorManager var1 = this.a;
         this.d = var1.registerListener(this, var1.getDefaultSensor(1), 3);
      }

      return this.d;
   }

   protected void b() throws Exception {
      if (this.d) {
         this.a.unregisterListener(this);
      }

   }

   public void onAccuracyChanged(Sensor var1, int var2) {
   }

   public void onSensorChanged(SensorEvent var1) {
      try {
         if (var1.sensor.getType() == 1) {
            long var6 = Calendar.getInstance().getTimeInMillis();
            float[] var8 = var1.values;
            float var9 = var8[0];
            float var10 = var8[1];
            float var11 = var8[2];
            if ((double)Math.abs(this.e - var9) > 0.1D || (double)Math.abs(this.f - var10) > 0.1D || (double)Math.abs(this.g - var11) > 0.1D) {
               this.c.a(var9, var10, var11);
               float var12 = (float)(var6 - this.h);
               if (10000.0F * (Math.abs(var11 + var9 + var10 - this.e - this.f - this.g) / var12) > 800.0F && var6 - this.i > 1000L) {
                  this.c.a();
                  this.i = var6;
               }

               this.h = var6;
               this.e = var9;
               this.f = var10;
               this.g = var11;
               return;
            }
         }
      } catch (Exception var13) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFSensor->onSensorChanged->");
         var3.append(var13.toString());
         k.b(var3.toString());
      }

   }
}
