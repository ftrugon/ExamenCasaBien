class GestorBiblioteca(
    override val catalogo: GestorCatalogo,
    override val registros: IGestorPrestamos,
    override val consola: IGestorConsola,
    override val usuarios: IGestorUsuarios
):IGestorBiblioteca {

    override fun agregarElementoCatalogo(elemento:ElementoBiblioteca)= catalogo.agregar(elemento)


    override fun eliminarelementoCatalogo(id:String){
        val elementoAEliminar = catalogo.buscar(id)
        if (elementoAEliminar != null){
            catalogo.eliminar(elementoAEliminar)
        }else{
            consola.elementoNoEncontrado()
        }
    }


    override fun registrarPrestamo(idLElemento:String, idUsuario:String) {
        val elementoAPrestar = catalogo.buscar(idLElemento)
        val usuarioPrestar = usuarios.buscar(idUsuario)

        if (elementoAPrestar != null && usuarioPrestar != null && elementoAPrestar.getEstado() == Estado.DISPONIBLE && elementoAPrestar is Prestable) {

           elementoAPrestar.prestar()
            usuarios.agregarPrestamo(elementoAPrestar, usuarioPrestar)
            val prestamo = Prestamo(elementoAPrestar, usuarioPrestar)
            registros.registrarPrestamo(prestamo)

        }else if (elementoAPrestar == null){
            consola.elementoNoEncontrado()
        }else if (elementoAPrestar !is Prestable) {
            consola.elementoNoPrestable()
        }else if (usuarioPrestar == null){
            consola.usuarioNoEncontrado()
        }else{
            consola.elementoEstabaEstado(Estado.PRESTADO)
        }
    }

    override fun devolverElemento(idLElemento:String, idUsuario:String){
        val elementoDevuelto = catalogo.buscar(idLElemento)
        val usuarioQueDevuelve = usuarios.buscar(idUsuario)

        if (elementoDevuelto != null && usuarioQueDevuelve != null && elementoDevuelto.getEstado() == Estado.PRESTADO && elementoDevuelto is Prestable){

            if (elementoDevuelto in usuarios.consultarPrestamos(usuarioQueDevuelve)){

                elementoDevuelto.devolver()
                usuarios.quitarPrestamo(elementoDevuelto,usuarioQueDevuelve)
                val prestamo = Prestamo(elementoDevuelto,usuarioQueDevuelve)
                registros.devolverPrestamo(prestamo)

            }else consola.elementoNoPrestadoUsuario()

        }else if (elementoDevuelto == null){
            consola.elementoNoEncontrado()
        }else if (elementoDevuelto !is Prestable) {
            consola.elementoNoPrestable()
        }else if (usuarioQueDevuelve == null){
            consola.usuarioNoEncontrado()
        }else{
            consola.elementoEstabaEstado(Estado.PRESTADO)
        }
    }

    override fun consultarDisponibilidad(id:String){
        val elemento = catalogo.buscar(id)
        if (elemento != null){
            consola.elementoEstaEstado(elemento.getEstado())
        }else{
            consola.elementoNoEncontrado()
        }
    }

    override fun retornarPorEstado(estado: Estado):List<ElementoBiblioteca>{
        return catalogo.buscarPorEstado(estado)
    }

    override fun agregarUsuario(usuario: Usuario) = usuarios.agregar(usuario)

    override fun eliminarUsuario(id: String){
        val usuarioAElimiar = usuarios.buscar(id)
        if (usuarioAElimiar != null){
            usuarios.eliminar(usuarioAElimiar)
        }else{
            consola.usuarioNoEncontrado()
        }
    }

    override fun historialDeUnElemento(id:String):List<Prestamo>{
        return registros.consultarHistorialElemento(id)
    }

    override fun historialDeUnUsuario(id:String):List<Prestamo>{
        return registros.consultarHistorialPersona(id)
    }

}