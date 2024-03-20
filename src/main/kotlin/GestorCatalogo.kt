class GestorCatalogo {
    private val catalogo = mutableListOf<Libro>()

    fun agregar(libro: Libro){
        catalogo.add(libro)
    }

    fun eliminar(libro: Libro){
        catalogo.remove(libro)
    }

    fun buscar(id:String):Libro?{
        return catalogo.find { it.getId() == id }
    }

    fun buscarPorEstado(estado: Estado): List<Libro> {
        return catalogo.filter { it.getEstado() == estado }
    }

    fun cambiarEstadoLibro(libro: Libro) = libro.setEstado(if (libro.getEstado() == Estado.DISPONIBLE) Estado.PRESTADO else Estado.DISPONIBLE)

}