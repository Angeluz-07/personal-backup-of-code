import numpy as np
from random import *
def printMenu():#listo
    print("1]Jugar")
    print("2]Mostrar tipos de barcos")
    print("3]Salir")
    print("Seleccione una opcion por favor:",end="")
    
def cargarArchivo(nomImputFile):
    f=open(nomImputFile,"r")
    d={}
    for line in f:
        line=line.strip()
        a,b,c= line.split(",")#[pais, capital, puntos ] o [hint,objeto en el Mar,puntos]
        d[a]=(b,int(c))
    f.close()
    return d
def crearBarcos(barcosTipo):#{100: {'desplazamientos': [(0, 0), (1, 0), (2, 0)]}, 405: {'desplazamientos': [(0, 0), (1, 0), (1, 1), (1, 2)]}, 270: {'desplazamientos': [(0, 0), (-1, 0), (-2, 0)]}, 303: {'desplazamientos': [(0, 0), (1, 0), (1, -1)]}}
    l=list(barcosTipo.keys())#[100,405,270,303]
    numB=choice(l)
    b=barcosTipo[numB].copy()
    b["tipo"]=numB
    return b
def colocarBarco(b,mar,n):#arreglar hay que ver si se cumple para demas barcos
    r,c=mar.shape#
    marValidar=np.zeros((r+2,c+2))##
    marValidar[-2:,:]=1
    marValidar[:,-2:]=1
    posF,posC=randint(0,r-1),randint(0,c-1)
    pos=np.reshape((posF,posC),(1,2))#
    desp=b["desplazamientos"]
    tam=len(desp)
    desplazamientos=np.reshape(desp,(tam,2))
    coordenadas=desplazamientos+pos
    while True:
        if not marValidar[coordenadas[:,0],coordenadas[:,1]].any():
            if not mar[coordenadas[:,0],coordenadas[:,1]].any():
                break
        posF,posC=randint(0,r-1),randint(0,c-1)
        pos=np.reshape((posF,posC),(1,2))
        desp=b["desplazamientos"]
        tam=len(desp)
        desplazamientos=np.reshape(desp,(tam,2))
        coordenadas=desplazamientos+pos
    mar[coordenadas[:,0],coordenadas[:,1]]=n
    return coordenadas
def asignarPais(paises):#{"colombia":(cali,2),"ecuador":(quito,3)...}
    l=list(paises.keys())
    pais=choice(l)#selecciona un pais al azar
    capital=paises[pais][0]#toma la capital de ese pais
    return(pais,capital)
def colocarFondoMar(objetosDelMar,dimDeTablero):
    #objetosDelMar={roca formada en el mar:(arrecife, 4),amigadenemo:(...}
    #ahora creo una matriz con numeros de 1 al 100
    fondoMar=np.reshape(range(1,dimDeTablero**2+1),(dimDeTablero,dimDeTablero))#pilas que lo manda aparentemente int
    d={}
    for i in range(len(fondoMar)):
        for j in range(len(fondoMar[i])):
            v=randint(0,1)
            if v==0:
                fondoMar[i,j]=0
            elif v==1:
                l=list(objetosDelMar.keys())
                v2=choice(l)
                d[fondoMar[i,j]]=(v2,objetosDelMar[v2][0],objetosDelMar[v2][1])#{3:(roca formada en el mar,arrecife,5)
    return fondoMar,d#retorna el fondoMar y el diccionario de los objetos que hay alli, con un numero como su llave.
def printTablero(mar,c="~",marco="@"):#recibe mar y lo imprime en terminos de -,x y otro caracter
    #aqui considero que -2 representa en el mar, un disparo fallido.
    filas,columnas=mar.shape
    lineaHorizontal=(marco*columnas)*2+marco*2
    print(lineaHorizontal)
    for row in mar:
        print(marco,end="")
        for value in row:
            if value==-1:
                print("x","",end="")
            elif value==-2:
                print("-","",end="")
            else :
                print(c,"",end="")
        print(marco)
    print(lineaHorizontal)
def coordinate(cadena):
    l=cadena.split(",")#['ATACAR','1','2']
    i=int(l[1])-1
    j=int(l[2])-1
    return (i,j)
def acerto(coordenadas,mar):#(2,3)
    if mar[coordenadas]==0 or mar[coordenadas]==-1 or mar[coordenadas]==-2:
        return False
    return True
def editarMar(coordenadas,mar,newValue):
    mar[coordenadas]=newValue
def hundioBarco(posicionesDeBarcoEnMar,mar):#array([[3, 5],[2, 5],[1, 5]])
    l=[]
    for elem in posicionesDeBarcoEnMar:
        l.append(mar[tuple(elem)])
    for elem in l:
        if elem!=-1:
            return False
    return True
def generarScores(alias,puntos,objetosEncontrados,fecha):#objetosEncontrados es lista
	f=open("puntajes.txt","w")
	f.write("Alias:"+alias+"\n")
	f.write("Puntaje:"+puntos+"\n")
	f.write("Fecha de ultimo juego:"+puntos+"\n")
	f.write("Objetos Encontrados:")
	for objeto in objetosEncontrados:
		f.write(objeto)
		if objeto!=objetosEncontrados[-1]:#si es el ultimo objeto no le pongo coma.
			print(",")
	f.close()
def validateOption():
	while True:
		try:
			option=int(input())
		except ValueError:
			print("Por favor ingrese una opcion valida...",end="")
			continue
		if option!=1 and option!=2 and option!=3:
			print("Por favor ingrese una opcion valida...",end="")
			continue
		else:
			return option
def validateCadena(mensaje,dimDeTablero):#debe tener formato 'cadena,#,#' dimDeTablero=10
    while True:
        cadena=input(mensaje)
        try:
            comando,n1,n2=cadena.split(",")
            n1=int(n1)
            n2=int(n2)
        except ValueError:
            print("Por favor ingrese una opcion de acuerdo a los comandos validos e intentelo de nuevo.")
            print("Aviso:verifique que las coordenadas estan en un rango valido para el tablero.")
            continue
        if comando!="ATACAR" or n1<=0 or n1>dimDeTablero or n2<=0 or n2>dimDeTablero:
            print("Por favor ingrese una opcion de acuerdo a los comandos validos e intentelo de nuevo.")
            print("Aviso:verifique que las coordenadas estan en un rango valido para el tablero.")
            continue
        return cadena
def consultarTipoDeBarco(dict):
    tipodeBarco=list(dict.keys())
    for elem in tipodeBarco:
        if elem==100:
            print("Tipo",(elem))
            print("|.|")
            print("|-|")
            print("|-|")
            print()
        if elem==405:
            print("Tipo",(elem))
            print("|.|")
            print("|-|-|-|")
            print()
        if elem==270:
            print("Tipo",(elem))
            print("|-|")
            print("|-|")
            print("|.|")
            print()
        if elem==303:
            print("Tipo",(elem))
            print("  |.|")
            print("|-|-|")
            print()
