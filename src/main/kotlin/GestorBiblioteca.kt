import kotlin.math.E

/**
 * Clase encargada de gestionar la biblioteca, incluyendo el catálogo de libros, los registros de préstamos y los usuarios.
 *
 * @property catalogo El gestor del catálogo de libros.
 * @property registros El gestor de los registros de préstamos.
 * @property consola El gestor que muestra cosas por pantalla.
 * @property usuarios El gestor de usuarios.
 */
class GestorBiblioteca(
    private val catalogo: GestorCatalogo,
    private val registros: GestorRegistros,
    private val consola:GestorConsola,
    private val usuarios: GestorUsuarios
) {

    /**
     * Añade un libro al catalogo
     * @param libro el libro a añadir
     */
    fun agregarLibroCatalogo(libro: Libro)= catalogo.agregar(libro)

    /**
     * elimina un libro del catalogo
     * @param id la id del libro a eliminar
     */
    fun eliminarLibroCatalogo(id:String){
        val libroAEliminar = catalogo.buscar(id)
        if (libroAEliminar != null){
            catalogo.eliminar(libroAEliminar)
        }else{
            consola.libroNoEncontrado()
        }
    }

    /**
     * Registra un prestamo en usuario y en registro de prestamos y cambia el etado del libro
     * @param idLibro la id del libro a prestar
     * @param idUsuario la id del usuario que se lleva el libro
     */
    fun registrarPrestamo(idLibro:String,idUsuario:String){
        val libroAPrestar = catalogo.buscar(idLibro)
        val usuarioPrestar = usuarios.buscar(idUsuario)

        if (libroAPrestar != null && usuarioPrestar != null && libroAPrestar.getEstado() == Estado.DISPONIBLE){

            catalogo.cambiarEstadoLibro(libroAPrestar)
            usuarios.agregarPrestamo(libroAPrestar,usuarioPrestar)
            val prestamo = Prestamo(libroAPrestar,usuarioPrestar)
            registros.registrarPrestamo(prestamo)

        }else if (libroAPrestar == null){
            consola.libroNoEncontrado()
        }else if (usuarioPrestar == null){
            consola.usuarioNoEncontrado()
        }else{
            consola.libroEstabaEstado(Estado.PRESTADO)
        }
    }

    /**
     * devuelve un libro
     * @param idLibro la id del libro a devolver
     * @param idUsuario la id del usuario que devuelve el libro
     */
    fun devolverLibro(idLibro:String,idUsuario:String){
        val libroDevuelto = catalogo.buscar(idLibro)
        val usuarioQueDevuelve = usuarios.buscar(idUsuario)

        if (libroDevuelto != null && usuarioQueDevuelve != null && libroDevuelto.getEstado() == Estado.PRESTADO){

            if (libroDevuelto in usuarios.consultarPrestamos(usuarioQueDevuelve)){

                catalogo.cambiarEstadoLibro(libroDevuelto)
                usuarios.quitarPrestamo(libroDevuelto,usuarioQueDevuelve)
                val prestamo = Prestamo(libroDevuelto,usuarioQueDevuelve)
                registros.devolverPrestamo(prestamo)

            }else consola.libroNoPrestadoUsuario()

        }else if (libroDevuelto == null){
            consola.libroNoEncontrado()
        }else if (usuarioQueDevuelve == null){
            consola.usuarioNoEncontrado()
        }else{
            consola.libroEstabaEstado(Estado.DISPONIBLE)
        }
    }

    /**
     * Consulta si un libro esta disponible y muestra por pantalla si esta disponible o prestado
     * @param id la id del libro a consultar
     */
    fun consultarDisponibilidad(id:String){
        val libro = catalogo.buscar(id)
        if (libro != null){
            consola.libroEstaEstado(libro.getEstado())
        }else{
            consola.libroNoEncontrado()
        }
    }

    /**
     * Devuelve una lista de los libros por el estado introdicudo
     * @param estado el estado por el que queremos buscar
     */
    fun retornarPorEstado(estado: Estado) = catalogo.buscarPorEstado(estado)

    /**
     * agrega un usuario a los usuarios
     * @param usuario usuario a añadir
     */
    fun agregarUsuario(usuario: Usuario) = usuarios.agregar(usuario)

    /**
     * elimina un usuario de los usuarios
     * @param id la id del usuario a eliminar
     */
    fun eliminarUsuario(id: String){
        val usuarioAElimiar = usuarios.buscar(id)
        if (usuarioAElimiar != null){
            usuarios.eliminar(usuarioAElimiar)
        }else{
            consola.usuarioNoEncontrado()
        }
    }

    /**
     * Obtiene el historial de préstamos de un libro
     * @param id la id del libro del que queremos saber el historial
     * @return Una lista prestamos
     */
    fun historialDeUnLibro(id:String):List<Prestamo>{
        return registros.consultarHistorialLibro(id)
    }

    /**
     * Obtiene el historial de préstamos de un usuario
     * @param id la id del usuario del que queremos saber el historial
     * @return Una lista prestamos
     */
    fun historialDeUnUsuario(id:String):List<Prestamo>{
        return registros.consultarHistorialPersona(id)
    }

}