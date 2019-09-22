#cajamagica
import numpy as np
def isMagicBox(m):
    valCols=m.sum(axis=0)
    a=valCols[0]
    for elem in valCols:
        if elem!=a:
            return False
    valRows=m.sum(axis=1)
    for elem in valRows:
        if elem!=a:
            return False
    if m.trace()!=a:
        return False        
    secondDiag=m[:,::-1].trace()
    if secondDiag!=a:
        return False
    return True

a=np.array([[1,2,3],[4,5,6],[6,7,8]],dtype=int)
b=np.array([[4,9,2],[3,5,7],[8,1,6]],dtype=int)
c=np.array([[16,3,2,13],[5,10,11,8],[9,6,7,12],[4,15,14,1]],dtype=int)
print(isMagicBox(a))
print(isMagicBox(b))
print(isMagicBox(c))

'''#1.recursiva que cambia numeros del 1 al 5 por vocales
def exchangeNumberForVowels(c):
    d={"1":"a","2":"e","3":"i","4":"o","5":"u"}
    string=c
    if string=='':
        return ''
    if string[0] in d:
        return d[string[0]]+exchangeNumberForVowels(string[1:])
    elif len(string)==1:
        return string
    else:
        return string[0]+exchangeNumberForVowels(string[1:])

a=exchangeNumberForVowels("v1c1c34n2s")
print(a)
a=exchangeNumberForVowels("m5rc32l1g4")
print(a)'''


