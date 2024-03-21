interface IGestorUsuarios {
    val usuarios:MutableList<Usuario>

    fun agregar(usuario: Usuario)
    fun eliminar(usuario: Usuario)
    fun buscar(id:String):Usuario?
    fun agregarPrestamo(elemento:ElementoBiblioteca, usuario: Usuario)
    fun quitarPrestamo(elemento:ElementoBiblioteca,usuario: Usuario)
    fun consultarPrestamos(usuario: Usuario):MutableList<ElementoBiblioteca>
}