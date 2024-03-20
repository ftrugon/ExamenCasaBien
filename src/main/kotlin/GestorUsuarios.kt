/**
 * Clase que gestiona la información de los usuarios de la biblioteca.
 *
 * @property usuarios La lista mutable de usuarios registrados en la biblioteca.
 */
class GestorUsuarios(
    private val usuarios:MutableList<Usuario> = mutableListOf()
){
    /**
     * Agrega un usuario a la lista de usuarios.
     *
     * @param usuario El usuario a agregar.
     */
    fun agregar(usuario: Usuario){
        usuarios.add(usuario)
    }

    /**
     * Elimina un usuario de la lista de usuarios.
     *
     * @param usuario El usuario a eliminar.
     */
    fun eliminar(usuario: Usuario){
        usuarios.remove(usuario)
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    fun buscar(id:String):Usuario?{
        return usuarios.find { it.getId() == id }
    }

    /**
     * Agrega un préstamo de un libro a un usuario.
     *
     * @param libro El libro a prestar.
     * @param usuario El usuario al que se le presta el libro.
     */
    fun agregarPrestamo(libro: Libro, usuario: Usuario){
        usuario.getlibrosPrestados().add(libro)
    }

    /**
     * Quita un préstamo de un libro de un usuario.
     *
     * @param libro El libro a devolver.
     * @param usuario El usuario que devuelve el libro.
     */
    fun quitarPrestamo(libro: Libro,usuario: Usuario){
        usuario.getlibrosPrestados().remove(libro)
    }

    /**
     * Consulta los préstamos activos de un usuario.
     *
     * @param usuario El usuario del que se consultan los préstamos.
     * @return La lista de libros prestados al usuario.
     */
    fun consultarPrestamos(usuario: Usuario) = usuario.getlibrosPrestados()

}
