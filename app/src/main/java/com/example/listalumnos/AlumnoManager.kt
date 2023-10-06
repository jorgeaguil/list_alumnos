package com.example.listalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Objeto que gestiona la lista de alumnos
object AlumnoManager {
    // Lista de alumnos almacenada como un ArrayList
    val alumnos: ArrayList<Alumno> = ArrayList()

    // Inicialización: Se agregan algunos estudiantes a la lista cuando se crea AlumnoManager
    init {
        alumnos.add(Alumno("José Nabor", "20102345", "jmorfin@ucol.mx", "https://imagenpng.com/wp-content/uploads/2017/02/pokemon-hulu-pikach.jpg"))
        alumnos.add(Alumno("Luis Antonio", "20112345", "jmorfin@ucol.mx", "https://i.pinimg.com/236x/e0/b8/3e/e0b83e84afe193922892917ddea28109.jpg"))
        alumnos.add(Alumno("Juan Pedro", "20122345", "jmorfin@ucol.mx", "https://i.pinimg.com/736x/9f/6e/fa/9f6efa277ddcc1e8cfd059f2c560ee53--clipart-gratis-vector-clipart.jpg"))
    }
}

/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Objeto que gestiona la lista de alumnos
object AlumnoManager {
    // Lista de alumnos almacenada como un ArrayList
    val alumnos: ArrayList<Alumno> = ArrayList()

    // Inicialización: Se agregan algunos estudiantes a la lista cuando se crea AlumnoManager
    init {
        alumnos.add(Alumno("José Nabor", "20102345", "jmorfin@ucol.mx", "https://imagenpng.com/wp-content/uploads/2017/02/pokemon-hulu-pikach.jpg"))
        alumnos.add(Alumno("Luis Antonio", "20112345", "jmorfin@ucol.mx", "https://i.pinimg.com/236x/e0/b8/3e/e0b83e84afe193922892917ddea28109.jpg"))
        alumnos.add(Alumno("Juan Pedro", "20122345", "jmorfin@ucol.mx", "https://i.pinimg.com/736x/9f/6e/fa/9f6efa277ddcc1e8cfd059f2c560ee53--clipart-gratis-vector-clipart.jpg"))
    }
}

 */