/**
 * Clase encargada de gestionar los registros de préstamos en la biblioteca.
 *
 * @property prestamosActuales Lista de préstamos actuales.
 * @property historialPrestamos Lista de historial de préstamos.
 */
class GestorRegistros(
    private val prestamosActuales:MutableList<Prestamo> = mutableListOf(),
    private val historialPrestamos:MutableList<Prestamo> = mutableListOf()
) {

    /**
     * Registra un nuevo préstamo, añadiéndolo tanto a los préstamos actuales como al historial.
     *
     * @param prestamo El préstamo a registrar.
     */
    fun registrarPrestamo(prestamo: Prestamo){
        prestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    /**
     * Devuelve un préstamo, removiéndolo de la lista de préstamos actuales.
     *
     * @param prestamo El préstamo a devolver.
     */
    fun devolverPrestamo(prestamo: Prestamo){
        prestamosActuales.remove(prestamo)
    }

    /**
     * Consulta el historial de préstamos de un libro específico.
     *
     * @param id El ID del libro del cual se desea consultar el historial.
     * @return Una lista de los préstamos asociados al libro.
     */
    fun consultarHistorialLibro(id:String):List<Prestamo>{
        return historialPrestamos.filter { it.libro.getId() == id }
    }

    /**
     * Consulta el historial de préstamos de una persona específica.
     *
     * @param id El ID de la persona del cual se desea consultar el historial.
     * @return Una lista de los préstamos asociados a la persona.
     */
    fun consultarHistorialPersona(id: String): List<Prestamo> {
        return historialPrestamos.filter { it.usuario.getId() == id }
    }

}