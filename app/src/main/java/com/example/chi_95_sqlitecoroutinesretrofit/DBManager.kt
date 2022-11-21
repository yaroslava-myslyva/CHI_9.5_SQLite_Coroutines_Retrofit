package com.example.chi_95_sqlitecoroutinesretrofit

import android.content.ContentValues
import android.content.Context

class DBManager(context: Context) {

    private val dataBaseHelper = DataBaseHelper(context)

    fun insertAnimals(animals: List<Animal>) {
        val db = dataBaseHelper.writableDatabase
        val cv = ContentValues()
        animals.forEach { animal ->
            cv.apply {
                put(Animal.ID, animal.id)
                put(Animal.NAME, animal.name)
                put(Animal.LATIN_NAME, animal.latin_name)
                put(Animal.ANIMAL_TYPE, animal.animal_type)
                put(Animal.ACTIVE_TIME, animal.active_time)
                put(Animal.LENGTH_MIN, animal.length_min)
                put(Animal.LENGTH_MAX, animal.length_max)
                put(Animal.WEIGHT_MIN, animal.weight_min)
                put(Animal.WEIGHT_MAX, animal.weight_max)
                put(Animal.LIFESPAN, animal.lifespan)
                put(Animal.HABITAT, animal.habitat)
                put(Animal.DIET, animal.diet)
                put(Animal.GEO_RANGE, animal.geo_range)
                put(Animal.IMAGE_LINK, animal.image_link)
            }
            db.insert(Animal.TABLE, null, cv)
            cv.clear()
        }
        db.close()
    }

    fun fetchAnimals(): List<Animal> {
        val db = dataBaseHelper.readableDatabase
        val cursor = db.query(Animal.TABLE, null, null, null, null, null, null)

        if (cursor != null && cursor.count > 0) {
            val animals = ArrayList<Animal>(cursor.count)
            cursor.moveToFirst()
            do {
                var index = cursor.getColumnIndex(Animal.ID)
                val id = cursor.getInt(index)

                index = cursor.getColumnIndex(Animal.NAME)
                val name = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.LATIN_NAME)
                val latinName = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.ANIMAL_TYPE)
                val animalType = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.ACTIVE_TIME)
                val activeTime = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.LENGTH_MIN)
                val lengthMin = cursor.getFloat(index)

                index = cursor.getColumnIndex(Animal.LENGTH_MAX)
                val lengthMax = cursor.getFloat(index)

                index = cursor.getColumnIndex(Animal.WEIGHT_MIN)
                val weightMin = cursor.getFloat(index)

                index = cursor.getColumnIndex(Animal.WEIGHT_MAX)
                val weightMax = cursor.getFloat(index)

                index = cursor.getColumnIndex(Animal.LIFESPAN)
                val lifespan = cursor.getInt(index)

                index = cursor.getColumnIndex(Animal.HABITAT)
                val habitat = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.DIET)
                val diet = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.GEO_RANGE)
                val geoRange = cursor.getString(index)

                index = cursor.getColumnIndex(Animal.IMAGE_LINK)
                val imageLink = cursor.getString(index)

                animals.add(
                    Animal(
                        name,
                        latinName,
                        animalType,
                        activeTime,
                        lengthMin,
                        lengthMax,
                        weightMin,
                        weightMax,
                        lifespan,
                        habitat,
                        diet,
                        geoRange,
                        imageLink,
                        id
                    )
                )
            } while (cursor.moveToNext())

            cursor.close()
            db.close()
            return animals
        }
        db.close()
        return emptyList()
    }
}
