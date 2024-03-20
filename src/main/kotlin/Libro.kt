/**
 *  solo contendrá datos, sin ninguna lógica asociada.
 */
data class Libro(
    val id:String,
    val titulo:String,
    val autor:String,
    val anioPublicacion:String,
    val tematica:String,
    var estado:Estado = Estado.DISPONIBLE
) {
    init {
        require(id.isNotEmpty()) {"La id no puede estar vacia"}
        require(titulo.isNotEmpty()) {"El titulo no puede estar vacio"}
        require(autor.isNotEmpty()) {"El autor no puede estar vacio"}
        require(anioPublicacion.isNotEmpty()) {"El Año de publicacion no puede estar vacio"}
        require(tematica.isNotEmpty()) {"La tematica no puede estar vacia"}
    }


}


enum class Estado {
    DISPONIBLE,
    PRESTADO
}