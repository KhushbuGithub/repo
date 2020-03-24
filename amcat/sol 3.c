/*
The function getarraysum(int * arr,int len)is  supported to calculation
and return the sum of elements of the input array arr of length len(len>0)
The function compiles successfully but fails to return the desired result
due to logical errors.
*/
int getarraysum(int *arr,int len)
{
    int sum = 0,i;
    for(i=0;i<len;i=i+1) // i = i + 1
    {
        sum += arr[i];
    }
    return sum;
}
int  main()
{
   int arr[] = {1,2,3,4,5,6,7,8,9,10};
   printf("%d ", getarraysum(arr, 10));

}
