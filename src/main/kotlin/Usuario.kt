class Usuario(
    private val id:String,
    private val nombre:String,
    private val listaElementosPrestados:MutableList<ElementoBiblioteca> = mutableListOf()
) {

    fun getId() = id
    fun getNombre() = nombre
    fun getElementosPrestados() = listaElementosPrestados

    override fun toString(): String {
        return "id=$id, nombre=$nombre"
    }

}
