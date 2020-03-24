/*
The method deleteDuplicate(int arr[]) of class DistinctArray takes an
 array as an input it is supposed to remove duplicates integers from
 the input array arr such that for each distinct integer the first occurrence
  is retained and all the duplicates elements following it are removed
  for Example given input array (2,3,2,2,5,6,6,7) the expected output
    is (2,3,5,6,7)
*/
#include<stdio.h>

 int *deleteDuplicate (int arr[], int len)
        {
                int count=0,p,i,j,k,originalLength=len, newlength;
                int *newArr = NULL;
                for(i=0;i<len;i++)
                {
                            for(j=i+1;j<len;j++)
                            {
                                    if(arr[j]==arr[i])
                                    {
                                        k=j;
                                        while(arr[j]==arr[i])
                                        {
                                             arr[k]=arr[k+1];

                                              len=len-1;
                                           count=count+1;
                                        }

                                    j=i;
                            }
                }

         newlength = originalLength-count;
 newArr=malloc(sizeof(int) * newlength);
for(i=0;i<newlength;i++)
newArr[i]=arr[i];
return newArr;

}



int  main()
{
int arr[]  = {1,1,1,1,6,6,6,8,8,9,12,12,12,67,78,89,90};
int size, ind, *newarr;
for(ind = 0; ind < size; ind++)
 printf("%d ", arr[ind]);
size = sizeof(arr) / sizeof(int);
deleteDuplicate(arr, size);
for(ind = 0,printf("\n\n"); ind < 10;ind++)
 printf("%d ", arr[ind]);



}













