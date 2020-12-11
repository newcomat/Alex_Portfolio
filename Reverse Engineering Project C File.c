#include <stdio.h>
#include <math.h>
#include <stdbool.h>

//creating a struct which is a data structure that will hold the student names and grades
struct Student { 
    char* name; 
    char* grade; 
};

//code for the ReadUserInfo function that prompts the user for their name and the password
void ReadUserInfo() {
    
    int userPass;
    char professorName;

    printf("Enter name: ");
    scanf("%s", &professorName);
    printf("Enter password: ");
    scanf("%d", &userPass);
}

//boolean function to verify whether or not the user entered password it correct
//uses simple if/else statement to return the function as true or false depending
//on the verification of the password
bool CheckUserPermissionAccess(int userPass) 
    { 
        if (userPass == 123) {
            return true;
        } else {
            return false;
        }
    }


//the function to display the student information, the information is all initialized
//and kept here and stored as these exact values as this is how the disassembled program
//functioned.  Even after taking the new grades, when running the program again, the
//previous grades remained, so that is what this program is designed to do
void DisplayStudentInformation() {
  
    int i;
    int n = 5;
  
  // filling the struct with the student names and grades
    struct Student student[n];
    student[0].name = "Jim"; 
    student[0].grade = "A"; 
   
    student[1].name = "Tom";  
    student[1].grade = "C"; 
   
    student[2].name = "Ben";
    student[2].grade = "C";
   
    student[3].name = "Alice";
    student[3].grade = "D";
 
    student[4].name = "Ruby"; 
    student[4].grade = "F"; 
  
    // for loop to iterate through and print all of the students names and grades
    for (i = 0; i < n; i++) { 
      printf("%s\t %s\n", student[i].name, student[i].grade);
    }
  
  
}

 // the main function
 int main()
 {

   //variables
   int userPass;
   char professorName;
   char ch;
   float s0;
   float s1;
   float s2;
   float s3;
   float s4;
   int n = 5;
  
    struct Student student[n];
    student[0].name = "Jim"; 
    student[0].grade = "A"; 
   
    student[1].name = "Tom";  
    student[1].grade = "C"; 
   
    student[2].name = "Ben";
    student[2].grade = "C";
   
    student[3].name = "Alice";
    student[3].grade = "D";
 
    student[4].name = "Ruby"; 
    student[4].grade = "F";

   // prompts for the name and password information from the user
    printf("Enter name: ");
    scanf("%s", &professorName);
    printf("Enter password: ");
    scanf("%d", &userPass);
   
   //verification of the password
   if (CheckUserPermissionAccess(userPass)){
     
     //called to print the student information
     DisplayStudentInformation();
   
     //prompt to see if the user wants to adjust the grades
     printf("Adjust grades for students? \n");
     scanf("%c", &ch);
     scanf("%c", &ch);
     //program continues if the user enters Y
     if (ch == 'Y') {
         
       // calling the student names one by one and then storing the new grade to a variable
         printf("Enter the GPA for students one at a time \n");
         printf("%s ", student[0].name);
         scanf("%f",&s0);
         
         printf("%s ", student[1].name);
         scanf("%f",&s1);
         
         printf("%s ", student[2].name);
         scanf("%f",&s2);
         
         printf("%s ", student[3].name);
         scanf("%f",&s3);
         
         printf("%s ", student[4].name);
         scanf("%f",&s4);
         
         //verification of updating the grades
         printf("You have successfully updated class grades.  The grades are now as follows: \n");
       
       //printing the student names along with their new grade values, floor invoked to mimic the
       //performance of the original program as this is how it functions.
         printf("%s\t %.0f\n", student[0].name, floor(s0));
         printf("%s\t %.0f\n", student[1].name, floor(s1));
         printf("%s\t %.0f\n", student[2].name, floor(s2));
         printf("%s\t %.0f\n", student[3].name, floor(s3));
         printf("%s\t %.0f\n", student[4].name, floor(s4));
     }  
     }
   return 0;
}