/*
Input:
5
Expected output:
a
ab
abc
abcd
abcde
testcase 2:
input:
1
Output:
a
*/

int main  ( )
     {
         int i , j,value = 1, num=15;
        char ch = 'a';
        char print = ch;
      for(i=0; i <num; i++, print=ch)
      {
            for(j=0;j<=i;j++)
                 printf( "%c", print++);
                printf("\n");
      }

    }
