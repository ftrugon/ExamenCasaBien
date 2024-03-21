/**
 * Interfaz que define la funcionalidad para interactuar con la consola de la aplicación.
 */
interface IGestorConsola {

    /**
     * Muestra un mensaje en la consola.
     *
     * @param mensaje El mensaje a mostrar.
     */
    fun mostrarMensaje(mensaje: String)

    /**
     * Muestra una lista de elementos en la consola.
     *
     * @param list La lista de elementos a mostrar.
     */
    fun <T> mostrarLista(list: List<T>)

    /**
     * Muestra un mensaje indicando que no se ha encontrado un elemento.
     */
    fun elementoNoEncontrado()

    /**
     * Muestra un mensaje indicando que no se ha encontrado un usuario.
     */
    fun usuarioNoEncontrado()

    /**
     * Muestra un mensaje indicando el estado anterior de un elemento.
     *
     * @param estado El estado anterior del elemento.
     */
    fun elementoEstabaEstado(estado: Estado)

    /**
     * Muestra un mensaje indicando el estado actual de un elemento.
     *
     * @param estado El estado actual del elemento.
     */
    fun elementoEstaEstado(estado: Estado)

    /**
     * Muestra un mensaje indicando que un elemento no está prestado al usuario.
     */
    fun elementoNoPrestadoUsuario()

    /**
     * Muestra un mensaje indicando que un elemento no es prestable.
     */
    fun elementoNoPrestable()
}