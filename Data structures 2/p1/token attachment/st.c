#include <string.h>
#include <stdio.h>

#define LINE_LENGTH 100

char *token;
char line[LINE_LENGTH] = "hello world how are you? I am fine!!";
char *search = " ";

int main()
{
  token = strtok(line, search);
  int i;  
  while(token != NULL) 
  {
    printf("[%s]\n", token);
    token = strtok(NULL, search); 
  }
}
