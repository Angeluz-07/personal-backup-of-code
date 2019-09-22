#_author= Alejandro Mena ,Program2
a=2
n=0
val=int(input("Por favor ingrese un valor entero: "))
if val>1:
    while a**n < val:
        n+=1
    b=2**(n-1)
    print("La mayor potencia de 2, que es menor al valor que usted ingreso es: ", b)
elif val==1:
    b=2**(n-1)
    print("La mayor potencia de 2, que es menor al valor que usted ingreso es: ", b)
else:
    print("No existe tal numero")
#El programa ha sido escrito excluyendo todos los casos donde el usuario ingresa datos flotantes
input()
