#_author= Alejandro Mena ,Program 5
g=1
n=float(input("Ingrese el valor al que le quiere sacar la raiz: "))
r=float(input("Ingrese un valor para la raiz: "))
gp=g-(pow(g,r)-n)/(r*pow(g,r-1))
while True:
    if abs(gp-g)<pow(10,-10):
        break
    else:
        g+=1
        gp=g-(pow(g,r)-n)/(r*pow(g,r-1))
print ("el resultado es %.1f" % gp)
input()
