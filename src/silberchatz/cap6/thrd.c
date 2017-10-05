/**
 * A simple pthread program illustrating pthread scheduling.
 * This is slightly more interesting than the code in the text
 * as each thread outputs a message in some  language. Furthermore,
 * it also illustrates scheduling priorities.
 *
 * The motivation for the messages output came from:
 * 	http://www.llnl.gov/computing/tutorials/workshops/workshop/pthreads/
 *
 * Usage:
 * 	<gcc | cc> thrd.c -o thrd -lpthread
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

/* The messages output by each thread */
char *greetings[NUM_THREADS];

main(int argc, char *argv[])
{
	int i;
	pthread_t tid[NUM_THREADS]; 	/* the thread identifier */
	int *thread_ids[NUM_THREADS];	/* integer identifiers */	
	pthread_attr_t attr; 		/* set of attributes for the thread */

	struct sched_param thread_param;/* for scheduling */
	int min_pri;
	int max_pri;

	greetings[0] = "English: Hello World";
	greetings[1] = "French: Bonjour, le monde!";
	greetings[2] = "Spanish: Hola al mundo";
	greetings[3] = "German: Guten Tag, Welt!";
	greetings[4] = "Latin: Orbis, te saluto!";

	/* get the default attributes */
	pthread_attr_init(&attr);

#if defined( _POSIX_THREAD_PRIORITY_SCHEDULING) 
	/* set the scheduling algorithm PROCESS or SYSTEM */
	if (pthread_attr_setscope(&attr, PTHREAD_SCOPE_PROCESS) != 0)
		printf("unable to set to PTHREAD_SCOPE_PROCESS\n");

	/* set the scheduling policy - FIFO, RT, or OTHER */
	if (pthread_attr_setschedpolicy(&attr, SCHED_OTHER) != 0)
		printf("unable to set scheduling policy to SCHED_OTHER\n");

	/* get some scheduling priority information */
	if (pthread_attr_getschedparam(&attr, &thread_param) != 0)
		printf("unable to get scheduling info");
	else {
		printf("Before: priority = %d\n",thread_param.sched_priority);
		
		/**
		 * let's alter the priority.
		 * (min + max) / 2
		 */
		min_pri = sched_get_priority_min(SCHED_OTHER);
		max_pri = sched_get_priority_max(SCHED_OTHER);
		thread_param.sched_priority = (min_pri + max_pri)/2;
		pthread_attr_setschedparam(&attr, &thread_param); 
		printf("After: priority = %d\n",thread_param.sched_priority);
	}
#else
	printf("_POSIX_THREAD_PRIORITY_SCHEDULING undefined\n");
#endif

	/* create the threads */
	for (i = 0; i < NUM_THREADS; i++) {
		/* pthread_create(&tid[i],&attr,runner,NULL); */ 
		thread_ids[i] = (int *) malloc(sizeof(int));
		*thread_ids[i] = i;
		pthread_create(&tid[i],&attr,runner, (void *)thread_ids[i]);
	}
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
	int *id_ptr = (int *)param;
	printf("%s\n", greetings[*id_ptr]);

	pthread_exit(0);
}

