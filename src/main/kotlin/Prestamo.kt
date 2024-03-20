/**
 * Clase que representa un préstamo de un libro a un usuario en la biblioteca.
 *
 * @property libro El libro prestado.
 * @property usuario El usuario que ha solicitado el préstamo.
 */
data class Prestamo(val libro: Libro,val usuario: Usuario)