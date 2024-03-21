interface IGestorBiblioteca {
    val catalogo: IGestorCatalogo
    val registros: IGestorPrestamos
    val consola: IGestorConsola
    val usuarios: IGestorUsuarios

    fun agregarElementoCatalogo(elemento:ElementoBiblioteca)

    fun eliminarelementoCatalogo(id:String)

    fun registrarPrestamo(idLElemento:String,idUsuario:String)

    fun devolverElemento(idLElemento:String, idUsuario:String)

    fun consultarDisponibilidad(id:String)

    fun retornarPorEstado(estado: Estado):List<ElementoBiblioteca>

    fun agregarUsuario(usuario: Usuario)

    fun eliminarUsuario(id: String)

    fun historialDeUnElemento(id:String):List<Prestamo>

    fun historialDeUnUsuario(id:String):List<Prestamo>
}