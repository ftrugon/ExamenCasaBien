/**
 * Clase de utilidades para la biblioteca que proporciona métodos estáticos para generar identificadores únicos.
 */
class UtilidadesBiblioteca {

    companion object{

        private var idLibro = 0
        /**
         * Genera un identificador único para un libro.
         * @return El identificador único generado para el libro.
         */
        fun generarIdentificadorUnicoLibro():String{
            idLibro++
            return idLibro.toString()
        }



        private var idUsuario = 0
        /**
         * Genera un identificador único para un usuario.
         * @return El identificador único generado para el usuario.
         */
        fun generarIdentificadorUnicoUsuario():String{
            idUsuario++
            return idUsuario.toString()
        }

    }

}