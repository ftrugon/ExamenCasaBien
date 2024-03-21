/**
 * Clase de utilidades para generar identificadores únicos para elementos bibliotecarios y usuarios.
 */
class UtilidadesBiblioteca {

    /**
     * Compañero de objetos que contiene funciones estáticas para generar identificadores únicos.
     */
    companion object {

        // Contador para identificadores únicos de elementos bibliotecarios
        private var idElemento = 0

        /**
         * Genera un identificador único para un elemento bibliotecario.
         *
         * @return El identificador único generado como una cadena de texto.
         */
        fun generarIdentificadorUnicoElemento(): String {
            idElemento++
            return idElemento.toString()
        }

        // Contador para identificadores únicos de usuarios
        private var idUsuario = 0

        /**
         * Genera un identificador único para un usuario.
         *
         * @return El identificador único generado como una cadena de texto.
         */
        fun generarIdentificadorUnicoUsuario(): String {
            idUsuario++
            return idUsuario.toString()
        }
    }
}
