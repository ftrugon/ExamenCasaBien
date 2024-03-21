/**
 * Clase que gestiona todas las operaciones relacionadas con la biblioteca.
 *
 * @property catalogo El gestor del catálogo de la biblioteca.
 * @property registros El gestor de los registros de préstamos de la biblioteca.
 * @property consola El gestor de la consola de la biblioteca.
 * @property usuarios El gestor de los usuarios de la biblioteca.
 * @constructor Crea un nuevo gestor de biblioteca con los gestores de catálogo, registros, consola y usuarios dados.
 */
class GestorBiblioteca(
    override val catalogo: GestorCatalogo,
    override val registros: IGestorPrestamos,
    override val consola: IGestorConsola,
    override val usuarios: IGestorUsuarios
) : IGestorBiblioteca {

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     *
     * @param elemento El elemento a agregar al catálogo.
     */
    override fun agregarElementoCatalogo(elemento: ElementoBiblioteca) = catalogo.agregar(elemento)

    /**
     * Elimina un elemento del catálogo de la biblioteca.
     *
     * @param id El identificador del elemento a eliminar del catálogo.
     */
    override fun eliminarelementoCatalogo(id: String) {
        val elementoAEliminar = catalogo.buscar(id)
        if (elementoAEliminar != null) {
            catalogo.eliminar(elementoAEliminar)
        } else {
            consola.elementoNoEncontrado()
        }
    }

    /**
     * Registra un préstamo de un elemento a un usuario.
     *
     * @param idLElemento El identificador del elemento a prestar.
     * @param idUsuario El identificador del usuario al que se le presta el elemento.
     */
    override fun registrarPrestamo(idLElemento: String, idUsuario: String) {
        val elementoAPrestar = catalogo.buscar(idLElemento)
        val usuarioPrestar = usuarios.buscar(idUsuario)

        if (elementoAPrestar != null && usuarioPrestar != null && elementoAPrestar.getEstado() == Estado.DISPONIBLE && elementoAPrestar is Prestable) {
            elementoAPrestar.prestar()
            usuarios.agregarPrestamo(elementoAPrestar, usuarioPrestar)
            val prestamo = Prestamo(elementoAPrestar, usuarioPrestar)
            registros.registrarPrestamo(prestamo)
        } else if (elementoAPrestar == null) {
            consola.elementoNoEncontrado()
        } else if (elementoAPrestar !is Prestable) {
            consola.elementoNoPrestable()
        } else if (usuarioPrestar == null) {
            consola.usuarioNoEncontrado()
        } else {
            consola.elementoEstabaEstado(Estado.PRESTADO)
        }
    }

    /**
     * Devuelve un elemento prestado por un usuario.
     *
     * @param idLElemento El identificador del elemento a devolver.
     * @param idUsuario El identificador del usuario que devuelve el elemento.
     */
    override fun devolverElemento(idLElemento: String, idUsuario: String) {
        val elementoDevuelto = catalogo.buscar(idLElemento)
        val usuarioQueDevuelve = usuarios.buscar(idUsuario)

        if (elementoDevuelto != null && usuarioQueDevuelve != null && elementoDevuelto.getEstado() == Estado.PRESTADO && elementoDevuelto is Prestable) {
            if (elementoDevuelto in usuarios.consultarPrestamos(usuarioQueDevuelve)) {
                elementoDevuelto.devolver()
                usuarios.quitarPrestamo(elementoDevuelto, usuarioQueDevuelve)
                val prestamo = Prestamo(elementoDevuelto, usuarioQueDevuelve)
                registros.devolverPrestamo(prestamo)
            } else consola.elementoNoPrestadoUsuario()
        } else if (elementoDevuelto == null) {
            consola.elementoNoEncontrado()
        } else if (elementoDevuelto !is Prestable) {
            consola.elementoNoPrestable()
        } else if (usuarioQueDevuelve == null) {
            consola.usuarioNoEncontrado()
        } else {
            consola.elementoEstabaEstado(Estado.PRESTADO)
        }
    }

    /**
     * Consulta la disponibilidad de un elemento en el catálogo.
     *
     * @param id El identificador del elemento a consultar.
     */
    override fun consultarDisponibilidad(id: String) {
        val elemento = catalogo.buscar(id)
        if (elemento != null) {
            consola.elementoEstaEstado(elemento.getEstado())
        } else {
            consola.elementoNoEncontrado()
        }
    }

    /**
     * Retorna una lista de elementos de la biblioteca con un estado dado.
     *
     * @param estado El estado de los elementos a buscar.
     * @return Una lista de elementos con el estado especificado.
     */
    override fun retornarPorEstado(estado: Estado): List<ElementoBiblioteca> {
        return catalogo.buscarPorEstado(estado)
    }

    /**
     * Agrega un usuario al sistema de la biblioteca.
     *
     * @param usuario El usuario a agregar.
     */
    override fun agregarUsuario(usuario: Usuario) = usuarios.agregar(usuario)

    /**
     * Elimina un usuario del sistema de la biblioteca.
     *
     * @param id El identificador del usuario a eliminar.
     */
    override fun eliminarUsuario(id: String) {
        val usuarioAElimiar = usuarios.buscar(id)
        if (usuarioAElimiar != null) {
            usuarios.eliminar(usuarioAElimiar)
        } else {
            consola.usuarioNoEncontrado()
        }
    }

    /**
     * Consulta el historial de préstamos de un elemento de la biblioteca.
     *
     * @param id El identificador del elemento.
     * @return Una lista de préstamos asociados al elemento.
     */
    override fun historialDeUnElemento(id: String): List<Prestamo> {
        return registros.consultarHistorialElemento(id)
    }

    /**
     * Consulta el historial de préstamos de un usuario de la biblioteca.
     *
     * @param id El identificador del usuario.
     * @return Una lista de préstamos asociados al usuario.
     */
    override fun historialDeUnUsuario(id:String):List<Prestamo>{
        return registros.consultarHistorialPersona(id)
    }

}