class DVD(
    id: String,
    titulo: String,
) :ElementoBiblioteca(id, titulo),Prestable{

    override fun prestar() {
        setEstado(Estado.PRESTADO)
    }

    override fun devolver() {
        setEstado(Estado.DISPONIBLE)
    }

    override fun toString(): String {
        return "DVD "+super.toString()
    }
}