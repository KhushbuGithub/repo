/*
The function replaceValues(int *arr, int len) accepts an array arr of
length len (len>0) as an input and returns an array of the same length.
If the length of arr is odd, all the elements of arr are supposed to be
replaced by 1st and in case it is even, the elements should be replaced
by 0s.
*/
int *replacevalues(int *arr, int len)
{
            int i,j;
            if(len%2==0)
            {
                for(i=0;i<len;i++)
                    arr[i]=0;
            }
            else
            {
                for(j=0;j<len;j+=1)
                    arr[j]=1;
            }
        return arr;
}
int main()
{
int arr[] = {1,2,3,4,5,6,7,8,9,10,11}, ctr;
replacevalues(arr, 11);
for(ctr = 0; ctr <11; ctr++)
    printf("%d ", arr[ctr]);

return 0;
}
