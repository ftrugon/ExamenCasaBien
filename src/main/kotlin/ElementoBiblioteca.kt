/**
 * Clase abstracta que representa un elemento de la biblioteca, como un libro, DVD, etc.
 *
 * @param id El identificador único del elemento.
 * @param titulo El título del elemento.
 * @param estado El estado del elemento, por defecto es Estado.DISPONIBLE.
 * @constructor Crea un objeto ElementoBiblioteca con el identificador, título y estado dados.
 */
abstract class ElementoBiblioteca(
    private val id: String,
    private val titulo: String,
    private var estado: Estado = Estado.DISPONIBLE
) {
    init {
        require(id.isNotEmpty()) { "La id no puede estar vacía" }
        require(titulo.isNotEmpty()) { "El título no puede estar vacío" }
    }

    /**
     * Obtiene el identificador único del elemento.
     *
     * @return El identificador único del elemento.
     */
    fun getId() = id

    /**
     * Obtiene el título del elemento.
     *
     * @return El título del elemento.
     */
    fun getTitulo() = titulo

    /**
     * Obtiene el estado del elemento.
     *
     * @return El estado del elemento.
     */
    fun getEstado() = estado

    /**
     * Establece el estado del elemento.
     *
     * @param estado El nuevo estado del elemento.
     */
    fun setEstado(estado: Estado) {
        this.estado = estado
    }

    override fun toString(): String {
        return "id=$id, titulo=$titulo, estado=$estado"
    }
}

/**
 * Interfaz que define el comportamiento de un elemento de la biblioteca que puede ser prestado y devuelto.
 */
interface Prestable {
    /**
     * Método para prestar el elemento.
     */
    fun prestar()

    /**
     * Método para devolver el elemento.
     */
    fun devolver()
}