def polinomio(numero,x):
    l=[]
    while numero!=0:
        digito=numero%10
        l.insert(0,digito)
        numero=numero//10
    v=0
    for i in range(len(l)):
        v=v+(l[i]*pow(x,i))
    return v
n=int(input("Ingrese numero: "))
x=int(input("Ingrese numero: "))
v=polinomio(n,x)
print (v)
