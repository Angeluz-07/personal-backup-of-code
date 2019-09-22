#_author= Alejandro Mena ,Program1
print("Por favor, a continuacion ingrese tres valores: ")
a=int(input("Valor 1: "))
b=int(input("Valor 2: "))
c=int(input("Valor 3: "))
if a>b and a>c:
    valmax=a
    print("el valor maximo es: ", valmax)
elif b>a and b>c:
    valmax=b
    print("el valor maximo es: ", valmax)
elif c>a and c>b:
    valmax=c
    print("el valor maximo es: ", valmax)
else:
    print("no hay un solo numero mayor")

if a<b and a<c:
    valmin=a
    print("el valor minimo es: ", valmin)
elif b<a and b<c:
    valmin=b
    print("el valor minimo es: ", valmin)
elif c<a and c<b:
    valmin=c
    print("el valor minimo es: ", valmin)
else:
    print("no hay un solo numero menor")
#Miss coloco el input al final para que no se cierre, si es que lo corre directamente.
input()
