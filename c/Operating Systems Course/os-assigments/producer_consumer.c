#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>
#include <time.h>

#define BUFFER_SIZE 5
typedef int buffer_item;
/* 
	Solution to producer-consumer problem.
	
	References:
	Abraham Silberschatz - Operating System Concepts - 9th - 2012
	
	Code adapted from:
	https://github.com/stackptr/operating-systems/tree/master/proj3
*/
// Global variables
buffer_item buffer[BUFFER_SIZE];
pthread_mutex_t mutex;
sem_t full, empty;
int in, out, count;//count is the number of elements currently in the buffer

// Function prototypes
int insert_item(buffer_item item);
int remove_item(buffer_item *item);
void *consumer(void *param);
void *producer(void *param);

int main(int argc, char *argv[]) {
	
  int i;  
  
  if (argc != 4){
    printf("usage: ./a.out <sleep time> <# producer threads> <# consumer threads>\n");
    exit(0);
  }
   
  //Get arguments
  int stime = atoi(argv[1]);
  int num_producer = atoi(argv[2]);
  int num_consumer = atoi(argv[3]);
  
  //Initialize producer consumer facilites  
  srand(time(NULL));//seeding random generator   
  pthread_mutex_init(&mutex, NULL);// create the mutex lock   
  sem_init(&empty, 0, BUFFER_SIZE);// create the 'empty' semaphore and initialize it to BUFFER_SIZE 
  sem_init(&full, 0, 0);// create the 'full' semaphore and initialize it to 0    
  count = in = out = 0;
  
  // Create the producer and consumer threads
  pthread_t producers[num_producer];
  pthread_t consumers[num_consumer];
  for(i = 0; i < num_producer; i++)
    pthread_create(&producers[i], NULL, producer, NULL);
  for(i = 0; i < num_consumer; i++)
    pthread_create(&consumers[i], NULL, consumer, NULL);

  // Sleep before terminating
  sleep(stime);
  return 0;
}


/* insert item into buffer
return 0 if successful, otherwise
return -1 indicating an error condition */
int insert_item(buffer_item item){
  int success; 
  
  sem_wait(&empty);
  pthread_mutex_lock(&mutex);

  /* critical section */  
  // add item to buffer
  if( count != BUFFER_SIZE){
    buffer[in] = item;
    in = (in + 1) % BUFFER_SIZE;
    count++;
    success = 0;
  }
  else
    success = -1;  
  /* critical section */

  pthread_mutex_unlock(&mutex);
  sem_post(&full);
  
  return success;
}

/* remove an object from buffer
placing it in item
return 0 if successful, otherwise
return -1 indicating an error condition */
int remove_item(buffer_item *item){
  int success;
  
  sem_wait(&full);
  pthread_mutex_lock(&mutex);
  
  /* critical section */
  // remove object from buffer to item
  if( count != 0){
    *item = buffer[out];
    out = (out + 1) % BUFFER_SIZE;
    count--;
    success = 0;
  }
  else
    success = -1;
  /* critical section */
  
  pthread_mutex_unlock(&mutex);
  sem_post(&empty);
  
  return success;
}

void *producer(void *param){
  buffer_item item;
  while(1){
    sleep(rand() % 5 + 1); // Sleep randomly between 1 and 5 seconds
    
	/* produce an item */
    item = rand(); //produces random integers between 0 and RAND_MAX. 
    if(insert_item(item))
      printf("Error occured in producer\n");
    else
      printf("Producer produced %d\n", item);
  }
}

void *consumer(void *param){
  buffer_item item;
  while(1){
    sleep(rand() % 5 + 1); // Sleep randomly between 1 and 5 seconds
	
	/* consume an item */
    if(remove_item(&item))
      printf("Error occured in consumer\n");
    else
      printf("Consumer consumed %d\n", item);
  }
}