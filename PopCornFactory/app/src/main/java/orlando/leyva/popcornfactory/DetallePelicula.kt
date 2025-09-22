package orlando.leyva.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import orlando.leyva.popcornfactory.databinding.ActivityDetallePeliculaBinding

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val ivPeliculaImagen = findViewById<ImageView>(R.id.iv_pelicula_imagen)
        val tvNombrePelicula = this.findViewById<TextView>(R.id.tv_nombre_pelicula)
        val tvPeliculaDesc = findViewById<TextView>(R.id.tv_pelicula_descripcion)

        val bundle = intent.extras

        bundle?.let {
            val imageResource = it.getInt("header", 0)
            if (imageResource != 0) {
                ivPeliculaImagen.setImageResource(imageResource)
            }

            val nombre = it.getString("nombre")
            if (!nombre.isNullOrEmpty()) {
                tvNombrePelicula.text = nombre
            }

            val sinopsis = it.getString("sinopsis")
            if (!sinopsis.isNullOrEmpty()) {
                tvPeliculaDesc.text = sinopsis
            }


        }
    }
}