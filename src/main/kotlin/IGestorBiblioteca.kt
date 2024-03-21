/**
 * Interfaz que define la funcionalidad de gestión de la biblioteca.
 */
interface IGestorBiblioteca {
    /**
     * La instancia del gestor del catálogo de la biblioteca.
     */
    val catalogo: GestorCatalogo

    /**
     * La instancia del gestor de los registros de préstamos de la biblioteca.
     */
    val registros: IGestorPrestamos

    /**
     * La instancia del gestor de la consola de la biblioteca.
     */
    val consola: IGestorConsola

    /**
     * La instancia del gestor de usuarios de la biblioteca.
     */
    val usuarios: IGestorUsuarios

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     *
     * @param elemento El elemento bibliotecario a agregar.
     */
    fun agregarElementoCatalogo(elemento: ElementoBiblioteca)

    /**
     * Elimina un elemento del catálogo de la biblioteca.
     *
     * @param id El identificador del elemento a eliminar.
     */
    fun eliminarelementoCatalogo(id: String)

    /**
     * Registra un préstamo de un elemento a un usuario.
     *
     * @param idLElemento El identificador del elemento a prestar.
     * @param idUsuario El identificador del usuario que realiza el préstamo.
     */
    fun registrarPrestamo(idLElemento: String, idUsuario: String)

    /**
     * Devuelve un elemento prestado por un usuario.
     *
     * @param idLElemento El identificador del elemento a devolver.
     * @param idUsuario El identificador del usuario que devuelve el elemento.
     */
    fun devolverElemento(idLElemento: String, idUsuario: String)

    /**
     * Consulta la disponibilidad de un elemento en el catálogo.
     *
     * @param id El identificador del elemento a consultar.
     */
    fun consultarDisponibilidad(id: String)

    /**
     * Retorna una lista de elementos en el catálogo que tienen el estado especificado.
     *
     * @param estado El estado de los elementos a retornar.
     * @return Una lista de elementos bibliotecarios con el estado especificado.
     */
    fun retornarPorEstado(estado: Estado): List<ElementoBiblioteca>

    /**
     * Agrega un usuario al sistema de la biblioteca.
     *
     * @param usuario El usuario a agregar.
     */
    fun agregarUsuario(usuario: Usuario)

    /**
     * Elimina un usuario del sistema de la biblioteca.
     *
     * @param id El identificador del usuario a eliminar.
     */
    fun eliminarUsuario(id: String)

    /**
     * Obtiene el historial de préstamos de un elemento bibliotecario.
     *
     * @param id El identificador del elemento del cual se desea consultar el historial.
     * @return Una lista de préstamos asociados al elemento especificado.
     */
    fun historialDeUnElemento(id: String): List<Prestamo>

    /**
     * Obtiene el historial de préstamos de un usuario.
     *
     * @param id El identificador del usuario del cual se desea consultar el historial.
     * @return Una lista de préstamos asociados al usuario especificado.
     */
    fun historialDeUnUsuario(id: String): List<Prestamo>
}