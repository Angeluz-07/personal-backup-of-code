/*
	Linux uses a dedicated 'tempfs' file system mounted under the directory /dev/shm. 
	This file system has kernel persistence.

*/
#include <fcntl.h>	/* Defines O_* constants */
#include <sys/stat.h>	/* Defines mode constants */
#include <sys/mman.h>

#include <string.h> 
#include <stdio.h> 
#include <stdlib.h> 


#include <unistd.h> 

#include <errno.h> 
int main(){
	/* the size (in bytes) of shared memory object */
  const size_t shm_size = 4096;
	
		int  shm_fd;	/* shared memory file descriptor */
   	
		/* pointer to shared memory obect */
    char* ptr; 
  
    /* create the shared memory object */
    shm_fd = shm_open("my_posix_shm", O_CREAT | O_RDWR, 0666); 
		if(shm_fd==-1){	
			fprintf(stderr, "shm_open error: %s\n", strerror(errno));
		}

		/* set size to shm */
  	if(ftruncate(shm_fd,shm_size)==-1){	
			fprintf(stderr, "ftruncate error: %s\n", strerror(errno));
		}

		/* map shared memory object */
    ptr = mmap(0,shm_size, PROT_WRITE, MAP_SHARED, shm_fd, 0); 
		if(ptr==MAP_FAILED){
			fprintf(stderr, "mmap error: %s\n", strerror(errno));		
		}
	
  	/* shm_fd is no longer needed */
		close(shm_fd);

    /* write to the shared memory object */	
		size_t len = strlen("hello moto.");
		printf("copying %ld bytes\n", (long) len);
		memcpy(ptr, "hello moto.", len); /* Copy string to shared memory */
		exit(EXIT_SUCCESS);
}
