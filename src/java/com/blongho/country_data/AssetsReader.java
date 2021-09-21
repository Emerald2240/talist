package com.blongho.country_data;

class AssetsReader {
    static final String TAG = "AssetsReader";

    private AssetsReader() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A:{SYNTHETIC, Splitter:B:22:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059 A:{SYNTHETIC, Splitter:B:29:0x0059} */
    static java.lang.String readFromAssets(android.content.Context r4, int r5) {
        /*
        r0 = 0;
        r4 = r4.getResources();	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r4 = r4.openRawResource(r5);	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r5 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r2 = "UTF-8";
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r1.<init>(r4, r2);	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r5.<init>(r1);	 Catch:{ IOException -> 0x0040, all -> 0x003d }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003b }
        r4.<init>();	 Catch:{ IOException -> 0x003b }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new char[r1];	 Catch:{ IOException -> 0x003b }
    L_0x0022:
        r2 = r5.read(r1);	 Catch:{ IOException -> 0x003b }
        r3 = -1;
        if (r2 == r3) goto L_0x002e;
    L_0x0029:
        r3 = 0;
        r4.append(r1, r3, r2);	 Catch:{ IOException -> 0x003b }
        goto L_0x0022;
    L_0x002e:
        r4 = r4.toString();	 Catch:{ IOException -> 0x003b }
        r5.close();	 Catch:{ IOException -> 0x0036 }
        goto L_0x003a;
    L_0x0036:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x003a:
        return r4;
    L_0x003b:
        r4 = move-exception;
        goto L_0x0042;
    L_0x003d:
        r4 = move-exception;
        r5 = r0;
        goto L_0x0057;
    L_0x0040:
        r4 = move-exception;
        r5 = r0;
    L_0x0042:
        r1 = "AssetsReader";
        r4 = r4.getMessage();	 Catch:{ all -> 0x0056 }
        android.util.Log.e(r1, r4);	 Catch:{ all -> 0x0056 }
        if (r5 == 0) goto L_0x0055;
    L_0x004d:
        r5.close();	 Catch:{ IOException -> 0x0051 }
        goto L_0x0055;
    L_0x0051:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0055:
        return r0;
    L_0x0056:
        r4 = move-exception;
    L_0x0057:
        if (r5 == 0) goto L_0x0061;
    L_0x0059:
        r5.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x0061;
    L_0x005d:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0061:
        goto L_0x0063;
    L_0x0062:
        throw r4;
    L_0x0063:
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blongho.country_data.AssetsReader.readFromAssets(android.content.Context, int):java.lang.String");
    }
}
