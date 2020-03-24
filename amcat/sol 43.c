/*The function countDigits (int num) is supposed  to return the remainder
when the input argument num (num>0) is divided by the number of digits
in sum.
The function compiles successfully but fails to return the desired result due to logical errors.
Your task is to debug the program to pass all test cases
*/
int countDigits(int num)
{
        int count=0, safe;
        safe = num;
        while(num!=0)
        {
                    num=num/10;
                    count++;
        }
        num = safe;
        return (num%count);

}


int main()
{
int num = 12345678;
printf("%d", countDigits(num));
return 0;

}
