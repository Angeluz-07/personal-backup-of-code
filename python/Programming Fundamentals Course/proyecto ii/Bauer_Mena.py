import numpy as np
from random import *
from funciones import *
barcosTipo={}#{100: {'desplazamientos': [(0, 0), (1, 0), (2, 0)]}, 405: {'desplazamientos': [(0, 0), (1, 0), (1, 1), (1, 2)]}, 270: {'desplazamientos': [(0, 0), (-1, 0), (-2, 0)]}, 303: {'desplazamientos': [(0, 0), (1, 0), (1, -1)]}}
barcosTipo[100]={"desplazamientos":[(0,0),(1,0),(2,0)]}
barcosTipo[303]={"desplazamientos":[(0,0),(1,0),(1,-1)]}
barcosTipo[270]={"desplazamientos":[(0,0),(-1,0),(-2,0)]}
barcosTipo[405]={"desplazamientos":[(0,0),(1,0),(1,1),(1,2)]}
while True:
    printMenu()
    option=validateOption()#
    if option==3:
	    break
    if option==1:
        alias=input("Ingrese su alias:")#
        fecha=input("Ingrese la fecha de hoy en el formato 'dd/mm/aaaa':")#
        #aqui abajo va un dicc con:tipo de barco,#de barco(1,2..),coordenadas en mar,
        #estadode barco(intacto,...),pais que pertenece,pos golpeadas.
        diccDeBarcos={}
        numeroDeBarcosMas1=5# #de barcos a colocar
        dimDeTablero=10#dimension del tablero, se asume que sera siempre cuadrado
        mar=np.zeros((dimDeTablero,dimDeTablero),dtype=int)#se crea mar con ceros
        paises=cargarArchivo("Paises.txt")#cargamos paises en un arreglo matriz(diccionario)
        for i in range(1,numeroDeBarcosMas1):
            diccDeBarcos[i]={}#creo un dicc dentro, donde la llave es,
            #el numero del barco que se genero
            b=crearBarcos(barcosTipo)#escoge al azar un dic,
            #ejemplo{"desplazamientos":[(0, 0), (1, 0), (2, 0)],"tipo":100}
            diccDeBarcos[i]["posicionesDeBarcoEnMar"]=colocarBarco(b,mar,i)#coloca,
            #el barco en el mar y retorna un arreglo con las posiciones donde lo coloco.
            diccDeBarcos[i]["tipo"]=b["tipo"]#aqui guardo el tipo de barco,ejemplo["tipo":100]
            diccDeBarcos[i]["pais_capital"]=asignarPais(paises)#devuelve tupla con(pais,capital)y asigno el pais,
            #con su capital, que se genero aleatoriamente
            diccDeBarcos[i]["estado"]="intacto"#asigno estado inicial
            diccDeBarcos[i]["posicionesGolpeadas"]=""#vacio, al inicio no hay posiciones golpeadas
        marInicial=mar.copy()
        objetosDelMar=cargarArchivo("Objetos del mar.txt")
        fondoMar,diccDeObjetosEnMar=colocarFondoMar(objetosDelMar,dimDeTablero)#crea una matriz,
        #con igual dimension que mar, pero almacena los objetos. y un dicc para saber que objetos hay
        printTablero(mar)#imprime el tablero que ve el usuario, de acuerdo,
        #al estado del mar, -2=disparo fallido,-1=disparo acertado.
        print(mar)
        #print(fondoMar) #este es el mar donde estan los objetos
        cadena="default"
        puntos=0
        numeroDeBarcosHundidos=0
        objetosEncontrados=[]
        while True:
            cadena=validateCadena("Ingrese las coordenadas donde quiere atacar de acuerdo al formato 'ATACAR,i,j' o el comando 'FIN' para salir:",dimDeTablero)#coordenada donde quiere atacar#validar
            if cadena=="FIN":
                break
            coordenadas=coordinate(cadena)#toma la cadena ingresada y retorna las coordenadas
            if acerto(coordenadas,mar):#esta funcion me dice si acerto
                puntos+=2
                print("HIT!")
                barcoAtacado=mar[coordenadas]#obtengo el numero del barco que se ataco
                editarMar(coordenadas,mar,-1)#se edita el mar con el lugar atacado
                marFinal=mar.copy()#lo pongo aqui porque puede que hunda todos los barcos despues del ultimo disparo.
                if hundioBarco(diccDeBarcos[barcoAtacado]["posicionesDeBarcoEnMar"],mar):
                    numeroDeBarcosHundidos+=1
                    if numeroDeBarcosHundidos==(numeroDeBarcosMas1-1):
                        break
                    puntos+=5
                    #le mando el arreglo con posiciones del barco que se ataco.
                    print("Wowww!! HUNDIDO!!")
                    capital=input("Este barco le pertenece a %s, y su capital es?: "% diccDeBarcos[barcoAtacado]["pais_capital"][0])#
                    if capital==diccDeBarcos[barcoAtacado]["pais_capital"][1]:
                        puntos+=3
                        print("Genial 3 puntos!!")
                    else:
                        puntos-=7
                        print("Lastima, hubiera leido ese libro de historia. Ahora pierdo 7 puntos :(")
            if mar[coordenadas]!=-1:#solo si en esa pos no hay un barco golpeado, edito el mar
                editarMar(coordenadas,mar,-2)
            objetoEnMar=fondoMar[coordenadas]
            print("...parece que hay un objeto aqui")
            if objetoEnMar!=0:#si entra significa que hay objeto alli
                objetosEncontrados.append(diccDeObjetosEnMar[objetoEnMar][1])#almaceno el objeto
                print("¡oh! una pista:%s"% diccDeObjetosEnMar[objetoEnMar][0])
                objeto=input("¿Cual crees que sea el objeto?:")#
                if objeto==diccDeObjetosEnMar[objetoEnMar][1]:#verifica que acierte
                    puntos+=diccDeObjetosEnMar[objetoEnMar][2]#le sumo los puntos asociados al objeto
                    print("¡Genial! adivinamos :)")
                else:
                    print("Que mal!! nos perdimos ese objeto :(")
                fondoMar[coordenadas]=0#elimino ese objeto, para que no entre de nuevo.
            else:
                print("No, no hay nada")
            printTablero(mar)
            print("Llevas %d puntos y %d barcos hundidos"% (puntos,numeroDeBarcosHundidos))
            print(mar)
        print("Fin del juego. Este es la distribucion de barcos inicial.")
        print(marInicial)
        print("Y esta la distribucion de barcos el tablero final")# ¿Solo presento el mar final?
        print("Donde -1 representa un disparo acertado y -2 un disparo fallido")
        print(marFinal)
        generarScores(alias,str(puntos),objetosEncontrados,fecha)
    if option==2:
        consultarTipoDeBarco(barcosTipo)

