interface IGestorConsola {
    fun mostrarMensaje(mensaje:String)
    fun <T>mostrarLista(list: List<T>)
    fun elementoNoEncontrado()
    fun usuarioNoEncontrado()
    fun elementoEstabaEstado(estado: Estado)
    fun elementoEstaEstado(estado: Estado)
    fun elementoNoPrestadoUsuario()
    fun elementoNoPrestable()
}