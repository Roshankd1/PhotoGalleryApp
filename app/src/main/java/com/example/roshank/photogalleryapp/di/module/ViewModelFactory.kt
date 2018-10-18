package com.example.roshank.photogalleryapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory : ViewModelProvider.Factory {

    var creators: Map<Class<out ViewModel>, Provider<ViewModel>>? = null

    @Inject
    fun ViewModelFactory(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
        this.creators = creators
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator: Provider<ViewModel>? = creators!!.get(modelClass)

    }

}