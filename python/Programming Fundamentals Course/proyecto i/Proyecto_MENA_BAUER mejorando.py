#__autores_: Joffre Bauer, Alejandro Mena
import random
def mensajeInicio():
	print("Bienvenido, el juego al que ha ingresado es de 2 jugadores el cual consiste en un camino de 20 espacios, ")
	print("el jugador se moverá un número aleatorio de posiciones en cada turno, este no se sobrepasará de los 5 pasos, ")
	print("de acuerdo al movimiento usted puede llegar donde se encuentren algunos premios, entre ellos: ")
	print("un helado, un árbol, cerezas y uvas, si obtiene 2 premios seguidos a excepción de las uvas, ")
	print("obtiene una ganancia de acuerdo a los premios obtenidos y a la apuesta que realizó durante los 2 turnos seguidos,")
	print("puede que alguna posición no posea ningún premio. ")
	print("Usted empezará con 100 monedas y en cada turno tendrá que realizar una apuesta para poder moverse, ")
	print("el jugador que termine primero el camino ganará el juego, si usted llegara a quedarse sin monedas perdería automáticamente. ")
	print("Que empiece el juego!")
def asignarValor(l,aleatorio,pos,valAsignar,a,b):
    if aleatorio>=a and aleatorio<=b :
        l[pos]=valAsignar
def generarCamino():
    camino=list(range(20))
    for i in camino: 
        valorAlea=random.randint(1,50)
        asignarValor(camino,valorAlea,i,7,1,10)
        asignarValor(camino,valorAlea,i,11,11,20)
        asignarValor(camino,valorAlea,i,21,21,30)
        asignarValor(camino,valorAlea,i,39,31,40)
        asignarValor(camino,valorAlea,i,0,41,50)
    return camino
def definirPremio(camino,pos):
	premio=camino[pos-1]
	return premio	
def premioEra(premio,tablaDePremios={7:"una Uva",11:"una Cereza",21:"un Helado",39:"un Arbol"}):#trabajando
    if premio in tablaDePremios:
        print("Aqui habia %s."% tablaDePremios[premio])
    else:
        print("Aqui no habia nada.")
def premioEs(premio,tablaDePremios={7:"una Uva",11:"una Cereza",21:"un Helado",39:"un Arbol"}):#trabajando
    if premio in tablaDePremios:
        print("Aqui hay %s" % tablaDePremios[premio])
        printPremio(premio)
    else:
        print("Que pena, Aqui no hay nada..")
def printPremio(premio):
	if premio==7:
		print(" 0 0 0")
		print("  0 0 ")
		print("   0  ")
	elif premio==11:
		print("   /\ ")
		print("  /  \ ")
		print(" 0    0")    
	elif premio==39:
		print("  /\ ")
		print(" /__\ ")
		print("  ||  ")
	elif premio==21:
		print("  @@@ ")
		print(" (   )")
		print("  \_/ ")    
def espaciosAvanzar():
    espacios=random.randint(1,5)
    return espacios
def mostrarCamino(pos):
	espaciosAntes="-"*(pos-1)
	espaciosDespues="-"*(20-pos)
	print ("%sX%s" % (espaciosAntes,espaciosDespues))
def determinarGanancia(premio,l,apuesta,n,veces):#
	count=0
	ganancia=0
	for elem in l:
		if elem==premio:
			count+=1
			if count==veces:
				ganancia+=apuesta*n
				l.clear()
				break
	return ganancia
def darGanancia(l,apuesta,dineroPendiente,d={39:[2,1],21:[2,2],7:[1,3],11:[2,4]}):#
	ganancia=0
	apuesta+=dineroPendiente
	#for elem in l:
	#	if elem in d:s trabajar aqui
			
	ganancia+=determinarGanancia(39,l,apuesta,1,2)
	ganancia+=determinarGanancia(21,l,apuesta,2,2)
	ganancia+=determinarGanancia(7,l,apuesta,3,1)
	ganancia+=determinarGanancia(11,l,apuesta,4,2)
	if len(l)==2:
		if l[0]==39 and l[1]==21:
			ganancia=apuesta*5
			l.clear()
	return ganancia
def gano(ganado):
	if ganado!=0:
		return True
	return False
def registrarMovGanancia(d,posEnLaQueGano,queGanoEnEsaPosicion,jugadaDondeGano):
	d[posEnLaQueGano]=[queGanoEnEsaPosicion,jugadaDondeGano]
def estaPendiente(l):
		if len(l)==1:
			return True
		return False
def ganoEnEsaPosicion(d,pos):
	if pos in d:
		return True
	return False
def mostrarMensajeGanador(v):
	if v==7:
		print("!Asombroso! Este fruto de la vida te refresca")
	elif v==11:
		print("Estupendo! Esta super fruta te ayuda a recobrar las energías")
	elif v==21:
		print("!Admirable! El camino se encuentra demasiado frio")
	elif v==39:
		print("!Fenomenal! Esto parece ya un bosque")
