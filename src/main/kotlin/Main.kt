package org.example

import GestorBiblioteca
import GestorCatalogo
import GestorRegistros
import GestorConsola
import GestorUsuarios
import Libro
import Usuario
import UtilidadesBiblioteca

fun main() {

    val consola = GestorConsola()


    val biblioteca = GestorBiblioteca(GestorCatalogo(),GestorRegistros(),consola,GestorUsuarios())
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"El silbon de torres","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"Achili Pum","migue","17/03/2020","Terror"))
    biblioteca.agregarLibroCatalogo(Libro(UtilidadesBiblioteca.generarIdentificadorUnicoLibro(),"lA bYda es un toMVola","migue","17/03/2020","Terror"))

    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"fran"))
    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"andres"))
    biblioteca.agregarUsuario(Usuario(UtilidadesBiblioteca.generarIdentificadorUnicoUsuario(),"ivan"))

    biblioteca.registrarPrestamo("1","1")
    biblioteca.registrarPrestamo("2","1")

    biblioteca.devolverLibro("2","1")
    biblioteca.devolverLibro("3","1")


    val listaDisponibles = biblioteca.retornarPorEstado(Estado.DISPONIBLE)
    val listaPrestados = biblioteca.retornarPorEstado(Estado.PRESTADO)

    consola.mostrarMensaje("\nLista Disponibles")
    consola.mostrarLista(listaDisponibles)

    consola.mostrarMensaje("\nLista Prestados")
    consola.mostrarLista(listaPrestados)



}