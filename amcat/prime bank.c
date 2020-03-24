/*You are required to complete the given code by reusing existing functions.click
on the helper code tab to find out the details of functions/classess provided for
reuse you can click on compile&amp;run anytime to check the compilation
/execution status of the program you can use system,out,println to debug your
code The submitted code should be logically/syntactically correct and pass all
testcase . . Do not write the main() function as it is not required.
Code Approach: For this question, you will need to correct the
givenimplementation. We do not expect you to modify the approach or
incorporate any additional library methods.
You are given a pre defined class PrimeBank containing of methods to perform
some basic operations
You will have to implement the methods PrintPrime(int num,int n)which
accepts initial number num and number of digits n as inputs and prints all the
numbers of n digits starting from the initial number num
you supposed to use Prime Bank  class and associated methods of task
*/

#include<stdio.h>

int primeBank(int num)
{
int factor, till;
if(num % 6 == 1  || num % 6 == 5)
{
till = sqrt(num);
for (factor = 2;  factor <= till; factor++)
if(num % factor == 0) return 0;
return 1;
}
else return 0;
}
int convert(int len)
{
int res=0, ctr;
for(ctr = 0; ctr < len; ctr++)
  res = res * 10 + 9;
  return res;
}
printPrime(int start, int len)
{
int till, num;
till = convert(len);
for(num = start; num <= till; num++)
    if(primeBank(num) == 1) printf("%d ", num);


}



int main()
{

printPrime(390, 4);
}











