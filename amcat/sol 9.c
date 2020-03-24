/*Input
[1,1,1,0,1,1,1,1],2
Expected return value:
[0,0,0,0,0,1,1,0]
*/
#include<stdio.h>

int* cellcompete(int* cells, int days)
{
     int *newarr = NULL;
     int dayctr, ind;
     newarr = (int * ) malloc(sizeof(int) * 8);
     for(dayctr = 0; dayctr < days ; dayctr++)
     {
         newarr[0] = 0 ^ cells[1];
       for(ind =1 ; ind < 7; ind++)
            newarr[ind] = cells[ind-1] ^ cells[ind+1];
          newarr[7] = 0 ^ cells[6];
            for(ind =0; ind < 8; ind++)
                cells[ind] = newarr[ind];
                for(ind=0 ; ind < 8 ; ind++)
                   printf("%d ",cells[ind]);
                   printf("\n\n");
     }
     return newarr;

}
int main()
{
    int cells[8]={1,1,1,0,1,1,1,1};
    int days=3,index;
    cellcompete(cells,days);
    for(index=0 ; index < 8 ; index++)
         printf("%d ",cells[index]);
}

