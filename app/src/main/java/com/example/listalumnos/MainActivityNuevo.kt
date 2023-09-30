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

        binding.btnGuardar.setOnClickListener {
            val txtNom = binding.txtNombre.text.toString()
            val txtCue = binding.txtCuenta.text.toString()
            val txtCorr = binding.txtCorreo.text.toString()
            val txtImg = binding.txtImage.text.toString()

            val intento2 = Intent(this, MainActivity::class.java)

            val mensaje = intent.getStringExtra("mensaje")
            if (mensaje == "edit") {
                val position = intent.getIntExtra("position", -1)
                if (position != -1) {
                    AlumnoManager.alumnos[position] = Alumno(txtNom, txtCue, txtCorr, txtImg)
                    intento2.putExtra("mensaje", "edited")
                    intento2.putExtra("position", position)
                } else {
                    intento2.putExtra("mensaje", "nuevo")
                }
            } else {
                intento2.putExtra("mensaje", "nuevo")
            }

            intento2.putExtra("nombre", txtNom)
            intento2.putExtra("cuenta", txtCue)
            intento2.putExtra("correo", txtCorr)
            intento2.putExtra("image", txtImg)
            startActivity(intento2)
        }
    }
}
