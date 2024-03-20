import kotlin.math.E

class GestorBiblioteca(
    private val catalogo: GestorCatalogo,
    private val registros: GestorRegistros,
    private val consola:GestorConsola,
    private val usuarios: GestorUsuarios) {

    fun agregarLibroCatalogo(libro: Libro)= catalogo.agregar(libro)

    fun eliminarLibroCatalogo(id:String){
        val libroAEliminar = catalogo.buscar(id)
        if (libroAEliminar != null){
            catalogo.eliminar(libroAEliminar)
        }else{
            consola.libroNoEncontrado()
        }
    }

    fun registrarPrestamo(idLibro:String,idUsuario:String){
        val libroAPrestar = catalogo.buscar(idLibro)
        val usuarioPrestar = usuarios.buscar(idUsuario)

        if (libroAPrestar != null && usuarioPrestar != null && libroAPrestar.getEstado() == Estado.DISPONIBLE){

            catalogo.cambiarEstadoLibro(libroAPrestar)
            usuarioPrestar.agregarPrestamo(libroAPrestar)
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

    fun devolverLibro(idLibro:String,idUsuario:String){
        val libroDevuelto = catalogo.buscar(idLibro)
        val usuarioQueDevuelve = usuarios.buscar(idUsuario)

        if (libroDevuelto != null && usuarioQueDevuelve != null && libroDevuelto.getEstado() == Estado.PRESTADO){

            if (libroDevuelto in usuarioQueDevuelve.consultarPrestamos()){

                catalogo.cambiarEstadoLibro(libroDevuelto)
                usuarioQueDevuelve.quitarPrestamo(libroDevuelto)
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

    fun consultarDisponibilidad(id:String){
        val libro = catalogo.buscar(id)
        if (libro != null){
            consola.libroEstaEstado(libro.getEstado())
        }else{
            consola.libroNoEncontrado()
        }
    }

    fun retornarPorEstado(estado: Estado) = catalogo.buscarPorEstado(estado)

    fun agregarUsuario(usuario: Usuario) = usuarios.agregar(usuario)

    fun eliminarUsuario(id: String){
        val usuarioAElimiar = usuarios.buscar(id)
        if (usuarioAElimiar != null){
            usuarios.eliminar(usuarioAElimiar)
        }else{
            consola.usuarioNoEncontrado()
        }
    }

}