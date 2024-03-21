abstract class ElementoBiblioteca(
    private val id:String,
    private val titulo:String,
    private var estado:Estado = Estado.DISPONIBLE
) {
    init {
        require(id.isNotEmpty()) {"La id no puede estar vacia"}
        require(titulo.isNotEmpty()) {"El titulo no puede estar vacio"}
    }
    fun getId() = id
    fun getTitulo() = titulo
    fun getEstado() = estado
    fun setEstado(estado: Estado){
        this.estado = estado
    }

    override fun toString(): String {
        return "id=${id}, titulo=$titulo, estado=$estado"
    }
}


interface Prestable{
    fun prestar()
    fun devolver()
}
