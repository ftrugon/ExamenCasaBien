class GestorCatalogo:IGestorCatalogo {
    override val catalogo = mutableListOf<ElementoBiblioteca>()

    override fun agregar(elemento: ElementoBiblioteca){
        catalogo.add(elemento)
    }


    override fun eliminar(elemento: ElementoBiblioteca){
        catalogo.remove(elemento)
    }



    override fun buscar(id:String):ElementoBiblioteca?{
        return catalogo.find { it.getId() == id }
    }


    override fun buscarPorEstado(estado: Estado): List<ElementoBiblioteca> {
        return catalogo.filter { it.getEstado() == estado }
    }


}