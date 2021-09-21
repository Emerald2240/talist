package com.iab.omid.library.adfalcon.walking;

final class TreeWalker$3 implements Runnable {
   public void run() {
      if (TreeWalker.e() != null) {
         TreeWalker.e().post(TreeWalker.f());
         TreeWalker.e().postDelayed(TreeWalker.g(), 200L);
      }

   }
}
