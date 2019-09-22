#_author= Alejandro Mena ,Program3
import random
a=random.randint(1,100)
nInt=0
print("Hola campeon, se ha generado un numero aleatorio entre 1 y 100")
val=int(input("Trata de adivinar que numero es: "))
while val!=a:
    nInt+=1
    if val>a:
        print("El valor es alto")
        val=int(input("Ingresa un numero menor: "))
    else:
        print("El valor es bajo")
        val=int(input("Ingresa un numero mayor: "))

print("!Felicidades! acertaste el numero %d en %d intentos" % (val,nInt))
input()
