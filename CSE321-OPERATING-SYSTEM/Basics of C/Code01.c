# include <stdio.h>
# include <string.h>
# include <stdlib.h>


// void incrementBy5(int *p){
//     *p += 5;
// }

// struct Stu{
//     char name[50];
//     char id[8];
//     float gpa;
// };

int main(){

    // int id;
    // printf("Enter your id ");
    // scanf("%d", &id);
    
    // printf("My name is Roudro\n");
    // printf("My Student id is: %d\n", id);
    // printf("Hello world!");


    // int arr[5]={1, 2, 3, 4, 5};
    // int arraySizeInByte = sizeof(arr);
    // printf("Size of the array in but: %d\n",arraySizeInByte);
    // int size = sizeof(arr)/sizeof(arr[0]);
    // printf("Size of the array: %d\n", size);    
    
    // int arr2[3][3] = {
    //     {1, 2, 3}, 
    //     {4, 5, 6},
    //     {7, 8, 9}
    // } ;

    // char ch;
    // scanf("%c", &ch);
    // printf("%c\n", ch);

    // ch = getchar();
    // putchar(ch);
    
    // char str[6] = {'H', 'e', 'l', 'l', 'o', '\0'}; // Character array (string) must end with a null character
    // printf("str: %s\n", str);

    // printf("str length: %ld\n", strlen(str));

    // char str1[15];
    // strcpy(str1, str);

    // printf("str1: %s\n", str1);
    // printf("%c\n", str1[2]);

    // char str2[2];
    // strcpy(str2, str);
    // printf("str2: %s\n", str2);

    // char str3[] = {' ', 'W', 'o', 'r', 'l', 'd', '\0'};
    // printf("str3 length: %ld\n", strlen(str3));

    // char str4[40];
    // strcpy(str4, str);
    // strcat(str4, str3);
    // printf("Concatenated str4: %s\n", str4);


    // int a;
    // a = 2;
    // printf("Value of a: %d\n", a);
    // printf("Address of a: %ld\n", &a);

    // int *p;
    // p = &a;
    // printf("Value of p: %ld\n", p);
    // printf("Address of p: %ld\n", &p);
    // printf("Dereferenced value of p: %d\n", *p);


    // printf("Value of a: %d\n", a);
    // incrementBy5(&a);
    // printf("Value of a: %d\n", a);

    // struct Stu s1;
    // struct Stu s2;

    // // Assigning values in the fields
    // //s1
    // strcpy(s1.name, "Khalid");
    // strcpy(s1.id, "1234");
    // s1.gpa = 3.95;

    // //s2
    // strcpy(s2.name, "Ikrima");
    // strcpy(s2.id, "1235");
    // s2.gpa = 3.90 ;

    // // Access 
    // // s1
    // printf("Name of student1: %s\n", s1.name);
    // printf("Id of student1: %s\n", s1.id);
    // printf("GPA of student1: %.2f\n", s1.gpa);

    // // s2
    // printf("\nName of student2: %s\n", s2.name);
    // printf("Id of student2: %s\n", s2.id);
    // printf("GPA of student2: %.2f\n", s2.gpa);

    FILE *ptr, *ptr2;
    ptr = fopen("a.txt", "w"); // Open and Write
    // Write
    fprintf(ptr, "This is 1st line___\n"); 
    fputs("This is 2nd line___\n", ptr);
    fclose(ptr); // Close

    char buff[500];
    ptr2 = fopen("a.txt", "r"); // Open and Read
    if(ptr2 == NULL){
        perror("File not found___");
        return 1;
    }
    fscanf(ptr2, "%s", buff); // Reads word; => "This"
    printf("1st read: %s\n", buff);
    fgets(buff, sizeof(buff), ptr2); // Reads line; => " is 1st line___"
    printf("2nd read: %s\n", buff);
    fgets(buff, sizeof(buff), ptr2); // => 2nd line
    printf("3rd read: %s\n", buff);
    fclose(ptr2);

    
    return 0;
}