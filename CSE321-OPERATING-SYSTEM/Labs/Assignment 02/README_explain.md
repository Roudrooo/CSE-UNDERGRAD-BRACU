# CSE 321 Lab Assignment 2 — Lottery Scheduler (xv6-riscv)

ID: 24101226

Basically I just went task by task from the assignment sheet. Here's what I did in each file, in plain words.

## Task 1: Add tickets + rounds to processes
- `kernel/proc.h`: added two `int`s to `struct proc` — `tickets` and `rounds`.
- `kernel/proc.c`:
  - `allocproc()` → sets `p->rounds = 0` for every freshly allocated process.
  - `freeproc()` → resets both `tickets` and `rounds` back to 0 when a proc slot is freed, so a reused slot doesn't carry over garbage from the old process.
  - `userinit()` → the very first process (`init`) gets `p->tickets = 10` right after it's allocated, like the handout says.
  - `kfork()` → right after copying memory, I added one line: `np->tickets = p->tickets;` so a child always inherits the parent's ticket count. Rounds stay 0 for the child since `allocproc()` already zeroed it.

## Task 2: `settickets(int n)` syscall
Added it the same way every other syscall in xv6 is wired up (4 files, all boilerplate):
- `kernel/syscall.h` → new number `SYS_settickets 23`.
- `kernel/syscall.c` → extern declaration + added to the `syscalls[]` function table.
- `kernel/sysproc.c` → the actual `sys_settickets()`. Reads the int arg, if it's less than 1 it returns -1 (bad ticket count), otherwise sets `myproc()->tickets = n` and returns 0.
- `user/usys.pl` and `user/user.h` → added the user-space stub/prototype so user programs can just call `settickets(5)`.

## Task 3: Random number generator
Copied the `do_rand()` / `rand()` code exactly as given in the assignment PDF and dropped it near the top of `kernel/proc.c`, along with the `rand_next` seed variable. Nothing fancy here, just used as-is.

## Task 4: Lottery scheduler
This is the main part, in `scheduler()` inside `kernel/proc.c`. Replaced the old round-robin loop with:
1. **First pass** over the proc table: lock each proc, if it's `RUNNABLE` add its `tickets` to a `total_tickets` counter, unlock.
2. If `total_tickets > 0`, draw `winner = rand() % total_tickets` — this is the winning ticket number in `[0, total_tickets - 1]`.
3. **Second pass**: walk the table again, and for each `RUNNABLE` proc add its tickets to a running `counter`. The first process where `counter > winner` is the one holding the winning ticket — that's who runs.
4. Set it to `RUNNING`, do `p->rounds += 1`, and `swtch()` into it exactly like the original code did.
5. If there were no runnable processes at all (`total_tickets == 0`), it falls through to `wfi` just like before.

I kept the locking pattern (acquire/release around each proc) the same as the original xv6 code so I don't break anything with concurrent access.

## Task 5: procdump
Just added `tickets` and `rounds` to the `printk()` line in `procdump()` so `Ctrl+P` shows something like:
```
4 run    test_scheduler tickets=10 rounds=114
```

## Task 6: test_scheduler user program
New file `user/test_scheduler.c`. It's short:
- takes 1 argument (the ticket count)
- calls `settickets()` with it
- spins forever in an empty `for(;;)` loop so it never blocks and stays eligible to be picked by the scheduler

Also added `$U/_test_scheduler` to `UPROGS` in the `Makefile` so it actually gets built and included in `fs.img`.

## Instructions I followed
- Set `CPUS := 1` in the `Makefile` (changed the `ifndef CPUS ... CPUS := 3 ... endif` block to a plain `CPUS := 1`), since this is a single-CPU scheduler.
- Did **not** commit — used `git add .` then `git diff --staged > 24101226.patch` like the sheet says.

## How I tested it (didn't just trust it blindly)
I actually built this for real — installed a RISC-V cross compiler + QEMU, booted xv6, and ran:
```
$ test_scheduler 10 &
$ test_scheduler 5 &
$ test_scheduler 2 &
```
then hit Ctrl+P a few times over ~12 seconds. The `rounds` numbers climbed roughly proportional to the 10:5:2 ticket ratio, e.g. one snapshot was `114 / 49 / 13` which is about `8.8 : 3.8 : 1` and still converging toward `5 : 2.5 : 1` — exactly the kind of behavior the assignment says to look for. I also double-checked the patch file applies cleanly (`git apply --check`) on a totally fresh clone of xv6-riscv and rebuilds with zero warnings under `-Wall -Werror`.

## Files in this submission
- **24101226.patch** — the only thing you actually need to submit (apply with `git apply 24101226.patch` on a clean xv6-riscv clone).
- **24101226_files/** — the individual modified files, just so you can read them without unpacking the patch: `Makefile`, `proc.c`, `proc.h`, `syscall.c`, `syscall.h`, `sysproc.c`, `user.h`, `usys.pl`, `test_scheduler.c` (new file).
