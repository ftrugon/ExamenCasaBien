package org.example

import GestorBiblioteca
import GestorCatalogo
import GestorRegistros
import GestorConsola
import Libro

fun main() {

    val consola = GestorConsola()

    val biblioteca = GestorBiblioteca(GestorCatalogo(),GestorRegistros(),consola)
    biblioteca.agregarLibroCatalogo(Libro("1","El silbon de torres","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro("2","Achili Pum","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro("3","lA bYda es un toMVola","migue","17/03/2020","Terror"))

    biblioteca.registrarPrestamo("1")
    biblioteca.registrarPrestamo("2")


    // roban el libro XD
    biblioteca.eliminarLibroCatalogo("2")

    biblioteca.devolverLibro("2")
    biblioteca.devolverLibro("3")

    val listaDisponibles = biblioteca.retornarPorEstado(Estado.DISPONIBLE)
    val listaPrestados = biblioteca.retornarPorEstado(Estado.PRESTADO)

    consola.mostrarMensaje("\nLista Disponibles")
    consola.mostrarLista(listaDisponibles)

    consola.mostrarMensaje("\nLista Prestados")
    consola.mostrarLista(listaPrestados)



}