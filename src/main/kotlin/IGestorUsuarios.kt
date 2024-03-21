/**
 * Interfaz que define la funcionalidad para gestionar los usuarios en la biblioteca.
 */
interface IGestorUsuarios {

    /**
     * Lista mutable que contiene los usuarios.
     */
    val usuarios: MutableList<Usuario>

    /**
     * Agrega un nuevo usuario a la biblioteca.
     *
     * @param usuario El usuario a agregar.
     */
    fun agregar(usuario: Usuario)

    /**
     * Elimina un usuario de la biblioteca.
     *
     * @param usuario El usuario a eliminar.
     */
    fun eliminar(usuario: Usuario)

    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    fun buscar(id: String): Usuario?

    /**
     * Agrega un préstamo a un usuario.
     *
     * @param elemento El elemento bibliotecario a prestar.
     * @param usuario El usuario al que se le prestará el elemento.
     */
    fun agregarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario)

    /**
     * Quita un préstamo de un usuario.
     *
     * @param elemento El elemento bibliotecario a devolver.
     * @param usuario El usuario que devuelve el elemento.
     */
    fun quitarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario)

    /**
     * Consulta los préstamos activos de un usuario.
     *
     * @param usuario El usuario del que se consultan los préstamos.
     * @return Una lista mutable de elementos bibliotecarios prestados al usuario.
     */
    fun consultarPrestamos(usuario: Usuario): MutableList<ElementoBiblioteca>
}