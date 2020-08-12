package com.example.admin.virtualdoctor;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

 class Singleton {
    private static volatile Singleton instance;

    private ArrayList<String> frameList;

    private Singleton() {
        this.frameList = new ArrayList<String>();

    }
     public static Singleton getInstance() {
         if (instance == null) {
             {
                 if (instance == null)
                     instance = new Singleton();
             }
         }
         return instance;
     }

     public static void setInstance(Singleton instance) {
         Singleton.instance = instance;
     }

     public ArrayList<String> getFrameList() {
         return this.frameList;
     }

     public void setFrameList() {
         this.frameList = frameList;
     }
 }
