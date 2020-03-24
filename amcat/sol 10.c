/* mySLATE
Self LEaring All time Enabled
TESTCASE 1
Input
5,7,4
Expected return value:
35
TESTCASE 2
Input
11,12,13
Expected return value:
156
*/


 int multiplynumber(int a,int b,int c)
        {
            int result,min,max,mid;
        //    max=(a>b)?a>c?a:cLb>c)?b:c);

             max = (a>b) ? (a>c?a:c) : (b>c?b:c);
               min = (a<b) ? (a<c?a:c) : (b<c?b:c);
        //    min=(a<b)?((a<c)?a:c((b<c)?b:c);
            mid=(a+b+c)-(min+max);
            result=(max*mid);
            return result;
        }


int main()
{
int num1, num2, num3;
num1  = 11;
num2 = 12;
num3 = 13;
printf("%d", multiplynumber(num1, num2, num3));
return 0;
}
