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

        var id = 0

        fun generarIdentificadorUnico():String{
            id++
            return id.toString()
        }


    }

}