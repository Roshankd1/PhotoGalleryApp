package com.example.roshank.photogalleryapp.core

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import java.lang.annotation.Inherited

class PhotoGalleryApplication : DaggerApplication() {

    val ACCESS_TOKEN: String = ""
    val CLIENT_ID: String = "3acd7f92ff3e4089be36b8f6be5c2855"
    val REDIRECT_URL:String = "https://github.com/Roshankd1"

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

    }
}