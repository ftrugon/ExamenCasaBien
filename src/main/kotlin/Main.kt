package org.example

import GestorBiblioteca
import GestorCatalogo
import GestorRegistros
import GestorConsola
import GestorUsuarios
import Libro
import Usuario
import UtilidadesBiblioteca


/**
 * la funcion principal del programa
 */
fun main() {

    //Creando el gestor de la consola
    val consola = GestorConsola()

    //Creando la biblioteca y agregandole libros y usuarios
    val biblioteca = GestorBiblioteca(GestorCatalogo(),GestorRegistros(),consola,GestorUsuarios())
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"El silbon de torres","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"Achili Pum","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"lA bYda es un toMVola","migue","17/03/2020","Terror"))

    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"fran"))
    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"andres"))
    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"ivan"))

    //Haciendo prestamos y devolviendolos
    biblioteca.registrarPrestamo("1","1")
    biblioteca.registrarPrestamo("2","1")

    biblioteca.devolverLibro("2","1")
    biblioteca.devolverLibro("3","1")

    //los libros prestados y disponibles
    val listaDisponibles = biblioteca.retornarPorEstado(Estado.DISPONIBLE)
    val listaPrestados = biblioteca.retornarPorEstado(Estado.PRESTADO)

    //mostrando los libros disponibles
    consola.mostrarMensaje("\nLista Disponibles") // <--- No se si eso esta bien porque por lo que dijisite del modelo vista-controlador, toda la informacion que se muestre en consola debe estar en gestor consola pero, toddos los mensajes a mostrar en serio?, he hecho esto porque lo tenias en tu codigo pero el resto de los mostrarMensaje estan en gestorConsola
    consola.mostrarLista(listaDisponibles)

    consola.mostrarMensaje("\nLista Prestados")
    consola.mostrarLista(listaPrestados)

    // Los historiales de libros y usuarios
    val historialPrestamosLibro1 = biblioteca.historialDeUnLibro("1")
    val historialPrestamosLibro2 = biblioteca.historialDeUnLibro("2")
    val historialPrestamosLibro3 = biblioteca.historialDeUnLibro("3")

    val historialUsuario1 = biblioteca.historialDeUnUsuario("1")
    val historialUsuario2 = biblioteca.historialDeUnUsuario("2")
    val historialUsuario3 = biblioteca.historialDeUnUsuario("3")


    // Mostrando los historiales
    consola.mostrarMensaje("\n*** historial libros ***")
    consola.mostrarMensaje("*** libro1 ***")
    consola.mostrarLista(historialPrestamosLibro1)
    consola.mostrarMensaje("*** libro2 ***")
    consola.mostrarLista(historialPrestamosLibro2)
    consola.mostrarMensaje("*** libro3 ***")
    consola.mostrarLista(historialPrestamosLibro3)

    consola.mostrarMensaje("\n*** historial usuarios ***")
    consola.mostrarMensaje("*** usuario1 ***")
    consola.mostrarLista(historialUsuario1)
    consola.mostrarMensaje("*** usuario2 ***")
    consola.mostrarLista(historialUsuario2)
    consola.mostrarMensaje("*** usuario3 ***")
    consola.mostrarLista(historialUsuario3)


}