class GestorCatalogo: GestorElementos<ElementoBiblioteca>() {

    override fun agregar(elemento: ElementoBiblioteca){
        super.agregar(elemento)
    }

    override fun eliminar(idElemeto: String) {
        super.eliminar(idElemeto)
    }

    override fun elementosGestionados(): MutableList<ElementoBiblioteca> {
        return super.elementosGestionados()
    }

    override fun filtrarPorCriterio(
        elementos: List<ElementoBiblioteca>,
        criterio: (elemento: ElementoBiblioteca) -> Boolean
    ): List<ElementoBiblioteca> {
        return super.filtrarPorCriterio(elementos, criterio)
    }



}