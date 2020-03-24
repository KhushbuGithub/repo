/*
The function removeElement( int *arr,int len,int index)takes an array
arr of length len as an input. It is supposed to return an array len-1 after
 removing the integer at the given index in the input arrayarr.If the given
  index is out of bounds, then this function should return the input
  array arr.
The function compiles successfully but fails to return the desired
result due to logical errors
*/
int* removeelement( int *arr,int len,int index)
{
        int i,j;
        if(index<len)
        {
                for(i=index;i<len-1;i++)
                {
                        arr[i]=arr[i+1];
                }
                int *rarr =(int*)malloc(sizeof(int)*(len-1));
                for(i=0;i<len-1;i++)
                rarr[i]=arr[i];
                return rarr;
        }
        else  return arr;
}




int main()
{
int arr[]={10,20,30,40,50,60,70,80,90,100};
int *newarr;
int size,remove_index=10, ind,newsize;
size = sizeof(arr) / sizeof(int);
for(ind = 0; ind < size ; ind++)
   printf("%d ", arr[ind]);

newarr = removeelement(arr, size, remove_index);
printf("\n\n");
newsize = sizeof(newarr) / sizeof(int);
for(ind = 0; ind < size  ; ind++)
   printf("%d ", newarr[ind]);

return 0;







}
