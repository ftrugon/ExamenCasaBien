/**
 *  solo contendrá datos, sin ninguna lógica asociada.
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

}


enum class Estado {
    DISPONIBLE,
    PRESTADO
}