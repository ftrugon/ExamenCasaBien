/**
 * Clase que implementa la interfaz IGestorConsola para gestionar mensajes de consola.
 */
class GestorConsola : IGestorConsola {

    /**
     * Muestra un mensaje en la consola.
     *
     * @param mensaje El mensaje a mostrar.
     */
    override fun mostrarMensaje(mensaje: String) {
        println(mensaje)
    }

    /**
     * Muestra una lista de elementos en la consola.
     *
     * @param list La lista de elementos a mostrar.
     */
    override fun <T> mostrarLista(list: List<T>) {
        list.forEach { println(it) }
    }

    // Mensajes del gestor de biblioteca
    override fun elementoNoEncontrado() = mostrarMensaje("Este elemento no se ha encontrado en el catalogo")

    override fun usuarioNoEncontrado() = mostrarMensaje("No se ha encontrado este usuario")

    override fun elementoEstabaEstado(estado: Estado) = mostrarMensaje("Este elemento ya estaba ${estado.toString().lowercase()}")

    override fun elementoEstaEstado(estado: Estado) = mostrarMensaje("Este elemento esta ${estado.toString().lowercase()}")

    override fun elementoNoPrestadoUsuario() = mostrarMensaje("Este elemento no se encuentra en los prestamos del usuario")

    override fun elementoNoPrestable() = mostrarMensaje("El elemento no es prestable")

}