
#include <stdio.h>

#include <string.h>
#include <errno.h>
#include <sys/types.h>
#include <unistd.h>
/*
	getpid()
	getppid()
	fork()
	sleep()
	pause()
*/

#include <sys/wait.h>
#include <stdlib.h>
/*
	exit()
*/
#include <signal.h>

/*
		spawn n processes
*/
void spawn_processes(int n){
	pid_t pid;
	/* creating children processes */
	for(int i=1;i<=n;i++){
		
		/* check fork() properly done*/
		if( (pid=fork()) < 0 ){
			/* unix-style error */
			fprintf(stderr,"fork error: %s\n",strerror(errno));
			exit(EXIT_FAILURE);
		}

		/* kill -9 signals to children don't affect the parent.*/
		/* Code executed by child */
		if(pid==0){
			printf("Child PID is %ld and Parent PID is= %ld \n", (long) getpid(),(long) getppid());
			while(1){ sleep(5); } /* work done by the process*/
		}
	}
}

/* handler is executed, either parent is running or not. */
void sig_handler(int sig){
		/* as sig_handler doesn't return, there's no need to save errno */
		printf("Child PID entering the handler is %ld \n", (long) getpid());		
		/* terminate process on signal received */
		exit(EXIT_SUCCESS);
}

int main(int argc, char* argv[]){

	/* check usage properly done*/
	if(argc!=2){
		fprintf(stderr,"usage : ./a.out n\n");
		fprintf(stderr,"n stands for number of processes to create\n");
		return 1;//return different from 0 means error
	}

	/* check installing handler properly done*/
	/* used SIGUSR1 i.e 10 */
	if( signal(SIGUSR1,sig_handler) == SIG_ERR){
		/* unix-style error */
		fprintf(stderr,"fork error: %s\n",strerror(errno));
		exit(EXIT_FAILURE);	
	}

	
	/* n processes to be created */
	int n=atoi(argv[1]);
	/* create n processes */
	spawn_processes(n);

	/* parent process waits to reap each child */
	int status;
	pid_t t_pid;/*troublesome process*/

	while ((t_pid = waitpid(-1,&status,0)) > 0){
		if(WIFEXITED(status)){
			/* printf works well as long as none other handler interrupts here*/
			printf("Child %d terminated normally with exit status = %d\n",t_pid,WEXITSTATUS(status));
			
			/* 
				If the process was terminated by  a signal SIGUSR1, it'll have 
				an exit status of 0. And a new process will be created in its place.

				Otherwise, the exit status will be different from 0 and the parent 
				process will do nothing.
			*/
			if(WEXITSTATUS(status)==0){
				printf("Creating a new process in place...\n");
				spawn_processes(1);
			}
			/*else do nothing*/
		}else{
			/* printf works well as long as none other handler interrupts here*/
			printf("Child %d terminated abnormally \n",t_pid);			
		}			
	}

	//exit when there's no more children
	exit(EXIT_SUCCESS);
}
	
