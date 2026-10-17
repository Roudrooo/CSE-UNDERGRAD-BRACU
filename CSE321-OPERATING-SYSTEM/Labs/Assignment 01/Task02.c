# include <stdio.h>
# include <stdlib.h>
# include <unistd.h>
# include <pthread.h>
# include <semaphore.h>
# include <stdbool.h>

void *Supplier(void *arg);
void *MakerA(void *arg);
void *MakerB(void *arg);
void *MakerC(void *arg);

pthread_mutex_t mutex;

sem_t S, A, B, C;

int N;
bool endFlag = false;

int main(){
    scanf("%d", &N);
    
    pthread_t t1, t2, t3, t4;

    pthread_mutex_init(&mutex, NULL);

    sem_init(&S, 0, 1);
    sem_init(&A, 0, 0);
    sem_init(&B, 0, 0);
    sem_init(&C, 0, 0);

    pthread_create(&t1, NULL, Supplier, NULL);
    pthread_create(&t2, NULL, MakerA, NULL);
    pthread_create(&t3, NULL, MakerB, NULL);
    pthread_create(&t4, NULL, MakerC, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);
    pthread_join(t4, NULL);
    
    pthread_mutex_destroy(&mutex);

    sem_destroy(&S);
    sem_destroy(&A);
    sem_destroy(&B);
    sem_destroy(&C);

    
    return 0;
}

void *Supplier(void *arg){
    for(int i = 0; i < N; i++){
        sem_wait(&S);
        pthread_mutex_lock(&mutex);
        
        if(i % 3 == 0){
            printf("Supplier places: Bread and Cheese\n");
            sem_post(&C);
        } 
        else if(i % 3 == 1){
            printf("Supplier places: Cheese and Lettuce\n");
            sem_post(&A);
        }
        else{
            printf("Supplier places: Bread and Lettuce\n");
            sem_post(&B);
        }
        pthread_mutex_unlock(&mutex);
    }

    endFlag = true;

    sem_post(&A);
    sem_post(&B);
    sem_post(&C);

    pthread_exit(NULL);
}

void *MakerA(void *arg){
    while(true){
        sem_wait(&A);
        if(endFlag == true) pthread_exit(NULL);

        pthread_mutex_lock(&mutex);

        printf("Maker A picks up Cheese and Lettuce\n");
        printf("Maker A is making the sandwich...\n");
        printf("Maker A finished making the sandwich and eats it\n");
        printf("Maker A signals Supplier\n");

        pthread_mutex_unlock(&mutex);
        sem_post(&S);
    }
}

void *MakerB(void *arg){
    while(true){
        sem_wait(&B);
        if(endFlag == true) pthread_exit(NULL);

        pthread_mutex_lock(&mutex);

        printf("Maker B picks up Bread and Lettuce\n");
        printf("Maker B is making the sandwich...\n");
        printf("Maker B finished making the sandwich and eats it\n");
        printf("Maker B signals Supplier\n");

        pthread_mutex_unlock(&mutex);
        sem_post(&S);
    }
}

void *MakerC(void *arg){
    while(true){
        sem_wait(&C);
        if(endFlag == true) pthread_exit(NULL);

        pthread_mutex_lock(&mutex);

        printf("Maker C picks up Bread and Cheese\n");
        printf("Maker C is making the sandwich...\n");
        printf("Maker C finished making the sandwich and eats it\n");
        printf("Maker C signals Supplier\n");

        pthread_mutex_unlock(&mutex);
        sem_post(&S);
    }
}