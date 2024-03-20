class GestorConsola {

    fun mostrarMensaje(mensaje:String){
        println(mensaje)
    }

    fun mostrarLista(list: List<Libro>){
        list.forEach { println(it) }
    }

    fun libroNoEncontrado() = mostrarMensaje("Este libro no se ha encontrado en el catalogo")

    fun libroEstabaEstado(estado: Estado) = mostrarMensaje("Este libro ya estaba ${estado.toString().lowercase()}")

    fun libroEstaEstado(estado: Estado) = mostrarMensaje("Este libro esta ${estado.toString().lowercase()}")

}