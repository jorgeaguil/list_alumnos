package com.example.listalumnos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adaptador para el RecyclerView que muestra una lista de estudiantes (Alumnos)
class AlumnoAdapter(private val context: Context, private val listAlumno: List<Alumno>): RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {

    // Interfaz para el listener de clics en elementos
    interface ClickListener {
        fun onItemClick(view: View, position: Int)
    }

    private var clickListener: ClickListener? = null

    // Infla el diseño de un solo elemento en el RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return ViewHolder(view)
    }

    // Vincula datos al ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = listAlumno[position]

        // Carga la imagen usando la biblioteca Glide
        Glide.with(context).load(itemsViewModel.imagen).into(holder.imageView)

        // Establece el nombre del estudiante
        holder.txtNombre.text = itemsViewModel.nombre

        // Establece los detalles de la cuenta del estudiante
        holder.txtCuenta.text = itemsViewModel.cuenta
    }

    // Devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int {
        return listAlumno.size
    }

    // Establece el listener para los clics en los elementos
    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    // ViewHolder para cada elemento en el RecyclerView
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.imgAlumno)
        val txtNombre: TextView = itemView.findViewById(R.id.nombre)
        val txtCuenta: TextView = itemView.findViewById(R.id.cuenta)

        init {
            // Asocia el listener de clics al elemento si está disponible
            if (clickListener != null) {
                itemView.setOnClickListener(this)
            }
        }

        // Maneja el evento de clic en el elemento
        override fun onClick(itemView: View) {
            clickListener?.onItemClick(itemView, adapterPosition)
        }
    }
}
