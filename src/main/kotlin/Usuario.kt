/**
 * Clase que representa a un usuario de la biblioteca.
 * @property id El identificador único del usuario.
 * @property nombre El nombre del usuario.
 * @property listaLibrosPrestados La lista de libros que el usuario tiene prestados actualmente.
 */
class Usuario(
    private val id:String,
    private val nombre:String,
    private val listaLibrosPrestados:MutableList<Libro> = mutableListOf()
) {

    fun getId() = id
    fun getNombre() = nombre
    fun getlibrosPrestados() = listaLibrosPrestados

    override fun toString(): String {
        return "id=$id, nombre=$nombre"
    }

}
