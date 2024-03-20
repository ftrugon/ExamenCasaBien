/**
 * Representa un libro en la biblioteca.
 *
 * @property id El identificador único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPublicacion El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado actual del libro (disponible, prestado, etc.).
 */
class Libro(
    private val id:String,
    private val titulo:String,
    private val autor:String,
    private val anioPublicacion:String,
    private val tematica:String,
    private var estado:Estado = Estado.DISPONIBLE
) {
    init {
        require(id.isNotEmpty()) {"La id no puede estar vacia"}
        require(titulo.isNotEmpty()) {"El titulo no puede estar vacio"}
        require(autor.isNotEmpty()) {"El autor no puede estar vacio"}
        require(anioPublicacion.isNotEmpty()) {"El Año de publicacion no puede estar vacio"}
        require(tematica.isNotEmpty()) {"La tematica no puede estar vacia"}
    }

    fun getId() = id
    fun getTitulo() = titulo
    fun getAutor() = autor
    fun getAnioPublicacion() = anioPublicacion
    fun getTematica() = tematica
    fun getEstado() = estado
    fun setEstado(estado: Estado){
        this.estado = estado
    }

    override fun toString(): String {
        return "id=$id, titulo=$titulo, estado=$estado"
    }

}


