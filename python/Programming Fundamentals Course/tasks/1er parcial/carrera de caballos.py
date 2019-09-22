import random
    
def ponerEnTerreno(l,v,n):
    for i in range(n):
        pos=random.randrange(len(l))
        while l[pos]!=0:
            pos=random.randrange(len(l))
        l[pos]=v

def llenarPistas(l):
    #l=[0]*50
    ponerEnTerreno(l,1,2)
    ponerEnTerreno(l,-1,2)
    
p=[0]*50
c1=10
c2=20
llenarPistas(p)
print(p)
