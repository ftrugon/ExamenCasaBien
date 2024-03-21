open class GestorElementos<T:ElementoBiblioteca> {

    private val elementos = mutableListOf<T>()

    open fun agregar(elemento:T){
        this.elementos.add(elemento)
    }

    open fun eliminar(idElemeto: String){
        val elemento = elementos.find { it.getId() == idElemeto }
        if (elemento != null){
            elementos.remove(elemento)
        }
    }

    open fun eliminar(elemento: ElementoBiblioteca){
        val elemento = elementos.find { it == elemento }
        if (elemento != null){
            elementos.remove(elemento)
        }

    }

    open fun elementosGestionados() = elementos

    open fun buscar(idElemeto: String):ElementoBiblioteca?{
        return elementos.find { it.getId() == idElemeto }
    }

    open fun filtrarPorCriterio(elementos: List<T>, criterio: (elemento: T) -> Boolean): List<T>{
        return elementos.filter(criterio)
    }

    open fun buscarPorEstado(estado: Estado):List<T>{
        return elementos.filter { it.getEstado() == estado }
    }

}