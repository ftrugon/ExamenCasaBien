/**
 * Clase base para gestionar una lista de elementos de tipo T que extienden de ElementoBiblioteca.
 *
 * @param T El tipo de elementos que gestionará el gestor.
 * @property elementos La lista mutable de elementos.
 */
open class GestorElementos<T : ElementoBiblioteca> {

    private val elementos = mutableListOf<T>()

    /**
     * Agrega un elemento a la lista de elementos gestionados.
     *
     * @param elemento El elemento a agregar.
     */
    open fun agregar(elemento: T) {
        elementos.add(elemento)
    }

    /**
     * Elimina un elemento de la lista de elementos gestionados por su identificador.
     *
     * @param idElemeto El identificador del elemento a eliminar.
     */
    open fun eliminar(idElemeto: String) {
        val elemento = elementos.find { it.getId() == idElemeto }
        if (elemento != null) {
            elementos.remove(elemento)
        }
    }

    /**
     * Elimina un elemento de la lista de elementos gestionados.
     *
     * @param elemento El elemento a eliminar.
     */
    open fun eliminar(elemento: ElementoBiblioteca) {
        val elementoEncontrado = elementos.find { it == elemento }
        if (elementoEncontrado != null) {
            elementos.remove(elementoEncontrado)
        }
    }

    /**
     * Devuelve la lista de elementos gestionados.
     *
     * @return La lista de elementos gestionados.
     */
    open fun elementosGestionados() = elementos

    /**
     * Busca un elemento por su identificador en la lista de elementos gestionados.
     *
     * @param idElemeto El identificador del elemento a buscar.
     * @return El elemento encontrado o null si no se encuentra.
     */
    open fun buscar(idElemeto: String): ElementoBiblioteca? {
        return elementos.find { it.getId() == idElemeto }
    }

    /**
     * Filtra una lista de elementos por un criterio dado.
     *
     * @param elementos La lista de elementos a filtrar.
     * @param criterio El criterio de filtrado.
     * @return La lista filtrada de elementos.
     */
    open fun filtrarPorCriterio(elementos: List<T>, criterio: (elemento: T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }

    /**
     * Filtra la lista de elementos gestionados por un estado dado.
     *
     * @param estado El estado por el cual filtrar los elementos.
     * @return La lista filtrada de elementos.
     */
    open fun buscarPorEstado(estado: Estado): List<T> {
        return elementos.filter { it.getEstado() == estado }
    }
}