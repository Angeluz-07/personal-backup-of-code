#include <fcntl.h>	/* Defines O_* constants */
#include <sys/stat.h>	/* Defines mode constants */
#include <sys/mman.h>

#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 


#include <unistd.h> 

#include <errno.h> 
int main(){
		int shm_fd;
		struct stat sb;//to get size in bytes of existing shm
		char *addr;

	/* Open existing object */
		shm_fd = shm_open("my_posix_shm", O_RDONLY, 0666);		
		if(shm_fd==-1){	
			fprintf(stderr, "shm_open error: %s\n", strerror(errno));
		}

	/* Use shared memory object size as length argument for mmap()
		and as number of bytes to write() */
		if (fstat(shm_fd, &sb) == -1){	
			fprintf(stderr, "fstat error: %s\n", strerror(errno));
		}

	addr = mmap(NULL, sb.st_size, PROT_READ, MAP_SHARED, shm_fd, 0);
	if (addr == MAP_FAILED){
			fprintf(stderr, "mmap error: %s\n", strerror(errno));		
		}
	
  	/* shm_fd is no longer needed */
		close(shm_fd);
  
		write(STDOUT_FILENO, addr, sb.st_size);
		printf("\n");
		exit(EXIT_SUCCESS);
}
