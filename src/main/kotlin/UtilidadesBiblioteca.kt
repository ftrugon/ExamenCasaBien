
class UtilidadesBiblioteca {

    companion object{

        private var idElemento = 0

        fun generarIdentificadorUnicoElemento():String{
            idElemento++
            return idElemento.toString()
        }



        private var idUsuario = 0

        fun generarIdentificadorUnicoUsuario():String{
            idUsuario++
            return idUsuario.toString()
        }

    }

}