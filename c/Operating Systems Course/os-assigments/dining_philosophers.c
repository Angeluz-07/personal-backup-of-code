#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>
#include <time.h>

#define N 5

/* 
	Solution to dining philosophers problem by allowing at most N-1 philosophers in 
	the table, given N number of chopsticks. Further analysis is required to ensure
	non-starvation.
	
	References:
	Abraham Silberschatz - Operating System Concepts - 9th - 2012
	https://es.wikipedia.org/wiki/Problema_de_la_cena_de_los_fil%C3%B3sofos#Diversas_soluciones_posibles
	https://www.youtube.com/watch?v=pU3fjsQtk-U
	https://gist.github.com/pseudomuto/9307707
	http://web.eecs.utk.edu/~mbeck/classes/cs560/560/notes/Dphil/lecture.html
*/

sem_t chopstick[N];
sem_t room;

void *philosopher(void *param);

int main(){
	int i;
	int stime;

	stime=30;

	//init process synchronization facilities
	srand(time(NULL));//seeding random generator    
	sem_init(&room, 0, N-1);// create the 'room' semaphore, must be initialized it to N-1 to avoid deadlock
	for(i = 0; i < N; i++)
		sem_init(&chopstick[i], 0, 1);//init N binary semaphores

	//create array of threads
	pthread_t philosophers[N];
	int phil_id[N];
	
	//spread philosopher threads
	for(i = 0; i < N; i++){
		phil_id[i]=i;
		pthread_create(&philosophers[i], NULL,philosopher,&phil_id[i]);
	}

	// Sleep before terminating
	sleep(stime);
	return 0;
}

void *philosopher(void *param){
	int i =*((int*)param);
	
	do{	
		sem_wait(&room);
		sem_wait(&chopstick[i]);		
		sem_wait(&chopstick[(i+1)%N]);
		
		/* eat for a while */
		printf("Philosopher[%d] eating for a while.\n",i);
		sleep(rand() % 5 + 1); // Sleep randomly between 1 and 5 seconds
		
		
		sem_post(&chopstick[i]);		
		sem_post(&chopstick[(i+1)%N]);		
		sem_post(&room);
		
		/* think for a while */
		printf("Philosopher[%d] thinking for a while.\n",i);
		sleep(rand() % 5 + 1); // Sleep randomly between 1 and 5 seconds
		
	}while(1);
}