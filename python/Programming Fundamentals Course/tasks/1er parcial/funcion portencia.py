def potencia(b,e):
    if e==0:
        return 1
    else:
        v=b
        while e!=1 :
            v=v*b
            e-=1
        return v
b=int(input("Ingrese base: "))
e=int(input("Ingrese exponente: "))
print(pow(b,e))
v=potencia(b,e)
print("EL valor es %d " % v)
#page94
