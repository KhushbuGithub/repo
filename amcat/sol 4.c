/*
The methods GetDigitSum(int arr[])  of class DigitSum accepts an integers array arr it is supposed to calculate the sum of digits of the even of the smallest elements in the input array it returns 1 if the calculated sum is even and returns 0 otherwise
However  there is a compliation error  in the code your task is to fix it so that the program works for all the input values

*/
 int getDigitSum(int arr[], int len)
    {
            int results,i, min;
            for( i=0,min=arr[0];i<len;i++)
            {
                if(arr[i]<min)
                    min=arr[i];
            }
            results=getSum(min);
            if(results%2==0)
                    return 1;
            else
                   return 0;

    }


int getSum(int num)
{
   int sum=0;
   while (num)
  {
   sum=sum+(num%10);
   num=num/10;
  }
  return sum;
}


int  main()
{
int arr[] = {123, 567, 890, 456, 190, 178, 112, 234};
int size;
size = sizeof (arr) / sizeof(arr[0]); //size = sizeof (arr) / sizeof(int);
printf("%d", getDigitSum(arr, size));
}














