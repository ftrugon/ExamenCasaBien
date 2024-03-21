/**
 * Interfaz que define la funcionalidad para gestionar los préstamos en la biblioteca.
 */
interface IGestorPrestamos {

    /**
     * Lista mutable que contiene los préstamos actuales.
     */
    val prestamosActuales: MutableList<Prestamo>

    /**
     * Lista mutable que contiene el historial de préstamos.
     */
    val historialPrestamos: MutableList<Prestamo>

    /**
     * Registra un nuevo préstamo en la biblioteca.
     *
     * @param prestamo El préstamo a registrar.
     */
    fun registrarPrestamo(prestamo: Prestamo)

    /**
     * Devuelve un préstamo registrado en la biblioteca.
     *
     * @param prestamo El préstamo a devolver.
     */
    fun devolverPrestamo(prestamo: Prestamo)

    /**
     * Consulta el historial de préstamos de un elemento específico.
     *
     * @param id El identificador del elemento.
     * @return Una lista de préstamos relacionados con el elemento.
     */
    fun consultarHistorialElemento(id: String): List<Prestamo>

    /**
     * Consulta el historial de préstamos de un usuario específico.
     *
     * @param id El identificador del usuario.
     * @return Una lista de préstamos relacionados con el usuario.
     */
    fun consultarHistorialPersona(id: String): List<Prestamo>
}
