class GestorUsuarios(
    override val usuarios:MutableList<Usuario> = mutableListOf()
):IGestorUsuarios{

    override fun agregar(usuario: Usuario){
        usuarios.add(usuario)
    }


    override fun eliminar(usuario: Usuario){
        usuarios.remove(usuario)
    }


    override fun buscar(id:String):Usuario?{
        return usuarios.find { it.getId() == id }
    }


    override fun agregarPrestamo(elemento:ElementoBiblioteca, usuario: Usuario){
        usuario.getElementosPrestados().add(elemento)
    }


    override fun quitarPrestamo(elemento:ElementoBiblioteca, usuario: Usuario){
        usuario.getElementosPrestados().remove(elemento)
    }

    override fun consultarPrestamos(usuario: Usuario):MutableList<ElementoBiblioteca> = usuario.getElementosPrestados()

}
