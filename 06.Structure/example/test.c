#include <stdio.h>


int* test(){
 	int a[10];
	for(int i=0;i<10;i++){
		a[i] = i;
	}
	return a;
}

int* testRefine(){
	int *rlt = malloc(sizeof(int) * 10);
	for(int i=0;i<10;i++){
                   rlt[i] = i;
           }
	return rlt;
}

int main(){
 	int* rlt = testRefine();
	for(int i=0;i<10;i++){
 		printf("%d\n", rlt[i]);
	}
}
