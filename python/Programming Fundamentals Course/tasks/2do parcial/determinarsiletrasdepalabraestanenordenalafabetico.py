word=""
while word!="salir":
    word=input("cadena: ")
    l=[]
    for c in word:
        l.insert(0,c)
    l.sort()
    t=""
    for c in l:
        t+=c
    if t==word:
        print("1")
    else:
        print("0")
