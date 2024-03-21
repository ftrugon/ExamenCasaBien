/**
 * Clase que representa un libro en la biblioteca.
 *
 * @param id El identificador único del libro.
 * @param titulo El título del libro.
 * @param autor El autor del libro.
 * @param anioPublicacion El año de publicación del libro.
 * @param tematica La temática del libro.
 */
class Libro(
    id: String,
    titulo: String,
    private val autor: String,
    private val anioPublicacion: String,
    private val tematica: String
) : ElementoBiblioteca(id, titulo), Prestable {

    /**
     * Devuelve el autor del libro.
     */
    fun getAutor() = autor

    /**
     * Devuelve el año de publicación del libro.
     */
    fun getAnioPublicacion() = anioPublicacion

    /**
     * Devuelve la temática del libro.
     */
    fun getTematica() = tematica

    /**
     * Marca el libro como prestado.
     */
    override fun prestar() {
        setEstado(Estado.PRESTADO)
    }

    /**
     * Marca el libro como disponible.
     */
    override fun devolver() {
        setEstado(Estado.DISPONIBLE)
    }

    /**
     * Representación en forma de cadena del libro.
     */
    override fun toString(): String {
        return "Libro " + super.toString()
    }
}