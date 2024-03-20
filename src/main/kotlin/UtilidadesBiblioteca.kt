import java.util.UUID

class UtilidadesBiblioteca {

    // Forma hardcore shit
    //companion object{
    //    var listaUUIDS = mutableListOf<String>()

    //    fun generarIdentificadorUnico():String{
    //        var uuidAsignar = UUID.randomUUID().toString()

    //        while (uuidAsignar in listaUUIDS){
    //            uuidAsignar = UUID.randomUUID().toString()
    //        }

    //        return uuidAsignar
    //    }
    //}


    // forma Ezzzzzz
    companion object{

        private var idLibro = 0
        fun generarIdentificadorUnicoLibro():String{
            idLibro++
            return idLibro.toString()
        }



        private var idUsuario = 0
        fun generarIdentificadorUnicoUsuario():String{
            idUsuario++
            return idUsuario.toString()
        }

    }

}