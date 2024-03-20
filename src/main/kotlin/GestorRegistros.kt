class GestorRegistros(
    private val prestamosActuales:MutableList<Prestamo> = mutableListOf(),
    private val historialPrestamos:MutableList<Prestamo> = mutableListOf()
) {

    fun registrarPrestamo(prestamo: Prestamo){
        prestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    fun devolverPrestamo(prestamo: Prestamo){
        prestamosActuales.remove(prestamo)
    }

    fun consultarHistorialLibro(id:String):List<Prestamo>{
        return historialPrestamos.filter { it.libro.getId() == id }
    }

    fun consultarHistorialPersona(id: String): List<Prestamo> {
        return historialPrestamos.filter { it.usuario.getId() == id }
    }

}

data class Prestamo(val libro: Libro,val usuario: Usuario)