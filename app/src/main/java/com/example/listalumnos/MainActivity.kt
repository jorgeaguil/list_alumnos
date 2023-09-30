package com.example.listalumnos

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listalumnos.databinding.ActivityMainBinding
import com.example.listalumnos.AlumnoManager


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlumnoAdapter
    private val data = AlumnoManager.alumnos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        adapter = AlumnoAdapter(this, data)
        binding.recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object: AlumnoAdapter.ClickListener {
            override fun onItemClick(view: View, position: Int) {
                itemOptionsMenu(position)
            }
        })

        binding.faButton.setOnClickListener {
            val intento1 = Intent(this, MainActivityNuevo::class.java)
            startActivity(intento1)
        }

        val parExtra = intent.extras
        val msje = parExtra?.getString("mensaje")
        if (msje == "edited") {
            val position = parExtra?.getInt("position", -1)
            if (position != null && position != -1) {
                adapter.notifyItemChanged(position)
            }
        } else if (msje == "nuevo") {
            val nombre = parExtra?.getString("nombre")
            val cuenta = parExtra?.getString("cuenta")
            val correo = parExtra?.getString("correo")
            val image = parExtra?.getString("image")
            val insertIndex: Int = data.count()
            data.add(insertIndex, Alumno("$nombre", "$cuenta", "$correo", "$image"))
            adapter.notifyItemInserted(insertIndex)
        }
    }

    private fun itemOptionsMenu(position: Int) {
        val viewHolder = binding.recyclerview.findViewHolderForAdapterPosition(position) ?: return
        val popupMenu = PopupMenu(this, viewHolder.itemView.findViewById(R.id.textViewOptions))
        popupMenu.inflate(R.menu.options_menu)
        val intento2 = Intent(this, MainActivityNuevo::class.java)
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId) {
                    R.id.borrar -> {
                        val tmpAlum = data[position]
                        data.remove(tmpAlum)
                        adapter.notifyDataSetChanged()
                        return true
                    }
                    R.id.editar -> {
                        val alumno = data[position]
                        intento2.putExtra("mensaje", "edit")
                        intento2.putExtra("position", position)
                        intento2.putExtra("nombre", "${alumno.nombre}")
                        intento2.putExtra("cuenta", "${alumno.cuenta}")
                        intento2.putExtra("correo", "${alumno.correo}")
                        intento2.putExtra("image", "${alumno.imagen}")
                        startActivity(intento2)
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }
}
