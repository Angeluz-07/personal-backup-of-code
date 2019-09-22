__author__ = 'Alejandro Mena'
''' # Leccion que hize :(
nume = int(input("ingrese un numero:"))
L1 = []
while ((nume%10)!=0):
    L1.append(nume%10)
L2 = L1[:]
L1.sort(reverse=True)
print(L1)
L2.sort()
for i in range(len(L2)+1):
    if (i%2 == 0):
        L3=L2[i]
print (L3)
'''
#Leccion Bien hecha :)
n = int(input("Ingrese un numero:"))
L1 = []
while (n!=0):
    v=n%10
    L1.append(v)
    n=n//10       # aprender a descomponer este numero
L1.reverse()
L2 = L1[:] #aqui va con corchetes
L1.sort(reverse=True)
L2=L2[0::2] #slicin, repasar.
L2.sort()
print ("EL resultado 1 es : " , end="")
for i in range(len(L1)): #repasar paramatros del lazo for
    print(L1[i],end="")
print ("\nEL resultado 2 es : " , end="") # repasar end=""
for i in range(len(L2)):
    print(L2[i],end="")
