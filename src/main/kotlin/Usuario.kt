/**
 * Clase que representa un usuario de la biblioteca.
 *
 * @property id El identificador único del usuario.
 * @property nombre El nombre del usuario.
 * @property listaElementosPrestados La lista de elementos bibliotecarios prestados al usuario.
 */
class Usuario(
    private val id: String,
    private val nombre: String,
    private val listaElementosPrestados: MutableList<ElementoBiblioteca> = mutableListOf()
) {

    /**
     * Retorna el identificador único del usuario.
     */
    fun getId() = id

    /**
     * Retorna el nombre del usuario.
     */
    fun getNombre() = nombre

    /**
     * Retorna la lista de elementos bibliotecarios prestados al usuario.
     */
    fun getElementosPrestados() = listaElementosPrestados

    /**
     * Retorna una representación en forma de cadena de texto del usuario.
     */
    override fun toString(): String {
        return "id=$id, nombre=$nombre"
    }
}
