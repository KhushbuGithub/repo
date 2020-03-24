/*
The function findMinElement(int *arr1,int len1,int *arr2,int len2)
 accepts two integer arrays arr1,arr2 of length len1,len2 respectively.
It is supposed to return the smallest element in both the input arrays.
Another function sortArray(int *arr,int len) sorts the input array arr of
length len in ascending order and returns the sorted array.
Your task is to use sortArray(int *arr,int len) function and
complete the code in findMinElement(int *arr1,int len1,int *arr2,int len2)
 so that it passes all test cases.

*/
int* sortArray(int arr[], int len)
    {
        int i=0,j=0,temp=0,index=0;
        for( i=0;i<len;i++)
        {
            for(j=i+1;j<len;j++)
            {
                if(arr[i]>arr[j])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    return arr;
}
 int findMaxElement(int arr1[],int len1 , int arr2[],int len2)
{
  sortArray(arr1, len1);
  sortArray(arr2, len2);
  //arr1[0] < arr2[0] ? return arr1[0] : return arr2[0];
  return arr1[len1-1] > arr2[len2-1] ? arr1[len1-1] : arr2[len2-1];
}



int main()
{
int arr1[] = {78,90,45,22,44,66,79,12, 6}, arr2[] = {45,10,11,12,89,23,56,77,6};
int size1, size2;
size1 = sizeof(arr1) / sizeof(int);
size2 = sizeof(arr2) / sizeof(int);

printf("%d", findMaxElement(arr1, size1, arr2, size2));
return 0;


}
