class GestorCatalogo {
    private val catalogo = mutableListOf<Libro>()

    fun agregar(libro: Libro){
        catalogo.add(libro)
    }

    fun eliminar(libro: Libro){
        catalogo.remove(libro)
    }

    fun buscar(id:String):Libro?{
        return catalogo.find { it.id == id }
    }

    fun buscarPorEstado(estado: Estado): List<Libro> {
        return catalogo.filter { it.estado == estado }
    }

}