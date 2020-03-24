void patternPrint(int n)
{
    int print=1,i,j;
    for( i=0;i<n;i++)
    {
        for(j=0;j<=i;j++)
        {
            printf("%d",print);

        }
        printf("\n");
    }

    }

int main()
{
patternPrint(15);
return 0;
}
