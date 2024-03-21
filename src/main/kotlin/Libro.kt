class Libro(
    id: String,
    titulo: String,
    private val autor:String,
    private val anioPublicacion:String,
    private val tematica:String
) :ElementoBiblioteca(id, titulo),Prestable{

    fun getAutor() = autor
    fun getAnioPublicacion() = anioPublicacion
    fun getTematica() = tematica

    override fun prestar() {
        setEstado(Estado.PRESTADO)
    }

    override fun devolver() {
        setEstado(Estado.DISPONIBLE)
    }

    override fun toString(): String {
        return "Libro "+super.toString()
    }
}
