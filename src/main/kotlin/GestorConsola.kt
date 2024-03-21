class GestorConsola:IGestorConsola {

    override fun mostrarMensaje(mensaje:String){
        println(mensaje)
    }

    override fun <T>mostrarLista(list: List<T>){
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