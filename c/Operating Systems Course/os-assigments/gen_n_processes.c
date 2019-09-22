
/*
	usage: ./a.out n	
	n: number of processes to create.

	desc.: generates n processes and wait for them.
*/
#include <stdio.h>

#include <string.h>
#include <errno.h>
/*
	errno: global integer variable to indicate what went wrong.
*/

#include <sys/types.h>
#include <unistd.h>
/*
	getpid()
	getppid()
	fork()
*/

#include <sys/wait.h>
/*
	wait()
*/
#include <stdlib.h>
/*
	exit()
*/

int main(int argc, char* argv[]){

	if(argc!=2){
		fprintf(stderr,"usage : ./a.out n\n");//stderr, the standar output error
		fprintf(stderr,"n stands for number of processes to create\n");
		return 1;//return different from 0 means error
	}

	pid_t pid;

	int n=atoi(argv[1]);
	int i;
	
	for(i=1;i<=n;i++){
		
		if( (pid=fork()) < 0 ){
			fprintf(stderr,"fork error: %s\n",strerror(errno));
			exit(EXIT_FAILURE);//EXIT_FAILURE, variable for portability.
		}

		/* Code executed by child */
		if(pid==0){
			printf("Child PID is %ld and i is= %d \n", (long) getpid(),i);			
			exit(EXIT_SUCCESS);
		}
	}
	for(i=1;i<=n;i++){
		wait(NULL);
		/*
 		fprintf(stderr,"Waiting in the father %ld for child %ld\n",(long) getpid(),cpid_array[i]);
	    w = waitpid(cpid_array[i], &status, WUNTRACED | WCONTINUED);
		fprintf(stderr,"Child finished \n");*/
	}
	printf("I'm your father\n");
	exit(EXIT_SUCCESS);
}
	
