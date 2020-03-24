/*
The method printpattern(int) of class drawpattern is
expected to expected to print the first n (n > 0)
Lines of the pattern
TESTCASES
TestCase 1
Input:
4
Expected Return value:
11
1111
111111
11111111
TestCase 2:
Input:
1
Expected Return Value:
11

*/
int  main()
     {
        int i,j,print = 1, n=4;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=2 * i;j++)
              printf( "%d", 1);
             if(i!=n)
              printf("\n");
        }

    }
