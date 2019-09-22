f=open("p.txt","r")
palabras=[]
for line in f:
    line=line.strip()
    line=line.strip(".")
    l=line.split(" ")
    for elem in l:
        palabras.append(elem)
f.close()
palabras.reverse()
f2=open("invertido.txt","w")
for c in palabras:
    f2.write(c+" ")
f2.close()
