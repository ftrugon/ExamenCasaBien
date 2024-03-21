/**
 * Clase que gestiona los registros de préstamos en la biblioteca.
 *
 * @property prestamosActuales La lista mutable de préstamos actuales.
 * @property historialPrestamos La lista mutable de historial de préstamos.
 */
class GestorRegistros(
    override val prestamosActuales: MutableList<Prestamo> = mutableListOf(),
    override val historialPrestamos: MutableList<Prestamo> = mutableListOf()
) : IGestorPrestamos {

    /**
     * Registra un préstamo en los registros.
     *
     * @param prestamo El préstamo a registrar.
     */
    override fun registrarPrestamo(prestamo: Prestamo) {
        prestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    /**
     * Devuelve un préstamo y lo elimina de los registros actuales.
     *
     * @param prestamo El préstamo a devolver.
     */
    override fun devolverPrestamo(prestamo: Prestamo) {
        prestamosActuales.remove(prestamo)
    }

    /**
     * Consulta el historial de préstamos de un elemento específico.
     *
     * @param id El identificador del elemento.
     * @return La lista de préstamos relacionados con el elemento.
     */
    override fun consultarHistorialElemento(id: String): List<Prestamo> {
        return historialPrestamos.filter { it.elemento.getId() == id }
    }

    /**
     * Consulta el historial de préstamos de un usuario específico.
     *
     * @param id El identificador del usuario.
     * @return La lista de préstamos realizados por el usuario.
     */
    override fun consultarHistorialPersona(id: String): List<Prestamo> {
        return historialPrestamos.filter { it.usuario.getId() == id }
    }
}