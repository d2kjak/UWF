 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   strtok.c
 * Author: djj5
 *
 * Created on August 30, 2016, 11:28 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    FILE *file;
    char lines[40];
    char fname[40];
    
    printf("what is the name of the file?-- \n");
    scanf("%s", fname);
    
    file = fopen(fname, "r");
    
    if(file == NULL){
        printf("error \n");
        exit(1);
    }
    
    fseek(file, 0, SEEK_END);
    long fsize = ftell(file);
    rewind(file);
    printf("the size is: %ld \n", fsize);
    
    
   /* printf("reading it to you... \n");
    while(!feof(file)){
        fgets(lines, 40, file);
        //puts(lines);
        
    }*/
    
    fclose(file);

    return (EXIT_SUCCESS);
}

