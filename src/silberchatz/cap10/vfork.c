/**
 * vfork.c
 *
 * This program creates a separate child process using vfork() rather than fork()
 * vfork() allows the child to share the same memory pages as the parent process.
 * In this program example, when the child updates the value of sharedData, the 
 * updated value will be reflected when the parent process outputs its value
 * when the child exits. It is useful to contrast the use of vfork() with fork()
 * to see how these system calls behave.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

#include <stdio.h>

int main(int argc, char *argv[])
{
int pid;
int sharedData = 5;

	/* fork another process */
	/* try this using 
	 * pid = fork() 
	 * as well **/
	printf("parent shared data = %d\n",sharedData);
	pid = vfork();

	if (pid < 0) { /* error occurred */
		fprintf(stderr, "Fork Failed\n");
		exit(-1);
	}
	else if (pid == 0) { /* child process */
		printf("I am the child - my PID value = %d\n",pid);
		sharedData += 25;
	}
	else { /* parent process */
		/* parent will wait for the child to complete */
		printf("I am the parent - my PID value = %d\n",pid);
		wait(NULL);
		
		printf("Child Complete\n");
		printf("shared data = %d\n",sharedData);
		exit(0);
	}
}
