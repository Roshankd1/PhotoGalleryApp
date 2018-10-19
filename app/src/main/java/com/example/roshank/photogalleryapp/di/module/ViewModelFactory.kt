package com.example.roshank.photogalleryapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory : ViewModelProvider.Factory {

    var creators: Map<Class<out ViewModel>, Provider<ViewModel>>? = null

    @Inject
    fun ViewModelFactory(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
        this.creators = creators
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<ViewModel>? = creators!![modelClass]
        if(creator!=null){
            for ((key, value) in creators!!) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if(creator==null){
        throw IllegalArgumentException("Unknown model class$modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}