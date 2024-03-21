/**
 * Clase que representa un DVD en la biblioteca.
 *
 * @param id El identificador único del DVD.
 * @param titulo El título del DVD.
 * @constructor Crea un objeto DVD con el identificador y título dados.
 */
class DVD(
    id: String,
    titulo: String
) : ElementoBiblioteca(id, titulo), Prestable {

    /**
     * Marca el DVD como prestado cambiando su estado a PRESTADO.
     */
    override fun prestar() {
        setEstado(Estado.PRESTADO)
    }

    /**
     * Marca el DVD como disponible cambiando su estado a DISPONIBLE.
     */
    override fun devolver() {
        setEstado(Estado.DISPONIBLE)
    }

    /**
     * Devuelve una representación en cadena del DVD.
     *
     * @return La representación en cadena del DVD.
     */
    override fun toString(): String {
        return "DVD " + super.toString()
    }
}