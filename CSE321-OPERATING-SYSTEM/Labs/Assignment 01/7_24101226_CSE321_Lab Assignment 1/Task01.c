# include <stdio.h>
# include <stdlib.h>
# include <unistd.h>
# include <pthread.h>

void *CreateFib(void *arg);
void *SearchFib(void *arg);

int n;
int *fib;
int m;

int main(){
    printf("Enter the term of fibonacci sequence:\n");
    scanf("%d", &n);

    pthread_t t1;
    pthread_create(&t1, NULL, (void *)CreateFib, NULL);
    pthread_join(t1, (void *)&fib);
    
    
    printf("How many numbers you are willing to search?:\n");
    scanf("%d", &m);

    pthread_t t2;
    int *res;
    pthread_create(&t2, NULL, (void *)SearchFib, NULL);
    pthread_join(t2, (void *)&res);



    for(int i = 0; i < n + 1 ; i++) printf("a[%d] = %d\n", i, fib[i]);
    for(int i = 0; i < m; i++) printf("result of search #%d = %d\n", (i + 1), res[i]);


    return 0;

}

void *CreateFib(void *arg){
    int *a = malloc(sizeof(int) * (n + 1));
    a[0] = 0;
    if(n > 0) a[1] = 1;
    for(int i = 2; i < n + 1; i++) a[i] = a[i - 1] + a[i - 2];
    pthread_exit((void *)a);
}

void *SearchFib(void *arg){
    int *b = malloc(sizeof(int) * m);
    for(int i = 0; i < m; i++){
        printf("Enter search %d:\n", i + 1);
        int idx;
        scanf("%d", &idx);
        if(idx > -1 && idx < n+1) b[i] = fib[idx];
        else b[i] = -1;
    }
    pthread_exit((void *)b);
}