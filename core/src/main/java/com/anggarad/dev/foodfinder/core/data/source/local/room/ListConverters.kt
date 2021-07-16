package com.anggarad.dev.foodfinder.core.data.source.local.room


import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromList(input: List<String>?): String? {

        return gson.toJson(input)
    }

    @TypeConverter
    fun fromString(input: String?): List<String>? {
        val listType = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(input, listType)
    }

}