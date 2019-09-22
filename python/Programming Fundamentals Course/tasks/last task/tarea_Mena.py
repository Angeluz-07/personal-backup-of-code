#https://www.quora.com/How-do-I-install-urllib-and-urllib2-for-Python-3-3-2
#http://www.pythonforbeginners.com/python-on-the-web/how-to-use-urllib2-in-python/
#http://stackoverflow.com/questions/1393324/in-python-given-a-url-to-a-text-file-what-is-the-simplest-way-to-read-the-cont
from urllib.request import urlopen
page=urlopen("http://www.espol.edu.ec/")
for line in page:
    l=str(line)
    if "img src" in l:
        break
a=l.split("src=")
b=a[1].split('"')
print("A continuacion el resultado del tema 2...")
print(b[1])

#http://code.activestate.com/recipes/577591-conversion-of-pil-image-and-numpy-array/
#A matriz numpy
from PIL import Image
from numpy import array
img = Image.open("sherlock.jpg")
m = array(img)
print("Aqui imprimo la matriz numpy de la imagen...")
print(m)

#http://stackoverflow.com/questions/12201577/how-can-i-convert-an-rgb-image-into-grayscale-in-python
#A escala de grises
from PIL import Image
img = Image.open('sherlock.jpg').convert('L')
img.save('sherlockGrey.jpg')
