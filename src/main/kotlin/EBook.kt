/**
 * Clase que representa un libro electrónico en la biblioteca.
 *
 * @param id El identificador único del libro electrónico.
 * @param titulo El título del libro electrónico.
 * @constructor Crea un objeto EBook con el identificador y título dados.
 */
class EBook(
    id: String,
    titulo: String
) : ElementoBiblioteca(id, titulo) {

    /**
     * Representación en forma de cadena del Ebook.
     */
    override fun toString(): String {
        return "Ebook " + super.toString()
    }
}