class Usuario(
    private val id:String,
    private val nombre:String,
    private val listaLibrosPrestados:MutableList<Libro> = mutableListOf()
) {
    fun agregarPrestamo(libro: Libro){
        listaLibrosPrestados.add(libro)
    }

    fun quitarPrestamo(libro: Libro){
        listaLibrosPrestados.remove(libro)
    }

    fun consultarPrestamos() = listaLibrosPrestados


    fun getId() = id
    fun getNombre() = nombre

}
