n=int(input("n:"))
'''# triangulo invertido, derecha
for i in range (1,n+1):
    for j in range(1,n+1):
        if j<i:
            print(" ", end="")
        else:
            print("*", end="")
    print("\n")'''

'''triangulo invertido izquierda
for i in range (1,n+1):
    for j in range(1,i-n,-1):
        print ("*", end="")
    print("\n")'''
        
