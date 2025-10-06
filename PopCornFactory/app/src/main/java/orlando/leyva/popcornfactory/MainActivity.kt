package orlando.leyva.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PeliculaAdapter
    private val peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        val gridview = findViewById<GridView>(R.id.gridView)
        gridview.adapter = adapter
    }

    private fun cargarPeliculas() {
        peliculas.add(Pelicula("Bones", R.drawable.bones, R.drawable.bonesheader, "Dr. Temperance Brennan is a brilliant, but lonely,"))
        peliculas.add(Pelicula("Dr. House", R.drawable.drhouse, R.drawable.drwhoheader, "The series follows the life of anti-social, pai"))
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city"))
        peliculas.add(Pelicula("Dr. Who", R.drawable.drwho, R.drawable.drwhoheader, "Traveling across time and space, the immortal time"))
        peliculas.add(Pelicula("Friends", R.drawable.friends, R.drawable.friendsheader, "Rachel Green, Ross Geller, Monica Geller, Joey"))
        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute"))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propo"))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of to"))
        peliculas.add(Pelicula("Smallville", R.drawable.smallville, R.drawable.smallvilleheader, "The numerous miraculous rescues by th"))
    }
}

class PeliculaAdapter(
    private val context: Context,
    private val peliculas: ArrayList<Pelicula>
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val pelicula = peliculas[position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = convertView ?: inflater.inflate(R.layout.pelicula, parent, false)

        val ivPelicula = vista.findViewById<ImageView>(R.id.iv_pelicula)
        val tvNombre = vista.findViewById<TextView>(R.id.tv_nombre_pelicula)

        ivPelicula.setImageResource(pelicula.image)
        tvNombre.text = pelicula.titulo

        ivPelicula.setOnClickListener {
            val intent = Intent(context, DetallePelicula::class.java).apply {
                putExtra("titulo", pelicula.titulo)
                putExtra("image", pelicula.image)
                putExtra("header", pelicula.header)
                putExtra("sinopsis", pelicula.sinopsis)
            }
            context.startActivity(intent)
        }

        return vista
    }

    override fun getItem(position: Int): Any = peliculas[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = peliculas.size
}