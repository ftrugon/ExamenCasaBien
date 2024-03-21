/**
 * Interfaz que define la funcionalidad de gestión del catálogo de la biblioteca.
 *
 * AUNQUE EN EL EJERCICIO5 NO SE USA
 */
interface IGestorCatalogo {

    /**
     * La lista mutable que representa el catálogo de elementos de la biblioteca.
     */
    val catalogo: MutableList<ElementoBiblioteca>

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     *
     * @param elemento El elemento bibliotecario a agregar.
     */
    fun agregar(elemento: ElementoBiblioteca)

    /**
     * Elimina un elemento del catálogo de la biblioteca.
     *
     * @param elemento El elemento bibliotecario a eliminar.
     */
    fun eliminar(elemento: ElementoBiblioteca)

    /**
     * Busca un elemento en el catálogo por su identificador.
     *
     * @param id El identificador del elemento a buscar.
     * @return El elemento bibliotecario encontrado, o null si no se encuentra.
     */
    fun buscar(id: String): ElementoBiblioteca?

    /**
     * Busca elementos en el catálogo que tengan el estado especificado.
     *
     * @param estado El estado de los elementos a buscar.
     * @return Una lista de elementos bibliotecarios con el estado especificado.
     */
    fun buscarPorEstado(estado: Estado): List<ElementoBiblioteca>
}