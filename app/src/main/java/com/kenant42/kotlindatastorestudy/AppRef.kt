package com.kenant42.kotlindatastorestudy

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

class AppRef(var context: Context) {
    val Context.ds:DataStore<Preferences> by preferencesDataStore("infos")

    companion object{
        val NAME_KEY = stringPreferencesKey("name")
    }

    suspend fun saveName(ad:String){
        context.ds.edit {
            it[NAME_KEY] = ad
        }
    }

    suspend fun readName():String{
        val data = context.ds.data.first()
        return data[NAME_KEY]?:"NA"
    }

    suspend fun removeName(){
        context.ds.edit {
            it.remove(NAME_KEY)
        }
    }

}