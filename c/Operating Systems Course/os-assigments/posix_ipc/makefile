all: posix_shm_creat posix_shm_read

#uset tabs on directives
#linking is done when input is an object file
posix_shm_creat:posix_shm_creat.o
	cc posix_shm_creat.o -o posix_shm_creat -lrt

posix_shm_read: posix_shm_read.o
	cc posix_shm_read.o -o posix_shm_read -lrt


#compile to object files
posix_shm_creat.o: posix_shm_creat.c
	cc -c posix_shm_creat.c 

posix_shm_read.o:posix_shm_read.c
	cc -c posix_shm_read.c

clean:
	rm *.o  manager corrector lector sensor
