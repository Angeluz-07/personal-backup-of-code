#_author= Alejandro Mena ,Program 4
val=float(input("Por favor ingresa un numero: "))
n=1
z=(2*n)-1
if val==0:
    print("El valor %.1f es un cuadrado exacto." % val)
else:
    while True :
        if val>z:
            n+=1
            z=z+((2*n)-1)
        elif val==z:
            print("El valor %.1f es un cuadrado exacto." % val)
            break
        else:
            print("El valor %.1f no es un cuadrado exacto." % val)
            break
input()
