/**
 * Clase que gestiona los usuarios de la biblioteca.
 *
 * @property usuarios La lista mutable de usuarios.
 */
class GestorUsuarios(
    override val usuarios: MutableList<Usuario> = mutableListOf()
) : IGestorUsuarios {

    /**
     * Agrega un usuario a la lista de usuarios.
     *
     * @param usuario El usuario a agregar.
     */
    override fun agregar(usuario: Usuario) {
        usuarios.add(usuario)
    }

    /**
     * Elimina un usuario de la lista de usuarios.
     *
     * @param usuario El usuario a eliminar.
     */
    override fun eliminar(usuario: Usuario) {
        usuarios.remove(usuario)
    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    override fun buscar(id: String): Usuario? {
        return usuarios.find { it.getId() == id }
    }

    /**
     * Agrega un préstamo al usuario.
     *
     * @param elemento El elemento bibliotecario prestado.
     * @param usuario El usuario al que se le presta el elemento.
     */
    override fun agregarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario) {
        usuario.getElementosPrestados().add(elemento)
    }

    /**
     * Quita un préstamo del usuario.
     *
     * @param elemento El elemento bibliotecario devuelto.
     * @param usuario El usuario que devuelve el elemento.
     */
    override fun quitarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario) {
        usuario.getElementosPrestados().remove(elemento)
    }

    /**
     * Consulta los préstamos realizados por un usuario.
     *
     * @param usuario El usuario del que se desean consultar los préstamos.
     * @return La lista mutable de elementos bibliotecarios prestados al usuario.
     */
    override fun consultarPrestamos(usuario: Usuario): MutableList<ElementoBiblioteca> {
        return usuario.getElementosPrestados()
    }
}