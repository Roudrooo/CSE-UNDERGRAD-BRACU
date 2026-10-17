// test_scheduler.c
//
// Task 6: a tiny user program used to test the lottery scheduler.
// Usage: test_scheduler <tickets>
//
// It sets its own ticket count using settickets(), then spins forever
// so it stays RUNNABLE/RUNNING and keeps racking up rounds. Run a few
// copies of this in the background with different ticket counts and
// watch Ctrl+P (procdump) to see the rounds converge to the expected
// ticket ratio.

#include "kernel/types.h"
#include "kernel/stat.h"
#include "user/user.h"

int
main(int argc, char *argv[])
{
  int tickets;

  if (argc != 2) {
    fprintf(2, "usage: test_scheduler <tickets>\n");
    exit(1);
  }

  tickets = atoi(argv[1]);
  if (tickets < 1) {
    fprintf(2, "test_scheduler: tickets must be a positive integer\n");
    exit(1);
  }

  if (settickets(tickets) < 0) {
    fprintf(2, "test_scheduler: settickets failed\n");
    exit(1);
  }

  // Spin forever so the scheduler keeps picking this process.
  for (;;)
    ;

  exit(0);
}
