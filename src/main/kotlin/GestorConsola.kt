class GestorConsola {

    /**
     * Muestra un mensaje que le indiquiemos
     * @param mensaje el mensaje
     */
    fun mostrarMensaje(mensaje:String){
        println(mensaje)
    }

    /**
     * Muestra una lista de cualquier cosa que le pasemos
     */
    fun <T>mostrarLista(list: List<T>){
        list.forEach { println(it) }
    }


    // Mensajes del gestor de biblioteca
    fun libroNoEncontrado() = mostrarMensaje("Este libro no se ha encontrado en el catalogo")

    fun usuarioNoEncontrado() = mostrarMensaje("No se ha encontrado este usuario")

    fun libroEstabaEstado(estado: Estado) = mostrarMensaje("Este libro ya estaba ${estado.toString().lowercase()}")

    fun libroEstaEstado(estado: Estado) = mostrarMensaje("Este libro esta ${estado.toString().lowercase()}")

    fun libroNoPrestadoUsuario() = mostrarMensaje("Este libro no se encuentra en los prestamos del usuario")

}