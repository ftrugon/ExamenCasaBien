class GestorRegistros(
    override val prestamosActuales:MutableList<Prestamo> = mutableListOf(),
    override val historialPrestamos:MutableList<Prestamo> = mutableListOf()
):IGestorPrestamos {

    override fun registrarPrestamo(prestamo: Prestamo){
        prestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    override fun devolverPrestamo(prestamo: Prestamo){
        prestamosActuales.remove(prestamo)
    }

    override fun consultarHistorialElemento(id:String):List<Prestamo>{
        return historialPrestamos.filter { it.elemento.getId() == id }
    }

    override fun consultarHistorialPersona(id: String): List<Prestamo> {
        return historialPrestamos.filter { it.usuario.getId() == id }
    }

}