def validar1(turno,monedas):
	while True:
		try:
			apuesta=int(input("Usted es el jugador %d tiene %d monedas, cuál es su apuesta(0 a 10)?: " % (turno+1,monedas)))
		except ValueError:#(turno+1),jugadores[turno][1]
			print("Debe ingresar un valor numerico. ",end="")
			continue
		if apuesta<=0 or apuesta>10:
			print("No puede apostar eso. ", end="")
			continue
		else:
			return apuesta
def validar2():
	while True:
		try:
			pos=int(input("digite un valor entre 1 y 20 para que observe que habia almacenado \nen esa posicion,si usted gano puntos alli y en que movimiento los gano. \nDigite -1 para salir: "))
		except ValueError:
			print("Debe ingresar un valor numerico. ",end="")
			continue
		if pos<1 or pos>20 :
			print("El camino tiene solo 20 posiciones. ", end="")
			continue
		else:
			return pos
#mensajeInicio()
camino=generarCamino()
print(camino) #puede imprimir la lista si desea verla
premios1=[]
premios2=[]
posicionesDondeGano1={}# la llave es la posicion donde gano
posicionesDondeGano2={}# el valor es una lista con lo que gano en esa posicion y en que jugada
jug1=[0,100,premios1,0,0,posicionesDondeGano1]#1ero la posicion,2do monedas,3ero premios,
jug2=[0,100,premios2,0,0,posicionesDondeGano2]#4to #de veces jugadas,5to dinero pendiente
jugadores=[jug1,jug2] #6to posiciones donde gano
turno=0
while True:	
	apuesta=validar1(turno,jugadores[turno][1])# validando
	jugadores[turno][3]+=1 # numero de veces jugadas
	espaciosavanzar=espaciosAvanzar()# numero de espacios que avanza
	jugadores[turno][0]+=espaciosavanzar
	if jugadores[turno][0]>=20: 
		break #aqui el primero que pase la posicion 20 gana
	mostrarCamino(jugadores[turno][0])
	premio=definirPremio(camino,jugadores[turno][0])#define el premio
	premioEs(premio)
	if premio!=0:#Si no hay en nada en camino no se agrega nada
		jugadores[turno][2].append(premio)#se agrega el premio
	ganado=darGanancia(jugadores[turno][2],apuesta,jugadores[turno][4])
	if gano(ganado):#Solo si se ha ganado algo
		registrarMovGanancia(jugadores[turno][5],jugadores[turno][0],ganado,jugadores[turno][3])
		jugadores[turno][4]=0
		mostrarMensajeGanador(premio)#Mostramos el mensaje ganador
		jugadores[turno][1]+=ganado
		jugadores[turno][1]-=apuesta
	elif estaPendiente(jugadores[turno][2]):# Recibe la lista de premios para revisarla
		jugadores[turno][4]=apuesta
	elif len(jugadores[turno][2])==2:#Como no ha entrado a los otros condiciales estamos seguros de que posee dos elementos o esta vacia
		del jugadores[turno][2][0]#Se elimina el primer elemento y solo queda el ultimo premio que nos sirve para comparar con el que ganemos después
		jugadores[turno][4]=apuesta #se actualiza la nueva apuesta
	if jugadores[turno][1]<=0:
		turno=int(not turno) #Aqui el primero que se le acaben las monedas, pierde. Se cambia el turno porque el turno me dira quien es el ganador
		break
	print("Usted gano %d monedas y ahora tiene %d" % (ganado,jugadores[turno][1]))
	print(jugadores[turno]) #esto es para ver como va nuestro jugador
	turno=int(not turno)

ganador=turno # El jugador ganador es el del turno
perdedor=int(not turno)
print("Felicidades!!! Jugador %d usted es el ganador !!!" % (ganador+1))
print("Jugador %d usted se lleva %d monedas despues de haber jugado %d veces" %((ganador+1),jugadores[ganador][1],jugadores[ganador][3]))
if jugadores[perdedor][1]<=0:#Perdió
	print("Lo lamento jugador %d usted perdio todo su dinero, " % (perdedor+1), end="")
else:
	print("Jugador %d usted tiene %d monedas, " % ((perdedor+1),jugadores[perdedor][1]),end="")
print("despues de haber jugado %d veces" % jugadores[perdedor][3])
print("Ahora Usuario Ganador, ", end="")

while True:
	pos=validar2()
	if pos==-1:
		break
	premio=definirPremio(camino,pos)
	premioEra(premio)#Se indica que premio se encontraba ahí
	if ganoEnEsaPosicion(jugadores[ganador][5],pos):	#Solo entra si ganó algo en esa posición
		puntosGanadosAlli=jugadores[ganador][5][pos][0]
		jugadaNumeroTal=jugadores[ganador][5][pos][1]
		print("Fue su jugada numero %d y usted gano %d monedas" % (jugadaNumeroTal,puntosGanadosAlli))
	else:
		print("Usted no gano nada alli")
    
input("Muchas gracias por jugar, presione enter para salir.")#Terminó el programa




