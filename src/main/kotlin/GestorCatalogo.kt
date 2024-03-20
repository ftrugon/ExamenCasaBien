/**
 * Clase que gestiona el catálogo de libros de la biblioteca.
 */
class GestorCatalogo {
    private val catalogo = mutableListOf<Libro>()

    /**
     * Agrega un libro al catálogo.
     *
     * @param libro El libro que se desea agregar al catálogo.
     */
    fun agregar(libro: Libro){
        catalogo.add(libro)
    }

    /**
     * Elimina un libro del catálogo.
     *
     * @param libro El libro que se desea eliminar del catálogo.
     */
    fun eliminar(libro: Libro){
        catalogo.remove(libro)
    }


    /**
     * Busca un libro en el catálogo por su ID.
     *
     * @param id El ID del libro que se desea buscar.
     * @return El libro encontrado, o null si no se encontró ningún libro con el ID especificado.
     */
    fun buscar(id:String):Libro?{
        return catalogo.find { it.getId() == id }
    }

    /**
     * Busca libros en el catálogo por su estado.
     *
     * @param estado El estado que queremos buscar
     * @return Una lista de libros que tienen el estado que queremos.
     */
    fun buscarPorEstado(estado: Estado): List<Libro> {
        return catalogo.filter { it.getEstado() == estado }
    }

    /**
     * Cambia el estado de un libro de DISPONIBLE a PRESTADO, o al reves
     * @param libro El libro el cual queremos cambiarle el estado
     */
    fun cambiarEstadoLibro(libro: Libro) = libro.setEstado(if (libro.getEstado() == Estado.DISPONIBLE) Estado.PRESTADO else Estado.DISPONIBLE)

}