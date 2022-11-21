package com.example.chi_95_sqlitecoroutinesretrofit

data class Animal(
    val name: String,
    val latin_name: String,
    val animal_type: String,
    val active_time: String,
    val length_min: Float,
    val length_max: Float,
    val weight_min: Float,
    val weight_max: Float,
    val lifespan: Int,
    val habitat: String,
    val diet: String,
    val geo_range: String,
    val image_link: String,
    val id: Int
){
    companion object{
        const val TABLE = "animals"

        const val ID = "_id"
        const val NAME = "name"
        const val LATIN_NAME = "latin_name"
        const val ANIMAL_TYPE = "animal_type"
        const val ACTIVE_TIME = "active_time"
        const val LENGTH_MIN = "length_min"
        const val LENGTH_MAX = "length_max"
        const val WEIGHT_MIN = "weight_min"
        const val WEIGHT_MAX = "weight_max"
        const val LIFESPAN = "lifespan"
        const val HABITAT = "habitat"
        const val DIET = "diet"
        const val GEO_RANGE = "geo_range"
        const val IMAGE_LINK = "image_link"
    }
}