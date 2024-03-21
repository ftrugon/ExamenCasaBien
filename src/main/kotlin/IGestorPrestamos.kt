interface IGestorPrestamos {
    val prestamosActuales:MutableList<Prestamo>
    val historialPrestamos:MutableList<Prestamo>

    fun registrarPrestamo(prestamo: Prestamo)
    fun devolverPrestamo(prestamo: Prestamo)
    fun consultarHistorialElemento(id:String):List<Prestamo>
    fun consultarHistorialPersona(id: String): List<Prestamo>
}