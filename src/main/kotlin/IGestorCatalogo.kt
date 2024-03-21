interface IGestorCatalogo {

    val catalogo: MutableList<ElementoBiblioteca>

    fun agregar(elemento: ElementoBiblioteca)
    fun eliminar(elemento: ElementoBiblioteca)
    fun buscar(id:String):ElementoBiblioteca?
    fun buscarPorEstado(estado: Estado): List<ElementoBiblioteca>

}