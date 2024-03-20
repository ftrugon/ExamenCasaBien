import kotlin.math.E

class GestorBiblioteca(val catalogo: GestorCatalogo, val registros: GestorRegistros, val consola:GestorConsola) {

    fun agregarLibroCatalogo(libro: Libro){
        catalogo.agregar(libro)
    }

    fun eliminarLibroCatalogo(id:String){
        val libroAEliminar = catalogo.buscar(id)
        if (libroAEliminar != null){
            catalogo.eliminar(libroAEliminar)
        }else{
            consola.libroNoEncontrado()
        }
    }

    fun registrarPrestamo(id:String){
        val libroAPrestar = catalogo.buscar(id)
        if (libroAPrestar != null && libroAPrestar.estado == Estado.DISPONIBLE){
            cambiarEstadoLibro(libroAPrestar)
        }else if (libroAPrestar == null){
            consola.libroNoEncontrado()
        }else{
            consola.libroEstabaEstado(Estado.PRESTADO)
        }
    }

    fun devolverLibro(id:String){
        val libroDevuelto = catalogo.buscar(id)
        if (libroDevuelto != null && libroDevuelto.estado == Estado.PRESTADO){
            cambiarEstadoLibro(libroDevuelto)
        }else if (libroDevuelto == null){
            consola.libroNoEncontrado()
        }else {
            consola.libroEstabaEstado(Estado.DISPONIBLE)
        }
    }

    fun cambiarEstadoLibro(libro: Libro){
        libro.estado = if (libro.estado == Estado.DISPONIBLE) Estado.PRESTADO else Estado.DISPONIBLE
    }


    fun consultarDisponibilidad(id:String){
        val libro = catalogo.buscar(id)
        if (libro != null){
            consola.libroEstaEstado(libro.estado)
        }else{
            consola.libroNoEncontrado()
        }
    }


    fun retornarPorEstado(estado: Estado):List<Libro>{
        return catalogo.buscarPorEstado(estado)
    }

}