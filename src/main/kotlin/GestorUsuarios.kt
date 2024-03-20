class GestorUsuarios(
    private val usuarios:MutableList<Usuario> = mutableListOf()
){

    fun agregar(usuario: Usuario){
        usuarios.add(usuario)
    }

    fun eliminar(usuario: Usuario){
        usuarios.remove(usuario)
    }

    fun buscar(id:String):Usuario?{
        return usuarios.find { it.getId() == id }
    }


}
