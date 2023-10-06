package com.example.listalumnos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listalumnos.databinding.ActivityMainNuevoBinding
import com.example.listalumnos.AlumnoManager

class MainActivityNuevo : AppCompatActivity() {
    private lateinit var binding: ActivityMainNuevoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Acción al hacer clic en el botón "Guardar"
        binding.btnGuardar.setOnClickListener {
            // Obtener los datos ingresados por el usuario
            val txtNom = binding.txtNombre.text.toString()
            val txtCue = binding.txtCuenta.text.toString()
            val txtCorr = binding.txtCorreo.text.toString()
            val txtImg = binding.txtImage.text.toString()

            // Crear una intent para volver a la actividad principal (MainActivity)
            val intento2 = Intent(this, MainActivity::class.java)

            // Obtener el mensaje de la actividad anterior
            val mensaje = intent.getStringExtra("mensaje")
            if (mensaje == "edit") {
                // Si se está editando un estudiante, obtener su posición y actualizarlo
                val position = intent.getIntExtra("position", -1)
                if (position != -1) {
                    AlumnoManager.alumnos[position] = Alumno(txtNom, txtCue, txtCorr, txtImg)
                    intento2.putExtra("mensaje", "edited")
                    intento2.putExtra("position", position)
                } else {
                    intento2.putExtra("mensaje", "nuevo")
                }
            } else {
                // Si es un estudiante nuevo, enviar un mensaje indicando que es un estudiante nuevo
                intento2.putExtra("mensaje", "nuevo")
            }

            // Enviar los datos ingresados a la actividad principal
            intento2.putExtra("nombre", txtNom)
            intento2.putExtra("cuenta", txtCue)
            intento2.putExtra("correo", txtCorr)
            intento2.putExtra("image", txtImg)

            // Iniciar la actividad principal
            startActivity(intento2)
        }
    }
}
