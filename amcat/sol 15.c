/*
Code Approach: For this question, you will need to correct the given
implementation. We do not expect you to modify the approach or
incorporate any additional library methods.
Lisa  always forgets her  birthday which is on 5 Th july
In order to help her we have function CheckBirthDay(char *month,int day)
which takes day and month as inputs and returns  1 if its her birthday and
returns a 0 otherwise The function compiles fine but to return desired
results for some cases Your task to fix  the code so but that it passes at
 test cases
15(1) TestCase 1;
Input
July 13
Expected Return Value:
0
TestCase 2:
Input
April 3
Expected Return Value:
0

*/
int checkBirthday(char* month,int day)
{
    if(strcmp(month,"july")==0&&(day==5))

        return 1;
    else
        return 0;
}

int main()
{
    char inp[]="july";
    int day=5;
    if(checkBirthday(inp,day)==1)
        printf("Yes");
    else
        printf("No");
    return 0 ;
}







