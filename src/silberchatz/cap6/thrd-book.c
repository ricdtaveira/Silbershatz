/**
 * A simple pthread program illustrating pthread scheduling.
 *
 * Figure 6.9
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

#include <pthread.h>
#include <stdio.h>
#define NUM_THREADS 5


/* the thread runs in this function */
void *runner(void *param); 

int main(int argc, char *argv[])
{
	int i;
	pthread_t tid[NUM_THREADS]; 	/* the thread identifier */
	pthread_attr_t attr; 		/* set of attributes for the thread */

	/* get the default attributes */
	pthread_attr_init(&attr);

	/* set the scheduling algorithm PROCESS or SYSTEM */
	pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);

	/* set the scheduling policy - FIFO, RT, or OTHER */
	pthread_attr_setschedpolicy(&attr, SCHED_OTHER);

	/* create the threads */
	for (i = 0; i < NUM_THREADS; i++) 
		pthread_create(&tid[i],&attr,runner,NULL); 

	/**
	 * Now join on each thread
	 */
	for (i = 0; i < NUM_THREADS; i++) 
		pthread_join(tid[i], NULL);

	printf("Main thread exiting\n");
}

/**
 * The thread will begin control in this function.
 * Each thread will output its own version of "Hello World"
 */
void *runner(void *param) 
{
	printf("I am a thread\n");

	pthread_exit(0);
}