'''#ejemplos de los diccionarios:
#diccDeBarcos={1: {'posicionesGolpeadas': '', 'tipo': 405, 'pais_capital': ('Estados Unidos', ' WashingtonDC'),
'posicionesDeBarcoEnMar': array([[7, 0],[8, 0],[8, 1],[8, 2]]), 'estado': 'intacto'}
, 2: {'posicionesGolpeadas': '', 'tipo': 270, 'pais_capital': ('Turquia', ' Ankara'),
'posicionesDeBarcoEnMar': array([[7, 7],[6, 7],[5, 7]]), 'estado': 'intacto'}
, 3: {'posicionesGolpeadas': '', 'tipo': 100, 'pais_capital': ('Brasil', ' Brasilia'),
'posicionesDeBarcoEnMar': array([[1, 3],[2, 3],[3, 3]]), 'estado': 'intacto'}
, 4: {'posicionesGolpeadas': '', 'tipo': 100, 'pais_capital': ('Canada', ' Ottawa'),
'posicionesDeBarcoEnMar': array([[2, 6],[3, 6],[4, 6]]), 'estado': 'intacto'}}
#diccDeObjetosEnMar={1: ('Amiga de Nemo', ' Dory', 5),
 13: ('Conocido como lobos de agua', ' pirana', 5), 
 22: ('De cuerpo gelatinoso con forma de campana', ' medusa', 2), 
 31: ('Pequeno animal que pasa su vida fijo a las rocas', ' coral', 7),
 45: ('Conocido como lobos de agua', ' pirana', 5), 
 59: ('Pez que habita en fondos rocosos', ' Vieja', 5), 
 60: ('Cetaceos que utilizan los sonidos la danza y el salto para comunicarse', ' delfin', 3), 61: ('Pez de cuerpo alargado', ' anguila', 3), 
 71: ('Depredadores del mar', ' tiburon', 5)
 83: ('Depredadores del mar', ' tiburon', 5)
 98: ('Posee cientos de tentáculos que les permiten identificar sus alrededores', ' anemona', 5)}
#Aviso: no se ha usado "estado" y "posicionesGolpeadas" de diccDeBarcos
'''
